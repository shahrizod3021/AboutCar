package oracleexample.oracledatabase.Repository;

import oracleexample.oracledatabase.Entity.CarColors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CarColorRepository extends JpaRepository<CarColors, Integer> {
}
