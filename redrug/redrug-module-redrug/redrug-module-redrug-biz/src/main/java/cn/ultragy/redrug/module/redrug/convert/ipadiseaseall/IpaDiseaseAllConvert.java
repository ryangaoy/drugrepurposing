package cn.ultragy.redrug.module.redrug.convert.ipadiseaseall;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseaseall.IpaDiseaseAllDO;

/**
 * ipa预测适应症all Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface IpaDiseaseAllConvert {

    IpaDiseaseAllConvert INSTANCE = Mappers.getMapper(IpaDiseaseAllConvert.class);

    IpaDiseaseAllDO convert(IpaDiseaseAllCreateReqVO bean);

    IpaDiseaseAllDO convert(IpaDiseaseAllUpdateReqVO bean);

    IpaDiseaseAllRespVO convert(IpaDiseaseAllDO bean);

    List<IpaDiseaseAllRespVO> convertList(List<IpaDiseaseAllDO> list);

    PageResult<IpaDiseaseAllRespVO> convertPage(PageResult<IpaDiseaseAllDO> page);

    List<IpaDiseaseAllExcelVO> convertList02(List<IpaDiseaseAllDO> list);

}
