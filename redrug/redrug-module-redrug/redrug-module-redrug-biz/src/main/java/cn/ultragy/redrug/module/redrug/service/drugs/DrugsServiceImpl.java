package cn.ultragy.redrug.module.redrug.service.drugs;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.DrugsCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.DrugsExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.DrugsPageReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.DrugsUpdateReqVO;
import cn.ultragy.redrug.module.redrug.convert.drugs.DrugsConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugs.DrugsDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.drugs.DrugsMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.DRUGS_NOT_EXISTS;

/**
 * 药物信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DrugsServiceImpl implements DrugsService {

    @Resource
    private DrugsMapper drugsMapper;

    @Override
    public String createDrugs(DrugsCreateReqVO createReqVO) {
        // 插入
        DrugsDO drugs = DrugsConvert.INSTANCE.convert(createReqVO);
        drugsMapper.insert(drugs);
        // 返回
        return drugs.getDrugbankId();
    }

    @Override
    public void updateDrugs(DrugsUpdateReqVO updateReqVO) {
        // 校验存在
        validateDrugsExists(updateReqVO.getDrugbankId());
        // 更新
        DrugsDO updateObj = DrugsConvert.INSTANCE.convert(updateReqVO);
        drugsMapper.updateById(updateObj);
    }

    @Override
    public void deleteDrugs(String id) {
        // 校验存在
        validateDrugsExists(id);
        // 删除
        drugsMapper.deleteById(id);
    }

    private void validateDrugsExists(String id) {
        if (drugsMapper.selectById(id) == null) {
            throw exception(DRUGS_NOT_EXISTS);
        }
    }

    @Override
    public DrugsDO getDrugs(String id) {
        return drugsMapper.selectById(id);
    }

    @Override
    public List<DrugsDO> getDrugsList(Collection<String> ids) {
        return drugsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DrugsDO> getDrugsPage(DrugsPageReqVO pageReqVO) {
        return drugsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DrugsDO> getDrugsList(DrugsExportReqVO exportReqVO) {
        return drugsMapper.selectList(exportReqVO);
    }

}
