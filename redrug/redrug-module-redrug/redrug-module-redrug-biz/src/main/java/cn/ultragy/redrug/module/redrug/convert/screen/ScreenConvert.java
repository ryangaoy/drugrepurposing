package cn.ultragy.redrug.module.redrug.convert.screen;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screen.ScreenDO;

/**
 * 筛选结果 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ScreenConvert {

    ScreenConvert INSTANCE = Mappers.getMapper(ScreenConvert.class);

    ScreenDO convert(ScreenCreateReqVO bean);

    ScreenDO convert(ScreenUpdateReqVO bean);

    ScreenRespVO convert(ScreenDO bean);

    List<ScreenRespVO> convertList(List<ScreenDO> list);

    PageResult<ScreenRespVO> convertPage(PageResult<ScreenDO> page);

    List<ScreenExcelVO> convertList02(List<ScreenDO> list);

}
