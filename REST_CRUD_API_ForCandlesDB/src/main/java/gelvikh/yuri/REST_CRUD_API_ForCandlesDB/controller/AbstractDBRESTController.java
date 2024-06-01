package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
public abstract class AbstractDBRESTController<T> {

    protected final AbstractDBService<T> service;

    @PostMapping
    public ResponseEntity<T> createProduct(@RequestBody T t){
        return new ResponseEntity<>(service.createProduct(t), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<T>> getAllProduct(){
        return new ResponseEntity<>(service.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public abstract ResponseEntity<T> findProductById(@PathVariable Long id);

    @GetMapping("/findByName/{name}")
    public abstract ResponseEntity<T> findProductByName(@PathVariable String name);

    @PutMapping
    public ResponseEntity<T> updateProduct(@RequestBody T t){
        return new ResponseEntity<>(service.updateProductById(t), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<T> deleteProduct(@PathVariable Long id){
        service.deleteProductById(id);
        return ResponseEntity.ok().build();
    }


}
