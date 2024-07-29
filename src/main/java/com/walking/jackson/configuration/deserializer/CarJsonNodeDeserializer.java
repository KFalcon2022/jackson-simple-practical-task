package com.walking.jackson.configuration.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.walking.jackson.model.Car;

import java.io.IOException;

public class CarJsonNodeDeserializer extends JsonDeserializer<Car> {
    @Override
    public Car deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        JsonNode rootNode = context.readTree(jsonParser);

        var id = rootNode.get("id").longValue();
        var number = rootNode.get("number").textValue();
        var year = rootNode.get("year").intValue();
        var color = rootNode.get("color").textValue();
        var actualTechnicalInspection = rootNode.get("actualTechnicalInspection").booleanValue();

        return new Car(id, number, year, color, actualTechnicalInspection);
    }
}
