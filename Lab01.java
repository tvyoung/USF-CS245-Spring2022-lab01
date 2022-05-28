//@name Vicki Young
//@date and version 2022.01.29
//CS245-03 Lab 1: Find the Missing Number

//given an unsorted array of integers in the range [0, n], return the missing number
import java.util.Arrays;

class Lab01{
    //method to find the missing number in unsorted array
    //@param int array of given numbers
    //@returns int missing number
    public static int findMissingNum(int[] nums){
        //n = length of nums array
        int n = nums.length;
        
        //finds the max integer in nums array
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        //if the length of nums array is greater than the max integer, return length of nums array (max + 1 is the missing number)
        if (n > max) {
            return n;
        }

        //creates array of integers from 0 to n while calculating the sum of the integers
        int[] arrayTrueSum = new int[n+1];
        arrayTrueSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            arrayTrueSum[i] = arrayTrueSum[i-1] + i;
        }
        //arrayTrueSum[n] should hold the sum of all integers
        //FOR TESTING: System.out.println("arrayTrueSum[n]: " + arrayTrueSum[n]);

        //find the sum of all the integers currently in nums array
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        //nums[n-1] should hold the sum of all integers that were in nums array
        //FOR TESTING: System.out.println("nums[n-1]: " + nums[n-1]);

        //missing number = sum of all integers from 0 to n - sum of all integers currently in the array
        return arrayTrueSum[n] - nums[n-1];
    }
    
    public static void main(String[] args) {
        int[] test1 = {2, 5, 7, 6, 1, 3, 0}; //returns 4
        int[] test2 = {0, 1}; //returns 2
        int[] test3 = {5, 3, 4, 2, 1}; //returns 0
        int[] test4 = {4, 2, 3, 1, 5, 0}; //returns 6
        int[] test5 = {0, 2}; //returns 1
        int[] test6 = {1, 3, 0}; //returns 2
        int[] test7 = {0}; //returns 1

        System.out.println("test 1 returns 4:");
        System.out.println(findMissingNum(test1));
        System.out.println("test 2 returns 2:");
        System.out.println(findMissingNum(test2));
        System.out.println("test 3 returns 0:");
        System.out.println(findMissingNum(test3));
        System.out.println("test 4 returns 6:");
        System.out.println(findMissingNum(test4));
        System.out.println("test 5 returns 1:");
        System.out.println(findMissingNum(test5));
        System.out.println("test 6 returns 2:");
        System.out.println(findMissingNum(test6));
        System.out.println("test 7 returns 1:");
        System.out.println(findMissingNum(test7));     
    }
}