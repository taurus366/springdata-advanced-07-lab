package course.springdata.advanced.init;

import course.springdata.advanced.dao.IngredientRepository;
import course.springdata.advanced.dao.LabelRepository;
import course.springdata.advanced.dao.ShampooRepository;
import course.springdata.advanced.entity.Ingredient;
import course.springdata.advanced.util.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static course.springdata.advanced.entity.Size.MEDIUM;

@Component
public class AppInitializer implements CommandLineRunner {
    private final ShampooRepository shampooRepo;
    private final LabelRepository labelRepo;
    private final IngredientRepository ingredientRepo;


    @Autowired
    public AppInitializer(ShampooRepository shampooRepo, LabelRepository labelRepo, IngredientRepository ingredientRepo) {
        this.shampooRepo = shampooRepo;
        this.labelRepo = labelRepo;
        this.ingredientRepo = ingredientRepo;
    }


    @Override
    public void run(String... args) throws Exception {

//        // Fetch Shampoos by Size
//        shampooRepo.findBySizeOrderById(MEDIUM)
//                .forEach(PrintUtil::printShampoo);
//
//        System.out.println("-".repeat(150)+ "\n");
//
//        // Fetch Slhampoos by Size or Label
//        shampooRepo.findBySizeOrLabelOrderByPriceDesc(MEDIUM,labelRepo.findLabelsByTitle("Vital").get())
//                .forEach(PrintUtil::printShampoo);
//
//        System.out.println("-".repeat(150)+ "\n");
//
//
//        // Fetch Shampoos by Ingredients in List With JOIN
//       shampooRepo.findWithIngredientsIn(Set.of("Berry","Mineral-Collagen")).forEach(PrintUtil::printShampoo);

        //System.out.println("-".repeat(150)+ "\n");

        // Fetch Shampoos by Ingredients in List With IN()
//       shampooRepo.findWithIngredientsIn2(Set.of("Berry","Mineral-Collagen")).forEach(PrintUtil::printShampoo);

//        System.out.println("-".repeat(150)+ "\n");

        // Fetch Shampoos by Price greater tahn or equal
//        shampooRepo.findShampooByPriceGreaterThanEqual(7)
//                .forEach(PrintUtil::printShampoo);
//
//        System.out.println("-".repeat(150)+ "\n");

        // Fetch Ingredients by Names
//        ingredientRepo.findByNameIn(Set.of("Lavender","Herbs","Apple"))
//                .forEach(PrintUtil::printIngredients);
//
//        System.out.println("-".repeat(150)+ "\n");

        // Count Shampoos by Price
//        System.out.println(shampooRepo.countShampoosByPriceLessThan(8.5));
//
//        System.out.println("-".repeat(150)+ "\n");

       // shampooRepo.findByCountOfIngredientsLowerThan().forEach(PrintUtil::printShampoo);

//        shampooRepo.findByCountOfIngredientsLowerThan(3)
//                .forEach(PrintUtil::printShampoo);
//
//        System.out.println("-".repeat(150)+ "\n");
        String nameToDelete = "Macadamia Oil";
        Ingredient IngredientToDelete = ingredientRepo.findByName(nameToDelete).get();
        shampooRepo.findWithIngredientsIn(Set.of(nameToDelete)).forEach(shampoo -> shampoo.getIngredients().remove(IngredientToDelete));
        System.out.println(ingredientRepo.deleteAllByName("Apple"));
    }
}
