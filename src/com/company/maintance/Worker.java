package com.company.maintance;

import com.company.PlaneBuilding;

public class Worker extends PlaneBuilding {
    private final String aeronauticalEngineer = "Mark Roseman";
    private String mechanicalEngineer = "Calvin Hibs";
    private String draftingEngineer = "Kevin Baker";
    private String operationsTechnician = "Alicia Tatcha";
    private String AircraftEquipmentMechanic = "Haryam Reyez";

    public String getAeronauticalEngineer() {
        return aeronauticalEngineer;
    }

    public String getMechanicalEngineer() {
        return mechanicalEngineer;
    }

    public String getDraftingEngineer() {
        return draftingEngineer;
    }

    public String getOperationsTechnician() {
        return operationsTechnician;
    }

    public String getAircraftEquipmentMechanic() {
        return AircraftEquipmentMechanic;
    }

    public static void main(String[] args) {
        Worker engineer = new Worker();
        System.out.println(engineer.aeronauticalEngineer);
        System.out.println(engineer.mechanicalEngineer);
        System.out.println(engineer.draftingEngineer);
    }

}
