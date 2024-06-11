package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Flavoring {
    private Long id;
    private String name;
    private String description = "coming soon";
}
