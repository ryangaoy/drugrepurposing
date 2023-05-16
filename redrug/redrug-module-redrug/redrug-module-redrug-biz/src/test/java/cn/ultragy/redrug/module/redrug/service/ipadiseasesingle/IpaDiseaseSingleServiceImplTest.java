package cn.ultragy.redrug.module.redrug.service.ipadiseasesingle;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo.IpaDiseaseSingleCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo.IpaDiseaseSingleUpdateReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseasesingle.IpaDiseaseSingleDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.ipadiseasesingle.IpaDiseaseSingleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.randomPojo;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.IPA_DISEASE_SINGLE_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
* {@link IpaDiseaseSingleServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(IpaDiseaseSingleServiceImpl.class)
public class IpaDiseaseSingleServiceImplTest extends BaseDbUnitTest {

    @Resource
    private IpaDiseaseSingleServiceImpl ipaDiseaseSingleService;

    @Resource
    private IpaDiseaseSingleMapper ipaDiseaseSingleMapper;

    @Test
    public void testCreateIpaDiseaseSingle_success() {
        // 准备参数
        IpaDiseaseSingleCreateReqVO reqVO = randomPojo(IpaDiseaseSingleCreateReqVO.class);

        // 调用
        Integer ipaDiseaseSingleId = ipaDiseaseSingleService.createIpaDiseaseSingle(reqVO);
        // 断言
        assertNotNull(ipaDiseaseSingleId);
        // 校验记录的属性是否正确
        IpaDiseaseSingleDO ipaDiseaseSingle = ipaDiseaseSingleMapper.selectById(ipaDiseaseSingleId);
        assertPojoEquals(reqVO, ipaDiseaseSingle);
    }

    @Test
    public void testUpdateIpaDiseaseSingle_success() {
        // mock 数据
        IpaDiseaseSingleDO dbIpaDiseaseSingle = randomPojo(IpaDiseaseSingleDO.class);
        ipaDiseaseSingleMapper.insert(dbIpaDiseaseSingle);// @Sql: 先插入出一条存在的数据
        // 准备参数
        IpaDiseaseSingleUpdateReqVO reqVO = randomPojo(IpaDiseaseSingleUpdateReqVO.class, o -> {
            o.setId(dbIpaDiseaseSingle.getId()); // 设置更新的 ID
        });

        // 调用
        ipaDiseaseSingleService.updateIpaDiseaseSingle(reqVO);
        // 校验是否更新正确
        IpaDiseaseSingleDO ipaDiseaseSingle = ipaDiseaseSingleMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, ipaDiseaseSingle);
    }

    @Test
    public void testUpdateIpaDiseaseSingle_notExists() {
        // 准备参数
        IpaDiseaseSingleUpdateReqVO reqVO = randomPojo(IpaDiseaseSingleUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> ipaDiseaseSingleService.updateIpaDiseaseSingle(reqVO), IPA_DISEASE_SINGLE_NOT_EXISTS);
    }

    @Test
    public void testDeleteIpaDiseaseSingle_success() {
        // mock 数据
        IpaDiseaseSingleDO dbIpaDiseaseSingle = randomPojo(IpaDiseaseSingleDO.class);
        ipaDiseaseSingleMapper.insert(dbIpaDiseaseSingle);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbIpaDiseaseSingle.getId();

        // 调用
        ipaDiseaseSingleService.deleteIpaDiseaseSingle(id);
       // 校验数据不存在了
       assertNull(ipaDiseaseSingleMapper.selectById(id));
    }

}
