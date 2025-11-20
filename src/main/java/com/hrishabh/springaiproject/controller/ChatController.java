package com.hrishabh.springaiproject.controller;

import com.hrishabh.springaiproject.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/ask-ai")
    public String getResponse(@RequestBody String prompt) {
        return chatService.generateResult(prompt);
    }
    @GetMapping("/ask-ai/4o")
    public String getResponseUsing4o(@RequestBody String prompt) {
        return chatService.generateResultOptions(prompt);
    }

}
