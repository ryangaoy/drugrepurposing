package cn.ultragy.redrug.module.redrug.service.md;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.ultragy.redrug.module.redrug.controller.admin.md.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.md.MdDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.redrug.convert.md.MdConvert;
import cn.ultragy.redrug.module.redrug.dal.mysql.md.MdMapper;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;

/**
 * 分子动力学模拟结果列 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MdServiceImpl implements MdService {

    @Resource
    private MdMapper mdMapper;

    @Override
    public Integer createMd(MdCreateReqVO createReqVO) {
        // 插入
        MdDO md = MdConvert.INSTANCE.convert(createReqVO);
        mdMapper.insert(md);
        // 返回
        return md.getId();
    }

    @Override
    public void updateMd(MdUpdateReqVO updateReqVO) {
        // 校验存在
        validateMdExists(updateReqVO.getId());
        // 更新
        MdDO updateObj = MdConvert.INSTANCE.convert(updateReqVO);
        mdMapper.updateById(updateObj);
    }

    @Override
    public void deleteMd(Integer id) {
        // 校验存在
        validateMdExists(id);
        // 删除
        mdMapper.deleteById(id);
    }

    private void validateMdExists(Integer id) {
        if (mdMapper.selectById(id) == null) {
            throw exception(MD_NOT_EXISTS);
        }
    }

    @Override
    public MdDO getMd(Integer id) {
        return mdMapper.selectById(id);
    }

    @Override
    public List<MdDO> getMdList(Collection<Integer> ids) {
        return mdMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MdDO> getMdPage(MdPageReqVO pageReqVO) {
        return mdMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MdDO> getMdList(MdExportReqVO exportReqVO) {
        return mdMapper.selectList(exportReqVO);
    }

}
