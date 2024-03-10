package org.example.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.Entity.AccessToken;
import org.example.Repository.AccessTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
public class ApplicationController {
//    @Value("${shop}")
//    private String store;
    @Value("${client_id}")
    private String client_id;
    @Value("${client_secret}")
    private String client_secret;
    @Value("${access_token}")
    String accessToken;
    @Autowired
    AccessTokenRepository accessTokenRepository;

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("<h2>Welcome to Application</h2>\n" +
                "<a href=https://localhost:9000/swagger-ui/index.html>swagger-ui</a>");
    }

    @GetMapping("/shopify/redirect")
    public ResponseEntity<String> authenticationGrant(@RequestParam("code") String code,@RequestParam("shop") String store){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "https://"+store+"/admin/oauth/access_token?client_id="+client_id+"&client_secret="+client_secret+"&code="+code;
        HttpEntity<String> entity= new HttpEntity<>(headers);
        ResponseEntity<String> response= restTemplate.exchange(url,HttpMethod.POST,entity, String.class);

        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            accessToken=(jsonNode.get("access_token").asText());
            AccessToken authToken = new AccessToken(store,accessToken);
            accessTokenRepository.save(authToken);

        }catch(JsonProcessingException exception){};

        return response;
    }


}
