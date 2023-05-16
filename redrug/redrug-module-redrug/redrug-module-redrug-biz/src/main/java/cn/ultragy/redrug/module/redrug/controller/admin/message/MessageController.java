package cn.ultragy.redrug.module.redrug.controller.admin.message;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.excel.core.util.ExcelUtils;
import cn.ultragy.redrug.framework.operatelog.core.annotations.OperateLog;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.*;
import cn.ultragy.redrug.module.redrug.convert.message.MessageConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.message.MessageDO;
import cn.ultragy.redrug.module.redrug.service.message.MessageService;
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

@Tag(name = "管理后台 - 用户消息")
@RestController
@RequestMapping("/redrug/message")
@Validated
public class MessageController {

    @Resource
    private MessageService messageService;

    @PostMapping("/create")
    @Operation(summary = "创建用户消息")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Integer> createMessage(@Valid @RequestBody MessageCreateReqVO createReqVO) {
        return success(messageService.createMessage(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新用户消息")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateMessage(@Valid @RequestBody MessageUpdateReqVO updateReqVO) {
        messageService.updateMessage(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户消息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteMessage(@RequestParam("id") Integer id) {
        messageService.deleteMessage(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得用户消息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<MessageRespVO> getMessage(@RequestParam("id") Integer id) {
        MessageDO message = messageService.getMessage(id);
        return success(MessageConvert.INSTANCE.convert(message));
    }

    @GetMapping("/list")
    @Operation(summary = "获得用户消息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<List<MessageRespVO>> getMessageList(@RequestParam("ids") Collection<Integer> ids) {
        List<MessageDO> list = messageService.getMessageList(ids);
        return success(MessageConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得用户消息分页")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<PageResult<MessageRespVO>> getMessagePage(@Valid MessagePageReqVO pageVO) {
        PageResult<MessageDO> pageResult = messageService.getMessagePage(pageVO);
        return success(MessageConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出用户消息 Excel")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportMessageExcel(@Valid MessageExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MessageDO> list = messageService.getMessageList(exportReqVO);
        // 导出 Excel
        List<MessageExcelVO> datas = MessageConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "用户消息.xls", "数据", MessageExcelVO.class, datas);
    }

}
