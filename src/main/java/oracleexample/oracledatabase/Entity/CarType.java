package oracleexample.oracledatabase.Entity;

import lombok.*;
import oracleexample.oracledatabase.Entity.AbsEntities.AbsNameEntity;
import oracleexample.oracledatabase.Entity.Enums.CarTypeName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CarType  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private CarTypeName carTypeName;

    public CarType(CarTypeName value) {
        this.carTypeName = value;
    }
}
