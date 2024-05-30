package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "candles")
public class Candle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column
    private Integer amount;
    @Column(nullable = false)
    private Float price;
}
