package gelvikh.yuri.webInterfaceForREST_API.service.DBAPIClient;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DBManagementService<T> {
    public List<T> getAllProduct();

    public  T createProduct(T t);

    public  T updateProduct(T t);

    public T getProductById(Long id);
    public T getProductByName(String name);
    public void deleteProductById(Long id);
}
