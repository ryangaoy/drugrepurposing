package cn.ultragy.redrug.module.redrug.service.pathways;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.pathways.PathwaysDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.redrug.convert.pathways.PathwaysConvert;
import cn.ultragy.redrug.module.redrug.dal.mysql.pathways.PathwaysMapper;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;

/**
 * 基因通路 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PathwaysServiceImpl implements PathwaysService {

    @Resource
    private PathwaysMapper pathwaysMapper;

    @Override
    public Integer createPathways(PathwaysCreateReqVO createReqVO) {
        // 插入
        PathwaysDO pathways = PathwaysConvert.INSTANCE.convert(createReqVO);
        pathwaysMapper.insert(pathways);
        // 返回
        return pathways.getId();
    }

    @Override
    public void updatePathways(PathwaysUpdateReqVO updateReqVO) {
        // 校验存在
        validatePathwaysExists(updateReqVO.getId());
        // 更新
        PathwaysDO updateObj = PathwaysConvert.INSTANCE.convert(updateReqVO);
        pathwaysMapper.updateById(updateObj);
    }

    @Override
    public void deletePathways(Integer id) {
        // 校验存在
        validatePathwaysExists(id);
        // 删除
        pathwaysMapper.deleteById(id);
    }

    private void validatePathwaysExists(Integer id) {
        if (pathwaysMapper.selectById(id) == null) {
            throw exception(PATHWAYS_NOT_EXISTS);
        }
    }

    @Override
    public PathwaysDO getPathways(Integer id) {
        return pathwaysMapper.selectById(id);
    }

    @Override
    public List<PathwaysDO> getPathwaysList(Collection<Integer> ids) {
        return pathwaysMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PathwaysDO> getPathwaysPage(PathwaysPageReqVO pageReqVO) {
        return pathwaysMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PathwaysDO> getPathwaysList(PathwaysExportReqVO exportReqVO) {
        return pathwaysMapper.selectList(exportReqVO);
    }

    @Override
    public List<PathwaysDO> getPathwaysListByDrug(String id) {
        return pathwaysMapper.selectList(id);
    }

}
