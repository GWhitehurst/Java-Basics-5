package com.gw.sse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Integer> nums = Arrays.asList(1,3,3,4,4,4,12,9,4);
        System.out.println(groupSumClump(0, nums, 18));
        System.out.println(groupSumClump(0, nums, 800));
        System.out.println(groupSumClump(0, nums, 43));
    }

    public static boolean groupSumClump(int depth, List<Integer> ints, int sum){
        System.out.println("Depth: " + depth + " " + ints + " Sum: " + sum);

        //base cases
        if(sum == 0){
            return true;
        }
        else if(ints.size() == 0){
            return false;
        }

        List<Integer> intsCopy = new ArrayList<Integer>();
        intsCopy.addAll(ints);

        if(depth == 0){ //If this is the first call, collapse adjacent duplicates into totals, then sort
            //generate totals from consecutives
            int runningTotal = 0;
            List<Integer> totalsToAdd = new ArrayList<Integer>();
            for(int i = 0; i < ints.size() - 1; i++){
                if(ints.get(i) == ints.get(i+1)){
                    if(runningTotal == 0){
                        runningTotal = ints.get(i);
                    }
                    runningTotal += ints.get(i);
                }
                else{
                    totalsToAdd.add(runningTotal);
                    runningTotal = 0;
                }
            }
            totalsToAdd.removeAll(Collections.singleton(0));

            //remove consecutives from original list
            boolean removed = false;
            for(int i = 0; i < ints.size() - 1; i++){
                if(ints.get(i) == ints.get(i+1)){
                    ints.set(i, 0);
                    removed = true;
                }
                else if(removed){
                    ints.set(i,0);
                    removed = false;
                }
            }

            //combine the two lists and remove 0's, sorted high to low
            List<Integer> modifiedInts = new ArrayList<Integer>();
            modifiedInts.addAll(ints);
            modifiedInts.addAll(totalsToAdd);
            modifiedInts.removeAll(Collections.singleton(0));
            Collections.sort(modifiedInts, Collections.reverseOrder());
            intsCopy.clear();
            intsCopy.addAll(modifiedInts);
            System.out.println("Resorted numbers: " + intsCopy);
        }

        if(intsCopy.stream().mapToInt(Integer::intValue).sum() == sum){     //If sum is the total
            //System.out.println("Total matches");
            return true;
        }
        else if(intsCopy.stream().mapToInt(Integer::intValue).sum() < sum){ //If the total can't reach the sum
            //System.out.println("Total can't reach sum");
            return false;
        }
        else{                                                               //If the total overshoots the sum, recurse and remove an element
            boolean recursionResult = false;
            List<Integer> smallerIntsList = new ArrayList<Integer>();
            for(int i = 0; i < intsCopy.size(); i++){
                smallerIntsList.addAll(intsCopy);
                int removedValue = intsCopy.get(i);
                //System.out.println("removedValue: " + removedValue);
                smallerIntsList.remove(i);
                //System.out.println(smallerIntsList);
                if(recursionResult == false){                               //If a solution hasn't been found in the removing of elements, try another
                    recursionResult = groupSumClump(1, smallerIntsList, sum - removedValue);
                }
                smallerIntsList.clear();
            }
            return recursionResult;
        }
    }
}