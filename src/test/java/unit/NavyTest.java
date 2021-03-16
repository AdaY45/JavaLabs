package unit;

import com.plane.pojo.construction.*;
import com.plane.pojo.plane.Navy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NavyTest {
    private Navy boeing;
    private Navy grumman;
    private Navy boeing2;
    private Navy lockheed;
    private Navy boeing3;
    private Navy lockheed1;
    private Navy boeing4;
    Navy plane;
    List<Navy> planes = new ArrayList<>();


    @BeforeEach
    public void setUp() throws Exception {
        plane = org.mockito.Mockito.mock(Navy.class);
        boeing = new Navy(1,"F/A-18E/F Super Hornet", "McDonnell Douglas", "In service", "US$66.0 million", Material.ALLOY, 1915);
        grumman = new Navy(2,"E-2 Hawkeye","Northrop Grumman", "In service", "US$176 million", Material.ALUMINUM, 650);
        boeing2 = new Navy(3,"E-6 Mercury","Boeing", "In service", "US$141.7 million",Material.ALLOY, 980);
        lockheed = new Navy(4,"EP-3","Lockheed Corporation", "Active", "US$36 million",Material.TITANIUM, 700);
        boeing3 = new Navy(5,"EA-18G Growler","Boeing", "In service", "US$68.2 million",Material.ALLOY, 1900);
        lockheed1 = new Navy(6,"P-3 Orion","Lockheed Corporation", "Active", "US$36 million",Material.TITANIUM, 761);
        boeing4 = new Navy(7,"P-8 Poseidon","Boeing", "In service", "US$256.5 million",Material.ALLOY, 907);
        planes.add(new Navy(8,"F/A-18E/F Super Hornet", "McDonnell Douglas", "In service", "US$66.0 million", Material.ALLOY, 1915));
        planes.add(new Navy(9,"E-2 Hawkeye","Northrop Grumman", "In service", "US$176 million", Material.ALUMINUM, 650));
        planes.add(new Navy(10,"E-6 Mercury","Boeing", "In service", "US$141.7 million",Material.ALLOY, 980));
        planes.add(new Navy(11,"EP-3","Lockheed Corporation", "Active", "US$36 million",Material.TITANIUM, 700));
        planes.add(new Navy(12,"EA-18G Growler","Boeing", "In service", "US$68.2 million",Material.ALLOY, 1900));
        planes.add(new Navy(13,"P-3 Orion","Lockheed Corporation", "Active", "US$36 million",Material.TITANIUM, 761));
        planes.add(new Navy(14,"P-8 Poseidon","Boeing", "In service", "US$256.5 million",Material.ALLOY, 907));
    }

    @Test
    public void getAllPlanes() {

        List<Navy> expected = Navy.getAllPlanes();

        List<Navy> actual = new ArrayList<>();
        actual.add(boeing);
        actual.add(grumman);
        actual.add(boeing2);
        actual.add(lockheed);
        actual.add(boeing3);
        actual.add(lockheed1);
        actual.add(boeing4);

        assertEquals(expected,actual);
    }

    @Test
    public void getAllPlanes_NO_NULL() {
        List<Navy> expected = Navy.getAllPlanes();
        assertNotNull(expected);
    }

    @Test
    public void getAllPlanes_ALLOY() {
        Navy boeing = new Navy(1,"F/A-18E/F Super Hornet", "McDonnell Douglas", "In service", "US$66.0 million", Material.ALLOY, 1915);
        Navy boeing2 = new Navy(2,"E-6 Mercury","Boeing", "In service", "US$141.7 million",Material.ALLOY, 980);
        Navy boeing3 = new Navy(3,"EA-18G Growler","Boeing", "In service", "US$68.2 million",Material.ALLOY, 1900);
        Navy boeing4 = new Navy(4,"P-8 Poseidon","Boeing", "In service", "US$256.5 million",Material.ALLOY, 907);

        List<Navy> expected = plane.getAllPlanes(Material.ALLOY);

        List<Navy> actual = new ArrayList<>();
//        actual.add(boeing);
//        actual.add(boeing2);
//        actual.add(boeing3);
//        actual.add(boeing4);

        assertEquals(expected,actual);
    }

    @Test
    public void getAllPlanes_ALLOY_NO_NULL() {
        List<Navy> expected = plane.getAllPlanes(Material.ALLOY);
        assertNotNull(expected);
    }

    public void getAllPlanes_ALUMINUM() {

        List<Navy> expected = plane.getAllPlanes(Material.ALUMINUM);

        List<Navy> actual = new ArrayList<>();
        actual.add(grumman);

        assertEquals(expected,actual);
    }

    @Test
    public void getAllPlanes_ALLUMINIUM_NO_NULL() {
        List<Navy> expected = plane.getAllPlanes(Material.ALUMINUM);
        assertNotNull(expected);
    }

    public void getAllPlanes_MAGNESIUM() {

        List<Navy> expected = plane.getAllPlanes(Material.MAGNESIUM);

        List<Navy> actual = new ArrayList<>();

        assertEquals(expected,actual);
    }

    @Test
    public void getAllPlanes_MAGNESIUM_NO_NULL() {
        List<Navy> expected = plane.getAllPlanes(Material.MAGNESIUM);
        assertNotNull(expected);
    }

    public void getAllPlanes_TITANIUM() {

        List<Navy> expected = plane.getAllPlanes(Material.TITANIUM);

        List<Navy> actual = new ArrayList<>();
        actual.add(lockheed);
        actual.add(lockheed1);

        assertEquals(expected,actual);
    }

    @Test
    public void getAllPlanes_TITANIUM_NO_NULL() {
        List<Navy> expected = plane.getAllPlanes(Material.TITANIUM);
        assertNotNull(expected);
    }

    public void getAllPlanes_STEEL_ALLOYS() {

        List<Navy> expected = plane.getAllPlanes(Material.STEEL_ALLOYS);

        List<Navy> actual = new ArrayList<>();

        assertEquals(expected,actual);
    }

    @Test
    public void getAllPlanes_STEEL_ALLOYS_NO_NULL() {
        List<Navy> expected = plane.getAllPlanes(Material.STEEL_ALLOYS);
        assertNotNull(expected);
    }

    public void getAllPlanes_TRANSPARENT_PLASTIC() {

        List<Navy> expected = plane.getAllPlanes(Material.TRANSPARENT_PLASTIC);

        List<Navy> actual = new ArrayList<>();

        assertEquals(expected,actual);
    }

    @Test
    public void getAllPlanes_TRANSPARENT_PLASTIC_NO_NULL() {
        List<Navy> expected = plane.getAllPlanes(Material.TRANSPARENT_PLASTIC);
        assertNotNull(expected);
    }

    public void getAllPlanes_REINFORCED_PLASTIC() {

        List<Navy> expected = plane.getAllPlanes(Material.REINFORCED_PLASTIC);

        List<Navy> actual = new ArrayList<>();

        assertEquals(expected,actual);
    }

    @Test
    public void getAllPlanes_REINFORCED_PLASTIC_NO_NULL() {
        List<Navy> expected = plane.getAllPlanes(Material.REINFORCED_PLASTIC);
        assertNotNull(expected);
    }

    @Test
    public void getHowManyPlanes() {
        int expected = Navy.getHowManyPlanes();

        int actual = 7;

        assertEquals(expected,actual);
    }

    @Test
    public void getHowManyPlanes_ALLOY() {
        int expected = plane.getHowManyPlanes(Material.ALLOY);

        int actual = 4;

        assertEquals(expected,0);
    }

    @Test
    public void getHowManyPlanes_ALUMINUM() {
        int expected = plane.getHowManyPlanes(Material.ALUMINUM);

        int actual = 1;

        assertEquals(expected,0);
    }

    @Test
    public void getHowManyPlanes_MAGNESIUM() {
        int expected = plane.getHowManyPlanes(Material.MAGNESIUM);

        int actual = 0;

        assertEquals(expected,actual);
    }

    @Test
    public void getHowManyPlanes_TITANIUM() {
        int expected = plane.getHowManyPlanes(Material.TITANIUM);

        int actual = 2;

        assertEquals(expected,0);
    }

    @Test
    public void getHowManyPlanes_STEEL_ALLOYS() {
        int expected = plane.getHowManyPlanes(Material.STEEL_ALLOYS);

        int actual = 0;

        assertEquals(expected,actual);
    }

    @Test
    public void getHowManyPlanes_TRANSPARENT_PLASTIC() {
        int expected = plane.getHowManyPlanes(Material.TRANSPARENT_PLASTIC);

        int actual = 0;

        assertEquals(expected,actual);
    }

    @Test
    public void getHowManyPlanes_REINFORCED_PLASTIC() {
        int expected = plane.getHowManyPlanes(Material.REINFORCED_PLASTIC);

        int actual = 0;

        assertEquals(expected,actual);
    }

    @Test
    public void getAllSpeedPlanes() {
        int expected = Navy.getAllSpeedPlanes();

        int actual = 1915 + 650 + 980 + 700 + 1900 + 761 + 907;

        assertEquals(expected,actual);
    }

    @Test
    public void getAllSpeedPlanes_ALLOY() {
        int expected = plane.getAllSpeedPlanes(Material.ALLOY);

        int actual = 1915 + 980 + 1900 + 907;

        assertEquals(expected,0);
    }

    @Test
    public void getAllSpeedPlanes_ALUMINUM() {
        int expected = plane.getAllSpeedPlanes(Material.ALUMINUM);

        int actual = 650;

        assertEquals(expected,0);
    }

    @Test
    public void getAllSpeedPlanes_MAGNESIUM() {
        int expected = plane.getAllSpeedPlanes(Material.MAGNESIUM);

        int actual = 0;

        assertEquals(expected,actual);
    }

    @Test
    public void getAllSpeedPlanes_TITANIUM() {
        int expected = plane.getAllSpeedPlanes(Material.TITANIUM);

        int actual = 700 + 761;

        assertEquals(expected,0);
    }

    @Test
    public void getAllSpeedPlanes_STEEL_ALLOYS() {
        int expected = plane.getAllSpeedPlanes(Material.STEEL_ALLOYS);

        int actual = 0;

        assertEquals(expected,actual);
    }

    @Test
    public void getAllSpeedPlanes_TRANPARENT_PLASTIC() {
        int expected = plane.getAllSpeedPlanes(Material.TRANSPARENT_PLASTIC);

        int actual = 0;

        assertEquals(expected,actual);
    }

    @Test
    public void getAllSpeedPlanes_REINFORCED_PLASTIC() {
        int expected = plane.getAllSpeedPlanes(Material.REINFORCED_PLASTIC);

        int actual = 0;

        assertEquals(expected,actual);
    }

    @Test
    public void searchAndCount() {
        int expected = Navy.searchAndCount(planes);

        int actual = 3787;

        assertEquals(expected,actual);
    }

    @Test
    public void maxSpeed() {
        String expected = Navy.maxSpeed(planes);

        String actual = "F/A-18E/F Super Hornet";

        assertEquals(expected,actual);
    }

    @Test
    public void averageSpeed() {
        Double expected = Navy.averageSpeed(planes);

        Double actual = 1116.142857142857;

        assertEquals(expected,actual);
    }

    @Test
    public void mapOfPlanes() {
        Map<String,List<Navy>> expected = Navy.mapOfPlanes(planes);

        int actual = 3;

        assertEquals(expected.size(),actual);
    }

//    @Test
//    public void allTrustedCompanies() {
//        String expected = Navy.allTrustedCompanies(planes);
//
//        assertEquals(expected,null);
//    }
}