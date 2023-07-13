package oracleexample.oracledatabase.Repository;

import oracleexample.oracledatabase.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface CarRepository extends JpaRepository<Car, Integer> {
}
