package cn.ultragy.redrug.module.redrug.service.drugs;

import java.util.*;
import javax.validation.*;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugs.DrugsDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

/**
 * 药物信息 Service 接口
 *
 * @author 芋道源码
 */
public interface DrugsService {

    /**
     * 创建药物信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createDrugs(@Valid DrugsCreateReqVO createReqVO);

    /**
     * 更新药物信息
     *
     * @param updateReqVO 更新信息
     */
    void updateDrugs(@Valid DrugsUpdateReqVO updateReqVO);

    /**
     * 删除药物信息
     *
     * @param id 编号
     */
    void deleteDrugs(String id);

    /**
     * 获得药物信息
     *
     * @param id 编号
     * @return 药物信息
     */
    DrugsDO getDrugs(String id);

    /**
     * 获得药物信息列表
     *
     * @param ids 编号
     * @return 药物信息列表
     */
    List<DrugsDO> getDrugsList(Collection<String> ids);

    /**
     * 获得药物信息分页
     *
     * @param pageReqVO 分页查询
     * @return 药物信息分页
     */
    PageResult<DrugsDO> getDrugsPage(DrugsPageReqVO pageReqVO);

    /**
     * 获得药物信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 药物信息列表
     */
    List<DrugsDO> getDrugsList(DrugsExportReqVO exportReqVO);

}
