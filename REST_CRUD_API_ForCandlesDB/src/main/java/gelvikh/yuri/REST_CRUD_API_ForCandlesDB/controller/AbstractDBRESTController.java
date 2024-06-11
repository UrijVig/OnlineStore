package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.excwprions.ShortageOfGoodsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for CandlesDB
 *
 * @param <T> T type of product
 */
@RequiredArgsConstructor
public abstract class AbstractDBRESTController<T> {

    protected final AbstractDBService<T> service;

    /**
     * Method for creating product
     * @param t product object
     * @return ResponseEntity<T>
     */
    @PostMapping
    public ResponseEntity<T> createProduct( @RequestBody T t) throws ShortageOfGoodsException {
        return new ResponseEntity<>(service.createProduct(t), HttpStatus.CREATED);
    }

    /**
     * Method for finding all products
     * @return ResponseEntity<T>
     */
    @GetMapping
    public ResponseEntity<List<T>> getAllProduct(){
        return new ResponseEntity<>(service.getAllProduct(), HttpStatus.OK);
    }

    /**
     * Method for finding product by id
     * @param id product id
     * @return ResponseEntity<T>
     */
    @GetMapping("/findById/{id}")
    public abstract ResponseEntity<T> findProductById(@PathVariable Long id);

    /**
     * Method for finding product by name
     * @param name product name
     * @return ResponseEntity<T>
     */
    @GetMapping("/findByName/{name}")
    public abstract ResponseEntity<T> findProductByName(@PathVariable String name);

    /**
     * Method for updating product
     * @param t product object
     * @return ResponseEntity<T>
     */
    @PutMapping
    public ResponseEntity<T> updateProduct(@RequestBody T t){
        return new ResponseEntity<>(service.updateProductById(t), HttpStatus.OK);
    }

    /**
     * Method for deleting product
     * @param id product id
     * @return  ResponseEntity<T>
     */
    @DeleteMapping({"/{id}"})
    public ResponseEntity<T> deleteProduct(@PathVariable Long id){
        service.deleteProductById(id);
        return ResponseEntity.ok().build();
    }


}
