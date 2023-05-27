package cn.ultragy.redrug.module.redrug.dal.mysql.pathways;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.module.redrug.dal.dataobject.pathways.PathwaysDO;
import org.apache.ibatis.annotations.Mapper;
import cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo.*;

/**
 * 基因通路 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PathwaysMapper extends BaseMapperX<PathwaysDO> {

    default PageResult<PathwaysDO> selectPage(PathwaysPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PathwaysDO>()
                .likeIfPresent(PathwaysDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(PathwaysDO::getGeneralName, reqVO.getGeneralName())
                .likeIfPresent(PathwaysDO::getKnownAs, reqVO.getKnownAs())
                .likeIfPresent(PathwaysDO::getPasswayId, reqVO.getPasswayId())
                .likeIfPresent(PathwaysDO::getPathwayDesc, reqVO.getPathwayDesc())
                .likeIfPresent(PathwaysDO::getFalseDiscoveryRate, reqVO.getFalseDiscoveryRate())
                .likeIfPresent(PathwaysDO::getLabels, reqVO.getLabels())
                .likeIfPresent(PathwaysDO::getLabelsIds, reqVO.getLabelsIds())
                .likeIfPresent(PathwaysDO::getPdbids, reqVO.getPdbids())
                .likeIfPresent(PathwaysDO::getPdbidsList, reqVO.getPdbidsList())
                .likeIfPresent(PathwaysDO::getPdbidAll, reqVO.getPdbidAll())
                .betweenIfPresent(PathwaysDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PathwaysDO::getId));
    }

    default List<PathwaysDO> selectList(PathwaysExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PathwaysDO>()
                .likeIfPresent(PathwaysDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(PathwaysDO::getGeneralName, reqVO.getGeneralName())
                .likeIfPresent(PathwaysDO::getKnownAs, reqVO.getKnownAs())
                .likeIfPresent(PathwaysDO::getPasswayId, reqVO.getPasswayId())
                .likeIfPresent(PathwaysDO::getPathwayDesc, reqVO.getPathwayDesc())
                .likeIfPresent(PathwaysDO::getFalseDiscoveryRate, reqVO.getFalseDiscoveryRate())
                .likeIfPresent(PathwaysDO::getLabels, reqVO.getLabels())
                .likeIfPresent(PathwaysDO::getLabelsIds, reqVO.getLabelsIds())
                .likeIfPresent(PathwaysDO::getPdbids, reqVO.getPdbids())
                .likeIfPresent(PathwaysDO::getPdbidsList, reqVO.getPdbidsList())
                .likeIfPresent(PathwaysDO::getPdbidAll, reqVO.getPdbidAll())
                .betweenIfPresent(PathwaysDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PathwaysDO::getId));
    }

    default List<PathwaysDO> selectList(String id) {
        return selectList(new LambdaQueryWrapperX<PathwaysDO>()
                .likeIfPresent(PathwaysDO::getDrugbankId, id)
                .orderByDesc(PathwaysDO::getId));
    }

}
