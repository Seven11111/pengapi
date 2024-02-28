package com.pengapi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pengapi.pengapicommon.model.entity.InterfaceInfo;

;

/**
* @author 彭丽菊
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-01-25 16:31:23
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * @description: 校验
     * @author 彭
     * @date 2024/1/25 16:48
     * @version 1.0
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
