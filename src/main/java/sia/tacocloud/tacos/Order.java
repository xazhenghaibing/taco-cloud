package sia.tacocloud.tacos;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Order {

  private long id;
  private Date placedAt;
  @NotBlank(message = "ccCVV is required")
  private String ccCVV;

}
