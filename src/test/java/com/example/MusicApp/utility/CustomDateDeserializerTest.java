package com.example.MusicApp.utility;

import com.example.MusicApp.models.Event;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomDateDeserializerTest {

    @InjectMocks
    CustomDateDeserializer deserializer;

    @Mock
    JsonParser parser;

    @Mock
    DeserializationContext context;

    @Test
    public void whenDeserializingDateUsingCustomDeserializer_thenCorrect()
            throws IOException {

        String json = "{ \"name\": \"party\", \"eventDate\": \"20-12-2014 02:30:00\"}";
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        ObjectMapper mapper = new ObjectMapper();
        Event event = mapper.readerFor(Event.class).readValue((json));
        assertEquals("20-12-2014 02:30:00", df.format(event.eventDate));
    }
}