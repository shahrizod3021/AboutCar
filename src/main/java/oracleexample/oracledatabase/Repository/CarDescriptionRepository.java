package oracleexample.oracledatabase.Repository;

import oracleexample.oracledatabase.Entity.CarDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CarDescriptionRepository extends JpaRepository<CarDescription, Integer> {
}
