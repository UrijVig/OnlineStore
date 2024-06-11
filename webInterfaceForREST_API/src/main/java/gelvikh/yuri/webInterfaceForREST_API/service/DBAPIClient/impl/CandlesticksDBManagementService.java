package gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Candlestick;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.DBManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandlesticksDBManagementService implements DBManagementService<Candlestick> {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${CANDLESTICK_API}")
    private String CANDLESTICK_API;

    @Override
    public List<Candlestick> getAllProduct() {
        ResponseEntity<List> responseEntity = template.getForEntity(CANDLESTICK_API, List.class);
        return responseEntity.getBody();
    }
    @Override
    public Candlestick createProduct(Candlestick candlestick) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Candlestick> request = new HttpEntity<>(candlestick, headers);
        ResponseEntity<Candlestick> response = template.exchange(CANDLESTICK_API, HttpMethod.POST, request, Candlestick.class);
        Candlestick createdCandlestick = response.getBody();
        return ResponseEntity.ok().body(createdCandlestick).getBody();
    }

    @Override
    public Candlestick updateProduct(Candlestick candlestick) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Candlestick> request = new HttpEntity<>(candlestick, headers);
        ResponseEntity<Candlestick> response = template.exchange(CANDLESTICK_API, HttpMethod.PUT, request, Candlestick.class);
        Candlestick createdCandlestick = response.getBody();
        return ResponseEntity.ok().body(createdCandlestick).getBody();
    }

    @Override
    public Candlestick getProductById(Long id) {
        ResponseEntity<Candlestick> responseEntity = template.getForEntity(CANDLESTICK_API+"/findById/" + id, Candlestick.class);
        return responseEntity.getBody();
    }
    @Override
    public Candlestick getProductByName(String name) {
        ResponseEntity<Candlestick> responseEntity = template.getForEntity(CANDLESTICK_API+"/findByName/" + name, Candlestick.class);
        return responseEntity.getBody();
    }

    @Override
    public void deleteProductById(Long id) {
        ResponseEntity<Void> responseEntity = template.exchange(CANDLESTICK_API + "/" + id,
                HttpMethod.DELETE, null, Void.class);
    }
}
