package cn.ultragy.redrug.module.redrug.convert.ipadiseasesingle;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseasesingle.IpaDiseaseSingleDO;

/**
 * ipa预测适应症single Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface IpaDiseaseSingleConvert {

    IpaDiseaseSingleConvert INSTANCE = Mappers.getMapper(IpaDiseaseSingleConvert.class);

    IpaDiseaseSingleDO convert(IpaDiseaseSingleCreateReqVO bean);

    IpaDiseaseSingleDO convert(IpaDiseaseSingleUpdateReqVO bean);

    IpaDiseaseSingleRespVO convert(IpaDiseaseSingleDO bean);

    List<IpaDiseaseSingleRespVO> convertList(List<IpaDiseaseSingleDO> list);

    PageResult<IpaDiseaseSingleRespVO> convertPage(PageResult<IpaDiseaseSingleDO> page);

    List<IpaDiseaseSingleExcelVO> convertList02(List<IpaDiseaseSingleDO> list);

}
