package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.extension.productsController;


import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.AbstractDBRESTController;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for Candles
 */
@RestController
@RequestMapping("/candles")
public class CandlesDBRESTController extends AbstractDBRESTController<Candle> {
    /**
     * Service for Candles
     * @param service service
     */
    public CandlesDBRESTController(AbstractDBService<Candle> service) {
        super(service);
    }

    /**
     * Method for find candles by id
     * @param id product id
     * @return ResponseEntity<Candle>
     */
    @Override
    public ResponseEntity<Candle> findProductById(Long id) {
        Candle candleById;
        try {
            candleById = service.findProductById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Candle());
        }
        return new ResponseEntity<>(candleById, HttpStatus.OK);
    }

    /**
     * Method for find candles by name
     * @param name product name
     * @return ResponseEntity<Candle>
     */
    @Override
    public ResponseEntity<Candle> findProductByName(String name) {
        Candle candleByName;
        try {
            candleByName = service.findProductByName(name);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Candle());
        }
        return new ResponseEntity<>(candleByName, HttpStatus.OK);
    }

}
