package gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.impl;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Order;
import gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient.DBManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersDBManagementService implements DBManagementService<Order> {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${ORDERS_API}")
    private String ORDERS_API;


    @Override
    public List<Order> getAllProduct() {
        ResponseEntity<List> responseEntity = template.getForEntity(ORDERS_API, List.class);
        return responseEntity.getBody();
    }

    @Override
    public Order createProduct(Order order) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Order> request = new HttpEntity<>(order, headers);
        ResponseEntity<Order> response = template.exchange(ORDERS_API, HttpMethod.POST, request, Order.class);
        Order createdOrder = response.getBody();
        return ResponseEntity.ok().body(createdOrder).getBody();
    }

    @Override
    public Order updateProduct(Order order) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Order> request = new HttpEntity<>(order, headers);
        ResponseEntity<Order> response = template.exchange(ORDERS_API, HttpMethod.PUT, request, Order.class);
        Order createdCandle = response.getBody();
        return ResponseEntity.ok().body(createdCandle).getBody();
    }

    @Override
    public Order getProductById(Long id) {
        ResponseEntity<Order> responseEntity = template.getForEntity(ORDERS_API+"/findById/" + id, Order.class);
        return responseEntity.getBody();
    }

    @Override
    public Order getProductByName(String name) {
        ResponseEntity<Order> responseEntity = template.getForEntity(ORDERS_API+"/findByName/" + name, Order.class);
        return responseEntity.getBody();
    }

    @Override
    public void deleteProductById(Long id) {
        ResponseEntity<Void> responseEntity = template.exchange(ORDERS_API + "/" + id,
                HttpMethod.DELETE, null, Void.class);
    }
}
