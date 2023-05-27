package cn.ultragy.redrug.module.redrug.controller.admin.md;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.md.vo.*;
import cn.ultragy.redrug.module.redrug.convert.md.MdConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.md.MdDO;
import cn.ultragy.redrug.module.redrug.service.md.MdService;
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

@Tag(name = "管理后台 - 分子动力学模拟结果列")
@RestController
@RequestMapping("/redrug/md")
@Validated
public class MdController {

    @Resource
    private MdService mdService;

    @PostMapping("/create")
    @Operation(summary = "创建分子动力学模拟结果列")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Integer> createMd(@Valid @RequestBody MdCreateReqVO createReqVO) {
        return success(mdService.createMd(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新分子动力学模拟结果列")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateMd(@Valid @RequestBody MdUpdateReqVO updateReqVO) {
        mdService.updateMd(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除分子动力学模拟结果列")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteMd(@RequestParam("id") Integer id) {
        mdService.deleteMd(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得分子动力学模拟结果列")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<MdRespVO> getMd(@RequestParam("id") Integer id) {
        MdDO md = mdService.getMd(id);
        return success(MdConvert.INSTANCE.convert(md));
    }

    @GetMapping("/list")
    @Operation(summary = "获得分子动力学模拟结果列列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<MdRespVO>> getMdList(@RequestParam("ids") Collection<Integer> ids) {
        List<MdDO> list = mdService.getMdList(ids);
        return success(MdConvert.INSTANCE.convertList(list));
    }

    @PostMapping("/page")
    @Operation(summary = "获得分子动力学模拟结果列分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<MdRespVO>> getMdPage(@RequestBody @Valid MdPageReqVO pageVO) {
        PageResult<MdDO> pageResult = mdService.getMdPage(pageVO);
        return success(MdConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出分子动力学模拟结果列 Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportMdExcel(@Valid MdExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MdDO> list = mdService.getMdList(exportReqVO);
        // 导出 Excel
        List<MdExcelVO> datas = MdConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "分子动力学模拟结果列.xls", "数据", MdExcelVO.class, datas);
    }

}
