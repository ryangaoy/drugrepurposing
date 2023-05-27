package cn.ultragy.redrug.module.redrug.controller.admin.screen;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.screen.vo.*;
import cn.ultragy.redrug.module.redrug.convert.screen.ScreenConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.screen.ScreenDO;
import cn.ultragy.redrug.module.redrug.service.screen.ScreenService;
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

@Tag(name = "管理后台 - 筛选结果")
@RestController
@RequestMapping("/redrug/screen")
@Validated
public class ScreenController {

    @Resource
    private ScreenService screenService;

    @PostMapping("/create")
    @Operation(summary = "创建筛选结果")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Integer> createScreen(@Valid @RequestBody ScreenCreateReqVO createReqVO) {
        return success(screenService.createScreen(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新筛选结果")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateScreen(@Valid @RequestBody ScreenUpdateReqVO updateReqVO) {
        screenService.updateScreen(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除筛选结果")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteScreen(@RequestParam("id") Integer id) {
        screenService.deleteScreen(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得筛选结果")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<ScreenRespVO> getScreen(@RequestParam("id") Integer id) {
        ScreenDO screen = screenService.getScreen(id);
        return success(ScreenConvert.INSTANCE.convert(screen));
    }

    @GetMapping("/list")
    @Operation(summary = "获得筛选结果列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<ScreenRespVO>> getScreenList(@RequestParam("ids") Collection<Integer> ids) {
        List<ScreenDO> list = screenService.getScreenList(ids);
        return success(ScreenConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/listByDrug")
    @Operation(summary = "获得筛选结果列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<ScreenRespVO>> getScreenListByDrug(@RequestParam("id") String id) {
        List<ScreenDO> list = screenService.getScreenListByDrug(id);
        return success(ScreenConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得筛选结果分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<ScreenRespVO>> getScreenPage(@Valid ScreenPageReqVO pageVO) {
        PageResult<ScreenDO> pageResult = screenService.getScreenPage(pageVO);
        return success(ScreenConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出筛选结果 Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportScreenExcel(@Valid ScreenExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ScreenDO> list = screenService.getScreenList(exportReqVO);
        // 导出 Excel
        List<ScreenExcelVO> datas = ScreenConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "筛选结果.xls", "数据", ScreenExcelVO.class, datas);
    }

}
