package gelvikh.yuri.REST_CRUD_API_ForCandlesDB;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders.Order;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders.OrderProduct;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.orderRepository.OrderDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.excwprions.ShortageOfGoodsException;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.orderDBServices.OrderCRUDService;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.productsDBServices.CandleCRUDService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestServiceWithAnnotationIntegration {
    @Autowired
    private OrderCRUDService saveOrderService;


    @MockBean
    private OrderDBRepository orderDBRepository;
    @MockBean
    private CandleCRUDService candleCRUDService;

    @Test
    public void SaveOrderCorrectFlow() throws ShortageOfGoodsException {

        Candle candle = new Candle();
        candle.setId(1L);
        candle.setAmount(10);

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setQuantity(10);
        orderProduct.setCandle(candle);

        Order order = new Order();
        order.setId(1L);
        order.setProducts(new ArrayList<>());
        order.getProducts().add(orderProduct);

        when(candleCRUDService.updateProductById(1L, 0)).thenReturn(candle);
        when(orderDBRepository.save(order)).thenReturn(order);

        //Exercise
        Order result = saveOrderService.createProduct(order);

        //Assert
        assertEquals(order, result);
        verify(candleCRUDService).updateProductById(1L, 0);
        verify(orderDBRepository).save(any(Order.class));
    }
}
