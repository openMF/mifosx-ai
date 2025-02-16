package org.mifos.ai.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Map;

@Service
@Slf4j
public class AIChatService {

    private final ChatClient chatClient;

    AIChatService(ChatClient.Builder builder){        
        this.chatClient = builder
                .defaultSystem("You are an advanced Mifos X AI assistant. Use external tools when needed instead of making assumptions. "
                        + "Available tools: MifosFunction - Fetches real-time information for a given topic. "
                        + "The user must provide a Mifos X feature to get an accurate how-to use advice. "
                        + "If required data is missing, ask the user to provide it. "
                        + "Ensure clarity and accuracy in responses.")
                .build();
    }

    public Flux<String> getAIResponse(String message) {
        try {
            return chatClient.prompt()
                    .user(message)                    
                    .stream()                     
                    .content()
                    .cache(Duration.ofMinutes(5));
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching Mifos X AI response, ex = " + e.getMessage());
        }
    }
}
