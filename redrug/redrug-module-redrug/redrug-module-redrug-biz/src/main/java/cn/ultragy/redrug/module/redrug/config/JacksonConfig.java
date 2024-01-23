package cn.ultragy.redrug.module.redrug.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

@Configuration
public class JacksonConfig implements InitializingBean {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() {
        SimpleModule simpleModule = new SimpleModule();
        //指定mongodb ObjectId 序列化方式
        simpleModule.addSerializer(ObjectId.class, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://127.0.0.1:27017");
    }
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "redrug");
    }
}
