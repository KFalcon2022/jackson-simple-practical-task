package com.walking.jackson.configuration.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.walking.jackson.model.Car;

import java.io.IOException;

public class CarJsonParserDeserializer extends JsonDeserializer<Car> {
    @Override
    public Car deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            jsonParser.nextToken();
        }

        var car = new Car();

        while (jsonParser.currentToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.currentName();
            jsonParser.nextToken();

            mapField(jsonParser, fieldName, car);

            jsonParser.nextToken();
        }

        return car;
    }

    private void mapField(JsonParser jsonParser, String fieldName, Car car) throws IOException {
        switch (fieldName) {
            case "id" -> car.setId(jsonParser.getLongValue());
            case "number" -> car.setNumber(jsonParser.getValueAsString());
            case "year" -> car.setYear(jsonParser.getIntValue());
            case "color" -> car.setColor(jsonParser.getValueAsString());
            case "actualTechnicalInspection" -> car.setActualTechnicalInspection(jsonParser.getBooleanValue());
            default -> throw new IOException("Unknown token: %s".formatted(jsonParser.currentToken()));
        }
    }
}
