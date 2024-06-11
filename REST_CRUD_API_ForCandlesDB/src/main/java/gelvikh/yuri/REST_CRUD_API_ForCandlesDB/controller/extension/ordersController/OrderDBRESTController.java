package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.extension.ordersController;


import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.controller.AbstractDBRESTController;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders.Order;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.excwprions.ShortageOfGoodsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderDBRESTController  extends AbstractDBRESTController<Order> {
    public OrderDBRESTController(AbstractDBService<Order> service) {
        super(service);
    }

    @Override
    public ResponseEntity<Order> createProduct(Order order) throws ShortageOfGoodsException {
        return super.createProduct(order);
    }

    @Override
    public ResponseEntity<Order> findProductById(Long id) {
        Order orderById;
        try {
            orderById = service.findProductById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Order());
        }
        return new ResponseEntity<>(orderById, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> findProductByName(String name) {
        Order orderByName;
        try {
            orderByName = service.findProductByName(name);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Order());
        }
        return new ResponseEntity<>(orderByName, HttpStatus.OK);
    }
}
