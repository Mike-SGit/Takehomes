package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {
/*
* Complete the 'customSort' function below.
* The function accepts INTEGER_ARRAY arr as parameter.
*/
public static void customSort(List<Integer> arr) {

    int arrLen = arr.size();


    //ought to use a merge sort, luckly Collections does a tim sort for us 
    Collections.sort(arr);
    
    //hashmap to track count of each value in array
    //keys are array values, and their count/frequency
    HashMap<Integer, Integer> countMap;
    try{
        countMap = new HashMap<Integer, Integer>();
    } catch (Exception err){
        System.out.println("failed to create Hashmap");
        System.out.println(err.getMessage());
        return;
    }

    //collect frequencies of values in arr into hashmap
    for (int i = 0; i < arrLen; i++) {
        if (countMap.containsKey(arr.get(i))) {
            countMap.put(arr.get(i), countMap.get(arr.get(i)) + 1);
        }
        else {
            countMap.put(arr.get(i),1); 
        }
    }
    
    // sort the array list simply based on the values' frequency
    // in countMap
    Collections.sort(arr, new Comparator<Integer>() {
        public int compare(Integer n1, Integer n2)
        {
            int freq1 = countMap.get(n1);
            int freq2 = countMap.get(n2);
                return freq1 - freq2;
        }
    });
    
    //print result
    for (int i = 0; i < arrLen; i++) {
       System.out.println(arr.get(i));
    } 

}

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new
        InputStreamReader(System.in));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
        //above line needs '(Collectors.toList())' instead of '(toList())'
        //or maybe my version of java is not good
        Result.customSort(arr);
        bufferedReader.close();
    }
}