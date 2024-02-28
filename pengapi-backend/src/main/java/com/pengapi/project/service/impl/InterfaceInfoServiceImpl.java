package com.pengapi.project.service.impl;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pengapi.pengapicommon.model.entity.InterfaceInfo;
import com.pengapi.project.common.ErrorCode;
import com.pengapi.project.exception.BusinessException;
import com.pengapi.project.exception.ThrowUtils;
import com.pengapi.project.mapper.InterfaceInfoMapper;
import com.pengapi.project.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 彭丽菊
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实现
 * @createDate 2024-01-25 16:31:23
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Long id = interfaceInfo.getId();
        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        Integer status = interfaceInfo.getStatus();
        String method = interfaceInfo.getMethod();
        Long userId = interfaceInfo.getUserId();
        Date createTime = interfaceInfo.getCreateTime();
        Date updateTime = interfaceInfo.getUpdateTime();
        Integer isDelete = interfaceInfo.getIsDelete();

        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name, url, method,requestHeader,responseHeader), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() > 80) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题过长");
        }

    }



    @Override
    public boolean saveOrUpdateBatch(Collection<InterfaceInfo> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<InterfaceInfo> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(InterfaceInfo entity) {
        return false;
    }

    @Override
    public InterfaceInfo getOne(Wrapper<InterfaceInfo> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<InterfaceInfo> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<InterfaceInfo> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }
}




