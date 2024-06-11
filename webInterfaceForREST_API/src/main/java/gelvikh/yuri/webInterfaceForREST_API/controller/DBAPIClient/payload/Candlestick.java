package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candlestick {
    private Long id;
    private String name;
    private Integer volume;
    private String material;
    private String description = "coming soon";
    private boolean lid = false;
}
