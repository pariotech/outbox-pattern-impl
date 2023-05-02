package com.pario.outbox.repo.converter;

import com.google.gson.Gson;
import com.pario.outbox.exception.JDBCConverterException;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * Created by Temire.Emmanuel 02/05/2023 - 6:11 pm
 **/
@WritingConverter
@RequiredArgsConstructor
public class JSONObjectToStringConverter implements Converter<JSONObject, String> {


    @Override
    public String convert(JSONObject source) {
        try {
            return new Gson().toJson(source);
        } catch (Exception e) {
            throw new JDBCConverterException("Error converting JsonNodeToString", e);
        }
    }
}
