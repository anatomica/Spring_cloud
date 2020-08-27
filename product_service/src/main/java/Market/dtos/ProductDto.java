package Market.dtos;

import java.math.BigDecimal;

public interface ProductDto {
    Long getId();
    String getTitle();
    BigDecimal getPrice();
}
