package sia.tacocloud.tacos;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class Order {
  @NotBlank(message = "ccCVV is required")
  private String ccCVV;

}
