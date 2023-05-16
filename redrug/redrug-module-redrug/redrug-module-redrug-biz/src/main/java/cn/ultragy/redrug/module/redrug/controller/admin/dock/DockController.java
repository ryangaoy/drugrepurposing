package cn.ultragy.redrug.module.redrug.controller.admin.dock;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.module.redrug.controller.admin.dock.vo.DockReqVO;
import cn.ultragy.redrug.module.redrug.entity.Dock;
import cn.ultragy.redrug.module.redrug.entity.PageResults;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import java.util.List;

import static cn.ultragy.redrug.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - Dock")
@RestController
@RequestMapping("/redrug/dock")
@Validated
@Slf4j
public class DockController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/result")
    @PermitAll
    @Operation(summary = "获取对接结果")
    public CommonResult<PageResults<List<Dock>>> result(@PathParam("current") Integer current, @PathParam("pageSize") Integer pageSize) {
        Query query = new Query();

        Pageable pageable = PageRequest.of(current - 1, pageSize);

//        Long total = mongoTemplate.count(query, "result_drugbank");
        List<Dock> result = mongoTemplate.find(query.with(pageable), Dock.class, "result_drugbank");
        return success(new PageResults<>(result, true, 10000L));
    }

    @PostMapping("/result")
    @PermitAll
    @Operation(summary = "获取对接结果")
    public CommonResult<PageResults<List<Dock>>> resultVO(@RequestBody @Valid DockReqVO dockReqVO) {
        Query query = new Query();
        if(dockReqVO.getLigand_id() != null && !dockReqVO.getLigand_id().equals("")) {
            query.addCriteria(Criteria.where("ligand_id").is(dockReqVO.getLigand_id().toUpperCase() + ".pdbqt"));
        }
        if(dockReqVO.getTarget_id() != null && !dockReqVO.getTarget_id().equals("")) {
            query.addCriteria(Criteria.where("target_id").is(dockReqVO.getTarget_id().toLowerCase() + "_pro.pdbqt"));
        }
        if(dockReqVO.getScore() != null) {
            query.addCriteria(Criteria.where("score").is(dockReqVO.getScore()));
        }
        if(dockReqVO.getLigand_dataset() != null && !dockReqVO.getLigand_dataset().equals("")) {
            query.addCriteria(Criteria.where("ligand_dataset").is(dockReqVO.getLigand_dataset()));
        }
        if(dockReqVO.getProtein_dataset() != null && !dockReqVO.getProtein_dataset().equals("")) {
            query.addCriteria(Criteria.where("protein_dataset").is(dockReqVO.getProtein_dataset()));
        }

        Pageable pageable = PageRequest.of(dockReqVO.getPageNo() - 1, dockReqVO.getPageSize());
        List<Dock> cursor = mongoTemplate.find(query.skip(10000).limit(1), Dock.class, "result_drugbank");
        long total = cursor.size() > 0 ? 10000 : mongoTemplate.count(query, "result_drugbank");
        List<Dock> result = mongoTemplate.find(query.with(pageable), Dock.class, "result_drugbank");
        return success(new PageResults<>(result, true, total));
    }

    @GetMapping("/resultByDrug")
    @PermitAll
    @Operation(summary = "获取对接结果")
    public CommonResult<PageResults<List<Dock>>> resultByDrug(@PathParam("id") String id, @PathParam("current") Integer current, @PathParam("pageSize") Integer pageSize) {
        Query query = new Query(Criteria.where("ligand_id").is(id + ".pdbqt"));

        Pageable pageable = PageRequest.of(current - 1, pageSize);

        Long total = mongoTemplate.count(query, "result_drugbank");
        List<Dock> result = mongoTemplate.find(query.with(pageable), Dock.class, "result_drugbank");
        return success(new PageResults<>(result, true, total));
    }
}
