package cn.ultragy.redrug.module.redrug.convert.drugs;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugs.DrugsDO;

/**
 * 药物信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DrugsConvert {

    DrugsConvert INSTANCE = Mappers.getMapper(DrugsConvert.class);

    DrugsDO convert(DrugsCreateReqVO bean);

    DrugsDO convert(DrugsUpdateReqVO bean);

    DrugsRespVO convert(DrugsDO bean);

    List<DrugsRespVO> convertList(List<DrugsDO> list);

    PageResult<DrugsRespVO> convertPage(PageResult<DrugsDO> page);

    List<DrugsExcelVO> convertList02(List<DrugsDO> list);

}
