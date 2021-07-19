package service;

import dto.ClientDto;
import exception.InvalidDataException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarInsuranceService {

    private static final int MIN_INSURANCE_COST = 2100;

    public double getCost(ClientDto clientDto) {
        log.info("getCost method works");
        if (clientDto.getAccidentQty() < 0 || clientDto.getEnginePower() <= 0 || clientDto.getExperience() < 0) {
            throw new InvalidDataException();
        }
        double carInsuranceCost = getCostByDrivingExperience(clientDto.getExperience())
                * getAccidentFactor(clientDto.getAccidentQty())
                * getCarEnginePowerFactor(clientDto.getEnginePower());
        return (carInsuranceCost <= MIN_INSURANCE_COST) ? MIN_INSURANCE_COST : carInsuranceCost;
    }

    private int getCostByDrivingExperience(int drivingExperienceYears) {
        log.info("getCostByDrivingExperience method works");
        int cost;
        if (drivingExperienceYears >= 5) {
            cost = MIN_INSURANCE_COST + 100;
        } else if (drivingExperienceYears >= 1) {
            cost = MIN_INSURANCE_COST + 200;
        } else {
            cost = MIN_INSURANCE_COST + 300;
        }
        return cost;
    }

    private double getAccidentFactor(int lastYearAccidentQty) {
        log.info("getAccidentFactor method works");
        double accidentsFactor;
        if (lastYearAccidentQty == 0) {
            accidentsFactor = 0.9;
        } else if (lastYearAccidentQty == 1) {
            accidentsFactor = 1.5;
        } else if (lastYearAccidentQty == 2) {
            accidentsFactor = 2.5;
        } else {
            accidentsFactor = 4;
        }
        return accidentsFactor;
    }

    private double getCarEnginePowerFactor(int carEnginePower) {
        log.info("getCarEnginePowerFactor method works");
        double factor;
        if (carEnginePower < 50) {
            factor = 0.6;
        } else if (carEnginePower < 100) {
            factor = 1.0;
        } else if (carEnginePower < 150) {
            factor = 1.4;
        } else {
            factor = 1.6;
        }
        return factor;
    }
}
