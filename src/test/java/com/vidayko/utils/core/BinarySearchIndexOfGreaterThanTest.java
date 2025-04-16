/*
 * Copyright (c) 2025 Roman Vidayko
 * www.linkedin.com/in/roman-vidayko
 */

package com.vidayko.utils.core;

import static com.vidayko.utils.core.BinarySearch.indexOfGreaterThan;
import static com.vidayko.utils.core.JsonLoader.loadTestcases;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.math.*;
import java.util.*;
import lombok.Data;
import org.junit.jupiter.api.*;

class BinarySearchIndexOfGreaterThanTest {

  @Test
  public void indexOfGreaterThanByte_test() throws IOException {

    final List<ByteTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ByteTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (ByteTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanByteWithComparator_test() throws IOException {
    final List<ByteWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ByteWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ByteWithComparatorTestCase testCase : testcases) {
      final Comparator<Byte> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanShort_test() throws IOException {

    final List<ShortTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ShortTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (ShortTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanShortWithComparator_test() throws IOException {
    final List<ShortWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ShortWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ShortWithComparatorTestCase testCase : testcases) {
      final Comparator<Short> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanInt_test() throws IOException {

    final List<IntTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (IntTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanIntWithComparator_test() throws IOException {
    final List<IntWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (IntWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanLong_test() throws IOException {

    final List<LongTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<LongTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (LongTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanLongWithComparator_test() throws IOException {
    final List<LongWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<LongWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (LongWithComparatorTestCase testCase : testcases) {
      final Comparator<Long> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanChar_test() throws IOException {

    final List<CharTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<CharTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/CharTestCases.json"
    );

    for (CharTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanCharWithComparator_test() throws IOException {
    final List<CharWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<CharWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/CharWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/CharWithComparatorReverseTestCases.json"
    );

    for (CharWithComparatorTestCase testCase : testcases) {
      final Comparator<Character> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanFloat_test() throws IOException {

    final List<FloatTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<FloatTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (FloatTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanFloatWithComparator_test() throws IOException {
    final List<FloatWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<FloatWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (FloatWithComparatorTestCase testCase : testcases) {
      final Comparator<Float> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanDouble_test() throws IOException {

    final List<DoubleTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<DoubleTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (DoubleTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanDoubleWithComparator_test() throws IOException {
    final List<DoubleWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<DoubleWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (DoubleWithComparatorTestCase testCase : testcases) {
      final Comparator<Double> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanInteger_test() throws IOException {

    final List<IntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (IntegerTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanIntegerWithComparator_test() throws IOException {
    final List<IntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (IntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanBigInteger_test() throws IOException {

    final List<BigIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (BigIntegerTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanBigIntegerWithComparator_test() throws IOException {
    final List<BigIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (BigIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<BigInteger> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanBigDecimal_test() throws IOException {

    final List<BigDecimalTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigDecimalTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (BigDecimalTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanBigDecimalWithComparator_test() throws IOException {
    final List<BigDecimalWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigDecimalWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (BigDecimalWithComparatorTestCase testCase : testcases) {
      final Comparator<BigDecimal> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanString_test() throws IOException {

    final List<StringTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<StringTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/StringTestCases.json"
    );

    for (StringTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanStringWithComparator_test() throws IOException {
    final List<StringWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<StringWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/StringWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/StringWithComparatorReverseTestCases.json"
    );

    for (StringWithComparatorTestCase testCase : testcases) {
      final Comparator<String> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanArrayWithComparator_test() throws IOException {
    final List<ArrayWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ArrayWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/ArrayWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/ArrayWithComparatorReverseTestCases.json"
    );

    for (ArrayWithComparatorTestCase testCase : testcases) {
      final Comparator<int[]> comparator = Comparator.comparing(a -> a[0]);

      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array,
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
  public void indexOfGreaterThanListInteger_test() throws IOException {

    final List<ListIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (ListIntegerTestCase testCase : testcases) {
      Collections.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanListIntegerWithComparator_test() throws IOException {
    final List<ListIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanListBigInteger_test() throws IOException {

    final List<ListBigIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (ListBigIntegerTestCase testCase : testcases) {
      Collections.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanListBigIntegerWithComparator_test() throws IOException {
    final List<ListBigIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListBigIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<BigInteger> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanListBigDecimal_test() throws IOException {

    final List<ListBigDecimalTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigDecimalTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberTestCases.json"
    );

    for (ListBigDecimalTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanListBigDecimalWithComparator_test() throws IOException {
    final List<ListBigDecimalWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigDecimalWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListBigDecimalWithComparatorTestCase testCase : testcases) {
      final Comparator<BigDecimal> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanListString_test() throws IOException {

    final List<ListStringTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/StringTestCases.json"
    );

    for (ListStringTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array)
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
  public void indexOfGreaterThanListStringWithComparator_test() throws IOException {
    final List<ListStringWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/StringWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/StringWithComparatorReverseTestCases.json"
    );

    for (ListStringWithComparatorTestCase testCase : testcases) {
      final Comparator<String> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array, comparator)
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
  public void indexOfGreaterThanListArrayWithComparator_test() throws IOException {
    final List<ListArrayWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListArrayWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/ArrayWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfGreaterThanTest/ArrayWithComparatorReverseTestCases.json"
    );

    for (ListArrayWithComparatorTestCase testCase : testcases) {
      final Comparator<int[]> comparator = Comparator.comparing(a -> a[0]);

      Assertions.assertEquals(
          testCase.expected,
          indexOfGreaterThan(testCase.key, testCase.array,
              testCase.reverseOrder ? comparator.reversed() : comparator)
      );
    }
  }

  @Data
  static class ListArrayWithComparatorTestCase {

    String scenario;
    int[] key;
    List<int[]> array;
    boolean reverseOrder;
    int expected;
  }

}