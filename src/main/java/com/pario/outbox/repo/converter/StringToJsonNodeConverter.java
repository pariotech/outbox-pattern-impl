package com.pario.outbox.repo.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pario.outbox.exception.JDBCConverterException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * Created by Adesegun.Adeyemo on 16/01/2023
 */
@ReadingConverter
@RequiredArgsConstructor
public class StringToJsonNodeConverter implements Converter<String, JsonNode> {
    private final ObjectMapper mapper;

    @Override
    public JsonNode convert(String source) {
        try {
            return mapper.readValue(source, JsonNode.class);
        } catch (JsonProcessingException e) {
            throw new JDBCConverterException("Error converting StringToJsonNode", e);
        }
    }
}
