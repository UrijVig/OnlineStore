package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.products;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity(name = "wax")
public class Wax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Column
    private String description = "coming soon";
}
