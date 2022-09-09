package com.jaredbears.optum;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CheckElementsTest {

  private CheckElements checkElements;

  @BeforeEach
  void setUp() throws Exception {
    checkElements = new CheckElements();
  }

  @ParameterizedTest
  @MethodSource("com.jaredbears.optum.CheckElementsTest#parameters")
  void testThatSortSolutionWorks(int[] arr, Boolean solution) {
    assertThat(checkElements.sortSolution(arr)).isEqualTo(solution);
  }
  
  @ParameterizedTest
  @MethodSource("com.jaredbears.optum.CheckElementsTest#parameters")
  void testThatHashSolutionWorks(int[] arr, Boolean solution) {
    assertThat(checkElements.hashSolution(arr)).isEqualTo(solution);
  }

  static Stream<Arguments> parameters() {
    int[] arrayOne = {7};
    int[] arrayTwo = {4, 3};
    int[] arrayThree = {11, 1, 8, 12, 14};
    int[] arrayFour = {4, 10, 8, 5, 9};
    return Stream.of(arguments(arrayOne, false), arguments(arrayTwo, true),
        arguments(arrayThree, true), arguments(arrayFour, true));
  }

}
