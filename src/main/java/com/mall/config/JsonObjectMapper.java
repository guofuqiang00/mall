package com.mall.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * @description: 转换null对象为空字符串
 */
@Component("jsonObjectMapper")
public class JsonObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;
    public JsonObjectMapper() {
        super();
        // 空值处理为空串
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
                if(value instanceof String || value instanceof StringBuffer || value instanceof StringBuilder || value instanceof Number){
                    jg.writeString("");
                }else{
                    jg.writeNull();
                }
            }
        });
        setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        /**
         * 数值转string
         */

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        simpleModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);

        registerModule(simpleModule);
    }
}
