package com.maven.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolutionTest{
    /**
     * Example:
     * assert min_by_key("a", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 1, "b": 2}
     * assert min_by_key("a", [{"a": 2}, {"a": 1, "b": 2}]) == {"a": 1, "b": 2}
     * assert min_by_key("b", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 2}
     * assert min_by_key("a", [{}]) == {}
     * assert min_by_key("b", [{"a": -1}, {"b": -1}]) == {"b": -1}
     **/
    private List<Map<String, Integer>> list;
    private Map<String, Integer> map1;
    private Map<String, Integer> map2;
    private MySolution solution;

    @Before
    public void before(){
        map1 = new HashMap<String, Integer>();
        map2 = new HashMap<String, Integer>();
        list = new ArrayList<Map<String, Integer>>();
        solution = new MySolution();
        list.add(map1);
        list.add(map2);
    }

    @Test
    public void testMySolution() {
        MySolution solution = new MySolution();
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        ((HashMap<String, Integer>) map1).put("a", 1);
        ((HashMap<String, Integer>) map1).put("b", 2);
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        ((HashMap<String, Integer>) map2).put("a", 2);
        List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
        ((ArrayList<Map<String, Integer>>) list).add(map1);
        ((ArrayList<Map<String, Integer>>) list).add(map2);
        Map<String, Integer> result = solution.minByKey("a", list);

        Assert.assertEquals(map1, result);
    }

    @Test
    public void testMySolution1(){
        map1.put("a",2);
        map2.put("a",1);
        map2.put("a",2);
        Map<String, Integer> result = solution.minByKey("a", list);
        Assert.assertEquals(map2, result);
    }

    @Test
    public void testMySolution2(){
        map1.put("a",1);
        map1.put("b",2);
        map2.put("a",1);
        Map<String, Integer> result = solution.minByKey("b", list);
        Assert.assertEquals(map2, result);
    }

    @Test
    public void testMySolution3(){
        map1.put("a",1);
        map1.put("b",2);
        map2.put("a",1);
        List<Map<String, Integer>> newList = new ArrayList<Map<String, Integer>>();
        newList.add(new HashMap<String, Integer>());
        Map<String, Integer> result = solution.minByKey("a", newList);
        Assert.assertEquals(new HashMap<String,Integer>().size(), result.size());
    }

    @Test
    public void testMySolution4(){
        map1.put("a",-1);
        map2.put("b",-1);
        Map<String, Integer> result = solution.minByKey("b", list);
        Assert.assertEquals(map2, result);
    }

    @After
    public void after(){
        map1.clear();
        map2.clear();
    }
}
