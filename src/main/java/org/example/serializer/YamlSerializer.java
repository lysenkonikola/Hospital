package org.example.serializer;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class YamlSerializer<T> implements Serializer{
    private final YAMLMapper yamlMapper;
    private final Class<T> clazz;

    public YamlSerializer(Class<T> clazz) {
        this.clazz = clazz;
        this.yamlMapper = new YAMLMapper();
        this.yamlMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serialize(Object entity, File file) throws IOException {
        yamlMapper.writeValue(file, entity);

    }

    @Override
    public T deserialize(File file) throws IOException {
        return  this.yamlMapper.readValue(file,this.clazz);
    }
}
