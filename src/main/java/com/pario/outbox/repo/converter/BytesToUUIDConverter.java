package com.pario.outbox.repo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Created by Adesegun.Adeyemo on 11/01/2023
 */
@ReadingConverter
public class BytesToUUIDConverter implements Converter<byte[], UUID> {
    @Override
    public UUID convert(byte[] source) {
        ByteBuffer buf = ByteBuffer.wrap(source);
        return new UUID(buf.getLong(), buf.getLong());
    }
}
