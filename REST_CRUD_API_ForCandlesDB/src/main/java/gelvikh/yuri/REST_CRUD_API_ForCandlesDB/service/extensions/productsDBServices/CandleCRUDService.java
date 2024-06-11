package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.productsDBServices;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.productsRepository.CandleDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CandleCRUDService  extends AbstractDBService<Candle> {


    public CandleCRUDService(CandleDBRepository candleDBRepository) {
        super(candleDBRepository);
    }
    @Override
    @Transactional
    public Candle updateProductById(Candle product) {
        Candle oldProduct = getProductById(product.getId());

        oldProduct.setAmount(product.getAmount());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setName(product.getName());
        oldProduct.setCandlestick(product.getCandlestick());
        oldProduct.setFlavoring(product.getFlavoring());
        oldProduct.setWax(product.getWax());
        oldProduct.setImageLink(product.getImageLink());

        return dbRepository.save(oldProduct);
    }
    @Transactional
    public Candle updateProductById(Long id, Integer amount) {
        Candle oldProduct = getProductById(id);
        oldProduct.setAmount(amount);
        return dbRepository.save(oldProduct);
    }

}
