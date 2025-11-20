package com.hrishabh.springaiproject.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {

private final ChatModel chatModel;
    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getRecipe(String ingredients,String cuisine){
        String template="I want to create a recipe for "+ingredients+" and "+cuisine +"please generate a recipe based on this with detailed cooking instructions!"
                ;
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String,Object> params=Map.of("ingredients",ingredients,"cuisine",cuisine);

        Prompt prompt=promptTemplate.create(params);

        return chatModel.call(prompt).getResult().getOutput().getText();
    }

}
