package com.plane.pojo.plane;

import com.plane.pojo.construction.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Navy extends Plane{

    private int id;
    public static Map<Integer, Navy> allPlanes = new HashMap<>();
    public static List<Company> construction = new ArrayList<>();
    private static int countId = 0;

    public Navy(Integer id, String model, String manufacturer, String status, String cost, Material material,int speed) {
        super(model,manufacturer,status,cost,material,speed);

        if (!hasPlane()) {
            countId++;
            this.id = countId;
            allPlanes.put(id,this);
        }
    }

    @Override
    public void AircraftConstruction() throws ConstructionIsNotFinishedException {
        System.out.println("Constructing an aircraft");
        Fuselage fuselage = new Fuselage("monocoque", Material.ALLOY, "bulkheads","frames","formers","stringers");
        Wing leftWing = new Wing(Material.ALLOY, "left spar", "right spar", "first rib", "second rib");
        Wing rightWing = new Wing(Material.ALLOY, "left spar", "right spar", "first rib", "second rib");
        Stabilizer firstStabilizer = new Stabilizer("vertical");
        Stabilizer secondStabilizer = new Stabilizer("horizontal");
        Primary primaryGroup = new Primary("primary","ailerons", "elevators", "rudders", leftWing,rightWing,firstStabilizer,secondStabilizer);
        Secondary secGroup = new Secondary("secondary","trim tabs", "spring tabs",primaryGroup);
        Auxiliary auxGroup = new Auxiliary("auxiliary", "spoilers" , "speed brakes", "slats",leftWing,rightWing,fuselage);
        Auxiliary.WingFlaps wingFlaps = auxGroup.new WingFlaps("plain flaps","split flaps", "fowler flaps", "leading flaps");

        if(!isEmpty(fuselage) && !isEmpty(leftWing) && !isEmpty(rightWing) && !isEmpty(firstStabilizer) && !isEmpty(secondStabilizer)) {
            System.out.println("Successfully constructing");
        } else {
            throw new ConstructionIsNotFinishedException("Failed to construct " + getModel());
        }

        fuselage.Info();
        leftWing.Info();
        rightWing.Info();
        firstStabilizer.Info();
        secondStabilizer.Info();
        primaryGroup.Info();
        secGroup.Info();
        auxGroup.Info();
        wingFlaps.Info();
    }

    @Override
    public void AircraftInfo(){
        System.out.println("Model: " + getModel() + "\nManufacturer: " + getManufacturer()
                            + "\nStatus: " + getStatus() + "\nCost: " + getCost() + "\n" + getMaterial() + "\nSpeed: " + getSpeed());
    }

    public static boolean isEmpty( Object object ){
        if( object == null ){
            return true;
        }
        return false;
    }

    private boolean hasPlane() {
        for(Navy plane : allPlanes.values()) {
            if (plane.equals(this) && plane.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public static List<Navy> getAllPlanes() {
        return new ArrayList<>(allPlanes.values());
    }

    public List<Navy> getAllPlanes(Material material) {
        List<Navy> listAllPlanes = new ArrayList<>();
        for (Navy plane : allPlanes.values()) {
            if (plane.material == material) {
                listAllPlanes.add(plane);
            }
        }
        return listAllPlanes;
    }

    public static int getHowManyPlanes() {
        return allPlanes.size();
    }

    public int getHowManyPlanes(Material material) {
        return getAllPlanes(material).size();
    }

    public static  int getAllSpeedPlanes() {
        int count = 0;
        for (Navy plane : allPlanes.values()) {
            count += plane.getSpeed();
        }
        return count;
    }

    private List<Company> getConstruction() {
        return construction;
    }

    public int getAllSpeedPlanes(Material material) {
        int count = 0;
        for (Navy plane : getAllPlanes(material)) {
            count += plane.getSpeed();
        }
        return count;
    }

    public static int searchAndCount(List<Navy> planes) {
        List<Navy> boeings = planes.stream()
                .filter(plane -> "Boeing".equals(plane.getManufacturer()))
                .collect(Collectors.toList());

        Predicate<Integer> isBigger = s -> s > 950;

        return boeings.stream()
                .mapToInt(p -> p.getSpeed())
                .sum();
//                .reduce(0,(p1,p2) ->{
//                            if(isBigger.test(p2.getSpeed()))
//                                return p1+p2.getSpeed();
//                            else
//                                return p1+0;
//                        },
//                        (p1,p2)->p1+p2);
    }

    public static String maxSpeed (List<Navy> planes) {
        return planes.stream()
                .max(Comparator.comparingInt(Plane::getSpeed)).get().getModel();
    }

    public static Double averageSpeed (List<Navy> planes) {
        return planes.stream()
                .mapToInt(p -> p.getSpeed()).average().getAsDouble();
    }

    public static Map<String,List<Navy>> mapOfPlanes(List<Navy> planes) {
         return planes.stream()
                .collect(Collectors.groupingBy(p -> p.getMaterial()));
    }

    public static String allTrustedCompanies(List<Navy> planes) {
        return planes.stream()
                .map(p -> p.getConstruction())
                .flatMap(comp -> comp.stream())
                .max(Comparator.comparingInt(Company::getTrustIndex))
                .map(Company::getName)
                .orElseThrow(() -> new RuntimeException());
    }

    public static Object checkIfPresent(Optional<Company> opt) {
        if(opt.isPresent()) {
            return opt.get().getName();
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Navy other = (Navy) obj;
        return getSpeed() == other.getSpeed() &&
                Objects.equals(getModel(), other.getModel()) &&
                Objects.equals(getManufacturer(), other.getManufacturer()) &&
                Objects.equals(getCost(), other.getCost()) &&
                Objects.equals(getStatus(), other.getStatus()) &&
                Objects.equals(getMaterial(), other.getMaterial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpeed(),getModel(),getManufacturer(),getCost(),getStatus(),getMaterial());
    }

    public static void main(String[] args) {
//        Navy boeing = new Navy("F/A-18E/F Super Hornet", "McDonnell Douglas", "In service", "US$66.0 million", Material.ALLOY, 1915);
//        Navy grumman = new Navy("E-2 Hawkeye","Northrop Grumman", "In service", "US$176 million", Material.ALUMINUM, 650);
//        Navy boeing2 = new Navy("E-6 Mercury","Boeing", "In service", "US$141.7 million",Material.ALLOY, 980);
//        Navy lockheed = new Navy("EP-3","Lockheed Corporation", "Active", "US$36 million",Material.TITANIUM, 700);
//        Navy boeing3 = new Navy("EA-18G Growler","Boeing", "In service", "US$68.2 million",Material.ALLOY, 1900);
//        Navy lockheed1 = new Navy("P-3 Orion","Lockheed Corporation", "Active", "US$36 million",Material.TITANIUM, 761);
//        Navy boeing4 = new Navy("P-8 Poseidon","Boeing", "In service", "US$256.5 million",Material.ALLOY, 907);


        List<Navy> planes = new ArrayList<>();
        planes.add(new Navy(1,"F/A-18E/F Super Hornet", "McDonnell Douglas", "In service", "US$66.0 million", Material.ALLOY, 1915));
        planes.add(new Navy(2,"E-2 Hawkeye","Northrop Grumman", "In service", "US$176 million", Material.ALUMINUM, 650));
        planes.add(new Navy(3,"E-6 Mercury","Boeing", "In service", "US$141.7 million",Material.ALLOY, 980));
        planes.add(new Navy(4,"EP-3","Lockheed Corporation", "Active", "US$36 million",Material.TITANIUM, 700));
        planes.add(new Navy(5,"EA-18G Growler","Boeing", "In service", "US$68.2 million",Material.ALLOY, 1900));
        planes.add(new Navy(6,"P-3 Orion","Lockheed Corporation", "Active", "US$36 million",Material.TITANIUM, 761));
        planes.add(new Navy(7,"P-8 Poseidon","Boeing", "In service", "US$256.5 million",Material.ALLOY, 907));


        System.out.println("Total speed: "+ searchAndCount(planes));
        System.out.println("Model with the highest speed: "+ maxSpeed(planes));
        System.out.println("Average speed: "+ averageSpeed(planes));
        System.out.println(mapOfPlanes(planes));

        construction.add(new Company("Airbus",1));
        construction.add(new Company("Boeing",10));
        construction.add(new Company("Lockheed Martin",3));
        construction.add(new Company("United Technologies",6));
        construction.add(new Company("Northrop Grumman",10));
        construction.add(new Company("GE Aviation",7));
        System.out.println("Most trusted company: "+ allTrustedCompanies(planes));

//        boeing.AircraftConstruction();
//        grumman.AircraftConstruction();
//        boeing2.AircraftConstruction();
//        lockheed.AircraftConstruction();
//        boeing3.AircraftConstruction();
//        lockheed1.AircraftConstruction();
//        boeing4.AircraftConstruction();
//        try {
//            boeing.AircraftConstruction();
//        } catch (ConstructionIsNotFinishedException e) {
//            System.out.println(e.getMessage());
//            System.out.println("Some details are missing.");
//        } finally {
//            System.out.println("Finally!");
//        }
//
        //System.out.println(boeing.equals(new ArrayList<>()));
//
//        ArrayList<String> models = new ArrayList<>(Arrays.asList(boeing.getModel(),boeing1.getModel(),grumman.getModel(),boeing2.getModel(),
//                lockheed.getModel(),boeing3.getModel(),lockheed1.getModel(),boeing4.getModel()));
//        Iterator<String> iter = models.iterator();
//        while(iter.hasNext()) {
//            System.out.println(iter.next());
//        }
    }
}
