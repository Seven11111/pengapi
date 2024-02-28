package com.pengapi.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pengapi.pengapicommon.model.entity.UserInterfaceInfo;
import com.pengapi.pengapicommon.service.InnerUserInterfaceInfoService;
import com.pengapi.project.common.ErrorCode;
import com.pengapi.project.exception.BusinessException;
import com.pengapi.project.service.UserInterfaceInfoService;
import com.pengapi.project.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author Mr.Peng
 * @version 1.0
 * @description: TODO
 * @date 2024/2/25 22:12
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(userId, interfaceInfoId);
    }

    @Override
    public boolean validUserInterfaceInfo(long interfaceInfoId, long userId) {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId).eq("userId", userId);
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoService.getOne(queryWrapper);
        if (userInterfaceInfo == null || userInterfaceInfo.getLeftNum() <= 0) {
           return false;
        }
       return true;
    }


}
