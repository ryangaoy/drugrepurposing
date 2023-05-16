package cn.ultragy.redrug.module.system.convert.logger;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.module.system.api.logger.dto.LoginLogCreateReqDTO;
import cn.ultragy.redrug.module.system.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import cn.ultragy.redrug.module.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import cn.ultragy.redrug.module.system.dal.dataobject.logger.LoginLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    PageResult<LoginLogRespVO> convertPage(PageResult<LoginLogDO> page);

    List<LoginLogExcelVO> convertList(List<LoginLogDO> list);

    LoginLogDO convert(LoginLogCreateReqDTO bean);

}
