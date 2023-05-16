package cn.ultragy.redrug.framework.operatelog.config;

import cn.ultragy.redrug.framework.operatelog.core.aop.OperateLogAspect;
import cn.ultragy.redrug.framework.operatelog.core.service.OperateLogFrameworkService;
import cn.ultragy.redrug.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import cn.ultragy.redrug.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class RedrugOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
