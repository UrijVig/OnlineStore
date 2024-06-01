package gelvikh.yuri.webInterfaceForREST_API.service;

import gelvikh.yuri.webInterfaceForREST_API.model.Candlestick;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandlesticksDBManagementService {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${CANDLESTICK_API}")
    private String CANDLESTICK_API;

    public List<Candlestick> getAllCandlesticks() {
        ResponseEntity<List> responseEntity = template.getForEntity(CANDLESTICK_API, List.class);
        return responseEntity.getBody();
    }
    public Candlestick getCandlestickById(Long id){
        ResponseEntity<Candlestick> responseEntity = template.getForEntity(CANDLESTICK_API+"/findById/" + id, Candlestick.class);
        return responseEntity.getBody();
    }
}
