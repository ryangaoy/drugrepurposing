package cn.ultragy.redrug.module.redrug.convert.md;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.md.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.md.MdDO;

/**
 * 分子动力学模拟结果列 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MdConvert {

    MdConvert INSTANCE = Mappers.getMapper(MdConvert.class);

    MdDO convert(MdCreateReqVO bean);

    MdDO convert(MdUpdateReqVO bean);

    MdRespVO convert(MdDO bean);

    List<MdRespVO> convertList(List<MdDO> list);

    PageResult<MdRespVO> convertPage(PageResult<MdDO> page);

    List<MdExcelVO> convertList02(List<MdDO> list);

}
