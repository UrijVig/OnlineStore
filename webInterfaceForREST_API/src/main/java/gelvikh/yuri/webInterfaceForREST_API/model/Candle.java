package gelvikh.yuri.webInterfaceForREST_API.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Candle {
    private Long id;
    private String name;
    private String description;
    private Candlestick candlestick;
    private Flavoring flavoring;
    private Wax wax;
    private String imageLink = "coming soon";
    private Integer amount;
    private Float price;
}
