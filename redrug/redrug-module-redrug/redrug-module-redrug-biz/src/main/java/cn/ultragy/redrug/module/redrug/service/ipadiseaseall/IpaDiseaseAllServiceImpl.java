package cn.ultragy.redrug.module.redrug.service.ipadiseaseall;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseaseall.IpaDiseaseAllDO;
import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.redrug.convert.ipadiseaseall.IpaDiseaseAllConvert;
import cn.ultragy.redrug.module.redrug.dal.mysql.ipadiseaseall.IpaDiseaseAllMapper;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.*;

/**
 * ipa预测适应症all Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class IpaDiseaseAllServiceImpl implements IpaDiseaseAllService {

    @Resource
    private IpaDiseaseAllMapper ipaDiseaseAllMapper;

    @Override
    public Integer createIpaDiseaseAll(IpaDiseaseAllCreateReqVO createReqVO) {
        // 插入
        IpaDiseaseAllDO ipaDiseaseAll = IpaDiseaseAllConvert.INSTANCE.convert(createReqVO);
        ipaDiseaseAllMapper.insert(ipaDiseaseAll);
        // 返回
        return ipaDiseaseAll.getId();
    }

    @Override
    public void updateIpaDiseaseAll(IpaDiseaseAllUpdateReqVO updateReqVO) {
        // 校验存在
        validateIpaDiseaseAllExists(updateReqVO.getId());
        // 更新
        IpaDiseaseAllDO updateObj = IpaDiseaseAllConvert.INSTANCE.convert(updateReqVO);
        ipaDiseaseAllMapper.updateById(updateObj);
    }

    @Override
    public void deleteIpaDiseaseAll(Integer id) {
        // 校验存在
        validateIpaDiseaseAllExists(id);
        // 删除
        ipaDiseaseAllMapper.deleteById(id);
    }

    private void validateIpaDiseaseAllExists(Integer id) {
        if (ipaDiseaseAllMapper.selectById(id) == null) {
            throw exception(IPA_DISEASE_ALL_NOT_EXISTS);
        }
    }

    @Override
    public IpaDiseaseAllDO getIpaDiseaseAll(Integer id) {
        return ipaDiseaseAllMapper.selectById(id);
    }

    @Override
    public List<IpaDiseaseAllDO> getIpaDiseaseAllList(Collection<Integer> ids) {
        return ipaDiseaseAllMapper.selectBatchIds(ids);
    }

    @Override
    public List<IpaDiseaseAllDO> getIpaDiseaseAllListByDrug(String id) {
        return ipaDiseaseAllMapper.selectByDrug(id);
    }

    @Override
    public PageResult<IpaDiseaseAllDO> getIpaDiseaseAllPage(IpaDiseaseAllPageReqVO pageReqVO) {
        return ipaDiseaseAllMapper.selectPage(pageReqVO);
    }

    @Override
    public List<IpaDiseaseAllDO> getIpaDiseaseAllList(IpaDiseaseAllExportReqVO exportReqVO) {
        return ipaDiseaseAllMapper.selectList(exportReqVO);
    }

}
