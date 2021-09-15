package com.gw.sse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,22,94,10,6);
        System.out.println(nums);
        nums = nums.stream().map(x -> x % 10).collect(Collectors.toList());
        System.out.println(nums);
    }
}
