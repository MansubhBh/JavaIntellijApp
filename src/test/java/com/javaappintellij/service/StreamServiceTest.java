package com.javaappintellij.service;

import com.javaappintellij.model.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class StreamServiceTest {

    private StreamService streamApp;

    @BeforeEach
    public void beforeEveryTest() {
        streamApp = new StreamServiceImpl();
    }

    @Test
    public void testSumAfterSkimFive() {
        int actualval = streamApp.sumAfterSkimFive();
        Assertions.assertEquals(100500, actualval);
    }

    @Test
    public void testCreateListOfStates() {
        Map<String, String> statemap = new HashMap<>();
        statemap.put("bagmati", "kathmandu");
        statemap.put("gandaki", "pokhara");
        statemap.put("lumbini", "butwal");
        List<String> actuallist = streamApp.createlistOfStates(statemap);
        List<String> expectedList = Arrays.asList("bagmati", "gandaki", "lumbini");
        Assertions.assertEquals(expectedList, actuallist);
    }


    @Test
    public void testabbrvKey() {
        Map<String, String> statemap = new HashMap<>();
        statemap.put("Australian Capital Territory", "Canberra");
        statemap.put("New South Wales", "Sydney");
        statemap.put("Victoria", "Melbourne");
        statemap.put("Queensland", "Brisbane");

        Map<String, String> actualval = streamApp.abbrvKey(statemap);
        Map<String, String> expectedval = new HashMap<>();
        expectedval.put("ACT", "Canberra");
        expectedval.put("NSW", "Sydney");
        expectedval.put("VIC", "Melbourne");
        expectedval.put("QUE", "Brisbane");
        Assertions.assertEquals(expectedval, actualval);
    }

    @Test
    public void testReverseEachItem() {
        List<String> citilist = Arrays.asList("perth", "sydney", "nsw");
        List<String> actuallist = streamApp.reverseEachItem(citilist);
        List<String> expectedlist = Arrays.asList("htrep", "yendys", "wsn");
        Assertions.assertEquals(expectedlist, actuallist);
    }

    @Test
    public void testconvertToGeoLocations() {
        List<String> coordinateList = Arrays.asList("33.868820,151.209290", "27.469770,153.025131");
        List<Location> actualval = streamApp.convertToGeoLocations(coordinateList);
        List<Location> expectedList = new ArrayList<>();
        expectedList.add(new Location(33.868820, 151.209290));
        expectedList.add(new Location(27.469770, 153.025131));
        Assertions.assertEquals(expectedList, actualval);

    }

    @Test
    public void testLocationEquality() {
        Location location = new Location(0.0, 0.0);
        Assertions.assertEquals(location, location);
        Assertions.assertNotEquals(location, null);
        Assertions.assertEquals(0.0d, location.getLongitude());
        Assertions.assertEquals(0.0d, location.getLatitude());
        Assertions.assertNotNull(location.toString());

        Assertions.assertNotEquals(location, "");
        Location location2 = new Location(0.1, 0.2);
        Assertions.assertNotEquals(location, location2);

        Location location1 = new Location(0.1, 0.2);
        Assertions.assertEquals(location1.hashCode(), location2.hashCode());
        Location location3 = new Location(0.1, 0.3);
        Assertions.assertNotEquals(location2, location3);

    }


}
