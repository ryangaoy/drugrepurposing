package cn.ultragy.redrug.module.redrug.dal.mysql.targets;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.module.redrug.dal.dataobject.targets.TargetsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.ultragy.redrug.module.redrug.controller.admin.targets.vo.*;

/**
 * 靶点pdb Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TargetsMapper extends BaseMapperX<TargetsDO> {

    default PageResult<TargetsDO> selectPage(TargetsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TargetsDO>()
                .likeIfPresent(TargetsDO::getPdb, reqVO.getPdb())
                .likeIfPresent(TargetsDO::getUniprotId, reqVO.getUniprotId())
                .likeIfPresent(TargetsDO::getGeneNames, reqVO.getGeneNames())
                .likeIfPresent(TargetsDO::getOrganism, reqVO.getOrganism())
                .likeIfPresent(TargetsDO::getProteinNames, reqVO.getProteinNames())
                .likeIfPresent(TargetsDO::getLengths, reqVO.getLengths())
                .likeIfPresent(TargetsDO::getEcNumber, reqVO.getEcNumber())
                .likeIfPresent(TargetsDO::getFunctions, reqVO.getFunctions())
                .likeIfPresent(TargetsDO::getPubmedId, reqVO.getPubmedId())
                .likeIfPresent(TargetsDO::getEntrys, reqVO.getEntrys())
                .betweenIfPresent(TargetsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TargetsDO::getId));
    }

    default List<TargetsDO> selectList(TargetsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TargetsDO>()
                .likeIfPresent(TargetsDO::getPdb, reqVO.getPdb())
                .likeIfPresent(TargetsDO::getUniprotId, reqVO.getUniprotId())
                .likeIfPresent(TargetsDO::getGeneNames, reqVO.getGeneNames())
                .likeIfPresent(TargetsDO::getOrganism, reqVO.getOrganism())
                .likeIfPresent(TargetsDO::getProteinNames, reqVO.getProteinNames())
                .likeIfPresent(TargetsDO::getLengths, reqVO.getLengths())
                .likeIfPresent(TargetsDO::getEcNumber, reqVO.getEcNumber())
                .likeIfPresent(TargetsDO::getFunctions, reqVO.getFunctions())
                .likeIfPresent(TargetsDO::getPubmedId, reqVO.getPubmedId())
                .likeIfPresent(TargetsDO::getEntrys, reqVO.getEntrys())
                .betweenIfPresent(TargetsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TargetsDO::getId));
    }

    default List<TargetsDO> selectByPdb(String id) {
        return selectList(new LambdaQueryWrapperX<TargetsDO>()
                .likeIfPresent(TargetsDO::getPdb, id));
    }

}
