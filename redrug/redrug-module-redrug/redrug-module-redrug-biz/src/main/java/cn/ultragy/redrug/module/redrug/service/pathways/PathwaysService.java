package cn.ultragy.redrug.module.redrug.service.pathways;

import java.util.*;
import javax.validation.*;
import cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.pathways.PathwaysDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

/**
 * 基因通路 Service 接口
 *
 * @author 芋道源码
 */
public interface PathwaysService {

    /**
     * 创建基因通路
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createPathways(@Valid PathwaysCreateReqVO createReqVO);

    /**
     * 更新基因通路
     *
     * @param updateReqVO 更新信息
     */
    void updatePathways(@Valid PathwaysUpdateReqVO updateReqVO);

    /**
     * 删除基因通路
     *
     * @param id 编号
     */
    void deletePathways(Integer id);

    /**
     * 获得基因通路
     *
     * @param id 编号
     * @return 基因通路
     */
    PathwaysDO getPathways(Integer id);

    /**
     * 获得基因通路列表
     *
     * @param ids 编号
     * @return 基因通路列表
     */
    List<PathwaysDO> getPathwaysList(Collection<Integer> ids);

    /**
     * 获得基因通路分页
     *
     * @param pageReqVO 分页查询
     * @return 基因通路分页
     */
    PageResult<PathwaysDO> getPathwaysPage(PathwaysPageReqVO pageReqVO);

    /**
     * 获得基因通路列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 基因通路列表
     */
    List<PathwaysDO> getPathwaysList(PathwaysExportReqVO exportReqVO);

    List<PathwaysDO> getPathwaysListByDrug(String id);

}
