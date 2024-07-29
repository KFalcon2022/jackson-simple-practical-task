package com.walking.jackson.configuration.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.walking.jackson.model.Car;

import java.io.IOException;

public class CarJsonNodeSerializer extends JsonSerializer<Car> {
    @Override
    public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        JsonNodeFactory nodeFactory = JsonNodeFactory.instance;

        ObjectNode rootNode = nodeFactory.objectNode()
                .put("id", car.getId())
                .put("number", car.getNumber())
                .put("year", car.getYear())
                .put("color", car.getColor())
                .put("actualTechnicalInspection", car.isActualTechnicalInspection());

        jsonGenerator.writeTree(rootNode);
    }
}
