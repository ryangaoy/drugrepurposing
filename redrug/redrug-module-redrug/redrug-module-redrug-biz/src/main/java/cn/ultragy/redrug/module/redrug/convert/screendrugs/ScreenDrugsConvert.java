package cn.ultragy.redrug.module.redrug.convert.screendrugs;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screendrugs.ScreenDrugsDO;

/**
 * 筛选药物 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ScreenDrugsConvert {

    ScreenDrugsConvert INSTANCE = Mappers.getMapper(ScreenDrugsConvert.class);

    ScreenDrugsDO convert(ScreenDrugsCreateReqVO bean);

    ScreenDrugsDO convert(ScreenDrugsUpdateReqVO bean);

    ScreenDrugsRespVO convert(ScreenDrugsDO bean);

    List<ScreenDrugsRespVO> convertList(List<ScreenDrugsDO> list);

    PageResult<ScreenDrugsRespVO> convertPage(PageResult<ScreenDrugsDO> page);

    List<ScreenDrugsExcelVO> convertList02(List<ScreenDrugsDO> list);

}
