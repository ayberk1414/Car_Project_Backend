package kodloma.io.rentACar.dataAccess.abstracts;

import kodloma.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface BrandRepository extends JpaRepository<Brand, Long> {
 boolean existsByName(String name);//spring jpa keywords
}

