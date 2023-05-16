package cn.ultragy.redrug.module.redrug.service.pathways;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;

import cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.pathways.PathwaysDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.pathways.PathwaysMapper;

import org.springframework.context.annotation.Import;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.*;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link PathwaysServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(PathwaysServiceImpl.class)
public class PathwaysServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PathwaysServiceImpl pathwaysService;

    @Resource
    private PathwaysMapper pathwaysMapper;

    @Test
    public void testCreatePathways_success() {
        // 准备参数
        PathwaysCreateReqVO reqVO = randomPojo(PathwaysCreateReqVO.class);

        // 调用
        Integer pathwaysId = pathwaysService.createPathways(reqVO);
        // 断言
        assertNotNull(pathwaysId);
        // 校验记录的属性是否正确
        PathwaysDO pathways = pathwaysMapper.selectById(pathwaysId);
        assertPojoEquals(reqVO, pathways);
    }

    @Test
    public void testUpdatePathways_success() {
        // mock 数据
        PathwaysDO dbPathways = randomPojo(PathwaysDO.class);
        pathwaysMapper.insert(dbPathways);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PathwaysUpdateReqVO reqVO = randomPojo(PathwaysUpdateReqVO.class, o -> {
            o.setId(dbPathways.getId()); // 设置更新的 ID
        });

        // 调用
        pathwaysService.updatePathways(reqVO);
        // 校验是否更新正确
        PathwaysDO pathways = pathwaysMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, pathways);
    }

    @Test
    public void testUpdatePathways_notExists() {
        // 准备参数
        PathwaysUpdateReqVO reqVO = randomPojo(PathwaysUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> pathwaysService.updatePathways(reqVO), PATHWAYS_NOT_EXISTS);
    }

    @Test
    public void testDeletePathways_success() {
        // mock 数据
        PathwaysDO dbPathways = randomPojo(PathwaysDO.class);
        pathwaysMapper.insert(dbPathways);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbPathways.getId();

        // 调用
        pathwaysService.deletePathways(id);
       // 校验数据不存在了
       assertNull(pathwaysMapper.selectById(id));
    }

}
