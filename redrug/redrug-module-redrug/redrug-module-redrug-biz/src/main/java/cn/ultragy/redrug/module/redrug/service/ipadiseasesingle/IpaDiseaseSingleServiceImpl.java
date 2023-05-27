package cn.ultragy.redrug.module.redrug.service.ipadiseasesingle;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseasesingle.IpaDiseaseSingleDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.redrug.convert.ipadiseasesingle.IpaDiseaseSingleConvert;
import cn.ultragy.redrug.module.redrug.dal.mysql.ipadiseasesingle.IpaDiseaseSingleMapper;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;

/**
 * ipa预测适应症single Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class IpaDiseaseSingleServiceImpl implements IpaDiseaseSingleService {

    @Resource
    private IpaDiseaseSingleMapper ipaDiseaseSingleMapper;

    @Override
    public Integer createIpaDiseaseSingle(IpaDiseaseSingleCreateReqVO createReqVO) {
        // 插入
        IpaDiseaseSingleDO ipaDiseaseSingle = IpaDiseaseSingleConvert.INSTANCE.convert(createReqVO);
        ipaDiseaseSingleMapper.insert(ipaDiseaseSingle);
        // 返回
        return ipaDiseaseSingle.getId();
    }

    @Override
    public void updateIpaDiseaseSingle(IpaDiseaseSingleUpdateReqVO updateReqVO) {
        // 校验存在
        validateIpaDiseaseSingleExists(updateReqVO.getId());
        // 更新
        IpaDiseaseSingleDO updateObj = IpaDiseaseSingleConvert.INSTANCE.convert(updateReqVO);
        ipaDiseaseSingleMapper.updateById(updateObj);
    }

    @Override
    public void deleteIpaDiseaseSingle(Integer id) {
        // 校验存在
        validateIpaDiseaseSingleExists(id);
        // 删除
        ipaDiseaseSingleMapper.deleteById(id);
    }

    private void validateIpaDiseaseSingleExists(Integer id) {
        if (ipaDiseaseSingleMapper.selectById(id) == null) {
            throw exception(IPA_DISEASE_SINGLE_NOT_EXISTS);
        }
    }

    @Override
    public IpaDiseaseSingleDO getIpaDiseaseSingle(Integer id) {
        return ipaDiseaseSingleMapper.selectById(id);
    }

    @Override
    public IpaDiseaseSingleDO getIpaDiseaseSingleByDrug(String id) {
        return ipaDiseaseSingleMapper.selectByDrug(id);
    }

    @Override
    public List<IpaDiseaseSingleDO> getIpaDiseaseSingleList(Collection<Integer> ids) {
        return ipaDiseaseSingleMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<IpaDiseaseSingleDO> getIpaDiseaseSinglePage(IpaDiseaseSinglePageReqVO pageReqVO) {
        return ipaDiseaseSingleMapper.selectPage(pageReqVO);
    }

    @Override
    public List<IpaDiseaseSingleDO> getIpaDiseaseSingleList(IpaDiseaseSingleExportReqVO exportReqVO) {
        return ipaDiseaseSingleMapper.selectList(exportReqVO);
    }

}
