package org.elm;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesFile {
    public static Properties properties;

    private static String configFile="C:/Users/DELL/Downloads/automationProject/WEBELM/src/main/resources/config.properties";
        public static void initalizePropertyFile(){

             properties=new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream(configFile);
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

