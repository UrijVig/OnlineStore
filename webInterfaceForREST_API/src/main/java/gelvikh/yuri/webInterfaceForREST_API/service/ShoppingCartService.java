package gelvikh.yuri.webInterfaceForREST_API.service;

import gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload.Candle;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@SessionScope
public class ShoppingCartService {
    private final Map<Candle, Integer> products = new LinkedHashMap<>();

    public void addProduct(Candle candle, int quantity){
        products.put(candle, products.getOrDefault(candle, 0 ) + quantity);
    }

    public void removeProduct(Candle candle){
        products.remove(candle);
    }

    public Map<Candle, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    public void clearProducts(){
        products.clear();
    }

    public Double getSum(){
        double sum = 0;
        for (Map.Entry<Candle, Integer> entry : products.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }
}
