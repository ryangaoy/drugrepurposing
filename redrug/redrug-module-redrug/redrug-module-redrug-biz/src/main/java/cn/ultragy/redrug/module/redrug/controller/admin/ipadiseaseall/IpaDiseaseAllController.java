package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo.*;
import cn.ultragy.redrug.module.redrug.convert.ipadiseaseall.IpaDiseaseAllConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseaseall.IpaDiseaseAllDO;
import cn.ultragy.redrug.module.redrug.service.ipadiseaseall.IpaDiseaseAllService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.ultragy.redrug.framework.common.pojo.CommonResult.success;
import static cn.ultragy.redrug.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Tag(name = "管理后台 - ipa预测适应症all")
@RestController
@RequestMapping("/redrug/ipa-disease-all")
@Validated
public class IpaDiseaseAllController {

    @Resource
    private IpaDiseaseAllService ipaDiseaseAllService;

    @PostMapping("/create")
    @Operation(summary = "创建ipa预测适应症all")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Integer> createIpaDiseaseAll(@Valid @RequestBody IpaDiseaseAllCreateReqVO createReqVO) {
        return success(ipaDiseaseAllService.createIpaDiseaseAll(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新ipa预测适应症all")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateIpaDiseaseAll(@Valid @RequestBody IpaDiseaseAllUpdateReqVO updateReqVO) {
        ipaDiseaseAllService.updateIpaDiseaseAll(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除ipa预测适应症all")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteIpaDiseaseAll(@RequestParam("id") Integer id) {
        ipaDiseaseAllService.deleteIpaDiseaseAll(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得ipa预测适应症all")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<IpaDiseaseAllRespVO> getIpaDiseaseAll(@RequestParam("id") Integer id) {
        IpaDiseaseAllDO ipaDiseaseAll = ipaDiseaseAllService.getIpaDiseaseAll(id);
        return success(IpaDiseaseAllConvert.INSTANCE.convert(ipaDiseaseAll));
    }

    @GetMapping("/list")
    @Operation(summary = "获得ipa预测适应症all列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<IpaDiseaseAllRespVO>> getIpaDiseaseAllList(@RequestParam("ids") Collection<Integer> ids) {
        List<IpaDiseaseAllDO> list = ipaDiseaseAllService.getIpaDiseaseAllList(ids);
        return success(IpaDiseaseAllConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/listByDrug")
    @Operation(summary = "获得ipa预测适应症all列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<IpaDiseaseAllRespVO>> getIpaDiseaseAllListByDrug(@RequestParam("id") String id) {
        List<IpaDiseaseAllDO> list = ipaDiseaseAllService.getIpaDiseaseAllListByDrug(id);
        return success(IpaDiseaseAllConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得ipa预测适应症all分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<IpaDiseaseAllRespVO>> getIpaDiseaseAllPage(@Valid IpaDiseaseAllPageReqVO pageVO) {
        PageResult<IpaDiseaseAllDO> pageResult = ipaDiseaseAllService.getIpaDiseaseAllPage(pageVO);
        return success(IpaDiseaseAllConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出ipa预测适应症all Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportIpaDiseaseAllExcel(@Valid IpaDiseaseAllExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<IpaDiseaseAllDO> list = ipaDiseaseAllService.getIpaDiseaseAllList(exportReqVO);
        // 导出 Excel
        List<IpaDiseaseAllExcelVO> datas = IpaDiseaseAllConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "ipa预测适应症all.xls", "数据", IpaDiseaseAllExcelVO.class, datas);
    }

}
