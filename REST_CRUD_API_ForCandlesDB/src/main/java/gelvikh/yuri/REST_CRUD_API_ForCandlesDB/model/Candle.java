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
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description = "coming soon";
    @ManyToOne
    @JoinColumn(name = "candlestick_id")
    private Candlestick candlestick;
    @ManyToOne
    @JoinColumn(name = "flavoring_id")
    private Flavoring flavoring;
    @ManyToOne
    @JoinColumn(name = "wax_id")
    private Wax wax;
    @Column
    private String imageLink = "coming soon";
    @Column
    private Integer amount = 0;
    @Column(nullable = false)
    private Float price = 1000F;
}
