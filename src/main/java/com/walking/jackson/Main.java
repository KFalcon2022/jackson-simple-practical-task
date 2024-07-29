package com.walking.jackson;

import com.walking.jackson.configuration.ObjectMapperConfiguration;
import com.walking.jackson.model.Car;
import com.walking.jackson.service.CarFileService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var objectMapperConfig = new ObjectMapperConfiguration();

//       Можем выбрать ObjectMapper в нужной конфигурации
        var objectMapper = objectMapperConfig.defaultObjectMapper();
//        var objectMapper = objectMapperConfig.imperativeObjectMapper();
//        var objectMapper = objectMapperConfig.jsonNodeObjectMapper();

        var carFileService = new CarFileService(objectMapper);

        var cars = carFileService.readAll();

        carFileService.writeAll(cars);
    }

    private static List<Car> initCars() {
        Car car1 = new Car(1L, "RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car(2L, "RR-222-RR", 2016, null, true);
        Car car3 = new Car(3L, "RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car(4L, "RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car(5L, "RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car(6L, "RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car(7L, "RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car(8L, "RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car(9L, "RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car(10L, "RR-000-RR", 2018, "yellow", true);

        return List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);
    }
}
