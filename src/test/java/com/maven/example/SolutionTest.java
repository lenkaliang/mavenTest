package com.maven.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * If you uncomment the below commented code, you will find following compile errors:
 * 1. Test annotation class not found
 * 2. minByKey is not found because you need to plug in the class where you implemented the minByKey method
 *
 * The task is to fix all these error and make a green test
 */
public class SolutionTest {

  @Test
  public void testMinByKey() {
    List<Map<String, Integer>> example1 = Arrays.asList(
        Maps.of("a", 1, "b", 2),
        Maps.of("a", 2)
    );
    List<Map<String, Integer>> example2 = Arrays.asList(example1.get(1), example1.get(0));
    List<Map<String, Integer>> example3 = Arrays.asList((Map<String,Integer>)new HashMap<String, Integer>());
    List<Map<String, Integer>> example4 = Arrays.asList(
        Maps.of("a", -1),
        Maps.of("b", -1)
    );

    MySolution s = new MySolution();
    System.out.println("minByKey");
    assertEqual(example1.get(0), s.minByKey("a", example1));
    assertEqual(example2.get(1), s.minByKey("a", example2));
    assertEqual(example1.get(1), s.minByKey("b", example1));
    assertEqual(example3.get(0), (s.minByKey("a", example3)));
    assertEqual(example4.get(1), s.minByKey("b", example4));
  }

  public static <T> void assertEqual(T expected, T actual) {
    if (expected == null && actual == null || actual != null && actual.equals(expected)) {
      System.out.println("PASSED");
    } else {
      throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
    }
  }
}
