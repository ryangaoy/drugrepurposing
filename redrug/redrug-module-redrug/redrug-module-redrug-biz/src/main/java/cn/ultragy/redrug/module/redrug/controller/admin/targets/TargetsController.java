package cn.ultragy.redrug.module.redrug.controller.admin.targets;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.targets.vo.*;
import cn.ultragy.redrug.module.redrug.convert.targets.TargetsConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.targets.TargetsDO;
import cn.ultragy.redrug.module.redrug.service.targets.TargetsService;
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

@Tag(name = "管理后台 - 靶点pdb")
@RestController
@RequestMapping("/redrug/targets")
@Validated
public class TargetsController {

    @Resource
    private TargetsService targetsService;

    @PostMapping("/create")
    @Operation(summary = "创建靶点pdb")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Integer> createTargets(@Valid @RequestBody TargetsCreateReqVO createReqVO) {
        return success(targetsService.createTargets(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新靶点pdb")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateTargets(@Valid @RequestBody TargetsUpdateReqVO updateReqVO) {
        targetsService.updateTargets(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除靶点pdb")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteTargets(@RequestParam("id") Integer id) {
        targetsService.deleteTargets(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得靶点pdb")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<TargetsRespVO> getTargets(@RequestParam("id") Integer id) {
        TargetsDO targets = targetsService.getTargets(id);
        return success(TargetsConvert.INSTANCE.convert(targets));
    }

    @GetMapping("/getByPdb")
    @Operation(summary = "获得靶点pdb")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<TargetsRespVO>> getTargetsByPdb(@RequestParam("id") String id) {
        List<TargetsDO> targets = targetsService.getTargetsByPdb(id);
        return success(TargetsConvert.INSTANCE.convertList(targets));
    }

    @GetMapping("/list")
    @Operation(summary = "获得靶点pdb列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<TargetsRespVO>> getTargetsList(@RequestParam("ids") Collection<Integer> ids) {
        List<TargetsDO> list = targetsService.getTargetsList(ids);
        return success(TargetsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得靶点pdb分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<TargetsRespVO>> getTargetsPage(@Valid TargetsPageReqVO pageVO) {
        PageResult<TargetsDO> pageResult = targetsService.getTargetsPage(pageVO);
        return success(TargetsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出靶点pdb Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportTargetsExcel(@Valid TargetsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TargetsDO> list = targetsService.getTargetsList(exportReqVO);
        // 导出 Excel
        List<TargetsExcelVO> datas = TargetsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "靶点pdb.xls", "数据", TargetsExcelVO.class, datas);
    }

}
