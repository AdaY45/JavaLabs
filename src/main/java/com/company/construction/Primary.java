package com.company.construction;

public class Primary extends FlightControlSurfaces{
    private final String ailerons;
    private final String elevators;
    private final String rudders;
    private final Wing leftWing;
    private final Wing rightWing;
    private final Stabilizer firstStabilizer;
    private final Stabilizer secondStabilizer;
    private String action;

    public Primary(String name, String ailerons, String elevators, String rudders,Wing leftWing,Wing rightWing,Stabilizer first,Stabilizer second) {
        super(name);
        this.ailerons = ailerons;
        this.elevators = elevators;
        this. rudders = rudders;
        this.leftWing = leftWing;
        this.rightWing = rightWing;
        this.firstStabilizer = first;
        this.secondStabilizer = second;
    }

    @Override
    public void construct() {
        leftWing.addElement(ailerons,"first");
        rightWing.addElement(ailerons,"second");
        action = "longitudinal control";
        actionPrint(action);
        addStabilizer(firstStabilizer);
        addStabilizer(secondStabilizer);
    }

    public void actionPrint(String a) {
        System.out.println("The " + a + " was done.");
    }

    public void addStabilizer(Stabilizer s) {
        if(s.getType().equals("horizontal")) {
            s.addElement(elevators);
            action = "lateral control";
            actionPrint(action);
        } else if(s.getType().equals("vertical")){
            s.addElement(rudders);
            action = "directional control";
            actionPrint(action);
        }
    }

    public void addElement(String element) {
        System.out.println(element + " are attached to the primary control surface.");
    }

    @Override
    public void Info() {
        System.out.println("\n" + getGroup() + " group is being constructed: \n");
        construct();
        System.out.println("\n" + getGroup() + " group has been successfully constructed: \n");
    }
}
