package org.mifos.ai.controller;


import org.mifos.ai.service.MifosXAiChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai-chat")
public class MifosXAiChatController {

    private final MifosXAiChatService aiChatService;

    public MifosXAiChatController(MifosXAiChatService aiChatService) {
        this.aiChatService = aiChatService;
    }


    @GetMapping
    public Flux<String> getAIChatResponse(@RequestParam String message) {
        return aiChatService.getAIResponse(message);
    }


}
