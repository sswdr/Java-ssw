package com.ssw.test.markdown;

import cn.hutool.json.JSONUtil;

import java.util.*;

/**
 * @author ssw
 * @date 2023/9/4 14:09
 */
public class MarkdownTableParser {
    public static void main(String[] args) {
        // 定义Markdown样例
        String markdown = "" +
                "| Name     | Age | Gender |\n" +
                "|----------|-----|--------|\n" +
                "| John     | 25  | Male   |\n" +
                "| Jane     | 30  | Female |\n" +
                "| Michael  | 35  | Male   |";
        List<Map<String, String>> res = convertMarkdownToList(markdown);
        System.out.println(res);
        System.out.println(JSONUtil.parseArray(res));
    }

    public static List<Map<String, String>> convertMarkdownToList(String markdown) {
        List<Map<String, String>> list = new ArrayList<>();
        // 按行拆分Markdown内容
        String[] lines = markdown.split("\n");
        // 获取表头
        String[] headers = getArray(lines[0], "\\|");
        // 遍历每一行数据
        for (int i = 2; i < lines.length; i++) {
            String[] values = getArray(lines[i], "\\|");
            Map<String, String> line = new LinkedHashMap<>();
            for (int j = 0; j < headers.length; j++) {
                line.put(headers[j].trim(), values[j].trim());
            }
            list.add(line);
        }
        return list;
    }

    public static String[] getArray(String line, String regex) {
        return Arrays.stream(Optional.ofNullable(line).orElse("").trim().split(regex))
                .filter(x -> null != x && !"".equals(x))
                .map(String::trim)
                .toArray(String[]::new);
    }
}