package sia.tacocloud.tacos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

  private long id;
  private Date createdAt;
  private String name;
  private List<String> ingredients;
}
