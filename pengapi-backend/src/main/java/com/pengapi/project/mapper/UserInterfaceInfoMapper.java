package com.pengapi.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pengapi.pengapicommon.model.entity.UserInterfaceInfo;

import java.util.List;


/**
* @author 彭丽菊
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2024-02-04 14:46:22
* @Entity com.pengapi.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




