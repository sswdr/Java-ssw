package com.ssw.test.gson;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.util.List;

/**
 * @Author: ssw
 * @DateTime: 2022/1/19 22:33
 * @Description: TODO
 */
public class test01 {

//    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
//        @SuppressWarnings("unchecked")
//        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
//        return ts;
//    }

    public static void main(String[] args) {

        String inPutString0 =
                "{\n" +
                "    \"abc\":\"123\",\n" +
                "    \"def\":\"456\"\n" +
                "}";
        String inPutString ="["+inPutString0+"]";
        System.out.println("inPutString:   "+inPutString+"\n");

        JSONArray jsonArray = new JSONArray(inPutString);
        System.out.println("jsonArray:  "+jsonArray.toString()+"\n");

        System.out.println("jsonArray.get(0):  "+jsonArray.get(0)+"\n");

        List<String> ts = jsonArray.toList(String.class);
        System.out.println(ts.get(0)+"\n");

        JSON json = new JSONObject(inPutString0);

        Object abc1 = ((JSONObject) json).getObj("abc");
        System.out.println(abc1+"\n");

        Object abc2 = ((JSONObject) json).get("abc");
        System.out.println(abc2+"\n");

    }
}
