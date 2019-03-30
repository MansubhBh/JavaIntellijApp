package com.javaappintellij.service;

import com.javaappintellij.model.Location;

import java.util.List;
import java.util.Map;

public interface StreamService {
     int sumAfterSkimFive();
     List<String> createlistOfStates(Map<String, String> statemap);
     Map<String, String> abbrvKey(Map<String, String> statemap);
    public List<String> reverseEachItem(List<String> citilist);
    List<Location> convertToGeoLocations(List<String> coordinateList);
}
