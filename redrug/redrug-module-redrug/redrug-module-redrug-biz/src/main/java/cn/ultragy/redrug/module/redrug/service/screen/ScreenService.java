package cn.ultragy.redrug.module.redrug.service.screen;

import java.util.*;
import javax.validation.*;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screen.ScreenDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

/**
 * 筛选结果 Service 接口
 *
 * @author 芋道源码
 */
public interface ScreenService {

    /**
     * 创建筛选结果
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createScreen(@Valid ScreenCreateReqVO createReqVO);

    /**
     * 更新筛选结果
     *
     * @param updateReqVO 更新信息
     */
    void updateScreen(@Valid ScreenUpdateReqVO updateReqVO);

    /**
     * 删除筛选结果
     *
     * @param id 编号
     */
    void deleteScreen(Integer id);

    /**
     * 获得筛选结果
     *
     * @param id 编号
     * @return 筛选结果
     */
    ScreenDO getScreen(Integer id);

    /**
     * 获得筛选结果列表
     *
     * @param ids 编号
     * @return 筛选结果列表
     */
    List<ScreenDO> getScreenList(Collection<Integer> ids);

    List<ScreenDO> getScreenListByDrug(String id);

    /**
     * 获得筛选结果分页
     *
     * @param pageReqVO 分页查询
     * @return 筛选结果分页
     */
    PageResult<ScreenDO> getScreenPage(ScreenPageReqVO pageReqVO);

    /**
     * 获得筛选结果列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 筛选结果列表
     */
    List<ScreenDO> getScreenList(ScreenExportReqVO exportReqVO);

}
