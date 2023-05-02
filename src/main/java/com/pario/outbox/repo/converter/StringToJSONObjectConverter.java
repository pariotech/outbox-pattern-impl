package com.pario.outbox.repo.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.pario.outbox.exception.JDBCConverterException;
import org.json.JSONObject;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Temire.Emmanuel 02/05/2023 - 6:52 pm
 **/
public class StringToJSONObjectConverter implements Converter<String, JSONObject> {
        @Override
        public JSONObject convert(String source) {
        try {
            return new Gson().fromJson(source, JSONObject.class);
        } catch (Exception e) {
            throw new JDBCConverterException("Error converting StringToJsonNode", e);
        }
    }
    }
