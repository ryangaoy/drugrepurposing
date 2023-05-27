package cn.ultragy.redrug.module.redrug.service.md;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;

import cn.ultragy.redrug.module.redrug.controller.admin.md.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.md.MdDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.md.MdMapper;

import org.springframework.context.annotation.Import;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.*;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link MdServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MdServiceImpl.class)
public class MdServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MdServiceImpl mdService;

    @Resource
    private MdMapper mdMapper;

    @Test
    public void testCreateMd_success() {
        // 准备参数
        MdCreateReqVO reqVO = randomPojo(MdCreateReqVO.class);

        // 调用
        Integer mdId = mdService.createMd(reqVO);
        // 断言
        assertNotNull(mdId);
        // 校验记录的属性是否正确
        MdDO md = mdMapper.selectById(mdId);
        assertPojoEquals(reqVO, md);
    }

    @Test
    public void testUpdateMd_success() {
        // mock 数据
        MdDO dbMd = randomPojo(MdDO.class);
        mdMapper.insert(dbMd);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MdUpdateReqVO reqVO = randomPojo(MdUpdateReqVO.class, o -> {
            o.setId(dbMd.getId()); // 设置更新的 ID
        });

        // 调用
        mdService.updateMd(reqVO);
        // 校验是否更新正确
        MdDO md = mdMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, md);
    }

    @Test
    public void testUpdateMd_notExists() {
        // 准备参数
        MdUpdateReqVO reqVO = randomPojo(MdUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> mdService.updateMd(reqVO), MD_NOT_EXISTS);
    }

    @Test
    public void testDeleteMd_success() {
        // mock 数据
        MdDO dbMd = randomPojo(MdDO.class);
        mdMapper.insert(dbMd);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbMd.getId();

        // 调用
        mdService.deleteMd(id);
       // 校验数据不存在了
       assertNull(mdMapper.selectById(id));
    }

}
