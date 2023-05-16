package cn.ultragy.redrug.module.redrug.service.drugpdb;

import java.util.*;
import javax.validation.*;
import cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugpdb.DrugPdbDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

/**
 * drug_pdb Service 接口
 *
 * @author 芋道源码
 */
public interface DrugPdbService {

    /**
     * 创建drug_pdb
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createDrugPdb(@Valid DrugPdbCreateReqVO createReqVO);

    /**
     * 更新drug_pdb
     *
     * @param updateReqVO 更新信息
     */
    void updateDrugPdb(@Valid DrugPdbUpdateReqVO updateReqVO);

    /**
     * 删除drug_pdb
     *
     * @param id 编号
     */
    void deleteDrugPdb(Integer id);

    /**
     * 获得drug_pdb
     *
     * @param id 编号
     * @return drug_pdb
     */
    DrugPdbDO getDrugPdb(Integer id);

    /**
     * 获得drug_pdb列表
     *
     * @param ids 编号
     * @return drug_pdb列表
     */
    List<DrugPdbDO> getDrugPdbList(Collection<Integer> ids);

    /**
     * 获得drug_pdb分页
     *
     * @param pageReqVO 分页查询
     * @return drug_pdb分页
     */
    PageResult<DrugPdbDO> getDrugPdbPage(DrugPdbPageReqVO pageReqVO);

    /**
     * 获得drug_pdb列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return drug_pdb列表
     */
    List<DrugPdbDO> getDrugPdbList(DrugPdbExportReqVO exportReqVO);

    List<DrugPdbDO> getDrugPdbListByDrug(String drugid);



}
