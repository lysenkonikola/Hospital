package org.example.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class JsonSerializer <T> implements Serializer{
    private final ObjectMapper objectMapper ;
    private final Class<T> clazz;

    public JsonSerializer(Class<T> clazz) {
        this.clazz = clazz;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void serialize(Object entity, File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(file, entity);

    }

    @Override
    public Object deserialize(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(file, this.clazz);
    }
}
