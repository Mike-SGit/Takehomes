package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
// Complete the maxMoney function below.
    static int maxMoney(int n, long k) {
        
        // fix; was thinking about this problem recently and realised i hadn't handled
        // the case where k is triangular but k > (n*(n+1))/2 //highest possible triangular value
        if (k > ((n*(n+1))/2) ) return (int) (((n*(n+1))/2) % 1000000007);
        
        //if julias number is triangular, she does not collect from student[0]
        //else she collects from all students
        boolean isTriangular = false;

        //k is triangular if and only if 8*k+1 is a square - wikipedia
        long calc_num = 8*k+1;
        long t = (long) Math.sqrt(calc_num);
        if (t*t==calc_num) {
            isTriangular = true;
        } 

        long res;
        if (isTriangular) {
            res = ((n*(n+1))/2)-1;
        } else {
            res =  ((n*(n+1))/2);
        }
        return (int) (res % 1000000007);
    }



    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        long k = Long.parseLong(bufferedReader.readLine().trim());
        int res = maxMoney(n, k);
        System.out.println(res);
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
