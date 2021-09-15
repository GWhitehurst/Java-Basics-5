package com.gw.sse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("zx","bb","cx","xxaaegxw");
        System.out.println(words);
        words = words.stream().map(s -> s.replace("x","")).collect(Collectors.toList());
        System.out.println(words);
    }
}
