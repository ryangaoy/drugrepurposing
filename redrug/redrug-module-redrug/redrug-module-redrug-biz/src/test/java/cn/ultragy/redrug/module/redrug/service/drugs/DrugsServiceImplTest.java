package cn.ultragy.redrug.module.redrug.service.drugs;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.DrugsCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.DrugsUpdateReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugs.DrugsDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.drugs.DrugsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.randomPojo;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.DRUGS_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link DrugsServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(DrugsServiceImpl.class)
public class DrugsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DrugsServiceImpl drugsService;

    @Resource
    private DrugsMapper drugsMapper;

    @Test
    public void testCreateDrugs_success() {
        // 准备参数
        DrugsCreateReqVO reqVO = randomPojo(DrugsCreateReqVO.class);

        // 调用
        String drugsId = drugsService.createDrugs(reqVO);
        // 断言
        assertNotNull(drugsId);
        // 校验记录的属性是否正确
        DrugsDO drugs = drugsMapper.selectById(drugsId);
        assertPojoEquals(reqVO, drugs);
    }

    @Test
    public void testUpdateDrugs_success() {
        // mock 数据
        DrugsDO dbDrugs = randomPojo(DrugsDO.class);
        drugsMapper.insert(dbDrugs);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DrugsUpdateReqVO reqVO = randomPojo(DrugsUpdateReqVO.class, o -> {
            o.setDrugbankId(dbDrugs.getDrugbankId()); // 设置更新的 ID
        });

        // 调用
        drugsService.updateDrugs(reqVO);
        // 校验是否更新正确
        DrugsDO drugs = drugsMapper.selectById(reqVO.getDrugbankId()); // 获取最新的
        assertPojoEquals(reqVO, drugs);
    }

    @Test
    public void testUpdateDrugs_notExists() {
        // 准备参数
        DrugsUpdateReqVO reqVO = randomPojo(DrugsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> drugsService.updateDrugs(reqVO), DRUGS_NOT_EXISTS);
    }

    @Test
    public void testDeleteDrugs_success() {
        // mock 数据
        DrugsDO dbDrugs = randomPojo(DrugsDO.class);
        drugsMapper.insert(dbDrugs);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbDrugs.getDrugbankId();

        // 调用
        drugsService.deleteDrugs(id);
       // 校验数据不存在了
       assertNull(drugsMapper.selectById(id));
    }

    @Test
    public void testDeleteDrugs_notExists() {
        // 准备参数
        String id = "1231321321321";

        // 调用, 并断言异常
        assertServiceException(() -> drugsService.deleteDrugs(id), DRUGS_NOT_EXISTS);
    }


}
