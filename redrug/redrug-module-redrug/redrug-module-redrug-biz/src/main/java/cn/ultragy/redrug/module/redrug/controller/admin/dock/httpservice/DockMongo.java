package cn.ultragy.redrug.module.redrug.controller.admin.dock.httpservice;

import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.module.redrug.controller.admin.dock.vo.DockReqVO;
import cn.ultragy.redrug.module.redrug.entity.Dock;
import cn.ultragy.redrug.module.redrug.entity.PageResults;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Query;

import java.util.List;

public interface DockMongo {
    @Get("http://111.229.123.72:30016/redrug/dock/result")
    CommonResult<PageResults<List<Dock>>> resultGet(@Query("current") int current, @Query("pageSize") int pageSize);

    @Get("http://111.229.123.72:30016/redrug/dock/resultByDrug")
    CommonResult<PageResults<List<Dock>>> resultByDrug(@Query("id") String id,  @Query("current") int current, @Query("pageSize") int pageSize);

    @Post(url = "http://111.229.123.72:30016/redrug/dock/result", contentType="application/json")
    CommonResult<PageResults<List<Dock>>> resultPost(@Body DockReqVO dockReqVO);

}
