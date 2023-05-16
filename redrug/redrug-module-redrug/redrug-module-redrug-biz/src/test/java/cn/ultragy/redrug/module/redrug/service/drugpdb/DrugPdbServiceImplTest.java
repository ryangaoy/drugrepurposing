package cn.ultragy.redrug.module.redrug.service.drugpdb;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;
import cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo.DrugPdbCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo.DrugPdbUpdateReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugpdb.DrugPdbDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.drugpdb.DrugPdbMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.randomPojo;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.DRUG_PDB_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
* {@link DrugPdbServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(DrugPdbServiceImpl.class)
public class DrugPdbServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DrugPdbServiceImpl drugPdbService;

    @Resource
    private DrugPdbMapper drugPdbMapper;

    @Test
    public void testCreateDrugPdb_success() {
        // 准备参数
        DrugPdbCreateReqVO reqVO = randomPojo(DrugPdbCreateReqVO.class);

        // 调用
        Integer drugPdbId = drugPdbService.createDrugPdb(reqVO);
        // 断言
        assertNotNull(drugPdbId);
        // 校验记录的属性是否正确
        DrugPdbDO drugPdb = drugPdbMapper.selectById(drugPdbId);
        assertPojoEquals(reqVO, drugPdb);
    }

    @Test
    public void testUpdateDrugPdb_success() {
        // mock 数据
        DrugPdbDO dbDrugPdb = randomPojo(DrugPdbDO.class);
        drugPdbMapper.insert(dbDrugPdb);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DrugPdbUpdateReqVO reqVO = randomPojo(DrugPdbUpdateReqVO.class, o -> {
            o.setId(dbDrugPdb.getId()); // 设置更新的 ID
        });

        // 调用
        drugPdbService.updateDrugPdb(reqVO);
        // 校验是否更新正确
        DrugPdbDO drugPdb = drugPdbMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, drugPdb);
    }

    @Test
    public void testUpdateDrugPdb_notExists() {
        // 准备参数
        DrugPdbUpdateReqVO reqVO = randomPojo(DrugPdbUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> drugPdbService.updateDrugPdb(reqVO), DRUG_PDB_NOT_EXISTS);
    }

    @Test
    public void testDeleteDrugPdb_success() {
        // mock 数据
        DrugPdbDO dbDrugPdb = randomPojo(DrugPdbDO.class);
        drugPdbMapper.insert(dbDrugPdb);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbDrugPdb.getId();

        // 调用
        drugPdbService.deleteDrugPdb(id);
       // 校验数据不存在了
       assertNull(drugPdbMapper.selectById(id));
    }

}
