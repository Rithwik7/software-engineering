/* @Question:
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 */

import java.util.Arrays;
import java.util.HashSet;

class containsDuplicate {

    // Brute force way using two simple loops
    // Logic: check if the same element exists more than once in the array
    // Big O time: O(n^2). This is my brain mapping to the most direct, literal implementation
    public boolean duplicateChecker1(int[] nums){

        // Find the Big O first. Then, the core operation that is inefficient.
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // Solving for: "When" is searching a list faster? Sorted list
    // Linear search on an unsorted list is O(n), whereas O(nlogn) when sorted
    // Key: When you hear "list", ask is it sorted or unsorted? When is it faster?
    public boolean duplicateChecker2(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }

    // Is there a "structure" built for fast searching? 
    // Follow up to: What is the fastest possible search time? O(1). By Hash Maps or Hash Sets.
    public boolean duplicateChecker3(int[] nums){
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums){
            if (seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;

    }


    // Run and test code here
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4};
        containsDuplicate duplicate = new containsDuplicate();
        System.out.println("Brute Force Algorithm: " + duplicate.duplicateChecker1(nums));
        System.out.println("Better Solution Algorithm: " + duplicate.duplicateChecker2(nums));
        System.out.println("Optimal Solution Algorithm: " + duplicate.duplicateChecker3(nums));
        
    }
}