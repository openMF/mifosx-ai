package org.mifos.ai.controller;


import org.mifos.ai.dto.ChatInteraction;
import org.mifos.ai.service.MifosXAiChatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins =  "*")
public class MifosXAiChatController {

    private final MifosXAiChatService aiChatService;

    public MifosXAiChatController(MifosXAiChatService aiChatService) {
        this.aiChatService = aiChatService;
    }


    @PostMapping(path = "/message",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<String> getAIChatResponse(@RequestBody ChatInteraction chatInteraction) {
        if(chatInteraction.getMessages().get(0).getRole().equalsIgnoreCase("assistant")){
            Flux<String> response = Flux.just("Hello", "How can I help you?");
            return response;
        }
        else {
            return aiChatService.getAIResponse(chatInteraction.getMessages().get(0).getContent());
        }
    }


}
