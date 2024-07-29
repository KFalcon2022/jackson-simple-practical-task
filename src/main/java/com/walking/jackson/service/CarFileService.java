package com.walking.jackson.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walking.jackson.model.Car;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarFileService {
    private static final File CAR_FILE = new File("./src/main/resources/cars.json");
    private static final TypeReference<List<Car>> CAR_LIST_TYPE_REFERENCE = new TypeReference<>() {};

    private final ObjectMapper objectMapper;

    public CarFileService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Car> readAll() {
        try {
            return objectMapper.readValue(CAR_FILE, CAR_LIST_TYPE_REFERENCE);
        } catch (IOException e) {
            throw new RuntimeException("Error of file reading", e);
        }
    }

    public void writeAll(List<Car> cars) {
        try {
            objectMapper.writeValue(CAR_FILE, cars);
        } catch (IOException e) {
            throw new RuntimeException("Error of file writing", e);
        }
    }
}
