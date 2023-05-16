package com.example.springdocker.datecontroller;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.time.LocalDateTime;

@Controller
public class DateController {

    @PostMapping ("/")
    @ResponseBody
    public String PostDate(Model model){
        //Body만들기
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("\"username\"", "\"Yousilience\"");
        params.add("\"content\"", "\"Success Challenge\"");
        params.add("\"Date\"", LocalDateTime.now().toString());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://discord.com/api/webhooks/1090549186040184913/_nVKm8TfNkMjjZDz2lgNqbVQBmciLcgii6trO7nXIEz7LAtMHVRBXkSVwoSd-nYRGxzU"
        , HttpMethod.POST, // 요청할 방식
                entity, // 요청할때 보내는 데이터
                String.class // 요청시 반환되는 데이터 타입
        );
        String responseData = response.getBody();
        return responseData;
    }
}
