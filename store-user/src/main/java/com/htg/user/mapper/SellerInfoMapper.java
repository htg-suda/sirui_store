package com.htg.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.dto.seller.system.SellerListDto;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.vo.seller.system.SysSellerListItem;

import java.util.List;

/**
 * <p>
 * 卖家/商户信息表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
public interface SellerInfoMapper extends BaseMapper<SellerInfo> {

    SellerInfo selectBySellerSn(String sellerSn);

   // SellerInfo selectByUserId(Integer userId);

    List<SysSellerListItem> selectSellerVerfiyInfoByPage(Page<SysSellerListItem> page, SellerListDto listDto);
}
