package course.springdata.advanced.dao;

import course.springdata.advanced.entity.Shampoo;
import course.springdata.advanced.entity.Size;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo,Long>{
    List<Shampoo> findBySizeOrderById(Size size);
}
