package gelvikh.yuri.webInterfaceForREST_API.service;


import gelvikh.yuri.webInterfaceForREST_API.model.Candle;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandlesDBManagementService {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${CANDLES_API}")
    private String CANDLES_API;

    public List<Candle> getAllCandles() {
        ResponseEntity<List> responseEntity = template.getForEntity(CANDLES_API, List.class);
        return responseEntity.getBody();
    }

    public  Candle createCandle(Candle candle){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Candle> request = new HttpEntity<>(candle, headers);
        ResponseEntity<Candle> response = template.exchange(CANDLES_API, HttpMethod.POST, request, Candle.class);
        Candle createdCandle = response.getBody();
        return ResponseEntity.ok().body(createdCandle).getBody();
    }

    public  Candle updateCandle(Candle candle){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Candle> request = new HttpEntity<>(candle, headers);
        ResponseEntity<Candle> response = template.exchange(CANDLES_API, HttpMethod.PUT, request, Candle.class);
        Candle createdCandle = response.getBody();
        return ResponseEntity.ok().body(createdCandle).getBody();
    }

    public Candle getCandleById(Long id){
        ResponseEntity<Candle> responseEntity = template.getForEntity(CANDLES_API+"/findById/" + id, Candle.class);
        return responseEntity.getBody();
    }
    public void deleteCandleById(Long id){
        ResponseEntity<Void> responseEntity = template.exchange(CANDLES_API + "/" + id, HttpMethod.DELETE, null, Void.class);
    }







}
