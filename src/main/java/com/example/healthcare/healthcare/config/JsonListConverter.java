package com.example.healthcare.healthcare.config;
//package com.example.healthcare.healthcare.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Converter
public class JsonListConverter implements AttributeConverter<List<Map<String, Object>>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Map<String, Object>> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute); // Converts to JSON string
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting list of maps to JSON", e);
        }
    }

    @Override
    public List<Map<String, Object>> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<List<Map<String, Object>>>() {});
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON string to list of maps", e);
        }
    }
}
