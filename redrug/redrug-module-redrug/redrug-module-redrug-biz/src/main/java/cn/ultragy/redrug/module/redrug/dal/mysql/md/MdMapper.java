package cn.ultragy.redrug.module.redrug.dal.mysql.md;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.module.redrug.dal.dataobject.md.MdDO;
import org.apache.ibatis.annotations.Mapper;
import cn.ultragy.redrug.module.redrug.controller.admin.md.vo.*;

/**
 * 分子动力学模拟结果列 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MdMapper extends BaseMapperX<MdDO> {

    default PageResult<MdDO> selectPage(MdPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MdDO>()
                .likeIfPresent(MdDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(MdDO::getEntrys, reqVO.getEntrys())
                .likeIfPresent(MdDO::getProteinNames, reqVO.getProteinNames())
                .likeIfPresent(MdDO::getPdb, reqVO.getPdb())
                .likeIfPresent(MdDO::getUniprotId, reqVO.getUniprotId())
                .likeIfPresent(MdDO::getOrganism, reqVO.getOrganism())
                .eqIfPresent(MdDO::getLengths, reqVO.getLengths())
                .orderByAsc(MdDO::getId));
    }

    default List<MdDO> selectList(MdExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MdDO>()
                .likeIfPresent(MdDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(MdDO::getEntrys, reqVO.getEntrys())
                .likeIfPresent(MdDO::getProteinNames, reqVO.getProteinNames())
                .likeIfPresent(MdDO::getPdb, reqVO.getPdb())
                .likeIfPresent(MdDO::getUniprotId, reqVO.getUniprotId())
                .likeIfPresent(MdDO::getOrganism, reqVO.getOrganism())
                .eqIfPresent(MdDO::getLengths, reqVO.getLengths())
                .betweenIfPresent(MdDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MdDO::getId));
    }

}
