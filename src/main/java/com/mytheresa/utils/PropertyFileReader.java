package com.mytheresa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileReader {

    static Properties properties=new Properties();
    static Map<Object,Object> PROPERTIES =new HashMap<>();

    static {

        try(FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/config.properties")){
            properties.load(fileInputStream);
            for( Map.Entry<Object,Object> property: properties.entrySet()){
                String key= String.valueOf(property.getKey());
                String value= String.valueOf(property.getValue());
                PROPERTIES.put(key,value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return properties.getProperty(key);
    }

}
