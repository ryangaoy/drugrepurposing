package cn.ultragy.redrug.module.redrug.service.targets;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.ultragy.redrug.module.redrug.controller.admin.targets.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.targets.TargetsDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.redrug.convert.targets.TargetsConvert;
import cn.ultragy.redrug.module.redrug.dal.mysql.targets.TargetsMapper;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;

/**
 * 靶点pdb Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TargetsServiceImpl implements TargetsService {

    @Resource
    private TargetsMapper targetsMapper;

    @Override
    public Integer createTargets(TargetsCreateReqVO createReqVO) {
        // 插入
        TargetsDO targets = TargetsConvert.INSTANCE.convert(createReqVO);
        targetsMapper.insert(targets);
        // 返回
        return targets.getId();
    }

    @Override
    public void updateTargets(TargetsUpdateReqVO updateReqVO) {
        // 校验存在
        validateTargetsExists(updateReqVO.getId());
        // 更新
        TargetsDO updateObj = TargetsConvert.INSTANCE.convert(updateReqVO);
        targetsMapper.updateById(updateObj);
    }

    @Override
    public void deleteTargets(Integer id) {
        // 校验存在
        validateTargetsExists(id);
        // 删除
        targetsMapper.deleteById(id);
    }

    private void validateTargetsExists(Integer id) {
        if (targetsMapper.selectById(id) == null) {
            throw exception(TARGETS_NOT_EXISTS);
        }
    }

    @Override
    public TargetsDO getTargets(Integer id) {
        return targetsMapper.selectById(id);
    }

    @Override
    public List<TargetsDO> getTargetsList(Collection<Integer> ids) {
        return targetsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TargetsDO> getTargetsPage(TargetsPageReqVO pageReqVO) {
        return targetsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TargetsDO> getTargetsList(TargetsExportReqVO exportReqVO) {
        return targetsMapper.selectList(exportReqVO);
    }

    @Override
    public List<TargetsDO> getTargetsByPdb(String id) {
        return targetsMapper.selectByPdb(id);
    }

}
