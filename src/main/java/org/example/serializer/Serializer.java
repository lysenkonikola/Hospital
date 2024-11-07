package org.example.serializer;

import java.io.File;
import java.io.IOException;

public interface Serializer<T> {
    /**
     * Serializes an entity to a specified format and writes it to a file.
     *
     * @param entity The entity to serialize.
     * @param file The file to write to.
     * @throws IOException If an I/O error occurs.
     */
    void serialize(T entity, File file) throws IOException;

    /**
     * Deserializes an entity from a specified format in a file.
     *
     * @param file The file to read from.
     * @return The deserialized entity.
     * @throws IOException If an I/O error occurs.
     */
    T deserialize(File file) throws IOException;
}
