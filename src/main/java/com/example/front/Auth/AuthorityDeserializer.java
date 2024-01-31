package com.example.front.Auth;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;

public class AuthorityDeserializer extends JsonDeserializer<SimpleGrantedAuthority> {

    @Override
    public SimpleGrantedAuthority deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectNode node = jp.getCodec().readTree(jp);
        String authority = node.get("authority").asText(); // Zakładając, że pola 'authority' zawiera nazwę uprawnienia
        return new SimpleGrantedAuthority(authority);
    }
}

