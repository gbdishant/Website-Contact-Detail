package com.site.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.domain.CountryCallingCode;
import lombok.extern.log4j.Log4j2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
public class Common {
    public static Map<String, String> countyNumberLengthMap = new HashMap<>();
    public static Map<String, CountryCallingCode> countryDialCodeMap;

    static {
        countyNumberLengthMap.put("1", "10");
        countyNumberLengthMap.put("7", "10");
        countyNumberLengthMap.put("20", "10");
        countyNumberLengthMap.put("27", "9");
        countyNumberLengthMap.put("30", "10");
        countyNumberLengthMap.put("31", "8");
        countyNumberLengthMap.put("32", "9");
        countyNumberLengthMap.put("33", "9");
        countyNumberLengthMap.put("34", "9");
        countyNumberLengthMap.put("36", "9");
        countyNumberLengthMap.put("39", "10");
        countyNumberLengthMap.put("40", "10");
        countyNumberLengthMap.put("41", "9");
        countyNumberLengthMap.put("43", "10");
        countyNumberLengthMap.put("44", "10");
        countyNumberLengthMap.put("45", "8");
        countyNumberLengthMap.put("46", "7");
        countyNumberLengthMap.put("47", "8");
        countyNumberLengthMap.put("48", "9");
        countyNumberLengthMap.put("49", "10");
        countyNumberLengthMap.put("51", "9");
        countyNumberLengthMap.put("52", "10");
        countyNumberLengthMap.put("54", "10");
        countyNumberLengthMap.put("55", "11");
        countyNumberLengthMap.put("56", "9");
        countyNumberLengthMap.put("57", "10");
        countyNumberLengthMap.put("58", "7");
        countyNumberLengthMap.put("60", "7");
        countyNumberLengthMap.put("61", "9");
        countyNumberLengthMap.put("62", "9");
        countyNumberLengthMap.put("63", "10");
        countyNumberLengthMap.put("65", "8");
        countyNumberLengthMap.put("66", "9");
        countyNumberLengthMap.put("81", "10");
        countyNumberLengthMap.put("82", "10");
        countyNumberLengthMap.put("84", "9");
        countyNumberLengthMap.put("86", "11");
        countyNumberLengthMap.put("90", "7");
        countyNumberLengthMap.put("91", "10");
        countyNumberLengthMap.put("92", "10");
        countyNumberLengthMap.put("93", "9");
        countyNumberLengthMap.put("94", "7");
        countyNumberLengthMap.put("95", "8");
        countyNumberLengthMap.put("213", "9");
        countyNumberLengthMap.put("216", "8");
        countyNumberLengthMap.put("218", "10");
        countyNumberLengthMap.put("226", "8");
        countyNumberLengthMap.put("227", "8");
        countyNumberLengthMap.put("228", "8");
        countyNumberLengthMap.put("229", "6");
        countyNumberLengthMap.put("230", "8");
        countyNumberLengthMap.put("231", "7");
        countyNumberLengthMap.put("233", "9");
        countyNumberLengthMap.put("234", "8");
        countyNumberLengthMap.put("235", "8");
        countyNumberLengthMap.put("237", "9");
        countyNumberLengthMap.put("241", "7");
        countyNumberLengthMap.put("246", "7");
        countyNumberLengthMap.put("252", "7");
        countyNumberLengthMap.put("254", "10");
        countyNumberLengthMap.put("255", "6");
        countyNumberLengthMap.put("258", "12");
        countyNumberLengthMap.put("260", "9");
        countyNumberLengthMap.put("262", "9");
        countyNumberLengthMap.put("263", "9");
        countyNumberLengthMap.put("268", "8");
        countyNumberLengthMap.put("290", "4");
        countyNumberLengthMap.put("297", "7");
        countyNumberLengthMap.put("298", "5");
        countyNumberLengthMap.put("299", "6");
        countyNumberLengthMap.put("351", "9");
        countyNumberLengthMap.put("352", "9");
        countyNumberLengthMap.put("353", "9");
        countyNumberLengthMap.put("356", "8");
        countyNumberLengthMap.put("357", "8");
        countyNumberLengthMap.put("358", "8");
        countyNumberLengthMap.put("370", "8");
        countyNumberLengthMap.put("371", "8");
        countyNumberLengthMap.put("372", "8");
        countyNumberLengthMap.put("373", "8");
        countyNumberLengthMap.put("374", "8");
        countyNumberLengthMap.put("375", "9");
        countyNumberLengthMap.put("377", "8");
        countyNumberLengthMap.put("380", "9");
        countyNumberLengthMap.put("381", "9");
        countyNumberLengthMap.put("382", "8");
        countyNumberLengthMap.put("383", "8");
        countyNumberLengthMap.put("385", "9");
        countyNumberLengthMap.put("387", "8");
        countyNumberLengthMap.put("389", "8");
        countyNumberLengthMap.put("420", "9");
        countyNumberLengthMap.put("421", "9");
        countyNumberLengthMap.put("500", "5");
        countyNumberLengthMap.put("501", "7");
        countyNumberLengthMap.put("502", "8");
        countyNumberLengthMap.put("503", "8");
        countyNumberLengthMap.put("504", "8");
        countyNumberLengthMap.put("505", "8");
        countyNumberLengthMap.put("506", "8");
        countyNumberLengthMap.put("507", "8");
        countyNumberLengthMap.put("590", "9");
        countyNumberLengthMap.put("594", "9");
        countyNumberLengthMap.put("595", "9");
        countyNumberLengthMap.put("596", "9");
        countyNumberLengthMap.put("598", "8");
        countyNumberLengthMap.put("670", "8");
        countyNumberLengthMap.put("672", "6");
        countyNumberLengthMap.put("675", "8");
        countyNumberLengthMap.put("677", "7");
        countyNumberLengthMap.put("680", "7");
        countyNumberLengthMap.put("682", "5");
        countyNumberLengthMap.put("683", "4");
        countyNumberLengthMap.put("685", "5");
        countyNumberLengthMap.put("686", "8");
        countyNumberLengthMap.put("687", "6");
        countyNumberLengthMap.put("689", "6");
        countyNumberLengthMap.put("691", "7");
        countyNumberLengthMap.put("692", "7");
        countyNumberLengthMap.put("852", "8");
        countyNumberLengthMap.put("855", "9");
        countyNumberLengthMap.put("880", "10");
        countyNumberLengthMap.put("886", "9");
        countyNumberLengthMap.put("960", "7");
        countyNumberLengthMap.put("961", "8");
        countyNumberLengthMap.put("962", "9");
        countyNumberLengthMap.put("963", "9");
        countyNumberLengthMap.put("964", "10");
        countyNumberLengthMap.put("965", "8");
        countyNumberLengthMap.put("966", "9");
        countyNumberLengthMap.put("967", "9");
        countyNumberLengthMap.put("968", "8");
        countyNumberLengthMap.put("970", "9");
        countyNumberLengthMap.put("971", "9");
        countyNumberLengthMap.put("972", "9");
        countyNumberLengthMap.put("973", "8");
        countyNumberLengthMap.put("974", "8");
        countyNumberLengthMap.put("976", "8");
        countyNumberLengthMap.put("977", "10");
        countyNumberLengthMap.put("994", "9");
        countyNumberLengthMap.put("995", "9");
        countyNumberLengthMap.put("996", "9");

        try {
            byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/json file/CountryCallingCode.json"));

            ObjectMapper objectMapper = new ObjectMapper();
            List<CountryCallingCode> countryCallingCodes = objectMapper.readValue(bytes, new TypeReference<>() {
            });

            countryDialCodeMap = countryCallingCodes.stream()
                    .parallel()
                    .collect(Collectors.toMap(CountryCallingCode::getCode, Function.identity()));
        } catch (Exception exception) {
            log.error("Exception while parse CountryCallingCode.json. Error message: {}", exception.getMessage(), exception);
        }
    }
}