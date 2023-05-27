package cn.ultragy.redrug.module.redrug.service.targets;

import java.util.*;
import javax.validation.*;
import cn.ultragy.redrug.module.redrug.controller.admin.targets.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.targets.TargetsDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

/**
 * 靶点pdb Service 接口
 *
 * @author 芋道源码
 */
public interface TargetsService {

    /**
     * 创建靶点pdb
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createTargets(@Valid TargetsCreateReqVO createReqVO);

    /**
     * 更新靶点pdb
     *
     * @param updateReqVO 更新信息
     */
    void updateTargets(@Valid TargetsUpdateReqVO updateReqVO);

    /**
     * 删除靶点pdb
     *
     * @param id 编号
     */
    void deleteTargets(Integer id);

    /**
     * 获得靶点pdb
     *
     * @param id 编号
     * @return 靶点pdb
     */
    TargetsDO getTargets(Integer id);

    /**
     * 获得靶点pdb列表
     *
     * @param ids 编号
     * @return 靶点pdb列表
     */
    List<TargetsDO> getTargetsList(Collection<Integer> ids);

    /**
     * 获得靶点pdb分页
     *
     * @param pageReqVO 分页查询
     * @return 靶点pdb分页
     */
    PageResult<TargetsDO> getTargetsPage(TargetsPageReqVO pageReqVO);

    /**
     * 获得靶点pdb列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 靶点pdb列表
     */
    List<TargetsDO> getTargetsList(TargetsExportReqVO exportReqVO);

    List<TargetsDO> getTargetsByPdb(String exportReqVO);

}
