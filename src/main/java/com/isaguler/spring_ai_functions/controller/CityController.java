package com.isaguler.spring_ai_functions.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    private final ChatClient chatClient;

    public CityController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/cities")
    public String cities(@RequestParam String message) {
        SystemMessage systemMessage = new SystemMessage("You are a helpful AI Assistant answering questions about cities around the world.");
        UserMessage userMessage = new UserMessage(message);

        OllamaOptions ollamaOptions = OllamaOptions.builder().withFunction("currentWeatherFunction").build();

        Prompt prompt = new Prompt(List.of(systemMessage, userMessage), ollamaOptions);
        ChatClient.CallPromptResponseSpec responseSpec = chatClient.prompt(prompt).call();

        return responseSpec.content();
    }
}
