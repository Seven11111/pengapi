package com.pengapi.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pengapi.pengapicommon.model.entity.User;
import com.pengapi.pengapicommon.service.InnerUserService;
import com.pengapi.project.common.ErrorCode;
import com.pengapi.project.exception.BusinessException;
import com.pengapi.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author Mr.Peng
 * @version 1.0
 * @description: TODO
 * @date 2024/2/25 22:13
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);

        return userMapper.selectOne(queryWrapper);
    }
}
