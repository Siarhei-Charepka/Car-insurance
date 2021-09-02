import dto.ClientDto;
import dto.TestDataDto;
import exception.InvalidDataException;
import json.JSONReader;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.CarInsuranceService;

import java.util.List;

@Slf4j
public class CarInsuranceServiceClassTest {

    private CarInsuranceService carInsuranceService;

    @BeforeClass
    public void init() {
        carInsuranceService = new CarInsuranceService();
    }

    @DataProvider(name = "carClientData", parallel = true)
    public Object[][] getCarClientData() {
        List<TestDataDto> carClientData = JSONReader.getCarClientData("carClientData.json");
        return carClientData.stream().map(element -> new TestDataDto[]{element}).toArray(TestDataDto[][]::new);
    }

    @Test(dataProvider = "carClientData")
    public void getCostTest(TestDataDto testDataDto) {
        log.info("getDrivingExperienceCostTest works");
        ClientDto clientDto = testDataDto.getClientDto();
        double actualCost = carInsuranceService.getCost(clientDto);
        double expectedCost = testDataDto.getExpectedInsuranceCost();
        Assert.assertEquals(actualCost, expectedCost);
    }

    @Test(expectedExceptions = InvalidDataException.class)
    public void getCostExceptionTest() {
        log.info("getDrivingExperienceCostTest works");
        ClientDto clientDto = new ClientDto(-1, -1, -1);
        double actualCost = carInsuranceService.getCost(clientDto);
    }
}
