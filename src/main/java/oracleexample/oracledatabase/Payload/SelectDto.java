package oracleexample.oracledatabase.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectDto {
    private Integer value;
    private String label;
}
