package com.pengapi.pengapicommon.service;

import com.pengapi.pengapicommon.model.entity.UserInterfaceInfo;

/**
 * 内部用户接口信息服务
 *
 * 
 * 
 */
public interface InnerUserInterfaceInfoService {



    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    boolean validUserInterfaceInfo(long interfaceInfoId, long userId);
}
