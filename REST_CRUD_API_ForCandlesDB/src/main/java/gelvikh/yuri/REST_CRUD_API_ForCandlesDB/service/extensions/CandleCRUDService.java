package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.extension.CandleDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.stereotype.Service;

@Service
public class CandleCRUDService  extends AbstractDBService<Candle> {


    public CandleCRUDService(CandleDBRepository candleDBRepository) {
        super(candleDBRepository);
    }
    @Override
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
}
