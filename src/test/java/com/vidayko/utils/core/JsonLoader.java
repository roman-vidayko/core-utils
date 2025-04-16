/*
 * Copyright (c) 2025 Roman Vidayko
 * www.linkedin.com/in/roman-vidayko
 */

package com.vidayko.utils.core;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES;
import static com.fasterxml.jackson.databind.MapperFeature.SORT_PROPERTIES_ALPHABETICALLY;
import static com.fasterxml.jackson.databind.SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.apache.commons.io.IOUtils;

public class JsonLoader {

  @SuppressWarnings("deprecation")
  public final static ObjectMapper mapper = new ObjectMapper()
      .configure(FAIL_ON_IGNORED_PROPERTIES, false)
      .configure(ALLOW_SINGLE_QUOTES, true)
      .configure(ORDER_MAP_ENTRIES_BY_KEYS, true)
      .configure(SORT_PROPERTIES_ALPHABETICALLY, true)
      .setSerializationInclusion(NON_NULL);

  public static <T> List<T> loadTestcases(ClassLoader classLoader,
      TypeReference<List<T>> typeReference,
      String... filePaths)
      throws IOException {

    final List<T> testcases = new ArrayList<>();
    for (String filePath : filePaths) {
      testcases.addAll(mapper.readValue(
          IOUtils.toString(Objects.requireNonNull(classLoader.getResourceAsStream(filePath)),
              StandardCharsets.UTF_8), typeReference));
    }
    return testcases;
  }
}
