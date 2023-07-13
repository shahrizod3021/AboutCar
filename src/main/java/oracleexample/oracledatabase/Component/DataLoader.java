package oracleexample.oracledatabase.Component;

import lombok.RequiredArgsConstructor;
import oracleexample.oracledatabase.Entity.CarType;
import oracleexample.oracledatabase.Entity.Enums.CarTypeName;
import oracleexample.oracledatabase.Repository.CarTypeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CarTypeRepository carTypeRepository;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String init;

    @Override
    public void run(String... args) throws Exception {
        if (init.equals("create-drop") || init.equals("create")){
            for (CarTypeName value : CarTypeName.values()) {
                carTypeRepository.save(new CarType(value));
            }
        }
    }
}
