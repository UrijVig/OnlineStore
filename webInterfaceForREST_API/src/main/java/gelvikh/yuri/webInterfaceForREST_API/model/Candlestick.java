package gelvikh.yuri.webInterfaceForREST_API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candlestick {
    private Long id;
    private String name;
    private String description = "coming soon";
    private boolean lid = false;
}
