package oracleexample.oracledatabase.Entity;

import lombok.*;
import oracleexample.oracledatabase.Entity.AbsEntities.AbsEntity;
import oracleexample.oracledatabase.Entity.AbsEntities.AbsNameEntity;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CarImages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "car_img")
    private UUID img;
}
