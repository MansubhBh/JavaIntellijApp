package com.javaappintellij.service;

import  com.javaappintellij.model.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamServiceImpl implements StreamService {

    @Override
    public int sumAfterSkimFive() {
        return IntStream.rangeClosed(1, 1000)
                .boxed()
                .filter(i -> i % 5 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public List<String> createlistOfStates(Map<String, String> statemap) {
        return statemap.keySet().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public Map<String, String> abbrvKey(Map<String, String> statemap) {
        Map<String, String> abbvrmap = new HashMap<>();
        statemap.entrySet().stream().forEach(
                entry -> {
                    if (entry.getKey().contains(" ")) {
                        String[] tokens = entry.getKey().split(" ");
                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < tokens.length; i++) {
                            builder.append(tokens[i].charAt(0));
                        }
                        abbvrmap.put(builder.toString().toUpperCase(), entry.getValue());
                    } else {
                        String abvr = entry.getKey().substring(0, 3);
                        abbvrmap.put(abvr.toUpperCase(), entry.getValue());
                    }
                });
        return abbvrmap;
    }

    @Override
    public List<String> reverseEachItem(List<String> citilist) {
        return citilist.stream().map(s -> {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }).collect(Collectors.toList());
    }


    @Override
    public List<Location> convertToGeoLocations(List<String> coordinateList) {
        return coordinateList.stream().map(entry -> {
            String[] tokens = entry.split(",");
            Location location = new Location();
            location.setLatitude(Double.valueOf(tokens[0]));
            location.setLongitude(Double.valueOf(tokens[1]));
            return location;
        }).collect(Collectors.toList());
    }


}
