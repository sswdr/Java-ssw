package com.ssw.test.debug;

import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ssw
 * @date 2023/8/2 18:27
 */
public class OfflineDebugging {
    public static void main(String[] args) throws Exception {
        write();
        read();
    }

    public static void write() throws Exception {
        // 模拟获取离线数据
        List<MyObject> objects = getObjects();
        String objectJson = JSONUtil.toJsonStr(objects);
        System.out.println(objectJson + "\n");

        FileWriter fileWriter = new FileWriter("C:\\Users\\Administrator\\Desktop\\file.json", false);
        fileWriter.write(objectJson);
        fileWriter.flush();
        fileWriter.close();
    }


    public static void read() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\file.json";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            Gson gson = new Gson();
            List<MyObject> myObjects = gson.fromJson(jsonString.toString(), new TypeToken<List<MyObject>>() {
            }.getType());

            System.out.println(myObjects);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<MyObject> getObjects() {
        List<MyObject> objects = new ArrayList<>();

        objects.add(new MyObject("1", "Object 1"));
        objects.add(new MyObject("2", "Object 2"));
        objects.add(new MyObject("3", "Object 3"));
        objects.add(new MyObject("4", "Object 4"));
        objects.add(new MyObject("5", "Object 5"));
        objects.add(new MyObject("6", "Object 6"));
        objects.add(new MyObject("7", "Object 7"));

        return objects;
    }

    @Data
    @ToString
    public static class MyObject {
        private String id;
        private String name;

        public MyObject(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
