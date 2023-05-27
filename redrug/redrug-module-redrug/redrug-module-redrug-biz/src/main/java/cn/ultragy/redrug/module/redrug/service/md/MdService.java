package cn.ultragy.redrug.module.redrug.service.md;

import java.util.*;
import javax.validation.*;
import cn.ultragy.redrug.module.redrug.controller.admin.md.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.md.MdDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

/**
 * 分子动力学模拟结果列 Service 接口
 *
 * @author 芋道源码
 */
public interface MdService {

    /**
     * 创建分子动力学模拟结果列
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createMd(@Valid MdCreateReqVO createReqVO);

    /**
     * 更新分子动力学模拟结果列
     *
     * @param updateReqVO 更新信息
     */
    void updateMd(@Valid MdUpdateReqVO updateReqVO);

    /**
     * 删除分子动力学模拟结果列
     *
     * @param id 编号
     */
    void deleteMd(Integer id);

    /**
     * 获得分子动力学模拟结果列
     *
     * @param id 编号
     * @return 分子动力学模拟结果列
     */
    MdDO getMd(Integer id);

    /**
     * 获得分子动力学模拟结果列列表
     *
     * @param ids 编号
     * @return 分子动力学模拟结果列列表
     */
    List<MdDO> getMdList(Collection<Integer> ids);

    /**
     * 获得分子动力学模拟结果列分页
     *
     * @param pageReqVO 分页查询
     * @return 分子动力学模拟结果列分页
     */
    PageResult<MdDO> getMdPage(MdPageReqVO pageReqVO);

    /**
     * 获得分子动力学模拟结果列列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 分子动力学模拟结果列列表
     */
    List<MdDO> getMdList(MdExportReqVO exportReqVO);

}
