package oracleexample.oracledatabase.Entity;

import lombok.*;
import oracleexample.oracledatabase.Entity.AbsEntities.AbsNameEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Car extends AbsNameEntity {

    @Column(name = "company_name")
    private String companyName;

    @ManyToMany
    private List<CarColors> carColors;

    @Column(name = "car_model")
    private String model;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    @Column(name = "car_price")
    private Double carPrice;

    @ManyToMany
    @JoinTable(name = "car_descriptions",
            joinColumns ={@JoinColumn(name = "car_id")},
            inverseJoinColumns ={@JoinColumn(name = "description_id")}
    )
    private List<CarDescription> carDescriptions;

    @ManyToMany
    private List<CarImages> carImages;

    @ManyToMany

    private List<CarType> carTypes;
}
