package cn.ultragy.redrug.module.redrug.controller.admin.drugs;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo.*;
import cn.ultragy.redrug.module.redrug.convert.drugs.DrugsConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugs.DrugsDO;
import cn.ultragy.redrug.module.redrug.service.drugs.DrugsService;
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

@Tag(name = "管理后台 - 药物信息")
@RestController
@RequestMapping("/redrug/drugs")
@Validated
public class DrugsController {

    @Resource
    private DrugsService drugsService;

    @PostMapping("/create")
    @Operation(summary = "创建药物信息")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<String> createDrugs(@Valid @RequestBody DrugsCreateReqVO createReqVO) {
        return success(drugsService.createDrugs(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新药物信息")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<Boolean> updateDrugs(@Valid @RequestBody DrugsUpdateReqVO updateReqVO) {
        drugsService.updateDrugs(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除药物信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteDrugs(@RequestParam("id") String id) {
        drugsService.deleteDrugs(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得药物信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<DrugsRespVO> getDrugs(@RequestParam("id") String id) {
        DrugsDO drugs = drugsService.getDrugs(id);
        return success(DrugsConvert.INSTANCE.convert(drugs));
    }

    @GetMapping("/list")
    @Operation(summary = "获得药物信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<DrugsRespVO>> getDrugsList(@RequestParam("ids") Collection<String> ids) {
        List<DrugsDO> list = drugsService.getDrugsList(ids);
        return success(DrugsConvert.INSTANCE.convertList(list));
    }

    @PostMapping("/page")
    @Operation(summary = "获得药物信息分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<DrugsRespVO>> getDrugsPage(@Valid @RequestBody DrugsPageReqVO pageVO) {
        PageResult<DrugsDO> pageResult = drugsService.getDrugsPage(pageVO);
        return success(DrugsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出药物信息 Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportDrugsExcel(@Valid DrugsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DrugsDO> list = drugsService.getDrugsList(exportReqVO);
        // 导出 Excel
        List<DrugsExcelVO> datas = DrugsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "药物信息.xls", "数据", DrugsExcelVO.class, datas);
    }

}
