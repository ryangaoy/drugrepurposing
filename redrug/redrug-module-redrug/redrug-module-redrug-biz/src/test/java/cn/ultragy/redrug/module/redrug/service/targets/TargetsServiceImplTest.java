package cn.ultragy.redrug.module.redrug.service.targets;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;

import cn.ultragy.redrug.module.redrug.controller.admin.targets.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.targets.TargetsDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.targets.TargetsMapper;

import org.springframework.context.annotation.Import;

import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.*;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link TargetsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(TargetsServiceImpl.class)
public class TargetsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private TargetsServiceImpl targetsService;

    @Resource
    private TargetsMapper targetsMapper;

    @Test
    public void testCreateTargets_success() {
        // 准备参数
        TargetsCreateReqVO reqVO = randomPojo(TargetsCreateReqVO.class);

        // 调用
        Integer targetsId = targetsService.createTargets(reqVO);
        // 断言
        assertNotNull(targetsId);
        // 校验记录的属性是否正确
        TargetsDO targets = targetsMapper.selectById(targetsId);
        assertPojoEquals(reqVO, targets);
    }

    @Test
    public void testUpdateTargets_success() {
        // mock 数据
        TargetsDO dbTargets = randomPojo(TargetsDO.class);
        targetsMapper.insert(dbTargets);// @Sql: 先插入出一条存在的数据
        // 准备参数
        TargetsUpdateReqVO reqVO = randomPojo(TargetsUpdateReqVO.class, o -> {
            o.setId(dbTargets.getId()); // 设置更新的 ID
        });

        // 调用
        targetsService.updateTargets(reqVO);
        // 校验是否更新正确
        TargetsDO targets = targetsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, targets);
    }

    @Test
    public void testUpdateTargets_notExists() {
        // 准备参数
        TargetsUpdateReqVO reqVO = randomPojo(TargetsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> targetsService.updateTargets(reqVO), TARGETS_NOT_EXISTS);
    }

    @Test
    public void testDeleteTargets_success() {
        // mock 数据
        TargetsDO dbTargets = randomPojo(TargetsDO.class);
        targetsMapper.insert(dbTargets);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbTargets.getId();

        // 调用
        targetsService.deleteTargets(id);
       // 校验数据不存在了
       assertNull(targetsMapper.selectById(id));
    }




}
