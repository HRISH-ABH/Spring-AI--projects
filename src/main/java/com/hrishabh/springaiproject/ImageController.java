package com.hrishabh.springaiproject;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/generateImage")
    public void getImage(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse result= imageService.generateImage(prompt);
        String imageUrl= result.getResult().getOutput().getUrl();
        response.sendRedirect(imageUrl);
    }
    @GetMapping("/generateImageOptions")
    public List<String> getImageOptions(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse result= imageService.generateImageOptions(prompt);
        return result.getResults().stream().map(image->image.getOutput().getUrl()).toList();
    }


}