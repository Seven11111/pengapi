package com.pengapi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pengapi.pengapicommon.model.entity.UserInterfaceInfo;

/**
* @author 彭丽菊
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-02-04 14:46:22
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * @description: 校验
     * @author 彭
     * @date 2024/1/25 16:48
     * @version 1.0
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * @description: 统计调用接口次数
     * @author 彭
     * @date 2024/2/4 15:12
     * @version 1.0
     */
    boolean invokeCount(long userId, long interfaceInfoId);
}
