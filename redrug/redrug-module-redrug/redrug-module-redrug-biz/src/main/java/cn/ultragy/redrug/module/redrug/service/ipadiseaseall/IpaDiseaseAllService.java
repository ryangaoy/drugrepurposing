package cn.ultragy.redrug.module.redrug.service.ipadiseaseall;

import java.util.*;
import javax.validation.*;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseaseall.IpaDiseaseAllDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

/**
 * ipa预测适应症all Service 接口
 *
 * @author 芋道源码
 */
public interface IpaDiseaseAllService {

    /**
     * 创建ipa预测适应症all
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createIpaDiseaseAll(@Valid IpaDiseaseAllCreateReqVO createReqVO);

    /**
     * 更新ipa预测适应症all
     *
     * @param updateReqVO 更新信息
     */
    void updateIpaDiseaseAll(@Valid IpaDiseaseAllUpdateReqVO updateReqVO);

    /**
     * 删除ipa预测适应症all
     *
     * @param id 编号
     */
    void deleteIpaDiseaseAll(Integer id);

    /**
     * 获得ipa预测适应症all
     *
     * @param id 编号
     * @return ipa预测适应症all
     */
    IpaDiseaseAllDO getIpaDiseaseAll(Integer id);

    /**
     * 获得ipa预测适应症all列表
     *
     * @param ids 编号
     * @return ipa预测适应症all列表
     */
    List<IpaDiseaseAllDO> getIpaDiseaseAllList(Collection<Integer> ids);

    List<IpaDiseaseAllDO> getIpaDiseaseAllListByDrug(String ids);

    /**
     * 获得ipa预测适应症all分页
     *
     * @param pageReqVO 分页查询
     * @return ipa预测适应症all分页
     */
    PageResult<IpaDiseaseAllDO> getIpaDiseaseAllPage(IpaDiseaseAllPageReqVO pageReqVO);

    /**
     * 获得ipa预测适应症all列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return ipa预测适应症all列表
     */
    List<IpaDiseaseAllDO> getIpaDiseaseAllList(IpaDiseaseAllExportReqVO exportReqVO);

}
