package com.walking.jackson.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.walking.jackson.configuration.deserializer.CarJsonNodeDeserializer;
import com.walking.jackson.configuration.deserializer.CarJsonParserDeserializer;
import com.walking.jackson.configuration.serializer.CarJsonGeneratorSerializer;
import com.walking.jackson.configuration.serializer.CarJsonNodeSerializer;
import com.walking.jackson.model.Car;

public class ObjectMapperConfiguration {
//    Один из расхожих примеров, когда именование методов отходит от правила с глаголом.
//    Обычно такие методы не используются напрямую, а обрабатываются контейнером, отвечающим за создание и управление
//    объектами. Позже мы увидим это в работе со Spring.
    public ObjectMapper defaultObjectMapper()
    {
        return new ObjectMapper();
    }

//    Название неоднозначное - все же, реализация конкретных мапперов имеет мало отношения к самому ObjectMapper.
//    Но в контексте условия задачи пойдет
    public ObjectMapper imperativeObjectMapper()
    {
        var carModule = new SimpleModule()
                .addSerializer(Car.class, new CarJsonGeneratorSerializer())
                .addDeserializer(Car.class, new CarJsonParserDeserializer());

        return new ObjectMapper()
                .registerModule(carModule);
    }

    public ObjectMapper jsonNodeObjectMapper()
    {
        var carModule = new SimpleModule()
                .addSerializer(Car.class, new CarJsonNodeSerializer())
                .addDeserializer(Car.class, new CarJsonNodeDeserializer());

        return new ObjectMapper()
                .registerModule(carModule);
    }
}
