package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.extension.productsController;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.AbstractDBRESTController;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candlestick;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/candlestick")
public class CandlestickDBRESTController extends AbstractDBRESTController<Candlestick> {
    public CandlestickDBRESTController(AbstractDBService<Candlestick> service) {
        super(service);
    }

    @Override
    public ResponseEntity<Candlestick> findProductById(Long id) {
        Candlestick candlestickById;
        try {
            candlestickById = service.findProductById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Candlestick());
        }
        return new ResponseEntity<>(candlestickById, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Candlestick> findProductByName(String name) {
        Candlestick candlestickByName;
        try {
            candlestickByName = service.findProductByName(name);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Candlestick());
        }
        return new ResponseEntity<>(candlestickByName, HttpStatus.OK);
    }

}