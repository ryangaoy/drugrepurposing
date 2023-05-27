package cn.ultragy.redrug.module.redrug.convert.pathways;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.pathways.PathwaysDO;

/**
 * 基因通路 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PathwaysConvert {

    PathwaysConvert INSTANCE = Mappers.getMapper(PathwaysConvert.class);

    PathwaysDO convert(PathwaysCreateReqVO bean);

    PathwaysDO convert(PathwaysUpdateReqVO bean);

    PathwaysRespVO convert(PathwaysDO bean);

    List<PathwaysRespVO> convertList(List<PathwaysDO> list);

    PageResult<PathwaysRespVO> convertPage(PageResult<PathwaysDO> page);

    List<PathwaysExcelVO> convertList02(List<PathwaysDO> list);

}
