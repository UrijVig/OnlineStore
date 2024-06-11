package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderProduct {



    private Candle candle;

    private Integer quantity = 1;

    public OrderProduct(Candle candle, Integer quantity) {
        this.candle = candle;
        this.quantity = quantity;
    }
}
