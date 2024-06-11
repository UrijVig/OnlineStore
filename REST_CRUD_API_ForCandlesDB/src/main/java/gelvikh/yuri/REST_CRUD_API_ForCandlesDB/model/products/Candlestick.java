package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "candlestick")
public class Candlestick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Column
    private Integer volume;
    @Column
    private String material;
    @Column
    private String description = "coming soon";
    @Column
    private boolean lid = false;
}
