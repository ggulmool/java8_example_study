package ch05.sec07;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeneratingExample {

  public static void main(String[] args) {
    Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
    stream.map(String::toUpperCase).forEach(System.out::println);

    int[] numbers = {2, 3, 5, 7, 11, 13};
    int sum = Arrays.stream(numbers).sum();
    System.out.println("sum = " + sum);

    long uniqueWords = 0;
    try (Stream<String> lines = Files
        .lines(Paths.get("java8-in-action/anne.txt"), Charset.defaultCharset())) {
      uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
          .distinct()
          .count();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("unique words of anne.txt : " + uniqueWords);

    Stream.iterate(0, n -> n + 2)
        .limit(10)
        .forEach(n -> System.out.print(n + " "));
    System.out.println();

    // quiz5-4
    Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
        .limit(10)
        .map(t -> t[0])
        .forEach(t -> System.out.print(t + " "));
    System.out.println();

    Stream.generate(Math::random)
        .limit(5)
        .forEach(n -> System.out.print(n + " "));
    System.out.println();

    IntSupplier fib = new IntSupplier() {
      private int previous = 0;
      private int current = 1;

      public int getAsInt() {
        int oldPrevious = this.previous;
        int nextValue = this.previous + this.current;
        this.previous = this.current;
        this.current = nextValue;
        return oldPrevious;
      }
    };
    IntStream.generate(fib).limit(10).forEach(n -> System.out.print(n + " "));
  }
}
