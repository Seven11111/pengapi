package com.pengapi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.pengapi.pengapicommon.model.entity.UserInterfaceInfo;
import com.pengapi.project.common.ErrorCode;
import com.pengapi.project.exception.BusinessException;
import com.pengapi.project.mapper.UserInterfaceInfoMapper;
import com.pengapi.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 彭丽菊
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
 * @createDate 2024-02-04 14:46:22
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Long id = userInterfaceInfo.getId();
        Integer status = userInterfaceInfo.getStatus();
        Long userId = userInterfaceInfo.getUserId();
        Date createTime = userInterfaceInfo.getCreateTime();
        Date updateTime = userInterfaceInfo.getUpdateTime();
        Integer isDelete = userInterfaceInfo.getIsDelete();

        // 创建时，参数不能为空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        // 有参数则校验
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "调用次数或剩余调用次数不能小于0");
        }

    }

    @Override
    public boolean invokeCount(long userId, long interfaceInfoId) {
        if (userId <= 0 || interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户或接口不存在");
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("userId", userId)
                .eq("interfaceInfoId", interfaceInfoId)
                .gt("leftNum",0)
                .setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");

        boolean update = this.update(updateWrapper);

        return update;
    }
}




