package com.example.demo.core;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class UidSerializer extends StdSerializer<Uid> {

	private static final long serialVersionUID = 1L;

	public UidSerializer() {
		this(null);
	}

	public UidSerializer(Class<Uid> t) {
		super(t);
	}

	@Override
	public void serialize(Uid value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeString(value.toString());
	}

	@Override
	public Class<Uid> handledType() {
		return Uid.class;
	}
}