package oracleexample.oracledatabase.Repository;

import oracleexample.oracledatabase.Entity.CarImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CarImagesRepository extends JpaRepository<CarImages, Integer> {
}
