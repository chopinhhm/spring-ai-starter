<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0D1117&height=150&section=header&text=Spring+AI+Starter+%F0%9F%9A%80&fontSize=40&fontColor=58A6FF&animation=fadeIn" />

[![MIT License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)]()
[![Spring AI](https://img.shields.io/badge/Spring_AI-1.0.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)]()
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker&logoColor=white)]()

<br>

<b>⚡ Spring AI 快速启动模板 — 开箱即用的 RAG / 多智能体 / SSE / 双记忆体系</b>

</div>

---

## ✨ What's Inside

| Feature | Description |
|---------|-------------|
| 🧠 **RAG Service** | 一行代码实现检索增强生成，支持 Milvus / Redis |
| 🤖 **Agent Orchestrator** | 多智能体编排框架，状态机驱动 |
| 💭 **Dual Memory** | 对话记忆 + 业务记忆，解决上下文丢失 |
| ⚡ **SSE Streaming** | 流式输出模板代码 |
| 🐳 **Docker Compose** | 一键启动完整开发环境 |
| 🚀 **CI/CD** | GitHub Actions 自动构建 |

---

## 🎯 Use Cases

- 🏥 AI 客服 / 智能问诊系统
- 📚 知识库问答系统
- 🤖 多智能体协作平台
- 🧪 Spring AI 原型快速验证

---

## 🚀 Quick Start (30 seconds)

\`\`\`bash
# 1. Clone
git clone https://github.com/chopinhhm/spring-ai-starter.git
cd spring-ai-starter

# 2. One-command start
docker-compose up -d && mvn spring-boot:run

# 3. Open browser
open http://localhost:8080
\`\`\`

---

## 🏗️ Project Structure

\`\`\`
spring-ai-starter/
├── src/main/java/com/starter/
│   ├── AiStarterApplication.java    # 启动类
│   ├── rag/RAGService.java          # RAG 核心服务
│   ├── agent/AgentOrchestrator.java # 多智能体编排器
│   └── memory/DualMemoryManager.java # 双记忆管理器
├── docker-compose.yml               # 一键环境
├── Dockerfile                       # 容器镜像
└── .github/workflows/ci.yml         # CI 流水线
\`\`\`

---

## 🤝 Contributing

PRs are welcome! Feel free to submit issues and feature requests.

---

## 📄 License

MIT © [chopinhhm](https://github.com/chopinhhm) — Free for personal & commercial use
