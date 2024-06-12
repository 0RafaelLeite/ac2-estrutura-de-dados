package com.ac2.facens.utils.list;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ListaSESerializer extends StdSerializer<ListaSE> {

    public ListaSESerializer() {
        this(null);
    }

    protected ListaSESerializer(Class<ListaSE> t) {
        super(t);
    }

    @Override
    public void serialize(ListaSE lista, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        Node current = lista.head;
        while (current != null) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", current.value);
            jsonGenerator.writeStringField("name", current.subject);
            jsonGenerator.writeEndObject();
            current = current.next;
        }
        jsonGenerator.writeEndArray();
    }
}
