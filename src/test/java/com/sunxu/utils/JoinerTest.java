package com.sunxu.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 孙许
 * @version 1.0
 * @date 2020/8/6 08:12
 */
public class JoinerTest {

    private final List<String> stringList = Lists.newArrayList("Google", "Guava", "Java", "Scala", "Kafka");
    private final List<String> stringWithNullList = Lists.newArrayList("Google", "Guava", "Java", null, "Kafka");
    private final List<String> stringNullList = null;

    @Test
    public void simple() {
        String join = Joiner.on("#").join(stringList);
        Assert.assertEquals("Google#Guava#Java#Scala#Kafka", join);
    }

    @Test
    public void simpleNull() {
        String join = Joiner.on("#").join(stringNullList);
        System.out.println(join);
    }

    @Test
    public void skipNull() {
        String join = Joiner.on("#").skipNulls().join(stringWithNullList);
        Assert.assertEquals("Google#Guava#Java#Kafka", join);
    }

    @Test
    public void replaceJoin() {
        String join = Joiner.on("#").useForNull("Sunxu").join(stringWithNullList);
        Assert.assertEquals("Google#Guava#Java#Sunxu#Kafka", join);
    }

    @Test
    public void stringBuilderJoin() {
        StringBuilder str = new StringBuilder("sun");
        String join = Joiner.on("#").skipNulls().appendTo(str, stringWithNullList).toString();
        Assert.assertEquals("sunGoogle#Guava#Java#Kafka", join);
    }

    @Test
    public void mapJoin() {
        Map<String, String> map = ImmutableMap.of("Hello", "world", "Google", "guava");
        String join = Joiner.on("#").withKeyValueSeparator("=").join(map);
        Assert.assertEquals("Hello=world#Google=guava", join);
    }
}