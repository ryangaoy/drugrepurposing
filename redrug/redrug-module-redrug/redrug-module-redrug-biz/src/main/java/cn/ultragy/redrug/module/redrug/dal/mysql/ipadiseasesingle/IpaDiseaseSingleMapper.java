package cn.ultragy.redrug.module.redrug.dal.mysql.ipadiseasesingle;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseasesingle.IpaDiseaseSingleDO;
import org.apache.ibatis.annotations.Mapper;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo.*;

/**
 * ipa预测适应症single Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface IpaDiseaseSingleMapper extends BaseMapperX<IpaDiseaseSingleDO> {

    default PageResult<IpaDiseaseSingleDO> selectPage(IpaDiseaseSinglePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<IpaDiseaseSingleDO>()
                .likeIfPresent(IpaDiseaseSingleDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(IpaDiseaseSingleDO::getGene, reqVO.getGene())
                .likeIfPresent(IpaDiseaseSingleDO::getDfunction, reqVO.getDfunction())
                .likeIfPresent(IpaDiseaseSingleDO::getDisease, reqVO.getDisease())
                .orderByDesc(IpaDiseaseSingleDO::getId));
    }

    default List<IpaDiseaseSingleDO> selectList(IpaDiseaseSingleExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<IpaDiseaseSingleDO>()
                .likeIfPresent(IpaDiseaseSingleDO::getDrugbankId, reqVO.getDrugbankId())
                .likeIfPresent(IpaDiseaseSingleDO::getGene, reqVO.getGene())
                .likeIfPresent(IpaDiseaseSingleDO::getDfunction, reqVO.getDfunction())
                .likeIfPresent(IpaDiseaseSingleDO::getDisease, reqVO.getDisease())
                .orderByDesc(IpaDiseaseSingleDO::getId));
    }

    default IpaDiseaseSingleDO selectByDrug(String id) {
        return selectOne(new LambdaQueryWrapperX<IpaDiseaseSingleDO>()
                .likeIfPresent(IpaDiseaseSingleDO::getDrugbankId, id));
    }

}
