package gelvikh.yuri.REST_CRUD_API_ForCandlesDB;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders.Order;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders.OrderProduct;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candle;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.orderRepository.OrderDBRepository;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.excwprions.ShortageOfGoodsException;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.orderDBServices.OrderCRUDService;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.service.extensions.productsDBServices.CandleCRUDService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class SaveOrderServiceWithAnnotationUTest {
    @InjectMocks
    private OrderCRUDService saveOrderService;


    @Mock
    private OrderDBRepository orderDBRepository;
    @Mock
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

        given(candleCRUDService.updateProductById(1L, 0)).willReturn(candle);
        given(orderDBRepository.save(order)).willReturn(order);

        //Exercise
        Order result = saveOrderService.createProduct(order);

        //Assert
        assertEquals(order, result);
        verify(candleCRUDService).updateProductById(1L, 0);
        verify(orderDBRepository).save(any(Order.class));
    }

    @Test
    public void SaveOrderShortageOfGoodsException() throws ShortageOfGoodsException {

        Candle candle = new Candle();
        candle.setId(1L);
        candle.setAmount(8);

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setQuantity(10);
        orderProduct.setCandle(candle);

        Order order = new Order();
        order.setId(1L);
        order.setProducts(new ArrayList<>());
        order.getProducts().add(orderProduct);

        assertThrows(ShortageOfGoodsException.class, () -> {
            saveOrderService.createProduct(order);
        });

        verify(candleCRUDService, never()).updateProductById(1L, 0);
        verify(orderDBRepository,never()).save(any(Order.class));
    }

}


