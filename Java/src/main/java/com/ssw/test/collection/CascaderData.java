package com.ssw.test.collection;

import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ssw
 * @date 2023/8/2 16:00
 */
public class CascaderData {
    public static void main(String[] args) throws Exception {
        // 模拟从后端获取对象列表的逻辑
        List<MyObject> objects = getObjectsFromBackend();
        System.out.println(JSONUtil.toJsonStr(objects) + "\n");

        // 分组成map的数据
        Map<String, Map<String, List<MyObject>>> groupedObjects = groupObjectsByProperty(objects);
        System.out.println(JSONUtil.toJsonStr(groupedObjects) + "\n");
        // {
        //    "Group B": {
        //        "Subgroup W": [
        //            {
        //                "id": "2",
        //                "property": "Group B",
        //                "subgroup": "Subgroup W",
        //                "name": "Object 6"
        //            }
        //        ],
        //        "Subgroup Z": [
        //            {
        //                "id": "2",
        //                "property": "Group B",
        //                "subgroup": "Subgroup Z",
        //                "name": "Object 4"
        //            },
        //            {
        //                "id": "2",
        //                "property": "Group B",
        //                "subgroup": "Subgroup Z",
        //                "name": "Object 5"
        //            }
        //        ]
        //    },
        //    "Group A": {
        //        "Subgroup X": [
        //            {
        //                "id": "1",
        //                "property": "Group A",
        //                "subgroup": "Subgroup X",
        //                "name": "Object 1"
        //            },
        //            {
        //                "id": "1",
        //                "property": "Group A",
        //                "subgroup": "Subgroup X",
        //                "name": "Object 2"
        //            }
        //        ],
        //        "Subgroup Y": [
        //            {
        //                "id": "1",
        //                "property": "Group A",
        //                "subgroup": "Subgroup Y",
        //                "name": "Object 3"
        //            }
        //        ]
        //    },
        //    "Group C": {
        //        "Subgroup X": [
        //            {
        //                "id": "3",
        //                "property": "Group C",
        //                "subgroup": "Subgroup X",
        //                "name": "Object 7"
        //            }
        //        ]
        //    }
        //}

        // vue级联组件Cascader数据
        List<Map<String, Object>> cascaderData = convertToCascaderData(groupedObjects);
        System.out.println(JSONUtil.toJsonStr(cascaderData) + "\n");
        //[
        //    {
        //        "children": [
        //            {
        //                "children": [
        //                    {
        //                        "label": "Object 6",
        //                        "value": "2"
        //                    }
        //                ],
        //                "label": "Subgroup W",
        //                "value": "Subgroup W"
        //            },
        //            {
        //                "children": [
        //                    {
        //                        "label": "Object 4",
        //                        "value": "2"
        //                    },
        //                    {
        //                        "label": "Object 5",
        //                        "value": "2"
        //                    }
        //                ],
        //                "label": "Subgroup Z",
        //                "value": "Subgroup Z"
        //            }
        //        ],
        //        "label": "Group B",
        //        "value": "Group B"
        //    },
        //    {
        //        "children": [
        //            {
        //                "children": [
        //                    {
        //                        "label": "Object 1",
        //                        "value": "1"
        //                    },
        //                    {
        //                        "label": "Object 2",
        //                        "value": "1"
        //                    }
        //                ],
        //                "label": "Subgroup X",
        //                "value": "Subgroup X"
        //            },
        //            {
        //                "children": [
        //                    {
        //                        "label": "Object 3",
        //                        "value": "1"
        //                    }
        //                ],
        //                "label": "Subgroup Y",
        //                "value": "Subgroup Y"
        //            }
        //        ],
        //        "label": "Group A",
        //        "value": "Group A"
        //    },
        //    {
        //        "children": [
        //            {
        //                "children": [
        //                    {
        //                        "label": "Object 7",
        //                        "value": "3"
        //                    }
        //                ],
        //                "label": "Subgroup X",
        //                "value": "Subgroup X"
        //            }
        //        ],
        //        "label": "Group C",
        //        "value": "Group C"
        //    }
        //]
    }


    static List<MyObject> getObjectsFromBackend() {
        List<MyObject> objects = new ArrayList<>();

        objects.add(new MyObject("1", "Group A", "Subgroup X", "Object 1"));
        objects.add(new MyObject("1", "Group A", "Subgroup X", "Object 2"));
        objects.add(new MyObject("1", "Group A", "Subgroup Y", "Object 3"));
        objects.add(new MyObject("2", "Group B", "Subgroup Z", "Object 4"));
        objects.add(new MyObject("2", "Group B", "Subgroup Z", "Object 5"));
        objects.add(new MyObject("2", "Group B", "Subgroup W", "Object 6"));
        objects.add(new MyObject("3", "Group C", "Subgroup X", "Object 7"));

        return objects;
    }

    static Map<String, Map<String, List<MyObject>>> groupObjectsByProperty(List<MyObject> objects) {
        return objects.stream()
                .collect(Collectors.groupingBy(MyObject::getProperty,
                        Collectors.groupingBy(MyObject::getSubgroup)));
    }

    static List<Map<String, Object>> convertToCascaderData(Map<String, Map<String, List<MyObject>>> groupedObjects) {
        List<Map<String, Object>> cascaderData = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<MyObject>>> groupEntry : groupedObjects.entrySet()) {
            String group = groupEntry.getKey();
            Map<String, List<MyObject>> subgroups = groupEntry.getValue();

            Map<String, Object> groupItem = new HashMap<>();
            groupItem.put("value", group);
            groupItem.put("label", group);

            List<Map<String, Object>> subgroupItems = new ArrayList<>();

            for (Map.Entry<String, List<MyObject>> subgroupEntry : subgroups.entrySet()) {
                String subgroup = subgroupEntry.getKey();
                List<MyObject> objects = subgroupEntry.getValue();

                Map<String, Object> subgroupItem = new HashMap<>();
                subgroupItem.put("value", subgroup);
                subgroupItem.put("label", subgroup);

                List<Map<String, Object>> objectItems = objects.stream()
                        .map(obj -> {
                            Map<String, Object> item = new HashMap<>();
                            item.put("value", obj.getId());
                            item.put("label", obj.getName());
                            return item;
                        })
                        .collect(Collectors.toList());

                subgroupItem.put("children", objectItems);
                subgroupItems.add(subgroupItem);
            }

            groupItem.put("children", subgroupItems);
            cascaderData.add(groupItem);
        }

        return cascaderData;
    }

    @Data
    static class MyObject {
        private String id;
        private String property;
        private String subgroup;
        private String name;

        public MyObject(String id, String property, String subgroup, String name) {
            this.id = id;
            this.property = property;
            this.subgroup = subgroup;
            this.name = name;
        }
    }
}
