package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.productsDBServices;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candlestick;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.productsRepository.CandlestickDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CandlestickCRUDService  extends AbstractDBService<Candlestick> {


    public CandlestickCRUDService(CandlestickDBRepository candlestickDBRepository) {
        super(candlestickDBRepository);
    }
    @Override
    @Transactional
    public Candlestick updateProductById(Candlestick product) {
        Candlestick oldProduct = getProductById(product.getId());

        oldProduct.setDescription(product.getDescription());
        oldProduct.setName(product.getName());
        oldProduct.setLid(product.isLid());

        return dbRepository.save(oldProduct);
    }
}
