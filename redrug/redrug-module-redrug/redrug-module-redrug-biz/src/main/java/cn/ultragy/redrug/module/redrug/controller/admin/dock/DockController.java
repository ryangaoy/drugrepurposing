package cn.ultragy.redrug.module.redrug.controller.admin.dock;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.module.redrug.controller.admin.dock.httpservice.DockMongo;
import cn.ultragy.redrug.module.redrug.controller.admin.dock.vo.DockReqVO;
import cn.ultragy.redrug.module.redrug.entity.Dock;
import cn.ultragy.redrug.module.redrug.entity.PageResults;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Tag(name = "管理后台 - Dock")
@RestController
@RequestMapping("/redrug/dock")
@Validated
@Slf4j
public class DockController {

    @Resource
    private DockMongo dockMongo;

    @GetMapping("/result")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    @Operation(summary = "获取对接结果")
    public CommonResult<PageResults<List<Dock>>> result(@PathParam("current") Integer current, @PathParam("pageSize") Integer pageSize) {
        return dockMongo.resultGet(current, pageSize);
    }

    @PostMapping("/result")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    @Operation(summary = "获取对接结果")
    public CommonResult<PageResults<List<Dock>>> resultVO(@RequestBody @Valid DockReqVO dockReqVO) {
        return dockMongo.resultPost(dockReqVO);
    }

    @GetMapping("/resultByDrug")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    @Operation(summary = "获取对接结果")
    public CommonResult<PageResults<List<Dock>>> resultByDrug(@PathParam("id") String id, @PathParam("current") Integer current, @PathParam("pageSize") Integer pageSize) {
        return dockMongo.resultByDrug(id, current, pageSize);
    }
}
