package cn.ultragy.redrug.module.redrug.service.screen;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;

import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screen.ScreenDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.screen.ScreenMapper;

import org.springframework.context.annotation.Import;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.*;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link ScreenServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ScreenServiceImpl.class)
public class ScreenServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ScreenServiceImpl screenService;

    @Resource
    private ScreenMapper screenMapper;

    @Test
    public void testCreateScreen_success() {
        // 准备参数
        ScreenCreateReqVO reqVO = randomPojo(ScreenCreateReqVO.class);

        // 调用
        Integer screenId = screenService.createScreen(reqVO);
        // 断言
        assertNotNull(screenId);
        // 校验记录的属性是否正确
        ScreenDO screen = screenMapper.selectById(screenId);
        assertPojoEquals(reqVO, screen);
    }

    @Test
    public void testUpdateScreen_success() {
        // mock 数据
        ScreenDO dbScreen = randomPojo(ScreenDO.class);
        screenMapper.insert(dbScreen);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ScreenUpdateReqVO reqVO = randomPojo(ScreenUpdateReqVO.class, o -> {
            o.setId(dbScreen.getId()); // 设置更新的 ID
        });

        // 调用
        screenService.updateScreen(reqVO);
        // 校验是否更新正确
        ScreenDO screen = screenMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, screen);
    }

    @Test
    public void testUpdateScreen_notExists() {
        // 准备参数
        ScreenUpdateReqVO reqVO = randomPojo(ScreenUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> screenService.updateScreen(reqVO), SCREEN_NOT_EXISTS);
    }

    @Test
    public void testDeleteScreen_success() {
        // mock 数据
        ScreenDO dbScreen = randomPojo(ScreenDO.class);
        screenMapper.insert(dbScreen);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbScreen.getId();

        // 调用
        screenService.deleteScreen(id);
       // 校验数据不存在了
       assertNull(screenMapper.selectById(id));
    }


}
