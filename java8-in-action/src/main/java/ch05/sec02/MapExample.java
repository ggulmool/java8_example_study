package ch05.sec02;

import static ch04.Menu.menus;
import static java.util.stream.Collectors.*;

import ch04.Dish;
import java.util.Arrays;
import java.util.List;

public class MapExample {

  public static void main(String[] args) {
    List<String> dishNames = menus().stream()
        .map(Dish::getName)
        .collect(toList());
    System.out.println("dishNames = " + dishNames);

    List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
    List<Integer> wordLength = words.stream()
        .map(String::length)
        .collect(toList());
    System.out.println("wordLength = " + wordLength);

    // map chaining
    List<Integer> dishNameLengths = menus().stream()
        .map(Dish::getName)
        .map(String::length)
        .collect(toList());
    System.out.println("dishNameLengths = " + dishNameLengths);
  }
}
