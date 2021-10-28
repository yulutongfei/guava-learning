package com.sunxu.collections.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙许
 * @version 1.0
 * @date 2020/8/5 17:23
 */
public class Demo1 {

    public static void main(String[] args) {
        List<String> list1 = Lists.newArrayList();
        List<String> theseElements = Lists.newArrayList("alpha", "beta", "gamma");
        ArrayList<String> list2  = Lists.newArrayListWithCapacity(10);
        List<List<String>> partition = Lists.partition(theseElements, 1);
        System.out.println(partition);
    }
}
