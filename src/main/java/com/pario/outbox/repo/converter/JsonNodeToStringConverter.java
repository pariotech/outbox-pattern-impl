package com.pario.outbox.repo.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pario.outbox.exception.JDBCConverterException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * Created by Temire.Emmanuel on 16/01/2023
 */
@WritingConverter
@RequiredArgsConstructor
public class JsonNodeToStringConverter implements Converter<JsonNode, String> {
    private final ObjectMapper mapper;

    @Override
    public String convert(JsonNode source) {
        try {
            return mapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            throw new JDBCConverterException("Error converting JsonNodeToString", e);
        }
    }
}
