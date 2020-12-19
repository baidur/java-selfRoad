package com.example.demo.stream;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

public class stream {

    public static void main(String[] args) {
        Stream<Double> stream = Stream.generate(Math::random).limit(100);
        stream.filter((e) -> e > 0)
                .map((e) -> new BigDecimal(e).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue())
                .limit(10)
                .sorted()
                .distinct()
                .forEach(System.out::println);
        Optional<Double> max = stream.max(Double::compareTo);

    }
}
