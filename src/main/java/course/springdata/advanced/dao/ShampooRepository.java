package course.springdata.advanced.dao;

import course.springdata.advanced.entity.Ingredient;
import course.springdata.advanced.entity.Label;
import course.springdata.advanced.entity.Shampoo;
import course.springdata.advanced.entity.Size;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo,Long>{
    List<Shampoo> findBySizeOrderById(Size size);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :ingredient_names")
    List<Shampoo> findWithIngredientsIn(@Param("ingredient_names") Iterable<String> ingredient_names);

    @Query("SELECT s FROM Shampoo s, IN(s.ingredients) i WHERE i.name IN :ingredient_names")
    List<Shampoo> findWithIngredientsIn2(@Param("ingredient_names") Iterable<String> ingredient_names);

    @Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :count")
    List<Shampoo> findByCountOfIngredientsLowerThan(@Param("count") int maxCount);

    List<Shampoo> findShampooBySizeOrLabel(Size size, Label label);


    List<Shampoo> findBySizeOrLabelOrderByPriceDesc(Size medium, Label s);


    List<Shampoo> findShampooByPriceGreaterThanEqual(double minPrice);


    List<Shampoo> findShampooByPriceBetween(double minPrice, double maxPrice);

    int countShampoosByPriceLessThan(double price);


}
