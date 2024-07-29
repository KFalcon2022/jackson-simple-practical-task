package com.walking.jackson.configuration.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.walking.jackson.model.Car;

import java.io.IOException;

public class CarJsonGeneratorSerializer extends JsonSerializer<Car> {
    @Override
    public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("id", car.getId());
        jsonGenerator.writeStringField("number", car.getNumber());
        jsonGenerator.writeNumberField("year", car.getYear());
        jsonGenerator.writeStringField("color", car.getColor());
        jsonGenerator.writeBooleanField("actualTechnicalInspection", car.isActualTechnicalInspection());

        jsonGenerator.writeEndObject();
    }
}
