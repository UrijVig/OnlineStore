package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.orderDBServices;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders.Order;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders.OrderProduct;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.orderRepository.OrderDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.AbstractDBService;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.excwprions.ShortageOfGoodsException;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.productsDBServices.CandleCRUDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderCRUDService extends AbstractDBService<Order> {
    private final CandleCRUDService candleCRUDService;

    public OrderCRUDService(OrderDBRepository dbRepository, CandleCRUDService candleCRUDService) {
        super(dbRepository);
        this.candleCRUDService = candleCRUDService;
    }

    @Override
    @Transactional
    public Order createProduct(Order order) throws ShortageOfGoodsException{
        List<OrderProduct> products = order.getProducts();
        products.forEach(orderProduct -> orderProduct.setOrder(order));
        for (OrderProduct orderProduct : products) {
            Candle candle = orderProduct.getCandle();
            if (orderProduct.getQuantity() > candle.getAmount()){
                throw new ShortageOfGoodsException("Недостаточно товаров %s в наличии".formatted(candle.getName()));
            }
            else {
                candleCRUDService.updateProductById(candle.getId(), candle.getAmount() - orderProduct.getQuantity());
            }
        }
        return dbRepository.save(order);
    }

    @Transactional
    @Override
    public Order updateProductById(Order order) {
        Order oldOrder = dbRepository.findById(order.getId()).orElseThrow();
        oldOrder.setStatus(order.getStatus());
        return dbRepository.save(oldOrder);
    }
}
