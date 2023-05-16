package cn.ultragy.redrug.module.redrug.dal.mysql.screen;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.ScreenExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.ScreenPageReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screen.ScreenDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 筛选结果 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ScreenMapper extends BaseMapperX<ScreenDO> {

    default PageResult<ScreenDO> selectPage(ScreenPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ScreenDO>()
                .likeIfPresent(ScreenDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(ScreenDO::getUniprotId, reqVO.getUniprotId())
                .likeIfPresent(ScreenDO::getTgname, reqVO.getTgname())
                .likeIfPresent(ScreenDO::getPdbid, reqVO.getPdbid())
                .eqIfPresent(ScreenDO::getScore, reqVO.getScore())
                .eqIfPresent(ScreenDO::getBindingRate, reqVO.getBindingRate())
                .likeIfPresent(ScreenDO::getUniprotTgnameMedN, reqVO.getUniprotTgnameMedN())
                .likeIfPresent(ScreenDO::getUniprotTgnameMedList, reqVO.getUniprotTgnameMedList())
                .eqIfPresent(ScreenDO::getUniprotTgshortMedN, reqVO.getUniprotTgshortMedN())
                .likeIfPresent(ScreenDO::getUniprotTgshortMedList, reqVO.getUniprotTgshortMedList())
                .eqIfPresent(ScreenDO::getAlternativeNameMedN, reqVO.getAlternativeNameMedN())
                .likeIfPresent(ScreenDO::getAlternativeNameMedList, reqVO.getAlternativeNameMedList())
                .eqIfPresent(ScreenDO::getUniprotDiseaseMedN, reqVO.getUniprotDiseaseMedN())
                .likeIfPresent(ScreenDO::getUniprotDiseaseMedList, reqVO.getUniprotDiseaseMedList())
                .eqIfPresent(ScreenDO::getUniprotGeneMedN, reqVO.getUniprotGeneMedN())
                .likeIfPresent(ScreenDO::getUniprotGeneMedList, reqVO.getUniprotGeneMedList())
                .eqIfPresent(ScreenDO::getPdbidMedN, reqVO.getPdbidMedN())
                .likeIfPresent(ScreenDO::getPdbidMedList, reqVO.getPdbidMedList())
                .betweenIfPresent(ScreenDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ScreenDO::getId));
    }

    default List<ScreenDO> selectList(ScreenExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ScreenDO>()
                .likeIfPresent(ScreenDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(ScreenDO::getUniprotId, reqVO.getUniprotId())
                .likeIfPresent(ScreenDO::getTgname, reqVO.getTgname())
                .likeIfPresent(ScreenDO::getPdbid, reqVO.getPdbid())
                .eqIfPresent(ScreenDO::getScore, reqVO.getScore())
                .eqIfPresent(ScreenDO::getBindingRate, reqVO.getBindingRate())
                .likeIfPresent(ScreenDO::getUniprotTgnameMedN, reqVO.getUniprotTgnameMedN())
                .likeIfPresent(ScreenDO::getUniprotTgnameMedList, reqVO.getUniprotTgnameMedList())
                .eqIfPresent(ScreenDO::getUniprotTgshortMedN, reqVO.getUniprotTgshortMedN())
                .likeIfPresent(ScreenDO::getUniprotTgshortMedList, reqVO.getUniprotTgshortMedList())
                .eqIfPresent(ScreenDO::getAlternativeNameMedN, reqVO.getAlternativeNameMedN())
                .likeIfPresent(ScreenDO::getAlternativeNameMedList, reqVO.getAlternativeNameMedList())
                .eqIfPresent(ScreenDO::getUniprotDiseaseMedN, reqVO.getUniprotDiseaseMedN())
                .likeIfPresent(ScreenDO::getUniprotDiseaseMedList, reqVO.getUniprotDiseaseMedList())
                .eqIfPresent(ScreenDO::getUniprotGeneMedN, reqVO.getUniprotGeneMedN())
                .likeIfPresent(ScreenDO::getUniprotGeneMedList, reqVO.getUniprotGeneMedList())
                .eqIfPresent(ScreenDO::getPdbidMedN, reqVO.getPdbidMedN())
                .likeIfPresent(ScreenDO::getPdbidMedList, reqVO.getPdbidMedList())
                .betweenIfPresent(ScreenDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ScreenDO::getId));
    }

    default List<ScreenDO> selectByDrug(String id) {
        return selectList(new LambdaQueryWrapperX<ScreenDO>()
                .likeIfPresent(ScreenDO::getDrugbankId, id)
                .orderByAsc(ScreenDO::getId));
    }

    default List<ScreenDO> selectIds(ScreenExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ScreenDO>()
                .likeIfPresent(ScreenDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(ScreenDO::getUniprotId, reqVO.getUniprotId())
                .likeIfPresent(ScreenDO::getTgname, reqVO.getTgname())
                .likeIfPresent(ScreenDO::getPdbid, reqVO.getPdbid())
                .eqIfPresent(ScreenDO::getScore, reqVO.getScore())
                .eqIfPresent(ScreenDO::getBindingRate, reqVO.getBindingRate())
                .likeIfPresent(ScreenDO::getUniprotTgnameMedN, reqVO.getUniprotTgnameMedN())
                .likeIfPresent(ScreenDO::getUniprotTgnameMedList, reqVO.getUniprotTgnameMedList())
                .eqIfPresent(ScreenDO::getUniprotTgshortMedN, reqVO.getUniprotTgshortMedN())
                .likeIfPresent(ScreenDO::getUniprotTgshortMedList, reqVO.getUniprotTgshortMedList())
                .eqIfPresent(ScreenDO::getAlternativeNameMedN, reqVO.getAlternativeNameMedN())
                .likeIfPresent(ScreenDO::getAlternativeNameMedList, reqVO.getAlternativeNameMedList())
                .eqIfPresent(ScreenDO::getUniprotDiseaseMedN, reqVO.getUniprotDiseaseMedN())
                .likeIfPresent(ScreenDO::getUniprotDiseaseMedList, reqVO.getUniprotDiseaseMedList())
                .eqIfPresent(ScreenDO::getUniprotGeneMedN, reqVO.getUniprotGeneMedN())
                .likeIfPresent(ScreenDO::getUniprotGeneMedList, reqVO.getUniprotGeneMedList())
                .eqIfPresent(ScreenDO::getPdbidMedN, reqVO.getPdbidMedN())
                .likeIfPresent(ScreenDO::getPdbidMedList, reqVO.getPdbidMedList())
                .betweenIfPresent(ScreenDO::getCreateTime, reqVO.getCreateTime())
                .orderByAsc(ScreenDO::getId)
                .select(ScreenDO::getDrugbankId));
    }

}
