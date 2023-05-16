package cn.ultragy.redrug.module.redrug.service.ipadiseasesingle;

import java.util.*;
import javax.validation.*;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseasesingle.IpaDiseaseSingleDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

/**
 * ipa预测适应症single Service 接口
 *
 * @author 芋道源码
 */
public interface IpaDiseaseSingleService {

    /**
     * 创建ipa预测适应症single
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createIpaDiseaseSingle(@Valid IpaDiseaseSingleCreateReqVO createReqVO);

    /**
     * 更新ipa预测适应症single
     *
     * @param updateReqVO 更新信息
     */
    void updateIpaDiseaseSingle(@Valid IpaDiseaseSingleUpdateReqVO updateReqVO);

    /**
     * 删除ipa预测适应症single
     *
     * @param id 编号
     */
    void deleteIpaDiseaseSingle(Integer id);

    /**
     * 获得ipa预测适应症single
     *
     * @param id 编号
     * @return ipa预测适应症single
     */
    IpaDiseaseSingleDO getIpaDiseaseSingle(Integer id);

    IpaDiseaseSingleDO getIpaDiseaseSingleByDrug(String id);

    /**
     * 获得ipa预测适应症single列表
     *
     * @param ids 编号
     * @return ipa预测适应症single列表
     */
    List<IpaDiseaseSingleDO> getIpaDiseaseSingleList(Collection<Integer> ids);

    /**
     * 获得ipa预测适应症single分页
     *
     * @param pageReqVO 分页查询
     * @return ipa预测适应症single分页
     */
    PageResult<IpaDiseaseSingleDO> getIpaDiseaseSinglePage(IpaDiseaseSinglePageReqVO pageReqVO);

    /**
     * 获得ipa预测适应症single列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return ipa预测适应症single列表
     */
    List<IpaDiseaseSingleDO> getIpaDiseaseSingleList(IpaDiseaseSingleExportReqVO exportReqVO);

}
