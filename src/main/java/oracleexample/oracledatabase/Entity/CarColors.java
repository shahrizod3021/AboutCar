package oracleexample.oracledatabase.Entity;

import lombok.*;
import oracleexample.oracledatabase.Entity.AbsEntities.AbsNameEntity;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
public class CarColors extends AbsNameEntity {
}
