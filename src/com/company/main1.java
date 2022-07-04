package com.company;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Pair {
    Integer num;
    Character sign;

    Pair(Integer num, Character sign) {
        this.num = num;
        this.sign = sign;
    }

    public String toString() {
        return "(" + this.sign + ")" + this.num + " ";
    }
}


public class main1 {
    public static void main(String[] args) {
        int[] numbers={7,4,-8,3};
        int target=12;
        System.out.println("Result:");
        printWays(numbers, numbers.length-1,0,target,new ArrayDeque<>());

    }

    public static void printNums(Deque<Pair> list) {
        for (Pair p : list) {
            System.out.print(p);
        }
        System.out.println();
    }

    public static void printWays(int[] numbers, int n, int sum, int target, Deque<Pair> list) {
        if (sum == target) {
            printNums(list);
            return;
        }
        if (n < 0) {
            return;
        }
        //ignoring the current elements!!! so clear
        printWays(numbers, n - 1, sum, target, list);

        list.addLast(new Pair(numbers[n], '+'));
        printWays(numbers, n - 1, sum + numbers[n], target, list);
        list.pollLast();

        list.addLast(new Pair(numbers[n], '-'));
        printWays(numbers, n - 1, sum - numbers[n], target, list);
        list.pollLast();
    }
}

































