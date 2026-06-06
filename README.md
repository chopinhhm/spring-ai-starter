# Spring AI Starter 🚀

> Spring AI 快速启动模板，内置 RAG 检索增强、多智能体编排、SSE 流式输出等常用功能封装

## ✨ 特性

- **RAG 封装** — 开箱即用的检索增强生成，支持 Milvus / Redis Vector Store
- **多智能体编排** — 基于状态机的轻量级 Agent 调度框架
- **SSE 流式输出** — Spring AI + Server-Sent Events 流式对话
- **双记忆体系** — 对话记忆 + 业务记忆，解决多轮对话上下文丢失
- **Markdown 分块** — 智能文档分块策略，提升检索准确率
- **Docker Compose** — 一键启动完整开发环境
- **CI/CD** — GitHub Actions 自动化构建测试

## 🎯 适用场景

- AI 客服 / 智能问诊系统
- 知识库问答系统
- 多智能体协作系统
- 需要快速验证 Spring AI 原型的项目

## 📦 Quick Start

\`\`\`bash
git clone https://github.com/chopinhhm/spring-ai-starter.git
cd spring-ai-starter
docker-compose up -d
mvn spring-boot:run
\`\`\`

## 🛠️ 技术栈

`Spring Boot 3.2` · `Spring AI` · `Milvus` · `Redis` · `MySQL` · `Docker`

## 📄 License

MIT License - 可自由用于个人和商业项目
