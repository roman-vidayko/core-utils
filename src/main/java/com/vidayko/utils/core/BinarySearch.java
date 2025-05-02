/*
 * Copyright (c) 2025 Roman Vidayko
 * www.linkedin.com/in/roman-vidayko
 */

package com.vidayko.utils.core;

import java.util.*;
import java.util.function.Function;

/**
 * Utility class providing extended binary search operations for primitive and object (generic)
 * arrays/lists, with comparators and mapping functions support.
 * <p>
 * Guarantees O(log n) time and O(1) space complexity.
 * <p>
 * These methods enhance the standard {@code Arrays.binarySearch()} behavior by offering:
 * <ul>
 *   <li>Index of the <b>first occurrence</b> of a key</li>
 *   <li>Index of the <b>last occurrence</b> of a key</li>
 *   <li>Index of the <b>first element greater than</b> a key</li>
 *   <li>Index of the <b>last element less than</b> a key</li>
 * </ul>
 * <p>
 * All methods assume the input array or list is already sorted, either in natural order or using a
 * provided {@link java.util.Comparator}.
 *
 * <h2>Supported Data Types</h2>
 * <ul>
 *   <li>{@code byte[]}</li>
 *   <li>{@code short[]}</li>
 *   <li>{@code int[]}</li>
 *   <li>{@code long[]}</li>
 *   <li>{@code char[]}</li>
 *   <li>{@code float[]}</li>
 *   <li>{@code double[]}</li>
 *   <li>{@code T[]} — for object arrays with generic type {@code T}</li>
 *   <li>{@code List<T>} — for object lists with generic type {@code T}</li>
 * </ul>
 */
public class BinarySearch {

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(byte key, byte[] array) {
    return lastIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(byte key, byte[] array, Comparator<Byte> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(array[mid], key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of bytes. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(byte key, byte[] array) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of bytes. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(byte key, byte[] array, Comparator<Byte> comparator) {
    int lastIndex = lastIndexOf(key, array, comparator);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < array.length ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(byte key, byte[] array) {
    return firstIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(byte key, byte[] array, Comparator<Byte> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(array[mid], key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of bytes. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(byte key, byte[] array) {
    return indexOfLessThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of bytes. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(byte key, byte[] array, Comparator<Byte> comparator) {
    int firstIndex = firstIndexOf(key, array, comparator);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(short key, short[] array) {
    return lastIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of shorts. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(short key, short[] array, Comparator<Short> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(array[mid], key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of shorts. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(short key, short[] array) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of shorts. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(short key, short[] array, Comparator<Short> comparator) {
    int lastIndex = lastIndexOf(key, array, comparator);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < array.length ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of shorts. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(short key, short[] array) {
    return firstIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of shorts. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(short key, short[] array, Comparator<Short> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(array[mid], key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of shorts. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(short key, short[] array) {
    return indexOfLessThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of shorts. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(short key, short[] array, Comparator<Short> comparator) {
    int firstIndex = firstIndexOf(key, array, comparator);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of integers. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(int key, int[] array) {
    return lastIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of integers. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(int key, int[] array, Comparator<Integer> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(array[mid], key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of integers. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(int key, int[] array) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of integers. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(int key, int[] array, Comparator<Integer> comparator) {
    int lastIndex = lastIndexOf(key, array, comparator);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < array.length ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of integers. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(int key, int[] array) {
    return firstIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of integers. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(int key, int[] array, Comparator<Integer> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(array[mid], key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of integers. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(int key, int[] array) {
    return indexOfLessThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of integers. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(int key, int[] array, Comparator<Integer> comparator) {
    int firstIndex = firstIndexOf(key, array, comparator);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(long key, long[] array) {
    return lastIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of longs. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(long key, long[] array, Comparator<Long> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(array[mid], key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of longs. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(long key, long[] array) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of longs. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(long key, long[] array, Comparator<Long> comparator) {
    int lastIndex = lastIndexOf(key, array, comparator);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < array.length ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of longs. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(long key, long[] array) {
    return firstIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of longs. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(long key, long[] array, Comparator<Long> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(array[mid], key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of longs. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(long key, long[] array) {
    return indexOfLessThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of longs. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(long key, long[] array, Comparator<Long> comparator) {
    int firstIndex = firstIndexOf(key, array, comparator);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(char key, char[] array) {
    return lastIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of chars. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(char key, char[] array, Comparator<Character> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(array[mid], key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of chars. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(char key, char[] array) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of chars. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(char key, char[] array, Comparator<Character> comparator) {
    int lastIndex = lastIndexOf(key, array, comparator);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < array.length ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of chars. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(char key, char[] array) {
    return firstIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of chars. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(char key, char[] array, Comparator<Character> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(array[mid], key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of chars. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(char key, char[] array) {
    return indexOfLessThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of chars. The array must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(char key, char[] array, Comparator<Character> comparator) {
    int firstIndex = firstIndexOf(key, array, comparator);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(float key, float[] array) {
    return lastIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of floats. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(float key, float[] array, Comparator<Float> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(array[mid], key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of floats. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(float key, float[] array) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of floats. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(float key, float[] array, Comparator<Float> comparator) {
    int lastIndex = lastIndexOf(key, array, comparator);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < array.length ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of floats. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(float key, float[] array) {
    return firstIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of floats. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(float key, float[] array, Comparator<Float> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(array[mid], key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of floats. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(float key, float[] array) {
    return indexOfLessThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of floats. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(float key, float[] array, Comparator<Float> comparator) {
    int firstIndex = firstIndexOf(key, array, comparator);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of bytes. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(double key, double[] array) {
    return lastIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of doubles. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int lastIndexOf(double key, double[] array, Comparator<Double> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(array[mid], key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of doubles. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(double key, double[] array) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of doubles. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static int indexOfGreaterThan(double key, double[] array, Comparator<Double> comparator) {
    int lastIndex = lastIndexOf(key, array, comparator);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < array.length ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of doubles. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(double key, double[] array) {
    return firstIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of doubles. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static int firstIndexOf(double key, double[] array, Comparator<Double> comparator) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(array[mid], key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(array[mid], key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of doubles. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(double key, double[] array) {
    return indexOfLessThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of doubles. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static int indexOfLessThan(double key, double[] array, Comparator<Double> comparator) {
    int firstIndex = firstIndexOf(key, array, comparator);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of objects. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @param <T>   the type of elements in the array
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <T extends Comparable<T>> int lastIndexOf(T key, T[] array) {
    return lastIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key      the value to search for
   * @param array    the sorted array to search
   * @param function a mapping function that extracts the comparable key from each list element
   * @param <K>      the type of the key, which must be {@link Comparable}
   * @param <T>      the type of elements in the array
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <K extends Comparable<K>, T> int lastIndexOf(K key, T[] array,
      Function<T, K> function) {
    return lastIndexOf(key, array, Comparator.naturalOrder(), function);
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @param <T>        the type of elements in the array
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <T> int lastIndexOf(T key, T[] array, Comparator<T> comparator) {
    return lastIndexOf(key, array, comparator, o -> o);
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @param function   a mapping function that extracts the comparable key from each list element
   * @param <K>        the type of the key
   * @param <T>        the type of elements in the array
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <K, T> int lastIndexOf(K key, T[] array, Comparator<K> comparator,
      Function<T, K> function) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(function.apply(array[mid]), key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(function.apply(array[mid]), key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of objects. The array must be sorted in natural order before calling this
   * method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @param <T>   the type of elements in the array
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static <T extends Comparable<T>> int indexOfGreaterThan(T key, T[] array) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder());
  }


  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key      the value to compare against
   * @param array    the sorted array to search
   * @param function a mapping function that extracts the comparable key from each list element
   * @param <K>      the type of the key, which must be {@link Comparable}
   * @param <T>      the type of elements in the array
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static <K extends Comparable<K>, T> int indexOfGreaterThan(K key, T[] array,
      Function<T, K> function) {
    return indexOfGreaterThan(key, array, Comparator.naturalOrder(), function);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @param <T>        the type of elements in the array
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static <T> int indexOfGreaterThan(T key, T[] array, Comparator<T> comparator) {
    return indexOfGreaterThan(key, array, comparator, o -> o);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @param function   a mapping function that extracts the comparable key from each list element
   * @param <K>        the type of the key
   * @param <T>        the type of elements in the array
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static <K, T> int indexOfGreaterThan(K key, T[] array, Comparator<K> comparator,
      Function<T, K> function) {
    int lastIndex = lastIndexOf(key, array, comparator, function);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < array.length ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of objects. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to search for
   * @param array the sorted array to search
   * @param <T>   the type of elements in the array
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <T extends Comparable<T>> int firstIndexOf(T key, T[] array) {
    return firstIndexOf(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key      the value to search for
   * @param array    the sorted array to search
   * @param function a mapping function that extracts the comparable key from each list element
   * @param <K>      the type of the key, which must be {@link Comparable}
   * @param <T>      the type of elements in the array
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <K extends Comparable<K>, T> int firstIndexOf(K key, T[] array,
      Function<T, K> function) {
    return firstIndexOf(key, array, Comparator.naturalOrder(), function);
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @param <T>        the type of elements in the array
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <T> int firstIndexOf(T key, T[] array, Comparator<T> comparator) {
    return firstIndexOf(key, array, comparator, a -> a);
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to search for
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @param function   a mapping function that extracts the comparable key from each list element
   * @param <K>        the type of the key
   * @param <T>        the type of elements in the array
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <K, T> int firstIndexOf(K key, T[] array, Comparator<K> comparator,
      Function<T, K> function) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = array.length - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(function.apply(array[mid]), key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(function.apply(array[mid]), key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of objects. The array must be sorted in natural order before calling this method.
   *
   * @param key   the value to compare against
   * @param array the sorted array to search
   * @param <T>   the type of elements in the array
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static <T extends Comparable<T>> int indexOfLessThan(T key, T[] array) {
    return indexOfLessThan(key, array, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key      the value to compare against
   * @param array    the sorted array to search, which must be {@link Comparable}
   * @param function a mapping function that extracts the comparable key from each list element
   * @param <K>      the type of the key
   * @param <T>      the type of elements in the array
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static <K extends Comparable<K>, T> int indexOfLessThan(K key, T[] array,
      Function<T, K> function) {
    return indexOfLessThan(key, array, Comparator.naturalOrder(), function);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @param <T>        the type of elements in the array
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static <T> int indexOfLessThan(T key, T[] array, Comparator<T> comparator) {
    return indexOfLessThan(key, array, comparator, a -> a);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted array of objects. The array must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param array      the sorted array to search
   * @param comparator the comparator used to compare array elements and the search key
   * @param function   a mapping function that extracts the comparable key from each list element
   * @param <K>        the type of the key
   * @param <T>        the type of elements in the array
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static <K, T> int indexOfLessThan(K key, T[] array, Comparator<K> comparator,
      Function<T, K> function) {
    int firstIndex = firstIndexOf(key, array, comparator, function);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted list of objects. The list must be sorted in natural order before calling this method.
   *
   * @param key  the value to search for
   * @param list the sorted list to search
   * @param <T>  the type of elements in the list
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <T extends Comparable<T>> int lastIndexOf(T key, List<T> list) {
    return lastIndexOf(key, list, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted list of objects. The list must be sorted in natural order before calling this method.
   *
   * @param key      the value to search for
   * @param list     the sorted list to search
   * @param function a mapping function that extracts the comparable key from each list element
   * @param <K>      the type of the key, which must be {@link Comparable}
   * @param <T>      the type of elements in the list
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <K extends Comparable<K>, T> int lastIndexOf(K key, List<T> list,
      Function<T, K> function) {
    return lastIndexOf(key, list, Comparator.naturalOrder(), function);
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted list of objects. The list must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param list       the sorted list to search
   * @param comparator the comparator used to compare list elements and the search key
   * @param <T>        the type of elements in the list
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <T> int lastIndexOf(T key, List<T> list, Comparator<T> comparator) {
    return lastIndexOf(key, list, comparator, o -> o);
  }

  /**
   * Performs a binary search to find the index of the last occurrence of the specified key in the
   * sorted list of objects. The list must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param list       the sorted list to search
   * @param comparator the comparator used to compare list elements and the search key
   * @param function   a mapping function that extracts the comparable key from each list element
   * @param <K>        the type of the key
   * @param <T>        the type of elements in the list
   * @return the index of the last occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <K, T> int lastIndexOf(K key, List<T> list, Comparator<K> comparator,
      Function<T, K> function) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = list.size() - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(function.apply(list.get(mid)), key)) {
        index = mid;
        left = mid + 1;
      } else if (0 > comparator.compare(function.apply(list.get(mid)), key)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted list of objects. The list must be sorted in natural order before calling this
   * method.
   *
   * @param key  the value to compare against
   * @param list the sorted list to search
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static <T extends Comparable<T>> int indexOfGreaterThan(T key, List<T> list) {
    return indexOfGreaterThan(key, list, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted list of objects. The list must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key      the value to compare against
   * @param list     the sorted list to search
   * @param function a mapping function that extracts the comparable key from each list element
   * @param <K>      the type of the key, which must be {@link Comparable}
   * @param <T>      the type of elements in the list
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static <K extends Comparable<K>, T> int indexOfGreaterThan(K key, List<T> list,
      Function<T, K> function) {
    return indexOfGreaterThan(key, list, Comparator.naturalOrder(), function);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted list of objects. The list must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param list       the sorted list to search
   * @param comparator the comparator used to compare list elements and the search key
   * @param <T>        the type of elements in the list
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static <T> int indexOfGreaterThan(T key, List<T> list, Comparator<T> comparator) {
    return indexOfGreaterThan(key, list, comparator, o -> o);
  }

  /**
   * Performs a binary search to find the index of the first element greater than the specified key
   * in a sorted list of objects. The list must be sorted according to the order induced by the
   * specified comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param list       the sorted list to search
   * @param comparator the comparator used to compare list elements and the search key
   * @param function   a mapping function that extracts the comparable key from each list element
   * @param <K>        the type of the key
   * @param <T>        the type of elements in the list
   * @return the index of the first element greater than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key would
   * be inserted to maintain the sorted order.
   */
  public static <K, T> int indexOfGreaterThan(K key, List<T> list, Comparator<K> comparator,
      Function<T, K> function) {
    int lastIndex = lastIndexOf(key, list, comparator, function);
    int insertionPoint = lastIndex >= 0 ? lastIndex + 1 : -lastIndex - 1;
    return 0 < insertionPoint && insertionPoint < list.size() ?
        insertionPoint : -insertionPoint - 1;
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted list of objects. The list must be sorted in natural order before calling this method.
   *
   * @param key  the value to search for
   * @param list the sorted list to search
   * @param <T>  the type of elements in the list
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <T extends Comparable<T>> int firstIndexOf(T key, List<T> list) {
    return firstIndexOf(key, list, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted list of objects. The list must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key      the value to search for
   * @param list     the sorted list to search
   * @param function a mapping function that extracts the comparable key from each list element
   * @param <K>      the type of the key, which must be {@link Comparable}
   * @param <T>      the type of elements in the list
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <K extends Comparable<K>, T> int firstIndexOf(K key, List<T> list,
      Function<T, K> function) {
    return firstIndexOf(key, list, Comparator.naturalOrder(), function);
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted list of objects. The list must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param list       the sorted list to search
   * @param comparator the comparator used to compare list elements and the search key
   * @param <T>        the type of elements in the list
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <T> int firstIndexOf(T key, List<T> list, Comparator<T> comparator) {
    return firstIndexOf(key, list, comparator, o -> o);
  }

  /**
   * Performs a binary search to find the index of the first occurrence of the specified key in the
   * sorted list of objects. The list must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to search for
   * @param list       the sorted list to search
   * @param comparator the comparator used to compare list elements and the search key
   * @param function   a mapping function that extracts the comparable key from each list element
   * @param <K>        the type of the key
   * @param <T>        the type of elements in the list
   * @return the index of the first occurrence of the key if it is found; otherwise, returns
   * -(insertion point) - 1, where the insertion point is the index at which the key would be
   * inserted to maintain the sorted order. The return value is non-negative if and only if the key
   * is found.
   */
  public static <K, T> int firstIndexOf(K key, List<T> list, Comparator<K> comparator,
      Function<T, K> function) {
    int index = Integer.MIN_VALUE;
    int left = 0, right = list.size() - 1;
    while (left <= right) {
      final int mid = (left + right) >>> 1;
      if (0 == comparator.compare(function.apply(list.get(mid)), key)) {
        index = mid;
        right = mid - 1;
      } else if (0 < comparator.compare(function.apply(list.get(mid)), key)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return index != Integer.MIN_VALUE ? index : -(left + 1);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted list of objects. The list must be sorted in natural order before calling this method.
   *
   * @param key  the value to compare against
   * @param list the sorted list to search
   * @param <T>  the type of elements in the list
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static <T extends Comparable<T>> int indexOfLessThan(T key, List<T> list) {
    return indexOfLessThan(key, list, Comparator.naturalOrder());
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted list of objects. The list must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key      the value to compare against
   * @param list     the sorted list to search
   * @param function a mapping function that extracts the comparable key from each list element
   * @param <K>      the type of the key
   * @param <T>      the type of elements in the list
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static <K extends Comparable<K>, T> int indexOfLessThan(K key, List<T> list,
      Function<T, K> function) {
    return indexOfLessThan(key, list, Comparator.naturalOrder(), function);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted list of objects. The list must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param list       the sorted list to search
   * @param comparator the comparator used to compare list elements and the search key
   * @param <T>        the type of elements in the list
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static <T> int indexOfLessThan(T key, List<T> list, Comparator<T> comparator) {
    return indexOfLessThan(key, list, comparator, o -> o);
  }

  /**
   * Performs a binary search to find the index of the last element less than the specified key in a
   * sorted list of objects. The list must be sorted according to the order induced by the specified
   * comparator before calling this method.
   *
   * @param key        the value to compare against
   * @param list       the sorted list to search
   * @param comparator the comparator used to compare list elements and the search key
   * @param function   a mapping function that extracts the comparable key from each list element
   * @param <K>        the type of the key
   * @param <T>        the type of elements in the list
   * @return the index of the last element less than key, if such an element exists; otherwise,
   * returns -(insertion point) - 1, where the insertion point is the index at which the key could
   * be inserted to maintain the sorted order.
   */
  public static <K, T> int indexOfLessThan(K key, List<T> list, Comparator<K> comparator,
      Function<T, K> function) {
    int firstIndex = firstIndexOf(key, list, comparator, function);
    return firstIndex >= 0 ? firstIndex - 1 : -firstIndex - 2;
  }
}
