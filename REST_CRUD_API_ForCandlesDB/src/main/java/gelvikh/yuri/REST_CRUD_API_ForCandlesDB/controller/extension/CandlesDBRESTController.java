package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.extension;


import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.AbstractDBRESTController;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.CandleCRUDService;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.CandlestickCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candles")
public class CandlesDBRESTController extends AbstractDBRESTController<Candle> {
    public CandlesDBRESTController(AbstractDBService<Candle> service) {
        super(service);
    }

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
