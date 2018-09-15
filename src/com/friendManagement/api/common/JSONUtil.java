package com.friendManagement.api.common;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JSONUtil {

    public static String ObjToStr(Object requestObj) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
                .setSerializationInclusion(Include.NON_NULL)
                .setVisibilityChecker(
                        mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                                .withGetterVisibility(JsonAutoDetect.Visibility.NONE).withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));

        String jsonStr = mapper.writeValueAsString(requestObj);
        return jsonStr;
    }

}
