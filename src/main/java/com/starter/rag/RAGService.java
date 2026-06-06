package com.starter.rag;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RAG 检索增强生成服务
 * 封装知识库检索 + AI 生成，开箱即用
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RAGService {

    private final VectorStore vectorStore;
    private final ChatClient.Builder chatClientBuilder;

    /**
     * RAG 检索增强生成
     * @param query 用户问题
     * @param topK 检索知识条数
     * @return AI 回答
     */
    public String query(String query, int topK) {
        // Step 1: 向量检索相关知识
        List<Document> docs = vectorStore.similaritySearch(
            SearchRequest.builder().query(query).topK(topK).build()
        );

        // Step 2: 构建增强 Prompt
        String context = docs.stream()
            .map(Document::getText)
            .collect(Collectors.joining("\n"));

        String prompt = String.format(
            "Based on the following knowledge:\n%s\n\nAnswer the question: %s",
            context, query
        );

        // Step 3: AI 生成回答
        return chatClientBuilder.build()
            .prompt()
            .user(prompt)
            .call()
            .content();
    }
}
