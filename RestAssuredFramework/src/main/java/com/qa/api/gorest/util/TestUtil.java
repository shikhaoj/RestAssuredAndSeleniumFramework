package com.qa.api.gorest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
    /**
     * THis method is used to convert POJO Object to a JSON STRING... which is called serialization
     * @param obj
     * @return jsonString
     */
    public static String getSerialization(Object obj){
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonString=null;
        try {
            jsonString=objectMapper.writeValueAsString(obj);
            System.out.println("JSON BODY PAYLOAD ===> "+jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
