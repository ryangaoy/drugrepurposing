package cn.ultragy.redrug.framework.idempotent.config;

import cn.ultragy.redrug.framework.idempotent.core.aop.IdempotentAspect;
import cn.ultragy.redrug.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import cn.ultragy.redrug.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import cn.ultragy.redrug.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import cn.ultragy.redrug.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import cn.ultragy.redrug.framework.redis.config.RedrugRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = RedrugRedisAutoConfiguration.class)
public class RedrugIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
