package gelvikh.yuri.webInterfaceForREST_API.service;

import gelvikh.yuri.webInterfaceForREST_API.model.Wax;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WaxDBManagementService {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${WAX_API}")
    private String WAX_API;

    public List<Wax> getAllWax() {
        ResponseEntity<List> responseEntity = template.getForEntity(WAX_API, List.class);
        return responseEntity.getBody();
    }
    public Wax getWaxById(Long id){
        ResponseEntity<Wax> responseEntity = template.getForEntity(WAX_API+"/findById/" + id, Wax.class);
        return responseEntity.getBody();
    }
}