package ch05.sec04;

import static ch04.Menu.menus;

import java.util.Arrays;
import java.util.List;

public class ReducingExample {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
    Integer sum = numbers.stream().reduce(0, Integer::sum);
    System.out.println("sum = " + sum);

    Integer product = numbers.stream().reduce(1, (a, b) -> a * b);
    System.out.println("product = " + product);

    // 초기값을 인자로 전달하지 않기 때문에 스트림요소에 값이 하나도 없는 경우에는 빈값이 생겨서 Optional리턴
    numbers.stream().reduce(Integer::max)
        .ifPresent(i -> System.out.println("max : " + i));

    numbers.stream().reduce(Integer::min)
        .ifPresent(i -> System.out.println("max : " + i));

    // quiz 5-3
    menus().stream()
        .map(i -> 1)
        .reduce(Integer::sum)
        .ifPresent(count -> System.out.println("count = " + count));
  }
}
