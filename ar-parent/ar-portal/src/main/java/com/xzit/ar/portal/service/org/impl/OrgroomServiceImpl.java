package com.xzit.ar.portal.service.org.impl;

import com.xzit.ar.common.exception.ServiceException;
import com.xzit.ar.common.mapper.origin.OriginMapper;
import com.xzit.ar.common.mapper.user.UserOriginMapper;
import com.xzit.ar.common.page.Page;
import com.xzit.ar.common.po.origin.Origin;
import com.xzit.ar.common.util.CommonUtil;
import com.xzit.ar.portal.service.org.OrgroomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * TODO ${TODO}
 *
 * @author 董亮亮 1075512174@qq.com.
 * @Date:2017/4/18 23:33.
 */
@Service("orgroomService")
public class OrgroomServiceImpl implements OrgroomService {

    @Resource
    private OriginMapper originMapper;

    @Resource
    private UserOriginMapper userOriginMapper;


    /**
     * TODO 根据 originId 查询 origin 基本信息
     * @param originId orginId
     * @return origin 信息
     * @throws ServiceException
     */
    @Override
    public Origin getOriginById(Integer originId) throws ServiceException {
        try {
            // 参数校验
            if(CommonUtil.isNotEmpty(originId)){
                return originMapper.getById(originId);
            }
        } catch (Exception e) {
            throw new ServiceException("查询信息时发生异常！");
        }
        return null;
    }

    /**
     * TODO 加载组织成员id列表
     *
     * @param originId
     * @return 成员id列表
     * @throws ServiceException
     */
    @Override
    public List<Integer> getMemberIds(Integer originId) throws ServiceException {
        try {
            // 参数校验
            if (CommonUtil.isNotEmpty(originId)){
                return userOriginMapper.getAllOriginMemberIds(originId);
            }
        } catch (Exception e) {
            throw new ServiceException("查询信息时发生异常！");
        }
        return null;
    }

    /**
     * TODO 记载组织最近消息
     * @param page     分页类
     * @param originId 组织id
     * @return 消息列表
     * @throws ServiceException
     */
    @Override
    public List<Map<String, Object>> getLatestInfosByOriginId(Page<Map<String, Object>> page, Integer originId)
            throws ServiceException {
        try {
            // 参数校验
            if (CommonUtil.isNotEmpty(originId)){
                // 查询
                return originMapper.getLatestInfosByOriginId(page, originId);
            }
        } catch (Exception e) {
            throw new ServiceException("加载最近消息时失败！");
        }
        return null;
    }
}
