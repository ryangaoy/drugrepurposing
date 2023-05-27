package cn.ultragy.redrug.module.redrug.controller.admin.screendrugs;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.ScreenExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo.*;
import cn.ultragy.redrug.module.redrug.convert.screendrugs.ScreenDrugsConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screendrugs.ScreenDrugsDO;
import cn.ultragy.redrug.module.redrug.service.screendrugs.ScreenDrugsService;
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

@Tag(name = "管理后台 - 筛选药物")
@RestController
@RequestMapping("/redrug/screen-drugs")
@Validated
public class ScreenDrugsController {

    @Resource
    private ScreenDrugsService screenDrugsService;

    @PostMapping("/create")
    @Operation(summary = "创建筛选药物")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Integer> createScreenDrugs(@Valid @RequestBody ScreenDrugsCreateReqVO createReqVO) {
        return success(screenDrugsService.createScreenDrugs(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新筛选药物")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateScreenDrugs(@Valid @RequestBody ScreenDrugsUpdateReqVO updateReqVO) {
        screenDrugsService.updateScreenDrugs(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除筛选药物")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteScreenDrugs(@RequestParam("id") Integer id) {
        screenDrugsService.deleteScreenDrugs(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得筛选药物")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<ScreenDrugsRespVO> getScreenDrugs(@RequestParam("id") Integer id) {
        ScreenDrugsDO screenDrugs = screenDrugsService.getScreenDrugs(id);
        return success(ScreenDrugsConvert.INSTANCE.convert(screenDrugs));
    }

    @GetMapping("/getByDrug")
    @Operation(summary = "获得筛选药物")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<ScreenDrugsRespVO> getScreenDrugsByDrug(@RequestParam("id") String id) {
        ScreenDrugsDO screenDrugs = screenDrugsService.getScreenDrugsByDrug(id);
        return success(ScreenDrugsConvert.INSTANCE.convert(screenDrugs));
    }

    @GetMapping("/list")
    @Operation(summary = "获得筛选药物列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<ScreenDrugsRespVO>> getScreenDrugsList(@RequestParam("ids") Collection<Integer> ids) {
        List<ScreenDrugsDO> list = screenDrugsService.getScreenDrugsList(ids);
        return success(ScreenDrugsConvert.INSTANCE.convertList(list));
    }

    @PostMapping("/page")
    @Operation(summary = "获得筛选药物分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<ScreenDrugsRespVO>> getScreenDrugsPage(@Valid @RequestBody ScreenDrugsPageReqVO pageVO) {
        PageResult<ScreenDrugsDO> pageResult = screenDrugsService.getScreenDrugsPage(pageVO);
        return success(ScreenDrugsConvert.INSTANCE.convertPage(pageResult));
    }

    @PostMapping("/screensearch")
    @Operation(summary = "获得筛选药物分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<ScreenDrugsRespVO>> screensearch(@Valid @RequestBody ScreenExportReqVO pageVO) {
        PageResult<ScreenDrugsDO> pageResult = screenDrugsService.screensearch(pageVO);
        return success(ScreenDrugsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出筛选药物 Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportScreenDrugsExcel(@Valid ScreenDrugsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ScreenDrugsDO> list = screenDrugsService.getScreenDrugsList(exportReqVO);
        // 导出 Excel
        List<ScreenDrugsExcelVO> datas = ScreenDrugsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "筛选药物.xls", "数据", ScreenDrugsExcelVO.class, datas);
    }

}
