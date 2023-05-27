package cn.ultragy.redrug.module.redrug.dal.mysql.ipadiseaseall;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseaseall.IpaDiseaseAllDO;
import org.apache.ibatis.annotations.Mapper;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo.*;

/**
 * ipa预测适应症all Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface IpaDiseaseAllMapper extends BaseMapperX<IpaDiseaseAllDO> {

    default PageResult<IpaDiseaseAllDO> selectPage(IpaDiseaseAllPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<IpaDiseaseAllDO>()
                .eqIfPresent(IpaDiseaseAllDO::getId, reqVO.getId())
                .likeIfPresent(IpaDiseaseAllDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(IpaDiseaseAllDO::getFromM, reqVO.getFromM())
                .likeIfPresent(IpaDiseaseAllDO::getTypeM, reqVO.getTypeM())
                .likeIfPresent(IpaDiseaseAllDO::getToM, reqVO.getToM())
                .likeIfPresent(IpaDiseaseAllDO::getCatalyst, reqVO.getCatalyst())
                .orderByDesc(IpaDiseaseAllDO::getId));
    }

    default List<IpaDiseaseAllDO> selectList(IpaDiseaseAllExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<IpaDiseaseAllDO>()
                .eqIfPresent(IpaDiseaseAllDO::getId, reqVO.getId())
                .likeIfPresent(IpaDiseaseAllDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(IpaDiseaseAllDO::getFromM, reqVO.getFromM())
                .likeIfPresent(IpaDiseaseAllDO::getTypeM, reqVO.getTypeM())
                .likeIfPresent(IpaDiseaseAllDO::getToM, reqVO.getToM())
                .likeIfPresent(IpaDiseaseAllDO::getCatalyst, reqVO.getCatalyst())
                .orderByAsc(IpaDiseaseAllDO::getId));
    }

    default List<IpaDiseaseAllDO> selectByDrug(String id) {
        return selectList(new LambdaQueryWrapperX<IpaDiseaseAllDO>()
                .likeIfPresent(IpaDiseaseAllDO::getDrugbankId, id)
                .orderByAsc(IpaDiseaseAllDO::getId));
    }

}
