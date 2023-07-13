package oracleexample.oracledatabase.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String name;
    private String model;
    private String companyName;
    private List<String> color;
    private List<String> description;
    private List<SelectDto> carType;
    private Integer manYear;
    private Double price;

}
