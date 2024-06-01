package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "candlestick")
public class Candlestick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description = "coming soon";
    @Column
    private boolean lid = false;
}
