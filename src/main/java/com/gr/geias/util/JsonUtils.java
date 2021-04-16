package com.gr.geias.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {

    public static void updataJson(String key, String value){
        String path = "src/main/python/config_tmp.json";
        JSONObject main = new JSONObject();

        JSONParser jsonParser = new JSONParser();

        try
        {
            Object obj = jsonParser.parse(new FileReader(path));

            JSONObject jsonObject = (JSONObject) obj;
//            jsonObject.put("since_date", "2018-01-01");
            jsonObject.put(key, value);
            FileWriter file = new FileWriter("src/main/python/config.json");
            file.write(jsonObject.toString());
            file.flush();
            file.close();
            System.out.println(jsonObject.toString());
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        JsonUtils.updataJson("since_date", "2018-01-01");
    }

}