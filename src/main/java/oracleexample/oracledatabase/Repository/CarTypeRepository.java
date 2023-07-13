package oracleexample.oracledatabase.Repository;

import oracleexample.oracledatabase.Entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CarTypeRepository extends JpaRepository<CarType, Integer> {
}
