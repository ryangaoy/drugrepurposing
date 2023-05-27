package cn.ultragy.redrug.module.redrug.service.screen;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screen.ScreenDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.redrug.convert.screen.ScreenConvert;
import cn.ultragy.redrug.module.redrug.dal.mysql.screen.ScreenMapper;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;

/**
 * 筛选结果 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ScreenServiceImpl implements ScreenService {

    @Resource
    private ScreenMapper screenMapper;

    @Override
    public Integer createScreen(ScreenCreateReqVO createReqVO) {
        // 插入
        ScreenDO screen = ScreenConvert.INSTANCE.convert(createReqVO);
        screenMapper.insert(screen);
        // 返回
        return screen.getId();
    }

    @Override
    public void updateScreen(ScreenUpdateReqVO updateReqVO) {
        // 校验存在
        validateScreenExists(updateReqVO.getId());
        // 更新
        ScreenDO updateObj = ScreenConvert.INSTANCE.convert(updateReqVO);
        screenMapper.updateById(updateObj);
    }

    @Override
    public void deleteScreen(Integer id) {
        // 校验存在
        validateScreenExists(id);
        // 删除
        screenMapper.deleteById(id);
    }

    private void validateScreenExists(Integer id) {
        if (screenMapper.selectById(id) == null) {
            throw exception(SCREEN_NOT_EXISTS);
        }
    }

    @Override
    public ScreenDO getScreen(Integer id) {
        return screenMapper.selectById(id);
    }

    @Override
    public List<ScreenDO> getScreenList(Collection<Integer> ids) {
        return screenMapper.selectBatchIds(ids);
    }

    @Override
    public List<ScreenDO> getScreenListByDrug(String id) {
        return screenMapper.selectByDrug(id);
    }

    @Override
    public PageResult<ScreenDO> getScreenPage(ScreenPageReqVO pageReqVO) {
        return screenMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ScreenDO> getScreenList(ScreenExportReqVO exportReqVO) {
        return screenMapper.selectList(exportReqVO);
    }

}
