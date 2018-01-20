package ch05.sec02;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExample {

  public static void main(String[] args) {
    String[] arrayOfWords = {"Goodbye", "World"};
    Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

    List<String> words = Arrays.asList("Hello", "World");
    List<String> uniqCharacters = words.stream()
        .map(w -> w.split(""))
        .flatMap(Arrays::stream)
        .distinct()
        .collect(toList());
    System.out.println("uniqCharacters = " + uniqCharacters);

    // quiz 5-2.1
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> squares = numbers.stream()
        .map(i -> i * i)
        .collect(toList());
    System.out.println("squares = " + squares);

    // quiz 5-2.2
    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);
    List<List<Integer>> pairs = numbers1.stream()
        .flatMap(i -> numbers2.stream().map(j -> Arrays.asList(i, j)))
        .collect(toList());
    System.out.println("pairs = " + pairs);

    // List<Stream<List<String> return
//    List<Stream<List<Integer>>> mapPairs = numbers1.stream()
//        .map(i -> numbers2.stream().map(j -> Arrays.asList(i, j)))
//        .collect(toList());
//    System.out.println("mapPairs = " + mapPairs);

    // quiz 5-2.3
    List<List<Integer>> pairs2 = numbers1.stream()
        .flatMap(i -> numbers2.stream()
            .filter(j -> (i + j) % 3 == 0)
            .map(j -> Arrays.asList(i, j)))
        .collect(toList());

    System.out.println("pairs2 = " + pairs2);
  }
}
