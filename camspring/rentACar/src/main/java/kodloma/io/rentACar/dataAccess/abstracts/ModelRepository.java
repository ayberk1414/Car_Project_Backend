package kodloma.io.rentACar.dataAccess.abstracts;

import kodloma.io.rentACar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Long> {
    List<Model> findAll();
}
