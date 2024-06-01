package gelvikh.yuri.webInterfaceForREST_API.service;

import gelvikh.yuri.webInterfaceForREST_API.model.Flavoring;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlavoringDBManagementService {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${FLAVORING_API}")
    private String FLAVORING_API;

    public List<Flavoring> getAllFlavoring() {
        ResponseEntity<List> responseEntity = template.getForEntity(FLAVORING_API, List.class);
        return responseEntity.getBody();
    }
    public Flavoring getFlavoringById(Long id){
        ResponseEntity<Flavoring> responseEntity = template.getForEntity(FLAVORING_API+"/findById/" + id, Flavoring.class);
        return responseEntity.getBody();
    }
}