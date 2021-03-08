package it;

import com.plane.pojo.construction.Material;
import com.plane.pojo.plane.Navy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class NavyIT {
    Navy plane = org.mockito.Mockito.mock(Navy.class);
    private Navy boeing;
    private Navy grumman;
    private Navy boeing2;
    private Navy lockheed;
    private Navy boeing3;
    private Navy lockheed1;
    private Navy boeing4;
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
    public void getAllSpeed_ALLOY() {
        Material material = Material.ALLOY;

        Mockito.when(plane.getAllSpeedPlanes(material)).thenReturn(1915 + 980 + 1900 + 907);
        assertEquals(5702, plane.getAllSpeedPlanes(material));
        Mockito.verify(plane, Mockito.times(1)).getAllSpeedPlanes(material);
    }

    @Test
    public void getHowManyPlanes_ALUMINUM() {
        Material material = Material.ALUMINUM;
        Mockito.when(plane.getAllSpeedPlanes(material)).thenReturn(650);
        assertEquals(650, plane.getAllSpeedPlanes(material));
        Mockito.verify(plane, Mockito.times(1)).getAllSpeedPlanes(material);
    }

    @Test
    public void getHowManyPlanes_TITANIUM() {
        Material material = Material.TITANIUM;
        Mockito.when(plane.getAllSpeedPlanes(material)).thenReturn(700 + 761);
        assertEquals(700 + 761,plane.getAllSpeedPlanes(material));
        Mockito.verify(plane,Mockito.times(1)).getAllSpeedPlanes(material);
    }

}