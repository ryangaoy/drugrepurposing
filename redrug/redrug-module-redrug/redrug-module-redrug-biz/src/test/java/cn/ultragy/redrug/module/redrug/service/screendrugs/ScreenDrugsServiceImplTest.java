package cn.ultragy.redrug.module.redrug.service.screendrugs;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsUpdateReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screendrugs.ScreenDrugsDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.screendrugs.ScreenDrugsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.randomPojo;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.SCREEN_DRUGS_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
* {@link ScreenDrugsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ScreenDrugsServiceImpl.class)
public class ScreenDrugsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ScreenDrugsServiceImpl screenDrugsService;

    @Resource
    private ScreenDrugsMapper screenDrugsMapper;

    @Test
    public void testCreateScreenDrugs_success() {
        // 准备参数
        ScreenDrugsCreateReqVO reqVO = randomPojo(ScreenDrugsCreateReqVO.class);

        // 调用
        Integer screenDrugsId = screenDrugsService.createScreenDrugs(reqVO);
        // 断言
        assertNotNull(screenDrugsId);
        // 校验记录的属性是否正确
        ScreenDrugsDO screenDrugs = screenDrugsMapper.selectById(screenDrugsId);
        assertPojoEquals(reqVO, screenDrugs);
    }

    @Test
    public void testUpdateScreenDrugs_success() {
        // mock 数据
        ScreenDrugsDO dbScreenDrugs = randomPojo(ScreenDrugsDO.class);
        screenDrugsMapper.insert(dbScreenDrugs);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ScreenDrugsUpdateReqVO reqVO = randomPojo(ScreenDrugsUpdateReqVO.class, o -> {
            o.setId(dbScreenDrugs.getId()); // 设置更新的 ID
        });

        // 调用
        screenDrugsService.updateScreenDrugs(reqVO);
        // 校验是否更新正确
        ScreenDrugsDO screenDrugs = screenDrugsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, screenDrugs);
    }

    @Test
    public void testUpdateScreenDrugs_notExists() {
        // 准备参数
        ScreenDrugsUpdateReqVO reqVO = randomPojo(ScreenDrugsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> screenDrugsService.updateScreenDrugs(reqVO), SCREEN_DRUGS_NOT_EXISTS);
    }

    @Test
    public void testDeleteScreenDrugs_success() {
        // mock 数据
        ScreenDrugsDO dbScreenDrugs = randomPojo(ScreenDrugsDO.class);
        screenDrugsMapper.insert(dbScreenDrugs);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbScreenDrugs.getId();

        // 调用
        screenDrugsService.deleteScreenDrugs(id);
       // 校验数据不存在了
       assertNull(screenDrugsMapper.selectById(id));
    }

}
