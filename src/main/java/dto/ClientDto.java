package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {
    private int experience;
    private int accidentQty;
    private int enginePower;
}
