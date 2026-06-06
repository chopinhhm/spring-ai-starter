package com.starter.memory;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 双记忆管理器
 * 对话记忆 + 业务记忆
 */
@Component
public class DualMemoryManager {

    private final StringRedisTemplate redis;
    private static final int EXPIRE_MINUTES = 30;

    public DualMemoryManager(StringRedisTemplate redis) {
        this.redis = redis;
    }

    /** 保存对话记忆 */
    public void saveConversation(String sessionId, String message, String role) {
        String key = "memory:conv:" + sessionId;
        redis.opsForList().rightPush(key, role + ":" + message);
        redis.expire(key, EXPIRE_MINUTES, TimeUnit.MINUTES);
    }

    /** 保存业务记忆 */
    public void saveBusiness(String sessionId, String context) {
        String key = "memory:business:" + sessionId;
        redis.opsForValue().set(key, context, EXPIRE_MINUTES, TimeUnit.MINUTES);
    }

    /** 获取完整记忆 */
    public String getMemory(String sessionId) {
        StringBuilder sb = new StringBuilder();
        String conv = (String) redis.opsForList().range("memory:conv:" + sessionId, 0, -1);
        String biz = redis.opsForValue().get("memory:business:" + sessionId);
        if (conv != null) sb.append("对话: ").append(conv).append("\n");
        if (biz != null) sb.append("业务: ").append(biz);
        return sb.toString();
    }

    /** 清除记忆 */
    public void clear(String sessionId) {
        redis.delete("memory:conv:" + sessionId);
        redis.delete("memory:business:" + sessionId);
    }
}
