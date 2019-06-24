package com.htg.user.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.constant.SellerConst;
import com.htg.common.constant.StoreConst;
import com.htg.common.dto.seller.shop.SellerAddDto;
import com.htg.common.dto.seller.system.SellerListDto;
import com.htg.common.dto.seller.system.SellerVerifyDto;
import com.htg.common.entity.seller.SellerBankInfo;
import com.htg.common.entity.seller.SellerEnterpriseInfo;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.utils.AuthUtil;
import com.htg.common.vo.seller.shop.SellerInfoDetailsVo;
import com.htg.common.vo.seller.shop.ShopSellerBankInfoVo;
import com.htg.common.vo.seller.shop.ShopSellerEnterpriseInfoVo;
import com.htg.common.vo.seller.shop.ShopSellerInfoVo;
import com.htg.common.vo.seller.system.SysSellerListItem;
import com.htg.user.constant.AddByConst;
import com.htg.user.mapper.SellerInfoMapper;
import com.htg.user.service.ISellerBankInfoService;
import com.htg.user.service.ISellerEnterpriseInfoService;
import com.htg.user.service.ISellerInfoService;
import com.htg.user.service.ISellerStoreService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 卖家/商户信息表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */

@Service
public class SellerInfoServiceImpl extends ServiceImpl<SellerInfoMapper, SellerInfo> implements ISellerInfoService {
    @Autowired
    private ISellerEnterpriseInfoService enterpriseInfoService;

    @Autowired
    private ISellerBankInfoService bankInfoService;

    @Autowired
    private ISellerStoreService sellerStoreService;

    /* 添加商户 */
    @Override
    @Transactional
    public CommonResult<RespId> addSeller(SellerAddDto sellerAddDto) throws GlobalException {
        SellerInfo sellerInfo = sellerAddDto.getSellerInfo();
        SellerBankInfo bankInfo = sellerAddDto.getSellerBankInfo();
        SellerEnterpriseInfo enterpriseInfo = sellerAddDto.getEnterpriseInfo();

        Integer sellerType = sellerInfo.getType();
        /* 如果商户即不是企业类型也不是个人类型 ,那么就会报异常 */
        if (sellerType != SellerConst.TYPE_ENTERPRISE && sellerType != SellerConst.TYPE_INDIVIDUALS)
            throw new GlobalException(CodeEnum.ADD_SELLER_TYPE_ERROR);

        /* 校验企业数据的完整性  */
        if (sellerType == SellerConst.TYPE_ENTERPRISE) {  // 企业商户
            if (enterpriseInfo == null) throw new GlobalException(CodeEnum.ADD_SELLER_TYPE_ERROR);
            /* 如果是企业帐号 ,法人信息必须要有 */
            if (bankInfo.getLegalPersonIdentityBackUrl() == null || bankInfo.getLegalPersonIdentityFrontUrl() == null || bankInfo.getLegalPersonIdentityNum() == null || bankInfo.getLegalPersonName() == null)
                throw new GlobalException(CodeEnum.ADD_SELLER_LEGAL_PERSON_ERROR);
            /* 如果是企业用户 那么开户许可证编号必须要有 是否为空 */
            if (bankInfo.getBankAccountPermitNum() == null)
                throw new GlobalException(CodeEnum.ADD_SELLER_BANK_ACCOUNT_PERMIT_NUM_ERROR);
        }

        Integer userId = AuthUtil.getLoginUserId();
        SellerInfo info = baseMapper.selectByUserId(userId);
        if (info != null) {  // 该用户已经存在了一家商户了
            throw new GlobalException(CodeEnum.SELLER_HAS_EXIST);
        }

        sellerInfo.setId(null);
        sellerInfo.setUserId(userId);
        sellerInfo.setAddBy(AddByConst.SELLER_SELF);
        sellerInfo.setDelFlag(Del_FLAG.EXISTED);
        String sellerSn = UUID.randomUUID().toString();
        sellerInfo.setSn(sellerSn);

        sellerInfo.setState(SellerConst.STATE_WAIT_FOR_VERIFY);
        sellerInfo.setStateRemark(null);
        /* 添加用户基本信息*/
        if (!insert(sellerInfo)) throw new GlobalException(CodeEnum.ADD_SELLER_INFO_ERROR);

        if (sellerType == SellerConst.TYPE_ENTERPRISE) {
            enterpriseInfo.setSellerSn(sellerSn);
            enterpriseInfo.setDelFlag(Del_FLAG.EXISTED);
            /* 添加商户企业信息*/
            if (!enterpriseInfoService.insert(enterpriseInfo))
                throw new GlobalException(CodeEnum.ADD_ENTERPRISE_INFO_ERROR);
        }
        bankInfo.setSellerSn(sellerSn);
        bankInfo.setDelFlag(Del_FLAG.EXISTED);
        /* 添加银行信息 */
        if (!bankInfoService.insert(bankInfo)) throw new GlobalException(CodeEnum.ADD_BANK_INFO_ERROR);

        return CommonResult.success(new RespId(sellerInfo.getId()));
    }

    /* 添加店铺*/
    @Override
    @Transactional
    public CommonResult<RespId> addStore(SellerStore sellerStore) throws GlobalException {
        SellerInfo info = getSellerInfo(AuthUtil.getLoginUserId());

        SellerStore storeExt = getStoreBySeller(info);
        if (storeExt != null) {
            throw new GlobalException(CodeEnum.SELLER_STORE_HAS_EXIST);
        }

        sellerStore.setDelFlag(Del_FLAG.EXISTED);
        sellerStore.setSellerSn(info.getSn());
        sellerStore.setId(null);
        sellerStore.setStatus(StoreConst.STATUS_ACTIVE);
        sellerStore.setStatusRemark(null);
        if (sellerStoreService.insert(sellerStore)) {
            return CommonResult.success(new RespId(sellerStore.getId()));
        } else {
            return CommonResult.error("添加失败");
        }
    }


    /* 获取商户详情 */
    @Override
    public CommonResult<RespPage<SysSellerListItem>> getSellerList(SellerListDto listDto) {
        Page<SysSellerListItem> page = new Page<>(listDto.getPageNum(), listDto.getPageSize());
        String sellerName = listDto.getSellerName();
        if (sellerName != null) {
            listDto.setSellerName("%" + sellerName + "%");
        }
        List<SysSellerListItem> sysSellerListItems = baseMapper.selectSellerVerfiyInfoByPage(page, listDto);
        long total = page.getPages();
        return CommonResult.success(new RespPage<>(sysSellerListItems, total));
    }


    @Override
    public SellerInfo getSellerInfo(Integer userId) throws GlobalException {
        SellerInfo info = baseMapper.selectByUserId(userId);
        if (info == null) {  // 商户还未开通,不能添加店铺
            throw new GlobalException(CodeEnum.SELLER_NOT_EXIST);
        }
        return info;
    }


    @Override
    public CommonResult<SellerInfoDetailsVo> getSellerInfoDetails(Integer userId) throws GlobalException {
        SellerInfoDetailsVo detailsVo = new SellerInfoDetailsVo();
        ShopSellerInfoVo sellerInfoVo = new ShopSellerInfoVo();
        ShopSellerBankInfoVo bankInfoVo = new ShopSellerBankInfoVo();
        ShopSellerEnterpriseInfoVo enterpriseInfoVo = new ShopSellerEnterpriseInfoVo();
        /* 获取商户信息 */
        SellerInfo sellerInfo = getSellerInfo(userId);
        BeanUtils.copyProperties(sellerInfo, sellerInfoVo);

        SellerBankInfo sellerBankInfo = bankInfoService.selectById(sellerInfo.getSn());
        if (sellerBankInfo == null) {
            throw new GlobalException(CodeEnum.SELLER_HAS_NO_BANK_INFO);
        }
        BeanUtils.copyProperties(sellerBankInfo, bankInfoVo);

        Integer type = sellerInfo.getType();
        if (type == SellerConst.TYPE_ENTERPRISE) {  //商户类型,0-企业商户
            SellerEnterpriseInfo sellerEnterpriseInfo = enterpriseInfoService.selectById(sellerInfo.getSn());
            BeanUtils.copyProperties(sellerEnterpriseInfo, enterpriseInfoVo);
            detailsVo.setEnterpriseInfoVo(enterpriseInfoVo);
        } else if (type == SellerConst.TYPE_INDIVIDUALS) { //1-个人商户 如果是企业用户
            detailsVo.setEnterpriseInfoVo(null);
        } else {
            throw new GlobalException(CodeEnum.ADD_SELLER_TYPE_ERROR);
        }
        detailsVo.setSellerInfoVo(sellerInfoVo);
        detailsVo.setSellerBankInfoVo(bankInfoVo);

        return CommonResult.success(detailsVo);
    }

    @Override
    public CommonResult verifySellerInfo(SellerVerifyDto verifyDto) {
        SellerInfo sellerInfo = selectById(verifyDto.getSellerId());
        if (sellerInfo == null) {
            throw new GlobalException(CodeEnum.SELLER_NOT_EXIST);
        }

        Integer state = verifyDto.getState();
        if (state != SellerConst.STATE_VERIFY_PASS
                && state != SellerConst.STATE_VERIFY_UNPASS
                && state != SellerConst.STATE_FROZEN) {
            throw new GlobalException(CodeEnum.SELLER_VERIDY_STATE_ERROR);
        }

        if ((state == SellerConst.STATE_VERIFY_UNPASS || state == SellerConst.STATE_FROZEN) && StringUtils.isBlank(verifyDto.getStateRemark())) {
            throw new GlobalException(CodeEnum.SELLER_VERIDY_STATE_REMARK_ERROR);
        }

        sellerInfo.setState(verifyDto.getState());

        sellerInfo.setStateRemark(verifyDto.getStateRemark());

        if (verifyDto.getStateRemark() == null) {
            sellerInfo.setStateRemark("");
        }
        if (updateById(sellerInfo)) {
            return CommonResult.success("更新成功");
        } else {
            return CommonResult.error("更新失败");
        }
    }


    /* 根据用户id 查找 他的店铺*/
    private SellerStore getStoreBySeller(SellerInfo info) throws GlobalException {
        if (info.getState() != SellerConst.STATE_VERIFY_PASS) throw new GlobalException(CodeEnum.SELLER_STATE_ERROR);
        SellerStore sellerStore = sellerStoreService.selectBySn(info.getSn());
        return sellerStore;
    }

    @Override
    public SellerStore getStoreByUserId(Integer userId) throws GlobalException {
        SellerInfo sellerInfo = getSellerInfo(userId);
        return getStoreBySeller(sellerInfo);
    }
}
