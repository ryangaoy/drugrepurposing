package cn.ultragy.redrug.module.redrug.service.ipadiseaseall;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo.IpaDiseaseAllCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo.IpaDiseaseAllUpdateReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseaseall.IpaDiseaseAllDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.ipadiseaseall.IpaDiseaseAllMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.randomPojo;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.IPA_DISEASE_ALL_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
* {@link IpaDiseaseAllServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(IpaDiseaseAllServiceImpl.class)
public class IpaDiseaseAllServiceImplTest extends BaseDbUnitTest {

    @Resource
    private IpaDiseaseAllServiceImpl ipaDiseaseAllService;

    @Resource
    private IpaDiseaseAllMapper ipaDiseaseAllMapper;

    @Test
    public void testCreateIpaDiseaseAll_success() {
        // 准备参数
        IpaDiseaseAllCreateReqVO reqVO = randomPojo(IpaDiseaseAllCreateReqVO.class);

        // 调用
        Integer ipaDiseaseAllId = ipaDiseaseAllService.createIpaDiseaseAll(reqVO);
        // 断言
        assertNotNull(ipaDiseaseAllId);
        // 校验记录的属性是否正确
        IpaDiseaseAllDO ipaDiseaseAll = ipaDiseaseAllMapper.selectById(ipaDiseaseAllId);
        assertPojoEquals(reqVO, ipaDiseaseAll);
    }

    @Test
    public void testUpdateIpaDiseaseAll_success() {
        // mock 数据
        IpaDiseaseAllDO dbIpaDiseaseAll = randomPojo(IpaDiseaseAllDO.class);
        ipaDiseaseAllMapper.insert(dbIpaDiseaseAll);// @Sql: 先插入出一条存在的数据
        // 准备参数
        IpaDiseaseAllUpdateReqVO reqVO = randomPojo(IpaDiseaseAllUpdateReqVO.class, o -> {
            o.setId(dbIpaDiseaseAll.getId()); // 设置更新的 ID
        });

        // 调用
        ipaDiseaseAllService.updateIpaDiseaseAll(reqVO);
        // 校验是否更新正确
        IpaDiseaseAllDO ipaDiseaseAll = ipaDiseaseAllMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, ipaDiseaseAll);
    }

    @Test
    public void testUpdateIpaDiseaseAll_notExists() {
        // 准备参数
        IpaDiseaseAllUpdateReqVO reqVO = randomPojo(IpaDiseaseAllUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> ipaDiseaseAllService.updateIpaDiseaseAll(reqVO), IPA_DISEASE_ALL_NOT_EXISTS);
    }

    @Test
    public void testDeleteIpaDiseaseAll_success() {
        // mock 数据
        IpaDiseaseAllDO dbIpaDiseaseAll = randomPojo(IpaDiseaseAllDO.class);
        ipaDiseaseAllMapper.insert(dbIpaDiseaseAll);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbIpaDiseaseAll.getId();

        // 调用
        ipaDiseaseAllService.deleteIpaDiseaseAll(id);
       // 校验数据不存在了
       assertNull(ipaDiseaseAllMapper.selectById(id));
    }


}
