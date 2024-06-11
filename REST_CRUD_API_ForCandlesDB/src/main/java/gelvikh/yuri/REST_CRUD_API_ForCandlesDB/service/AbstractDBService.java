package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.AbstractDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.excwprions.ShortageOfGoodsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class AbstractDBService<T> {
    protected final AbstractDBRepository<T> dbRepository;

    @Transactional
    public T createProduct(T t) throws ShortageOfGoodsException {
        return dbRepository.save(t);
    }

    public List<T> getAllProduct(){
        return dbRepository.findAll();
    }
    public T findProductById(Long id){
        return dbRepository.findById(id).orElseThrow();
    }
    protected T getProductById(Long id){
        return findProductById(id);
    }
    public T findProductByName(String name){
        return dbRepository.findByName(name).orElseThrow();
    }
    @Transactional
    public void deleteProductById(Long id){
        dbRepository.deleteById(id);
    }

    public abstract T updateProductById(T product);

}
