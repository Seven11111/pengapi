package com.pengapi.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pengapi.pengapicommon.model.entity.InterfaceInfo;
import com.pengapi.pengapicommon.service.InnerInterfaceInfoService;
import com.pengapi.project.common.ErrorCode;
import com.pengapi.project.exception.BusinessException;
import com.pengapi.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author Mr.Peng
 * @version 1.0
 * @description: TODO
 * @date 2024/2/25 22:12
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    /**
     * @description: 根据路径和方法获取接口信息
     * @author 彭
     * @date 2024/2/25 22:17
     * @version 1.0
     */
    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
