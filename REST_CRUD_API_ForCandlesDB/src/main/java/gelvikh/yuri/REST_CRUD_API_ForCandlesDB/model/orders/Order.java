package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable  = false)
    private String username;
    @Column
    private String comment;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Double price;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderProduct> products;
}
