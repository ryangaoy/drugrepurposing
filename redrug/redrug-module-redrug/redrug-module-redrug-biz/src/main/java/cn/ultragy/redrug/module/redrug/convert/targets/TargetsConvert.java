package cn.ultragy.redrug.module.redrug.convert.targets;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.targets.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.targets.TargetsDO;

/**
 * 靶点pdb Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TargetsConvert {

    TargetsConvert INSTANCE = Mappers.getMapper(TargetsConvert.class);

    TargetsDO convert(TargetsCreateReqVO bean);

    TargetsDO convert(TargetsUpdateReqVO bean);

    TargetsRespVO convert(TargetsDO bean);

    List<TargetsRespVO> convertList(List<TargetsDO> list);

    PageResult<TargetsRespVO> convertPage(PageResult<TargetsDO> page);

    List<TargetsExcelVO> convertList02(List<TargetsDO> list);

}
