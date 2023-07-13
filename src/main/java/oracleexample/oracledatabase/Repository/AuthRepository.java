package oracleexample.oracledatabase.Repository;

import oracleexample.oracledatabase.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
public interface AuthRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByPhoneNumber(String phoneNumber);


}
