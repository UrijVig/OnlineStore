package gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Flavoring;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.DBManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlavoringDBManagementService implements DBManagementService<Flavoring> {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${FLAVORING_API}")
    private String FLAVORING_API;

    @Override
    public List<Flavoring> getAllProduct() {
        ResponseEntity<List> responseEntity = template.getForEntity(FLAVORING_API, List.class);
        return responseEntity.getBody();
    }

    @Override
    public Flavoring createProduct(Flavoring flavoring) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Flavoring> request = new HttpEntity<>(flavoring, headers);
        ResponseEntity<Flavoring> response = template.exchange(FLAVORING_API, HttpMethod.POST, request, Flavoring.class);
        Flavoring createdFlavoring = response.getBody();
        return ResponseEntity.ok().body(createdFlavoring).getBody();
    }

    @Override
    public Flavoring updateProduct(Flavoring flavoring) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Flavoring> request = new HttpEntity<>(flavoring, headers);
        ResponseEntity<Flavoring> response = template.exchange(FLAVORING_API, HttpMethod.PUT, request, Flavoring.class);
        Flavoring createdFlavoring = response.getBody();
        return ResponseEntity.ok().body(createdFlavoring).getBody();
    }

    @Override
    public Flavoring getProductById(Long id) {
        ResponseEntity<Flavoring> responseEntity = template.getForEntity(FLAVORING_API + "/findById/" + id, Flavoring.class);
        return responseEntity.getBody();
    }

    @Override
    public Flavoring getProductByName(String name) {
        ResponseEntity<Flavoring> responseEntity = template.getForEntity(FLAVORING_API + "/findByName/" + name, Flavoring.class);
        return responseEntity.getBody();
    }

    @Override
    public void deleteProductById(Long id) {
        ResponseEntity<Void> responseEntity = template.exchange(FLAVORING_API + "/" + id,
                HttpMethod.DELETE, null, Void.class);
    }
}