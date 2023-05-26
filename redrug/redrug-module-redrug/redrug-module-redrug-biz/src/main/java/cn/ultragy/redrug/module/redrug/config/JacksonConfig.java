package cn.ultragy.redrug.module.redrug.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class JacksonConfig implements InitializingBean {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() {

    }
}
