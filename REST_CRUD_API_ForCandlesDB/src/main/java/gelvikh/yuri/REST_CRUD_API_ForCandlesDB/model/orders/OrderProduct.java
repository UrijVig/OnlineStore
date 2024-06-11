package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders;


import com.fasterxml.jackson.annotation.JsonBackReference;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products.Candle;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "orders_products")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="order_id")
    @ManyToOne
    @JsonBackReference
    private Order order;

    @JoinColumn(name="candle_id")
    @ManyToOne
    private Candle candle;

    @Column
    private Integer quantity = 1;
}

