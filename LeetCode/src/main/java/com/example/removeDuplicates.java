package com.example;

public class removeDuplicates {
    public static void main(String[] args) {
        int[]  nums = {1,1,1,2,2,3};

        int n = nums.length;
        if (n <= 2) {
            System.out.println(n);
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        System.out.println(slow);
    }
}
