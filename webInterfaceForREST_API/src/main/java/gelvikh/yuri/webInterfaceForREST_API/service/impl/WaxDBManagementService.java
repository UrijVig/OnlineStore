package gelvikh.yuri.webInterfaceForREST_API.service.impl;

import gelvikh.yuri.webInterfaceForREST_API.model.Wax;
import gelvikh.yuri.webInterfaceForREST_API.service.DBManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WaxDBManagementService  implements DBManagementService<Wax> {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${WAX_API}")
    private String WAX_API;

    @Override
    public List<Wax> getAllProduct() {
        ResponseEntity<List> responseEntity = template.getForEntity(WAX_API, List.class);
        return responseEntity.getBody();
    }
    @Override
    public Wax createProduct(Wax wax) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Wax> request = new HttpEntity<>(wax, headers);
        ResponseEntity<Wax> response = template.exchange(WAX_API, HttpMethod.POST, request, Wax.class);
        Wax createdWax = response.getBody();
        return ResponseEntity.ok().body(createdWax).getBody();
    }

    @Override
    public Wax updateProduct(Wax wax) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Wax> request = new HttpEntity<>(wax, headers);
        ResponseEntity<Wax> response = template.exchange(WAX_API, HttpMethod.PUT, request, Wax.class);
        Wax createdWax = response.getBody();
        return ResponseEntity.ok().body(createdWax).getBody();
    }

    @Override
    public Wax getProductById(Long id) {
        ResponseEntity<Wax> responseEntity = template.getForEntity(WAX_API+"/findById/" + id, Wax.class);
        return responseEntity.getBody();
    }
    @Override
    public Wax getProductByName(String name) {
        ResponseEntity<Wax> responseEntity = template.getForEntity(WAX_API + "/findByName/" + name, Wax.class);
        return responseEntity.getBody();
    }

    @Override
    public void deleteProductById(Long id) {
        ResponseEntity<Void> responseEntity = template.exchange(WAX_API + "/" + id,
                HttpMethod.DELETE, null, Void.class);
    }
}