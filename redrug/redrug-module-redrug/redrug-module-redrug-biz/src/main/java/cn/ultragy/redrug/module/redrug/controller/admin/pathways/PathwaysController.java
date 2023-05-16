package cn.ultragy.redrug.module.redrug.controller.admin.pathways;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo.*;
import cn.ultragy.redrug.module.redrug.convert.pathways.PathwaysConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.pathways.PathwaysDO;
import cn.ultragy.redrug.module.redrug.service.pathways.PathwaysService;
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

@Tag(name = "管理后台 - 基因通路")
@RestController
@RequestMapping("/redrug/pathways")
@Validated
public class PathwaysController {

    @Resource
    private PathwaysService pathwaysService;

    @PostMapping("/create")
    @Operation(summary = "创建基因通路")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Integer> createPathways(@Valid @RequestBody PathwaysCreateReqVO createReqVO) {
        return success(pathwaysService.createPathways(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基因通路")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updatePathways(@Valid @RequestBody PathwaysUpdateReqVO updateReqVO) {
        pathwaysService.updatePathways(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基因通路")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deletePathways(@RequestParam("id") Integer id) {
        pathwaysService.deletePathways(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基因通路")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PathwaysRespVO> getPathways(@RequestParam("id") Integer id) {
        PathwaysDO pathways = pathwaysService.getPathways(id);
        return success(PathwaysConvert.INSTANCE.convert(pathways));
    }

    @GetMapping("/list")
    @Operation(summary = "获得基因通路列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<PathwaysRespVO>> getPathwaysList(@RequestParam("ids") Collection<Integer> ids) {
        List<PathwaysDO> list = pathwaysService.getPathwaysList(ids);
        return success(PathwaysConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/listByDrug")
    @Operation(summary = "获得基因通路列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<PathwaysRespVO>> getPathwaysListByDrug(@RequestParam("id") String id) {
        List<PathwaysDO> list = pathwaysService.getPathwaysListByDrug(id);
        return success(PathwaysConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基因通路分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<PathwaysRespVO>> getPathwaysPage(@Valid PathwaysPageReqVO pageVO) {
        PageResult<PathwaysDO> pageResult = pathwaysService.getPathwaysPage(pageVO);
        return success(PathwaysConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基因通路 Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportPathwaysExcel(@Valid PathwaysExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PathwaysDO> list = pathwaysService.getPathwaysList(exportReqVO);
        // 导出 Excel
        List<PathwaysExcelVO> datas = PathwaysConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "基因通路.xls", "数据", PathwaysExcelVO.class, datas);
    }

}
