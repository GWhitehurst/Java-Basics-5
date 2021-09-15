package com.gw.sse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    List<String> words = Arrays.asList("Rory", "Egon", "Tosh", "November", "Vorazun", "Karax", "James", "Sarah", "Artanis", "Alarak", "Arm", "App", "Bat");
        System.out.println("Unaltered word list"); showList(words);

        //sort by length, shortest to longest
        Comparator<String> shortToLong = (name1, name2) -> name1.length() - name2.length();
        List<String> wordsByLength = words.stream().sorted(shortToLong).collect(Collectors.toList());
        System.out.println("Sorted short to long"); showList(wordsByLength);

        //sort by length, longest to shortest
        Comparator<String> longToShort = (name1, name2) -> name2.length() - name1.length();
        List<String> wordsByLengthReversed = words.stream().sorted(longToShort).collect(Collectors.toList());
        System.out.println("Sorted long to short"); showList(wordsByLengthReversed);

        //sort alphabetically by first character only
        Comparator<String> alphabetFirst = (name1, name2) -> name1.charAt(0) - name2.charAt(0);
        List<String> wordsAlphabetFirst = words.stream().sorted(alphabetFirst).collect(Collectors.toList());
        System.out.println("Sorted by first letter alphabetically"); showList(wordsAlphabetFirst);

        //sort by strings that contain 'e'
        List<String> wordsDupe = words;
        Collections.sort(wordsDupe, (s1,s2) -> (((s2.contains("e") || s2.contains("E")) ? 1 : 0) - ((s1.contains("e") || s1.contains("E")) ? 1 : 0)));
        System.out.println("Sorted by words that contain 'e' first"); showList(wordsDupe);

        //sort by strings but with helper function
        //Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
        wordsDupe = words;
        Collections.sort(wordsDupe, (s1,s2) -> helperE(s1,s2));
        System.out.println("Same as before but with helper method"); showList(wordsDupe);

        //Run Odd/Even
        List<Integer> testInts = Arrays.asList(3, 5, 6, 7, 9, 12, 100000);
        System.out.println("Odd/Even string"); System.out.println(oddEven(testInts));

        //3 letter a-words
        System.out.println("3 letter words beginning with a"); System.out.println(aaa(words));
    }

    private static int helperE(String s1, String s2){
        int s1Int, s2Int;

        if(s1.contains("e") || s1.contains("E")) s1Int = 1;
        else s1Int = 0;

        if(s2.contains("e") || s2.contains("E")) s2Int = 1;
        else s2Int = 0;

        return s2Int - s1Int;
    }

    private static void showList(List<String> l){
        for(int i = 0; i < l.size(); i++){
            System.out.print(l.get(i) + ", ");
        }
        System.out.print("\n");
    }

    //Using Java8 features, return a comma separated string
    public static String oddEven(List<Integer> ints){
        List<String> stringNumList = ints.stream().map(s -> String.valueOf(s)).collect(Collectors.toList());

        stringNumList = stringNumList.stream().map(s -> {
            if(Integer.parseInt(s) % 2 == 0) s = "e" + s + ",";
            else s = "o" + s + ",";
            return s;
        }).collect(Collectors.toList());

        return stringNumList.stream().collect(Collectors.joining());
    }

    //Given a list of Strings, return a list of all strings starting with 'a' and have 3 characters
    public static List<String> aaa(List<String> words){
        return words.stream().filter(s -> s.length() == 3 && (s.charAt(0) == 'a' || s.charAt(0) == 'A')).collect(Collectors.toList());
    }
}
