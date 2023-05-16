package cn.ultragy.redrug.module.redrug.dal.mysql.screendrugs;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsPageReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screendrugs.ScreenDrugsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 筛选药物 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ScreenDrugsMapper extends BaseMapperX<ScreenDrugsDO> {

    default PageResult<ScreenDrugsDO> selectPage(ScreenDrugsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ScreenDrugsDO>()
                .eqIfPresent(ScreenDrugsDO::getId, reqVO.getId())
                .likeIfPresent(ScreenDrugsDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(ScreenDrugsDO::getName, reqVO.getName())
                .likeIfPresent(ScreenDrugsDO::getDescription, reqVO.getDescription())
                .likeIfPresent(ScreenDrugsDO::getCasNumber, reqVO.getCasNumber())
                .eqIfPresent(ScreenDrugsDO::getAverageMass, reqVO.getAverageMass())
                .eqIfPresent(ScreenDrugsDO::getMonoisotopicMass, reqVO.getMonoisotopicMass())
                .likeIfPresent(ScreenDrugsDO::getGroups, reqVO.getGroups())
                .likeIfPresent(ScreenDrugsDO::getSynthesisReference, reqVO.getSynthesisReference())
                .likeIfPresent(ScreenDrugsDO::getIndication, reqVO.getIndication())
                .likeIfPresent(ScreenDrugsDO::getPharmacodynamics, reqVO.getPharmacodynamics())
                .likeIfPresent(ScreenDrugsDO::getAbsorption, reqVO.getAbsorption())
                .likeIfPresent(ScreenDrugsDO::getVolumeOfDistribution, reqVO.getVolumeOfDistribution())
                .likeIfPresent(ScreenDrugsDO::getProteinBinding, reqVO.getProteinBinding())
                .likeIfPresent(ScreenDrugsDO::getMetabolism, reqVO.getMetabolism())
                .likeIfPresent(ScreenDrugsDO::getRouteOfElimination, reqVO.getRouteOfElimination())
                .likeIfPresent(ScreenDrugsDO::getHalfLife, reqVO.getHalfLife())
                .likeIfPresent(ScreenDrugsDO::getClearance, reqVO.getClearance())
                .likeIfPresent(ScreenDrugsDO::getMolecular, reqVO.getMolecular())
                .eqIfPresent(ScreenDrugsDO::getAtomicN, reqVO.getAtomicN())
                .likeIfPresent(ScreenDrugsDO::getManufacturers, reqVO.getManufacturers())
                .likeIfPresent(ScreenDrugsDO::getPubmedGene, reqVO.getPubmedGene())
                .orderByAsc(ScreenDrugsDO::getId));
    }

    default List<ScreenDrugsDO> selectList(ScreenDrugsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ScreenDrugsDO>()
                .likeIfPresent(ScreenDrugsDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(ScreenDrugsDO::getName, reqVO.getName())
                .likeIfPresent(ScreenDrugsDO::getDescription, reqVO.getDescription())
                .likeIfPresent(ScreenDrugsDO::getCasNumber, reqVO.getCasNumber())
                .eqIfPresent(ScreenDrugsDO::getAverageMass, reqVO.getAverageMass())
                .eqIfPresent(ScreenDrugsDO::getMonoisotopicMass, reqVO.getMonoisotopicMass())
                .likeIfPresent(ScreenDrugsDO::getGroups, reqVO.getGroups())
                .likeIfPresent(ScreenDrugsDO::getSynthesisReference, reqVO.getSynthesisReference())
                .likeIfPresent(ScreenDrugsDO::getIndication, reqVO.getIndication())
                .likeIfPresent(ScreenDrugsDO::getPharmacodynamics, reqVO.getPharmacodynamics())
                .likeIfPresent(ScreenDrugsDO::getAbsorption, reqVO.getAbsorption())
                .likeIfPresent(ScreenDrugsDO::getVolumeOfDistribution, reqVO.getVolumeOfDistribution())
                .likeIfPresent(ScreenDrugsDO::getProteinBinding, reqVO.getProteinBinding())
                .likeIfPresent(ScreenDrugsDO::getMetabolism, reqVO.getMetabolism())
                .likeIfPresent(ScreenDrugsDO::getRouteOfElimination, reqVO.getRouteOfElimination())
                .likeIfPresent(ScreenDrugsDO::getHalfLife, reqVO.getHalfLife())
                .likeIfPresent(ScreenDrugsDO::getClearance, reqVO.getClearance())
                .likeIfPresent(ScreenDrugsDO::getMolecular, reqVO.getMolecular())
                .eqIfPresent(ScreenDrugsDO::getAtomicN, reqVO.getAtomicN())
                .likeIfPresent(ScreenDrugsDO::getManufacturers, reqVO.getManufacturers())
                .likeIfPresent(ScreenDrugsDO::getPubmedGene, reqVO.getPubmedGene())
                .orderByAsc(ScreenDrugsDO::getId));
    }

    default ScreenDrugsDO selectByDrug(String id) {
        return selectOne(new LambdaQueryWrapperX<ScreenDrugsDO>()
                .likeIfPresent(ScreenDrugsDO::getDrugbankId, id));
    }

    default PageResult<ScreenDrugsDO> selectPageByIds(ScreenDrugsPageReqVO reqVO, List<String> ids) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ScreenDrugsDO>()
                .in(ScreenDrugsDO::getDrugbankId, ids)
                .orderByAsc(ScreenDrugsDO::getId));
    }

}
