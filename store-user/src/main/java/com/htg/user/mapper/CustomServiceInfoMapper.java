package com.htg.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.entity.custom.CustomServiceInfo;
import com.htg.common.vo.user.admin.CustomServiceUserInfoVo;

import java.util.List;

/**
 * <p>
 * 客服信息表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-06-25
 */
public interface CustomServiceInfoMapper extends BaseMapper<CustomServiceInfo> {

    CustomServiceInfo selectByUserId(Integer userId);

    List<CustomServiceUserInfoVo> selectCustomUserInfo(Page<CustomServiceUserInfoVo> page, String tel, String serviceName);

    CustomServiceUserInfoVo selectCustomUserInfoById(Integer id);

}
