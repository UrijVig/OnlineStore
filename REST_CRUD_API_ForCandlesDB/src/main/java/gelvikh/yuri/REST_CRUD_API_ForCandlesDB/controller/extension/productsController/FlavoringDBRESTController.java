package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.extension.productsController;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.AbstractDBRESTController;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Flavoring;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flavoring")
public class FlavoringDBRESTController extends AbstractDBRESTController<Flavoring> {
    public FlavoringDBRESTController(AbstractDBService<Flavoring> service) {
        super(service);
    }

    @Override
    public ResponseEntity<Flavoring> findProductById(Long id) {
        Flavoring flavoringById;
        try {
            flavoringById = service.findProductById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Flavoring());
        }
        return new ResponseEntity<>(flavoringById, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Flavoring> findProductByName(String name) {
        Flavoring flavoringByName;
        try {
            flavoringByName = service.findProductByName(name);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Flavoring());
        }
        return new ResponseEntity<>(flavoringByName, HttpStatus.OK);
    }

}