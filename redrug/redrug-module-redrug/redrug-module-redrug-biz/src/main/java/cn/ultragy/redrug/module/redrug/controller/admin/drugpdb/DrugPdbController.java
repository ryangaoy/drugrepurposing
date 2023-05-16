package cn.ultragy.redrug.module.redrug.controller.admin.drugpdb;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo.*;
import cn.ultragy.redrug.module.redrug.convert.drugpdb.DrugPdbConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.drugpdb.DrugPdbDO;
import cn.ultragy.redrug.module.redrug.service.drugpdb.DrugPdbService;
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

@Tag(name = "管理后台 - drug_pdb")
@RestController
@RequestMapping("/redrug/drug-pdb")
@Validated
public class DrugPdbController {

    @Resource
    private DrugPdbService drugPdbService;

    @PostMapping("/create")
    @Operation(summary = "创建drug_pdb")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<Integer> createDrugPdb(@Valid @RequestBody DrugPdbCreateReqVO createReqVO) {
        return success(drugPdbService.createDrugPdb(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新drug_pdb")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<Boolean> updateDrugPdb(@Valid @RequestBody DrugPdbUpdateReqVO updateReqVO) {
        drugPdbService.updateDrugPdb(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除drug_pdb")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<Boolean> deleteDrugPdb(@RequestParam("id") Integer id) {
        drugPdbService.deleteDrugPdb(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得drug_pdb")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<DrugPdbRespVO> getDrugPdb(@RequestParam("id") Integer id) {
        DrugPdbDO drugPdb = drugPdbService.getDrugPdb(id);
        return success(DrugPdbConvert.INSTANCE.convert(drugPdb));
    }

    @GetMapping("/list")
    @Operation(summary = "获得drug_pdb列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<List<DrugPdbRespVO>> getDrugPdbList(@RequestParam("ids") Collection<Integer> ids) {
        List<DrugPdbDO> list = drugPdbService.getDrugPdbList(ids);
        return success(DrugPdbConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/listByDrug")
    @Operation(summary = "获得drug_pdb列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<List<DrugPdbRespVO>> getDrugPdbListByDrug(@RequestParam("id") String drugid) {
        List<DrugPdbDO> list = drugPdbService.getDrugPdbListByDrug(drugid);
        return success(DrugPdbConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得drug_pdb分页")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<PageResult<DrugPdbRespVO>> getDrugPdbPage(@Valid DrugPdbPageReqVO pageVO) {
        PageResult<DrugPdbDO> pageResult = drugPdbService.getDrugPdbPage(pageVO);
        return success(DrugPdbConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出drug_pdb Excel")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    @OperateLog(type = EXPORT)
    public void exportDrugPdbExcel(@Valid DrugPdbExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<DrugPdbDO> list = drugPdbService.getDrugPdbList(exportReqVO);
        // 导出 Excel
        List<DrugPdbExcelVO> datas = DrugPdbConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "drug_pdb.xls", "数据", DrugPdbExcelVO.class, datas);
    }

}
