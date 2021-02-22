package com.company.maintance;

public class Worker {
    private final String aeronauticalEngineer = "Mark Roseman";
    private final String mechanicalEngineer = "Calvin Hibs";
    private final String draftingEngineer = "Kevin Baker";
    private final String operationsTechnician = "Alicia Tatcha";
    private final String AircraftEquipmentMechanic = "Haryam Reyez";

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
