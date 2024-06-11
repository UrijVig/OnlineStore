package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.extension.productsController;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.AbstractDBRESTController;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Wax;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wax")
public class WaxDBRESTController extends AbstractDBRESTController<Wax> {
    public WaxDBRESTController(AbstractDBService<Wax> service) {
        super(service);
    }

    @Override
    public ResponseEntity<Wax> findProductById(Long id) {
        Wax waxById;
        try {
            waxById = service.findProductById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Wax());
        }
        return new ResponseEntity<>(waxById, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Wax> findProductByName(String name) {
        Wax waxByName;
        try {
            waxByName = service.findProductByName(name);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Wax());
        }
        return new ResponseEntity<>(waxByName, HttpStatus.OK);
    }

}