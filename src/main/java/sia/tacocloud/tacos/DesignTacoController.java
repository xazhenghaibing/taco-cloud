package sia.tacocloud.tacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.tacos.Ingredient.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

  private IngredientRepository ingredientRepo;

  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepo){
    this.ingredientRepo = ingredientRepo;
  }

  @GetMapping
  public String showDesignForm(Model model){
    List<Ingredient> ingredients = new ArrayList<>();
    /*List<Ingredient> ingredients = Arrays.asList(
        new Ingredient("FLTO","Flour Tortilla", Ingredient.Type.WRAP),
        new Ingredient("FLTO1","Flour Tortilla1", Ingredient.Type.WRAP)
    );*/

    ingredientRepo.findAll().forEach(ingredient -> ingredients.add(ingredient));
    Type[] types = Type.values();
    for (Type type : types){
      model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
    }

    model.addAttribute("design",new Taco());
    log.info("test");
    return "design";
  }

  @PostMapping
  public String processDesign(Taco design){
    log.info("process design :" + design);
    return "redirect:/orders/current";
  }

  private List<Ingredient> filterByType(List<Ingredient> ingredients,Type type){
    return ingredients.stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
  }
}
