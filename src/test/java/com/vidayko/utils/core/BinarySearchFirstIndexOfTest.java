/*
 * Copyright (c) 2025 Roman Vidayko
 * www.linkedin.com/in/roman-vidayko
 */

package com.vidayko.utils.core;

import static com.vidayko.utils.core.BinarySearch.firstIndexOf;
import static com.vidayko.utils.core.JsonLoader.loadTestcases;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.math.*;
import java.util.*;
import java.util.stream.*;
import lombok.Data;
import org.junit.jupiter.api.*;

class BinarySearchFirstIndexOfTest {

  @Test
  public void firstIndexOfByte_test() throws IOException {

    final List<ByteTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ByteTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (ByteTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (IntStream.range(0, testCase.array.length).mapToObj(i -> testCase.array[i])
          .anyMatch(o -> o == testCase.key)) {
        Assertions.assertEquals(testCase.expected,
            IntStream.range(0, testCase.array.length).mapToObj(i -> testCase.array[i])
                .collect(Collectors.toList()).indexOf(
                    testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class ByteTestCase {

    String scenario;
    byte key;
    byte[] array;
    int expected;
  }

  @Test
  public void firstIndexOfByteWithComparator_test() throws IOException {
    final List<ByteWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ByteWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ByteWithComparatorTestCase testCase : testcases) {
      final Comparator<Byte> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class ByteWithComparatorTestCase {

    String scenario;
    byte key;
    byte[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfShort_test() throws IOException {

    final List<ShortTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ShortTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (ShortTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (IntStream.range(0, testCase.array.length).mapToObj(i -> testCase.array[i])
          .anyMatch(o -> o == testCase.key)) {
        Assertions.assertEquals(testCase.expected,
            IntStream.range(0, testCase.array.length).mapToObj(i -> testCase.array[i])
                .collect(Collectors.toList()).indexOf(
                    testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class ShortTestCase {

    String scenario;
    short key;
    short[] array;
    int expected;
  }

  @Test
  public void firstIndexOfShortWithComparator_test() throws IOException {
    final List<ShortWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ShortWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ShortWithComparatorTestCase testCase : testcases) {
      final Comparator<Short> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class ShortWithComparatorTestCase {

    String scenario;
    short key;
    short[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfInt_test() throws IOException {

    final List<IntTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (IntTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (Arrays.stream(testCase.array).anyMatch(o -> o == testCase.key)) {
        Assertions.assertEquals(testCase.expected,
            Arrays.stream(testCase.array).boxed().collect(Collectors.toList()).indexOf(
                testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class IntTestCase {

    String scenario;
    int key;
    int[] array;
    int expected;
  }

  @Test
  public void firstIndexOfIntWithComparator_test() throws IOException {
    final List<IntWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (IntWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class IntWithComparatorTestCase {

    String scenario;
    int key;
    int[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfLong_test() throws IOException {

    final List<LongTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<LongTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (LongTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (Arrays.stream(testCase.array).boxed()
          .anyMatch(o -> o == testCase.key)) {
        Assertions.assertEquals(testCase.expected,
            Arrays.stream(testCase.array).boxed()
                .collect(Collectors.toList()).indexOf(
                    testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class LongTestCase {

    String scenario;
    long key;
    long[] array;
    int expected;
  }

  @Test
  public void firstIndexOfLongWithComparator_test() throws IOException {
    final List<LongWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<LongWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (LongWithComparatorTestCase testCase : testcases) {
      final Comparator<Long> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class LongWithComparatorTestCase {

    String scenario;
    long key;
    long[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfChar_test() throws IOException {

    final List<CharTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<CharTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/CharTestCases.json"
    );

    for (CharTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (IntStream.range(0, testCase.array.length).mapToObj(i -> testCase.array[i])
          .anyMatch(o -> o == testCase.key)) {
        Assertions.assertEquals(testCase.expected,
            IntStream.range(0, testCase.array.length).mapToObj(i -> testCase.array[i])
                .collect(Collectors.toList()).indexOf(
                    testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class CharTestCase {

    String scenario;
    char key;
    char[] array;
    int expected;
  }

  @Test
  public void firstIndexOfCharWithComparator_test() throws IOException {
    final List<CharWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<CharWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/CharWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/CharWithComparatorReverseTestCases.json"
    );

    for (CharWithComparatorTestCase testCase : testcases) {
      final Comparator<Character> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class CharWithComparatorTestCase {

    String scenario;
    char key;
    char[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfFloat_test() throws IOException {

    final List<FloatTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<FloatTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (FloatTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (IntStream.range(0, testCase.array.length).mapToObj(i -> testCase.array[i])
          .anyMatch(o -> o == testCase.key)) {
        Assertions.assertEquals(testCase.expected,
            IntStream.range(0, testCase.array.length).mapToObj(i -> testCase.array[i])
                .collect(Collectors.toList()).indexOf(
                    testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class FloatTestCase {

    String scenario;
    float key;
    float[] array;
    int expected;
  }

  @Test
  public void firstIndexOfFloatWithComparator_test() throws IOException {
    final List<FloatWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<FloatWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (FloatWithComparatorTestCase testCase : testcases) {
      final Comparator<Float> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class FloatWithComparatorTestCase {

    String scenario;
    float key;
    float[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfDouble_test() throws IOException {

    final List<DoubleTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<DoubleTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (DoubleTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (Arrays.stream(testCase.array).boxed()
          .anyMatch(o -> o == testCase.key)) {
        Assertions.assertEquals(testCase.expected,
            Arrays.stream(testCase.array).boxed()
                .collect(Collectors.toList()).indexOf(
                    testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class DoubleTestCase {

    String scenario;
    double key;
    double[] array;
    int expected;
  }

  @Test
  public void firstIndexOfDoubleWithComparator_test() throws IOException {
    final List<DoubleWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<DoubleWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (DoubleWithComparatorTestCase testCase : testcases) {
      final Comparator<Double> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class DoubleWithComparatorTestCase {

    String scenario;
    double key;
    double[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfInteger_test() throws IOException {

    final List<IntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (IntegerTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (Arrays.stream(testCase.array).anyMatch(o -> o.equals(testCase.key))) {
        Assertions.assertEquals(testCase.expected,
            Arrays.stream(testCase.array).collect(Collectors.toList()).indexOf(
                testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class IntegerTestCase {

    String scenario;
    Integer key;
    Integer[] array;
    int expected;
  }

  @Test
  public void firstIndexOfIntegerWithComparator_test() throws IOException {
    final List<IntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (IntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class IntegerWithComparatorTestCase {

    String scenario;
    Integer key;
    Integer[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfBigInteger_test() throws IOException {

    final List<BigIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (BigIntegerTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (Arrays.stream(testCase.array).anyMatch(o -> o.equals(testCase.key))) {
        Assertions.assertEquals(testCase.expected,
            Arrays.stream(testCase.array).collect(Collectors.toList()).indexOf(
                testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class BigIntegerTestCase {

    String scenario;
    BigInteger key;
    BigInteger[] array;
    int expected;
  }

  @Test
  public void firstIndexOfBigIntegerWithComparator_test() throws IOException {
    final List<BigIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (BigIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<BigInteger> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class BigIntegerWithComparatorTestCase {

    String scenario;
    BigInteger key;
    BigInteger[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfBigDecimal_test() throws IOException {

    final List<BigDecimalTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigDecimalTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (BigDecimalTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (Arrays.stream(testCase.array).anyMatch(o -> o.equals(testCase.key))) {
        Assertions.assertEquals(testCase.expected,
            Arrays.stream(testCase.array).collect(Collectors.toList()).indexOf(
                testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class BigDecimalTestCase {

    String scenario;
    BigDecimal key;
    BigDecimal[] array;
    int expected;
  }

  @Test
  public void firstIndexOfBigDecimalWithComparator_test() throws IOException {
    final List<BigDecimalWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigDecimalWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (BigDecimalWithComparatorTestCase testCase : testcases) {
      final Comparator<BigDecimal> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class BigDecimalWithComparatorTestCase {

    String scenario;
    BigDecimal key;
    BigDecimal[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfString_test() throws IOException {

    final List<StringTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<StringTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringTestCases.json"
    );

    for (StringTestCase testCase : testcases) {
      Arrays.sort(testCase.array);

      if (Arrays.stream(testCase.array).anyMatch(o -> o.equals(testCase.key))) {
        Assertions.assertEquals(testCase.expected,
            Arrays.stream(testCase.array).collect(Collectors.toList()).indexOf(
                testCase.key));
      } else {
        Assertions.assertEquals(testCase.expected,
            Arrays.binarySearch(testCase.array, testCase.key));
      }

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class StringTestCase {

    String scenario;
    String key;
    String[] array;
    int expected;
  }

  @Test
  public void firstIndexOfStringWithComparator_test() throws IOException {
    final List<StringWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<StringWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringWithComparatorReverseTestCases.json"
    );

    for (StringWithComparatorTestCase testCase : testcases) {
      final Comparator<String> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class StringWithComparatorTestCase {

    String scenario;
    String key;
    String[] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfArrayWithComparator_test() throws IOException {
    final List<ArrayWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ArrayWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/ArrayWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/ArrayWithComparatorReverseTestCases.json"
    );

    for (ArrayWithComparatorTestCase testCase : testcases) {
      final Comparator<int[]> comparator = Comparator.comparing(a -> a[0]);

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array,
              testCase.reverseOrder ? comparator.reversed() : comparator)
      );
    }
  }

  @Data
  static class ArrayWithComparatorTestCase {

    String scenario;
    int[] key;
    int[][] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfListInteger_test() throws IOException {

    final List<ListIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (ListIntegerTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class ListIntegerTestCase {

    String scenario;
    Integer key;
    List<Integer> array;
    int expected;
  }

  @Test
  public void firstIndexOfListIntegerWithComparator_test() throws IOException {
    final List<ListIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class ListIntegerWithComparatorTestCase {

    String scenario;
    Integer key;
    List<Integer> array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfListBigInteger_test() throws IOException {

    final List<ListBigIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (ListBigIntegerTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class ListBigIntegerTestCase {

    String scenario;
    BigInteger key;
    List<BigInteger> array;
    int expected;
  }

  @Test
  public void firstIndexOfListBigIntegerWithComparator_test() throws IOException {
    final List<ListBigIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListBigIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<BigInteger> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class ListBigIntegerWithComparatorTestCase {

    String scenario;
    BigInteger key;
    List<BigInteger> array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfListBigDecimal_test() throws IOException {

    final List<ListBigDecimalTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigDecimalTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberTestCases.json"
    );

    for (ListBigDecimalTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class ListBigDecimalTestCase {

    String scenario;
    BigDecimal key;
    List<BigDecimal> array;
    int expected;
  }

  @Test
  public void firstIndexOfListBigDecimalWithComparator_test() throws IOException {
    final List<ListBigDecimalWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigDecimalWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListBigDecimalWithComparatorTestCase testCase : testcases) {
      final Comparator<BigDecimal> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class ListBigDecimalWithComparatorTestCase {

    String scenario;
    BigDecimal key;
    List<BigDecimal> array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfListString_test() throws IOException {

    final List<ListStringTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringTestCases.json"
    );

    for (ListStringTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array)
      );
    }
  }

  @Data
  static class ListStringTestCase {

    String scenario;
    String key;
    List<String> array;
    int expected;
  }

  @Test
  public void firstIndexOfListStringWithFunction_test() throws IOException {

    final List<ListStringWithFunctionTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringWithFunctionTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringTestCases.json"
    );

    for (ListStringWithFunctionTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key.charAt(0), testCase.array, (String s) -> s.charAt(0))
      );
    }
  }

  @Data
  static class ListStringWithFunctionTestCase {

    String scenario;
    String key;
    List<String> array;
    int expected;
  }

  @Test
  public void firstIndexOfListStringWithComparator_test() throws IOException {
    final List<ListStringWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringWithComparatorReverseTestCases.json"
    );

    for (ListStringWithComparatorTestCase testCase : testcases) {
      final Comparator<String> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array, comparator)
      );
    }
  }

  @Data
  static class ListStringWithComparatorTestCase {

    String scenario;
    String key;
    List<String> array;
    boolean reverseOrder;
    int expected;
  }


  @Test
  public void firstIndexOfListStringWithComparatorAndFunction_test() throws IOException {
    final List<ListStringWithComparatorAndFunctionTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringWithComparatorAndFunctionTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/StringWithComparatorReverseTestCases.json"
    );

    for (ListStringWithComparatorAndFunctionTestCase testCase : testcases) {
      final Comparator<Character> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key.charAt(0), testCase.array, comparator,
              (String s) -> s.charAt(0))
      );
    }
  }

  @Data
  static class ListStringWithComparatorAndFunctionTestCase {

    String scenario;
    String key;
    List<String> array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfListArrayWithFunction_test() throws IOException {
    final List<ListArrayWithFunctionTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListArrayWithFunctionTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/ArrayTestCases.json"
    );

    for (ListArrayWithFunctionTestCase testCase : testcases) {

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key[0], testCase.array, (int[] arr) -> arr[0])
      );
    }
  }

  @Data
  static class ListArrayWithFunctionTestCase {

    String scenario;
    int[] key;
    int[][] array;
    int expected;
  }

  @Test
  public void firstIndexOfListArrayWithComparator_test() throws IOException {
    final List<ListArrayWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListArrayWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/ArrayWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/ArrayWithComparatorReverseTestCases.json"
    );

    for (ListArrayWithComparatorTestCase testCase : testcases) {
      final Comparator<int[]> comparator = Comparator.comparing(a -> a[0]);

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key, testCase.array,
              testCase.reverseOrder ? comparator.reversed() : comparator)
      );
    }
  }

  @Data
  static class ListArrayWithComparatorTestCase {

    String scenario;
    int[] key;
    int[][] array;
    boolean reverseOrder;
    int expected;
  }

  @Test
  public void firstIndexOfListArrayWithComparatorAndFunction_test() throws IOException {
    final List<ListArrayWithComparatorAndFunctionTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListArrayWithComparatorAndFunctionTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/ArrayWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchFirstIndexOfTest/ArrayWithComparatorReverseTestCases.json"
    );

    for (ListArrayWithComparatorAndFunctionTestCase testCase : testcases) {
      final Comparator<Integer> comparator = Comparator.naturalOrder();

      Assertions.assertEquals(
          testCase.expected,
          firstIndexOf(testCase.key[0], testCase.array,
              testCase.reverseOrder ? comparator.reversed() : comparator, (int[] arr) -> arr[0])
      );
    }
  }

  @Data
  static class ListArrayWithComparatorAndFunctionTestCase {

    String scenario;
    int[] key;
    int[][] array;
    boolean reverseOrder;
    int expected;
  }
}