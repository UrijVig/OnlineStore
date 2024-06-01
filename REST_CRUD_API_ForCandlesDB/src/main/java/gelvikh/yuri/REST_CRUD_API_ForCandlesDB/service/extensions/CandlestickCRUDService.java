package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Candlestick;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.extension.CandlestickDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.stereotype.Service;
@Service
public class CandlestickCRUDService  extends AbstractDBService<Candlestick> {


    public CandlestickCRUDService(CandlestickDBRepository candlestickDBRepository) {
        super(candlestickDBRepository);
    }
    @Override
    public Candlestick updateProductById(Candlestick product) {
        Candlestick oldProduct = getProductById(product.getId());

        oldProduct.setDescription(product.getDescription());
        oldProduct.setName(product.getName());
        oldProduct.setLid(product.isLid());

        return dbRepository.save(oldProduct);
    }
}
