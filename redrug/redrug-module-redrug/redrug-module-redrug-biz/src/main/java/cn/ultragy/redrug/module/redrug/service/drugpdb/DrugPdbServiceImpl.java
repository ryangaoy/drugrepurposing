package cn.ultragy.redrug.module.redrug.service.drugpdb;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugpdb.DrugPdbDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.redrug.convert.drugpdb.DrugPdbConvert;
import cn.ultragy.redrug.module.redrug.dal.mysql.drugpdb.DrugPdbMapper;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;

/**
 * drug_pdb Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DrugPdbServiceImpl implements DrugPdbService {

    @Resource
    private DrugPdbMapper drugPdbMapper;

    @Override
    public Integer createDrugPdb(DrugPdbCreateReqVO createReqVO) {
        // 插入
        DrugPdbDO drugPdb = DrugPdbConvert.INSTANCE.convert(createReqVO);
        drugPdbMapper.insert(drugPdb);
        // 返回
        return drugPdb.getId();
    }

    @Override
    public void updateDrugPdb(DrugPdbUpdateReqVO updateReqVO) {
        // 校验存在
        validateDrugPdbExists(updateReqVO.getId());
        // 更新
        DrugPdbDO updateObj = DrugPdbConvert.INSTANCE.convert(updateReqVO);
        drugPdbMapper.updateById(updateObj);
    }

    @Override
    public void deleteDrugPdb(Integer id) {
        // 校验存在
        validateDrugPdbExists(id);
        // 删除
        drugPdbMapper.deleteById(id);
    }

    private void validateDrugPdbExists(Integer id) {
        if (drugPdbMapper.selectById(id) == null) {
            throw exception(DRUG_PDB_NOT_EXISTS);
        }
    }

    @Override
    public DrugPdbDO getDrugPdb(Integer id) {
        return drugPdbMapper.selectById(id);
    }

    @Override
    public List<DrugPdbDO> getDrugPdbList(Collection<Integer> ids) {
        return drugPdbMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DrugPdbDO> getDrugPdbPage(DrugPdbPageReqVO pageReqVO) {
        return drugPdbMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DrugPdbDO> getDrugPdbList(DrugPdbExportReqVO exportReqVO) {
        return drugPdbMapper.selectList(exportReqVO);
    }

    @Override
    public List<DrugPdbDO> getDrugPdbListByDrug(String drugid) {
        return drugPdbMapper.selectList(drugid);
    }

}
