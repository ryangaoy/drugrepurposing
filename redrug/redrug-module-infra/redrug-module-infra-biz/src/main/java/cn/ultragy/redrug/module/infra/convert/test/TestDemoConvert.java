package cn.ultragy.redrug.module.infra.convert.test;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.module.infra.controller.admin.test.vo.TestDemoCreateReqVO;
import cn.ultragy.redrug.module.infra.controller.admin.test.vo.TestDemoExcelVO;
import cn.ultragy.redrug.module.infra.controller.admin.test.vo.TestDemoRespVO;
import cn.ultragy.redrug.module.infra.controller.admin.test.vo.TestDemoUpdateReqVO;
import cn.ultragy.redrug.module.infra.dal.dataobject.test.TestDemoDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 字典类型 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TestDemoConvert {

    TestDemoConvert INSTANCE = Mappers.getMapper(TestDemoConvert.class);

    TestDemoDO convert(TestDemoCreateReqVO bean);

    TestDemoDO convert(TestDemoUpdateReqVO bean);

    TestDemoRespVO convert(TestDemoDO bean);

    List<TestDemoRespVO> convertList(List<TestDemoDO> list);

    PageResult<TestDemoRespVO> convertPage(PageResult<TestDemoDO> page);

    List<TestDemoExcelVO> convertList02(List<TestDemoDO> list);

}
