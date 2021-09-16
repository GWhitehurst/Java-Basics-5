package com.gw.sse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    List<Integer> data = Arrays.asList(5,1,4,2,5,3,87799778,1,3,2,12);
        for(int i = 1; i < data.size(); i += 2){
            List<Integer> num = new ArrayList<Integer>();
            num.add(data.get(i+1));
            switch(data.get(i)){
                case 1:
                    isOdd(num);
                    break;
                case 2:
                    isPrime(num);
                    break;
                case 3:
                    isPalindrome(num);
                    break;
                default:
                    System.out.println("Invalid function ID found, skipping...");
                    break;
            }
        }
    }

    //1
    public static void isOdd(List<Integer> num){
        num = num.stream().map(n -> n%2).collect(Collectors.toList());
        if(num.get(0) == 1){
            System.out.println("ODD");
        }
        else{
            System.out.println("EVEN");
        }
    }

    //2
    public static void isPrime(List<Integer> num){
        num = num.stream().map(n -> {
            boolean isPrime = true;
            for(int i = 1; i < n/2; i++){
                if(n % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) return 1;
            else return 0;
        }).collect(Collectors.toList());

        if(num.get(0) == 1){
            System.out.println("PRIME");
        }
        else{
            System.out.println("COMPOSITE");
        }
    }

    //3
    public static void isPalindrome(List<Integer> num){
        num = num.stream().map(n -> {
            String s = String.valueOf(n);
            boolean isPalindrome;
            if(s.length() % 2 == 0){
                int halfLength = s.length() / 2;
                String sub1 = s.substring(0, halfLength);
                String sub2 = s.substring(halfLength);
                StringBuffer sbr = new StringBuffer(sub2);
                sbr.reverse();
                sub2 = sbr.toString();
                isPalindrome = sub1.equals(sub2);
            }
            else{
                int halfLength = s.length() / 2;
                String sub1 = s.substring(0, halfLength);
                String sub2 = s.substring(halfLength + 1);
                StringBuffer sbr = new StringBuffer(sub2);
                sbr.reverse();
                sub2 = sbr.toString();
                isPalindrome = sub1.equals(sub2);
            }
            if(isPalindrome) return 1;
            return 0;
        }).collect(Collectors.toList());

        if(num.get(0) == 1){
            System.out.println("PALINDROME");
        }
        else{
            System.out.println("NOT PALINDROME");
        }

    }
}