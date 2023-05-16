package cn.ultragy.redrug.module.infra.convert.logger;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import cn.ultragy.redrug.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import cn.ultragy.redrug.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import cn.ultragy.redrug.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 错误日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
