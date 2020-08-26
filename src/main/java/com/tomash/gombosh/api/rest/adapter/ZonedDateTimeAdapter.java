package com.tomash.gombosh.api.rest.adapter;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import static java.util.Objects.isNull;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class ZonedDateTimeAdapter extends TypeAdapter<ZonedDateTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public void write(final JsonWriter jsonWriter, final ZonedDateTime value) throws IOException {
        if (isNull(value)) {
            jsonWriter.nullValue();
        } else {
            final String format = value.format(FORMATTER);
            jsonWriter.value(format);
        }
    }

    @Override
    public ZonedDateTime read(final JsonReader jsonReader) {
        final JsonElement jElement = new JsonParser().parse(jsonReader);
        return ZonedDateTime.parse(jElement.getAsString(), FORMATTER);
    }
}
