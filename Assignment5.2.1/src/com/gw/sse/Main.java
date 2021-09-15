package com.gw.sse;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Integer> data = Arrays.asList(5,1,4,2,5,3,898,1,3,2,12);
        for(int i = 1; i < data.size(); i += 2){
            switch(data.get(i)){
                case 1:
                    isOdd(data.get(i+1));
                    break;
                case 2:
                    isPrime(data.get(i+1));
                    break;
                case 3:
                    isPalindrome(data.get(i+1));
                    break;
                default:
                    System.out.println("Invalid function ID found, skipping...");
                    break;
            }
        }
    }

    //1
    public static void isOdd(int num){
        if(num % 2 == 0){
            System.out.println("EVEN");
        }
        else{
            System.out.println("ODD");
        }
    }

    //2
    public static void isPrime(int num){
        boolean isPrime = true;
        for(int i = 1; i < num / 2; i++){
            if(num % i == 0){
                isPrime = false;
            }
        }
        if(isPrime){
            System.out.println("PRIME");
        }
        else{
            System.out.println("COMPOSITE");
        }
    }

    //3
    public static void isPalindrome(int num){
        String s = String.valueOf(num);
        if(s.charAt(0) == s.charAt(s.length() - 1)){
            if(s.length() == 0 || s.length() == 1) {
                System.out.println("PALINDROME");
            }
            else{
                s = s.substring(1, s.length()-1);
                isPalindrome(Integer.parseInt(s));
            }

        }
        else {
            System.out.println("NOT PALINDROME");
        }
    }
}