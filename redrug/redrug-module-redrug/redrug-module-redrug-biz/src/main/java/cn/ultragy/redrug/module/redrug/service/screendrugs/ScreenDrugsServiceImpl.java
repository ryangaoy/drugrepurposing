package cn.ultragy.redrug.module.redrug.service.screendrugs;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.ScreenExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsPageReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.ScreenDrugsUpdateReqVO;
import cn.ultragy.redrug.module.redrug.convert.screendrugs.ScreenDrugsConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screen.ScreenDO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screendrugs.ScreenDrugsDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.screen.ScreenMapper;
import cn.ultragy.redrug.module.redrug.dal.mysql.screendrugs.ScreenDrugsMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.SCREEN_DRUGS_NOT_EXISTS;

/**
 * 筛选药物 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ScreenDrugsServiceImpl implements ScreenDrugsService {

    @Resource
    private ScreenDrugsMapper screenDrugsMapper;
    @Resource
    private ScreenMapper screenMapper;

    @Override
    public Integer createScreenDrugs(ScreenDrugsCreateReqVO createReqVO) {
        // 插入
        ScreenDrugsDO screenDrugs = ScreenDrugsConvert.INSTANCE.convert(createReqVO);
        screenDrugsMapper.insert(screenDrugs);
        // 返回
        return screenDrugs.getId();
    }

    @Override
    public void updateScreenDrugs(ScreenDrugsUpdateReqVO updateReqVO) {
        // 校验存在
        validateScreenDrugsExists(updateReqVO.getId());
        // 更新
        ScreenDrugsDO updateObj = ScreenDrugsConvert.INSTANCE.convert(updateReqVO);
        screenDrugsMapper.updateById(updateObj);
    }

    @Override
    public void deleteScreenDrugs(Integer id) {
        // 校验存在
        validateScreenDrugsExists(id);
        // 删除
        screenDrugsMapper.deleteById(id);
    }

    private void validateScreenDrugsExists(Integer id) {
        if (screenDrugsMapper.selectById(id) == null) {
            throw exception(SCREEN_DRUGS_NOT_EXISTS);
        }
    }

    @Override
    public ScreenDrugsDO getScreenDrugs(Integer id) {
        return screenDrugsMapper.selectById(id);
    }

    @Override
    public ScreenDrugsDO getScreenDrugsByDrug(String id) {
        return screenDrugsMapper.selectByDrug(id);
    }

    @Override
    public List<ScreenDrugsDO> getScreenDrugsList(Collection<Integer> ids) {
        return screenDrugsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ScreenDrugsDO> getScreenDrugsPage(ScreenDrugsPageReqVO pageReqVO) {
        return screenDrugsMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<ScreenDrugsDO> screensearch(ScreenExportReqVO reqVO) {
        List<ScreenDO> screenDOS = screenMapper.selectIds(reqVO);
        List<String> ids = screenDOS.stream().map(ScreenDO::getDrugbankId).collect(Collectors.toList());
        return screenDrugsMapper.selectPageByIds(new ScreenDrugsPageReqVO(), ids);
    }

    @Override
    public List<ScreenDrugsDO> getScreenDrugsList(ScreenDrugsExportReqVO exportReqVO) {
        return screenDrugsMapper.selectList(exportReqVO);
    }

}
