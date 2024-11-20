

public class MajorityElement {

    public static int majorityElement(int[] nums){

        //first solution:
        //return sorted(nums)[len(nums) // 2]

        //second solution:
        int candidate = 0;
        int count = 0;

        for (int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
            // tenary operator, short way to write if else statement.
            // (num == candidate) checks if num is candidate
            // if true add 1, if false subtract 1. 
            //shorthand for:
            // if (num == candidate) {
            //     count += 1; // Increment count
            // } else {
            //     count -= 1; // Decrement count
            // }
        }
        return candidate;

        // //out problem guarantees majority element so verification unecessary
        // int verifyCount = 0;
        // for (int num : nums){
        //     if(num == candidate){
        //         verifyCount++;
        //     }
        // }
        // if (verifyCount > nums.length /2 ){
        //     return candidate;
        // }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums)); // Output: 3
    }
}