package org.example.serializer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> implements Serializer {
    private final XmlMapper xmlMapper;
    private final Class<T> clazz;

    public XmlSerializer(Class<T> clazz) {
        this.clazz = clazz;
        this.xmlMapper = new XmlMapper();
    }

    @Override
    public void serialize(Object entity, File file) throws IOException {
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.writeValue(file, entity);
    }

    @Override
    public Object deserialize(File file) throws IOException {
        xmlMapper.registerModule(new JavaTimeModule());
        return xmlMapper.readValue(file, clazz);
    }
}
