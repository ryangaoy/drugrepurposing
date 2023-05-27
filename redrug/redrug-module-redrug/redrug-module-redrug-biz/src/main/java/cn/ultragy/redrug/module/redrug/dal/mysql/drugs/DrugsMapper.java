package cn.ultragy.redrug.module.redrug.dal.mysql.drugs;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugs.DrugsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.*;

/**
 * 药物信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DrugsMapper extends BaseMapperX<DrugsDO> {

    default PageResult<DrugsDO> selectPage(DrugsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DrugsDO>()
                .likeIfPresent(DrugsDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(DrugsDO::getGeneralName, reqVO.getGeneralName())
                .likeIfPresent(DrugsDO::getKnownAs, reqVO.getKnownAs())
                .likeIfPresent(DrugsDO::getGroups, reqVO.getGroups())
                .likeIfPresent(DrugsDO::getMolecular, reqVO.getMolecular())
                .likeIfPresent(DrugsDO::getAtomicN, reqVO.getAtomicN())
                .likeIfPresent(DrugsDO::getStructure, reqVO.getStructure())
                .likeIfPresent(DrugsDO::getManufacturers, reqVO.getManufacturers())
                .likeIfPresent(DrugsDO::getIndication, reqVO.getIndication())
                .likeIfPresent(DrugsDO::getTargets, reqVO.getTargets())
                .likeIfPresent(DrugsDO::getUniprotId, reqVO.getUniprotId())
                .orderByAsc(DrugsDO::getDrugbankId));
    }

    default List<DrugsDO> selectList(DrugsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DrugsDO>()
                .likeIfPresent(DrugsDO::getGeneralName, reqVO.getGeneralName())
                .likeIfPresent(DrugsDO::getKnownAs, reqVO.getKnownAs())
                .likeIfPresent(DrugsDO::getGroups, reqVO.getGroups())
                .likeIfPresent(DrugsDO::getMolecular, reqVO.getMolecular())
                .likeIfPresent(DrugsDO::getAtomicN, reqVO.getAtomicN())
                .likeIfPresent(DrugsDO::getStructure, reqVO.getStructure())
                .likeIfPresent(DrugsDO::getManufacturers, reqVO.getManufacturers())
                .likeIfPresent(DrugsDO::getIndication, reqVO.getIndication())
                .likeIfPresent(DrugsDO::getTargets, reqVO.getTargets())
                .likeIfPresent(DrugsDO::getUniprotId, reqVO.getUniprotId())
                .orderByDesc(DrugsDO::getDrugbankId));
    }

}
