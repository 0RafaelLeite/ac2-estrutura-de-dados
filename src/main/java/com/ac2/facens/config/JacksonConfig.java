package com.ac2.facens.config;

import com.ac2.facens.utils.list.ListaSE;
import com.ac2.facens.utils.list.ListaSESerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public SimpleModule customSerializerModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(ListaSE.class, new ListaSESerializer());
        return module;
    }
}
