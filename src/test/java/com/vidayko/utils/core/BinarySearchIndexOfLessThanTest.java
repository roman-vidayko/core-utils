/*
 * Copyright (c) 2025 Roman Vidayko
 * www.linkedin.com/in/roman-vidayko
 */

package com.vidayko.utils.core;

import static com.vidayko.utils.core.BinarySearch.indexOfLessThan;
import static com.vidayko.utils.core.JsonLoader.loadTestcases;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.math.*;
import java.util.*;
import lombok.Data;
import org.junit.jupiter.api.*;

class BinarySearchIndexOfLessThanTest {

  @Test
  public void indexOfLessThanByte_test() throws IOException {

    final List<ByteTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ByteTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (ByteTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanByteWithComparator_test() throws IOException {
    final List<ByteWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ByteWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ByteWithComparatorTestCase testCase : testcases) {
      final Comparator<Byte> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanShort_test() throws IOException {

    final List<ShortTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ShortTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (ShortTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanShortWithComparator_test() throws IOException {
    final List<ShortWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ShortWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ShortWithComparatorTestCase testCase : testcases) {
      final Comparator<Short> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanInt_test() throws IOException {

    final List<IntTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (IntTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanIntWithComparator_test() throws IOException {
    final List<IntWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (IntWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanLong_test() throws IOException {

    final List<LongTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<LongTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (LongTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanLongWithComparator_test() throws IOException {
    final List<LongWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<LongWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (LongWithComparatorTestCase testCase : testcases) {
      final Comparator<Long> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanChar_test() throws IOException {

    final List<CharTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<CharTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/CharTestCases.json"
    );

    for (CharTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanCharWithComparator_test() throws IOException {
    final List<CharWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<CharWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/CharWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/CharWithComparatorReverseTestCases.json"
    );

    for (CharWithComparatorTestCase testCase : testcases) {
      final Comparator<Character> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanFloat_test() throws IOException {

    final List<FloatTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<FloatTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (FloatTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanFloatWithComparator_test() throws IOException {
    final List<FloatWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<FloatWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (FloatWithComparatorTestCase testCase : testcases) {
      final Comparator<Float> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanDouble_test() throws IOException {

    final List<DoubleTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<DoubleTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (DoubleTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanDoubleWithComparator_test() throws IOException {
    final List<DoubleWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<DoubleWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (DoubleWithComparatorTestCase testCase : testcases) {
      final Comparator<Double> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanInteger_test() throws IOException {

    final List<IntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (IntegerTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanIntegerWithComparator_test() throws IOException {
    final List<IntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<IntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (IntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanBigInteger_test() throws IOException {

    final List<BigIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (BigIntegerTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanBigIntegerWithComparator_test() throws IOException {
    final List<BigIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (BigIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<BigInteger> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanBigDecimal_test() throws IOException {

    final List<BigDecimalTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigDecimalTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (BigDecimalTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanBigDecimalWithComparator_test() throws IOException {
    final List<BigDecimalWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<BigDecimalWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (BigDecimalWithComparatorTestCase testCase : testcases) {
      final Comparator<BigDecimal> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanString_test() throws IOException {

    final List<StringTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<StringTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringTestCases.json"
    );

    for (StringTestCase testCase : testcases) {
      Arrays.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanStringWithComparator_test() throws IOException {
    final List<StringWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<StringWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringWithComparatorReverseTestCases.json"
    );

    for (StringWithComparatorTestCase testCase : testcases) {
      final Comparator<String> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanArrayWithComparator_test() throws IOException {
    final List<ArrayWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ArrayWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/ArrayWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/ArrayWithComparatorReverseTestCases.json"
    );

    for (ArrayWithComparatorTestCase testCase : testcases) {
      final Comparator<int[]> comparator = Comparator.comparing(a -> a[0]);

      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array,
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
  public void indexOfLessThanListInteger_test() throws IOException {

    final List<ListIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (ListIntegerTestCase testCase : testcases) {
      Collections.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanListIntegerWithComparator_test() throws IOException {
    final List<ListIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<Integer> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanListBigInteger_test() throws IOException {

    final List<ListBigIntegerTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigIntegerTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (ListBigIntegerTestCase testCase : testcases) {
      Collections.sort(testCase.array);
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanListBigIntegerWithComparator_test() throws IOException {
    final List<ListBigIntegerWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigIntegerWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListBigIntegerWithComparatorTestCase testCase : testcases) {
      final Comparator<BigInteger> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanListBigDecimal_test() throws IOException {

    final List<ListBigDecimalTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigDecimalTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberTestCases.json"
    );

    for (ListBigDecimalTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanListBigDecimalWithComparator_test() throws IOException {
    final List<ListBigDecimalWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListBigDecimalWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/NumberWithComparatorReverseTestCases.json"
    );

    for (ListBigDecimalWithComparatorTestCase testCase : testcases) {
      final Comparator<BigDecimal> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanListString_test() throws IOException {

    final List<ListStringTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringTestCases.json"
    );

    for (ListStringTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array)
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
  public void indexOfLessThanListStringWithFunction_test() throws IOException {

    final List<ListStringWithFunctionTestCase> testcases = loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringWithFunctionTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringTestCases.json"
    );

    for (ListStringWithFunctionTestCase testCase : testcases) {
      Collections.sort(testCase.array);

      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key.charAt(0), testCase.array, (String s) -> s.charAt(0))
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
  public void indexOfLessThanListStringWithComparator_test() throws IOException {
    final List<ListStringWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringWithComparatorReverseTestCases.json"
    );

    for (ListStringWithComparatorTestCase testCase : testcases) {
      final Comparator<String> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array, comparator)
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
  public void indexOfLessThanListStringWithComparatorAndFunction_test() throws IOException {
    final List<ListStringWithComparatorAndFunctionTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListStringWithComparatorAndFunctionTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/StringWithComparatorReverseTestCases.json"
    );

    for (ListStringWithComparatorAndFunctionTestCase testCase : testcases) {
      final Comparator<Character> comparator =
          testCase.reverseOrder ? Comparator.reverseOrder() : Comparator.naturalOrder();
      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key.charAt(0), testCase.array, comparator,
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
  public void indexOfLessThanListArrayWithFunction_test() throws IOException {
    final List<ListArrayWithFunctionTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListArrayWithFunctionTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/ArrayTestCases.json"
    );

    for (ListArrayWithFunctionTestCase testCase : testcases) {

      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key[0], testCase.array, (int[] arr) -> arr[0])
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
  public void indexOfLessThanListArrayWithComparator_test() throws IOException {
    final List<ListArrayWithComparatorTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListArrayWithComparatorTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/ArrayWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/ArrayWithComparatorReverseTestCases.json"
    );

    for (ListArrayWithComparatorTestCase testCase : testcases) {
      final Comparator<int[]> comparator = Comparator.comparing(a -> a[0]);

      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key, testCase.array,
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
  public void indexOfLessThanListArrayWithComparatorAndFunction_test() throws IOException {
    final List<ListArrayWithComparatorAndFunctionTestCase> testcases = JsonLoader.loadTestcases(
        this.getClass().getClassLoader(),
        new TypeReference<List<ListArrayWithComparatorAndFunctionTestCase>>() {
        },
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/ArrayWithComparatorTestCases.json",
        "testcases/com/vidayko/utils/core/BinarySearchIndexOfLessThanTest/ArrayWithComparatorReverseTestCases.json"
    );

    for (ListArrayWithComparatorAndFunctionTestCase testCase : testcases) {
      final Comparator<Integer> comparator = Comparator.naturalOrder();

      Assertions.assertEquals(
          testCase.expected,
          indexOfLessThan(testCase.key[0], testCase.array,
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