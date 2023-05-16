package cn.ultragy.redrug.module.redrug.convert.drugpdb;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugpdb.DrugPdbDO;

/**
 * drug_pdb Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DrugPdbConvert {

    DrugPdbConvert INSTANCE = Mappers.getMapper(DrugPdbConvert.class);

    DrugPdbDO convert(DrugPdbCreateReqVO bean);

    DrugPdbDO convert(DrugPdbUpdateReqVO bean);

    DrugPdbRespVO convert(DrugPdbDO bean);

    List<DrugPdbRespVO> convertList(List<DrugPdbDO> list);

    PageResult<DrugPdbRespVO> convertPage(PageResult<DrugPdbDO> page);

    List<DrugPdbExcelVO> convertList02(List<DrugPdbDO> list);

}
