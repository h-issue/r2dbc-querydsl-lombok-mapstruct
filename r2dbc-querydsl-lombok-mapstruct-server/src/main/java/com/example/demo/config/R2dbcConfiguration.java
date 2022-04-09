package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.H2Dialect;

import com.example.demo.core.Uid;
import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLTemplates;

@Configuration
public class R2dbcConfiguration {

	@Bean
	public R2dbcCustomConversions customConversions() {
		List<Converter<?, ?>> converters = new ArrayList<>();
		converters.add(new UidReadConverter());
		converters.add(new UidWriteConverter());
		return R2dbcCustomConversions.of(H2Dialect.INSTANCE, converters);
	}

	@ReadingConverter
	static class UidReadConverter implements Converter<String, Uid> {
		@Override
		public Uid convert(String id) {
			return Uid.of(id);
		}
	}

	@WritingConverter
	static class UidWriteConverter implements Converter<Uid, String> {
		@Override
		public String convert(Uid uid) {
			return uid.toString();
		}
	}

	@Bean
	public SQLTemplates sqlTemplates() {
		return H2Templates.DEFAULT;
	}

}
