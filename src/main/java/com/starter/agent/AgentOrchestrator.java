package com.starter.agent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 多智能体编排器
 * 基于状态机的轻量级 Agent 调度框架
 */
@Slf4j
@Component
public class AgentOrchestrator {

    public enum Stage { INIT, EXECUTING, REVIEWING, COMPLETED }

    private final Map<String, Agent> agents = new HashMap<>();

    public void registerAgent(String name, Agent agent) {
        agents.put(name, agent);
        log.info("注册 Agent: {}", name);
    }

    /**
     * 执行编排任务
     */
    public String orchestrate(String task, Stage... stages) {
        StringBuilder result = new StringBuilder();
        for (Stage stage : stages) {
            for (Agent agent : agents.values()) {
                if (agent.supports(stage)) {
                    String output = agent.execute(task);
                    result.append(output).append("\n");
                }
            }
        }
        return result.toString();
    }

    public interface Agent {
        boolean supports(Stage stage);
        String execute(String task);
    }
}
