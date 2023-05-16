package cn.ultragy.redrug.module.redrug.service.screendrugs;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.ScreenExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsPageReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsUpdateReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screendrugs.ScreenDrugsDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 筛选药物 Service 接口
 *
 * @author 芋道源码
 */
public interface ScreenDrugsService {

    /**
     * 创建筛选药物
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createScreenDrugs(@Valid ScreenDrugsCreateReqVO createReqVO);

    /**
     * 更新筛选药物
     *
     * @param updateReqVO 更新信息
     */
    void updateScreenDrugs(@Valid ScreenDrugsUpdateReqVO updateReqVO);

    /**
     * 删除筛选药物
     *
     * @param id 编号
     */
    void deleteScreenDrugs(Integer id);

    /**
     * 获得筛选药物
     *
     * @param id 编号
     * @return 筛选药物
     */
    ScreenDrugsDO getScreenDrugs(Integer id);
    ScreenDrugsDO getScreenDrugsByDrug(String id);

    /**
     * 获得筛选药物列表
     *
     * @param ids 编号
     * @return 筛选药物列表
     */
    List<ScreenDrugsDO> getScreenDrugsList(Collection<Integer> ids);

    /**
     * 获得筛选药物分页
     *
     * @param pageReqVO 分页查询
     * @return 筛选药物分页
     */
    PageResult<ScreenDrugsDO> getScreenDrugsPage(ScreenDrugsPageReqVO pageReqVO);
    PageResult<ScreenDrugsDO> screensearch(ScreenExportReqVO reqVO);

    /**
     * 获得筛选药物列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 筛选药物列表
     */
    List<ScreenDrugsDO> getScreenDrugsList(ScreenDrugsExportReqVO exportReqVO);

}
