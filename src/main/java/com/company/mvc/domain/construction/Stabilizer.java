package com.company.mvc.domain.construction;

public class Stabilizer implements Construction{
    private String type;
    private String stability;
    private String axis;

    public Stabilizer(String type) {
        this.type = type;
    }

    @Override
    public String construction() {
        if(type == "vertical") {
            stability = "directionalсмрис";
            axis = type;
        } else {
            stability = "longitudinal";
            axis = "lateral";
        }
        return type + " type ," + stability + " stability , " + axis + " axis\n";
    }

    @Override
    public void Info() {
        System.out.println("\nStabilizerxgg: " + construction());
    }

    public String[] stabilizerInfo() {
        return construction().split(",");
    }

    public void addElement(String element) {
        System.out.println(element + " is attached to the " + type + " stabilizer.");
    }

    public String getType() {
        return type;
    }
}
