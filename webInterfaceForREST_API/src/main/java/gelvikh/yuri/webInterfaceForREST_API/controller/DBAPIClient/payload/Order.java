package gelvikh.yuri.webInterfaceForREST_API.controller.DBAPIClient.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class Order {
    private Long id;
    private String username;
    private String comment;
    private String status;
    private Double price;
//    @JsonManagedReference
    private List<OrderProduct> products = new LinkedList<>();
}
