package cn.nwcdcloud.service;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RedisService {
    private ValueCommands<String, String> commands;

    public RedisService(RedisDataSource reactiveRedisDS) {
        commands = reactiveRedisDS.value(String.class);
    }

    public String get(String key) {
        return commands.get(key);
    }

    public void set(String key, String value) {
        commands.set(key, value);
    }
}
