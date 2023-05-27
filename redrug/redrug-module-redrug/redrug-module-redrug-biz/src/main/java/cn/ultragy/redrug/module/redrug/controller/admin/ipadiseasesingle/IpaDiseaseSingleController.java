package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo.*;
import cn.ultragy.redrug.module.redrug.convert.ipadiseasesingle.IpaDiseaseSingleConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseasesingle.IpaDiseaseSingleDO;
import cn.ultragy.redrug.module.redrug.service.ipadiseasesingle.IpaDiseaseSingleService;
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

@Tag(name = "管理后台 - ipa预测适应症single")
@RestController
@RequestMapping("/redrug/ipa-disease-single")
@Validated
public class IpaDiseaseSingleController {

    @Resource
    private IpaDiseaseSingleService ipaDiseaseSingleService;

    @PostMapping("/create")
    @Operation(summary = "创建ipa预测适应症single")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Integer> createIpaDiseaseSingle(@Valid @RequestBody IpaDiseaseSingleCreateReqVO createReqVO) {
        return success(ipaDiseaseSingleService.createIpaDiseaseSingle(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新ipa预测适应症single")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateIpaDiseaseSingle(@Valid @RequestBody IpaDiseaseSingleUpdateReqVO updateReqVO) {
        ipaDiseaseSingleService.updateIpaDiseaseSingle(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除ipa预测适应症single")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteIpaDiseaseSingle(@RequestParam("id") Integer id) {
        ipaDiseaseSingleService.deleteIpaDiseaseSingle(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得ipa预测适应症single")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<IpaDiseaseSingleRespVO> getIpaDiseaseSingle(@RequestParam("id") Integer id) {
        IpaDiseaseSingleDO ipaDiseaseSingle = ipaDiseaseSingleService.getIpaDiseaseSingle(id);
        return success(IpaDiseaseSingleConvert.INSTANCE.convert(ipaDiseaseSingle));
    }

    @GetMapping("/getByDrug")
    @Operation(summary = "获得ipa预测适应症single")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<IpaDiseaseSingleRespVO> getIpaDiseaseSingleByDrug(@RequestParam("id") String id) {
        IpaDiseaseSingleDO ipaDiseaseSingle = ipaDiseaseSingleService.getIpaDiseaseSingleByDrug(id);
        return success(IpaDiseaseSingleConvert.INSTANCE.convert(ipaDiseaseSingle));
    }

    @GetMapping("/list")
    @Operation(summary = "获得ipa预测适应症single列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<IpaDiseaseSingleRespVO>> getIpaDiseaseSingleList(@RequestParam("ids") Collection<Integer> ids) {
        List<IpaDiseaseSingleDO> list = ipaDiseaseSingleService.getIpaDiseaseSingleList(ids);
        return success(IpaDiseaseSingleConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得ipa预测适应症single分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<IpaDiseaseSingleRespVO>> getIpaDiseaseSinglePage(@Valid IpaDiseaseSinglePageReqVO pageVO) {
        PageResult<IpaDiseaseSingleDO> pageResult = ipaDiseaseSingleService.getIpaDiseaseSinglePage(pageVO);
        return success(IpaDiseaseSingleConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出ipa预测适应症single Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportIpaDiseaseSingleExcel(@Valid IpaDiseaseSingleExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<IpaDiseaseSingleDO> list = ipaDiseaseSingleService.getIpaDiseaseSingleList(exportReqVO);
        // 导出 Excel
        List<IpaDiseaseSingleExcelVO> datas = IpaDiseaseSingleConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "ipa预测适应症single.xls", "数据", IpaDiseaseSingleExcelVO.class, datas);
    }

}
