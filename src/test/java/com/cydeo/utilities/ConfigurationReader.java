package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
        /*
    in this class , we will be creating the re-usable logic to read from
    configuration.properties file
     */


    //1- Creat the Properties object(creat object)
    //private so we are limiting accese to the object
    //static is to makesure its created and loaded before everythoing else
    private static Properties properties = new Properties();

    static {

        try {
            //2- Open file using FileInputStream(open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3 Load the "properties" object with "file" (load properties)
            properties.load(file);
            //close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }

    }

    //creat the utitlity method to used the object to read

    //4- Use "Properties " object to read from the file(read properties)
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
