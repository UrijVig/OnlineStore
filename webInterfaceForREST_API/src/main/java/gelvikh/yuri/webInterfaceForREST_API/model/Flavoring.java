package gelvikh.yuri.webInterfaceForREST_API.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Flavoring {
    private Long id;
    private String name;
    private String description = "coming soon";
}
