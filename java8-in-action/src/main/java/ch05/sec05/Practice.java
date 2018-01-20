package ch05.sec05;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class Practice {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    System.out.println("1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순 정렬");
    System.out.println(transactions.stream()
        .filter(t -> t.getYear() == 2011)
        .sorted(comparing(Transaction::getValue))
        .collect(toList()));

    System.out.println("\n2. 거래자가 근무하는 모든 도시를 중복없이 나열");
    System.out.println(transactions.stream()
        .map(t -> t.getTrader().getCity())
        .collect(toSet())
    ); //distinct 사용안하고 toSet사용

    System.out.println("\n3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순 정렬");
    System.out.println(transactions.stream()
        .map(Transaction::getTrader)
        .filter(t -> t.getCity().equals("Cambridge"))
        .distinct()
        .sorted(comparing(Trader::getName))
        //.sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
        .collect(toList()));

    System.out.println("\n4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환");
    System.out.println(transactions.stream()
          .map(t -> t.getTrader().getName())
          .distinct()
          .sorted((n1, n2) -> n1.compareTo(n2))
          .reduce((n1, n2) -> n1 + "," + n2)
          .orElse("")
    );

//    transactions.stream()
//        .map(t -> t.getTrader().getName())
//        .distinct()
//        .sorted((n1, n2) -> n1.compareTo(n2))
//        .collect(joining(","));

    System.out.println("\n5. 밀라노에 거래자가 있는가?");
    System.out.println(
        transactions.stream()
          .anyMatch(t -> t.getTrader().getCity().equals("Milan"))
    );

    System.out.println("\n6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력");
    System.out.println(
        transactions.stream()
          .filter(t -> t.getTrader().getCity().equals("Cambridge"))
          .map(Transaction::getValue)
          .collect(toList())
    );


    System.out.println("\n7. 전체 트랜잭션 중 최대값은");
    transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::max)
        .ifPresent(max -> System.out.println("max = " + max));

    System.out.println("\n8. 전체 트랜잭션 중 최소값은");
//    transactions.stream()
//        .map(Transaction::getValue)
//        .reduce((t1, t2) -> t1 < t2 ? t1 : t2)
//        .ifPresent(min -> System.out.println("min = " + min));
      transactions.stream()
          .min(comparingInt(Transaction::getValue))
          .ifPresent(t -> System.out.println("min = " + t.getValue()));
  }
}
