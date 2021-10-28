package com.sunxu.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * @author 孙许
 * @version 1.0
 * @date 2020/8/5 18:10
 */
public class JoinerTest {

    private static List<String> stringList = Lists.newArrayList("Google", "Guava", "Java", "Scala", "Kafka");
    private static List<String> stringWithNullList = Lists.newArrayList("Google", "Guava", "Java", null, "Kafka");

    public static void main(String[] args) {
        String join = Joiner.on("#").join(stringList);
        String join2 = String.join("#", stringList);
        System.out.println(join);
        System.out.println(join2);
        String join3 = String.join("#", stringWithNullList);
        System.out.println(join3);
        // 过滤null
        String join4 = Joiner.on("#").skipNulls().join(stringWithNullList);
        System.out.println(join4);
        // 替换null
        String join5 = Joiner.on("#").useForNull("Sunxu").join(stringWithNullList);
        System.out.println(join5);
        StringBuilder str = new StringBuilder("sun");
        String join6 = Joiner.on("#").skipNulls().appendTo(str, stringWithNullList).toString();
        System.out.println(join6);

        Map<String, String> map = ImmutableMap.of("Hello", "world", "Google", "guava");
        System.out.println(map);
        String join7 = Joiner.on("#").withKeyValueSeparator("=").join(map);
        System.out.println(join7);
    }
}
