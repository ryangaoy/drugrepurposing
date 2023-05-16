package cn.ultragy.redrug.module.redrug.dal.mysql.drugpdb;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugpdb.DrugPdbDO;
import org.apache.ibatis.annotations.Mapper;
import cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo.*;

/**
 * drug_pdb Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DrugPdbMapper extends BaseMapperX<DrugPdbDO> {

    default PageResult<DrugPdbDO> selectPage(DrugPdbPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DrugPdbDO>()
                .likeIfPresent(DrugPdbDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(DrugPdbDO::getPdbId, reqVO.getPdbId())
                .likeIfPresent(DrugPdbDO::getScore, reqVO.getScore())
                .likeIfPresent(DrugPdbDO::getBindingRate, reqVO.getBindingRate())
                .orderByDesc(DrugPdbDO::getId));
    }

    default List<DrugPdbDO> selectList(DrugPdbExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DrugPdbDO>()
                .likeIfPresent(DrugPdbDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(DrugPdbDO::getPdbId, reqVO.getPdbId())
                .likeIfPresent(DrugPdbDO::getScore, reqVO.getScore())
                .likeIfPresent(DrugPdbDO::getBindingRate, reqVO.getBindingRate())
                .orderByDesc(DrugPdbDO::getScore));
    }

    default List<DrugPdbDO> selectList(String drugid) {
        return selectList(new LambdaQueryWrapperX<DrugPdbDO>()
                .likeIfPresent(DrugPdbDO::getDrugbankId, drugid)
                .orderByDesc(DrugPdbDO::getScore));
    }

}
