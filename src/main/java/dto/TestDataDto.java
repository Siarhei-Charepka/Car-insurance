package dto;

import lombok.Data;

@Data
public class TestDataDto {
    private ClientDto clientDto;
    private double expectedInsuranceCost;
}
