MergeSortedArray.java

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 
Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109


	Input: nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3


	three pointers:
		last_num_nums1 pointing to the last element in the effective part of nums1 (index m-1)
		last_num_nums2 pointing to the last element in nums2 (index n-1)
		last_position_nums1 pointing to the last element in nums1 (index m + n - 1)

	Example of execution

		last_num_nums1 = 2 (points to nums1[2] = 3)
		last_num_nums2 = 2 (points to nums2[2] = 6)
		last_position_nums1 = 5 (points to nums1[5], where we’ll place the next largest element)

		First Comparison:
		nums1[last_num_nums1] = 3 and nums2[last_num_nums2] = 6
		6 is greater than 3, so place 6 in nums1[last_position_nums1]
		Update nums1 to [1, 2, 3, 0, 0, 6]
		Move last_num_nums2 to 1 and last_position_nums1 to 4

		Second Comparison:
		nums1[last_num_nums1] = 3 and nums2[last_num_nums2] = 5
		5 is greater than 3, so place 5 in nums1[last_position_nums1]
		Update nums1 to [1, 2, 3, 0, 5, 6]
		Move last_num_nums2 to 0 and last_position_nums1 to 3

		Third Comparison:
		nums1[last_num_nums1] = 3 and nums2[last_num_nums2] = 2
		3 is greater than 2, so place 3 in nums1[k]
		Update nums1 to [1, 2, 3, 3, 5, 6]
		Move last_num_nums1 to 1 and last_position_nums1 to 2

		Fourth Comparison:
		nums1[last_num_nums1] = 2 and nums2[last_num_nums2] = 2.
		Since they are equal, place 2 from nums2 in nums1[last_position_nums1].
		Update nums1 to [1, 2, 2, 3, 5, 6].
		Move last_num_nums2 to -1 and last_position_nums1 to 1.

		Remaining Elements:
		Now, last_num_nums2 is -1, which means all elements from nums2 have been merged.
		nums1 already has the remaining elements from the initial nums1 part in the correct order.

		Where we would need the second while loop and why:
		heres a problem if all element sin nums2 are smaller than elements in nums1
		suppose we have nums1 = [4, 5, 6, 0, 0, 0], m = 3 & nums2 = [1, 2, 3], n = 3
		after running the above loop until last_num_nums1 = -1 (it stops), we get [4,5,6,4,5,6], but we need [1,2,3,4,5,6]
		else block never executes in this case and last_num_nums2 never decrements, meaning there are still elements in nums2 
		left to be copied into nums1



RemoveDuplicates.java

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).



	I made an empty list, if the element is not already inlist add it. length of list is k, iterated thru nums and set all indexes from 0 to length of k as the numbers from list and after the last element from list is copied into nums, set the rest to 0

	this is not optimal and has time complexity O(n) so I made a better solution:
		make a counter k that doubles as index
		go thru all elements inside nums.
		if element is not equals to nums[k], set nums[k] as that element
		then increment k, only if the if condition is true.
		in case where we have [1,1,2]:
		1. 1 = nums[0] (which is 1), so we do nothing
		2. 1 = nums[0] (which is 1), so we do nothing
		3. 2 != nums[0] (which is 1), so now nums = [1,2,2] & k = 1
	since only first two elements matter, this is correct and since k represents the index of the last unique element, we need to increase it by 1 to have it be the number of unique elements. 





RemoveElement.java

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores

	we are really only interested to do smth with numbers that are NOT val, namely to put them at the front of the array.
	we create an int and set it to 0. suppose we have a case where nums = [3,2,2,3] and val = 3
	first, 3 = 3. nothing happens. k remains 0.
	next, 2 != 3. lets add 2 into nums at index k and increment it. next, 2 is again not equal 3. add 2 to nums at index k, nums[1]. also increment k. k is now 2. since 3 = 3 for the last element of nums, do nothing.




MajorityElement.java

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


	first solution: 
	since majority element always appears more times than the length of array/2, we can simply sort the array and then retrieve the element at len(array)/2. this works if len is an odd number because integer division in java (and in Python) always truncates the decimal part. The only problem withthis solution is the time complexity.
	Java uses DUal-Pivot Quicksort for primitive types like integer. This is an optimized version of traditional quicksort. It has the time complexity O(nlogn). It selects two pivots (elements in array used to divide it into smaller parts for sorting). If you have an array [7, 3, 5, 8, 2] and you pick 5 as the pivot, you can split the array into: elements less than the pivot: [3, 2], the pivot itself: [5], elements greater than the pivot: [7, 8]. Dual Pivot does the following: For the array [7, 3, 5, 8, 2], let’s pick 3 and 7 as pivots: elements less than 3: [2], elements between 3 and 7: [5], elements greater than 7: [8]. Then, these parts are recursively sorted.
	At every recursion level, partitioning takes O(n) because the algorithm has to process all the elements in the array once to rearrange them relative to the chosen pivot(s). After that, When we split the array into smaller chunks (e.g., halves or thirds), the number of elements in each part gets smaller at every step. For example, if the array is halved at each step:
	•	After the first split: Array size becomes n / 2.
	•	After the second split: Array size becomes n / 4.
	•	After the third split: Array size becomes n / 8.

	We are continuously dividing with a greater number, approaching 0. The size shrinks exponentially at each step. However:
	Exponential vs. Logarithmic Growth

	1.	Exponential Growth:
	•	Exponential growth means something grows rapidly as x increases.
	•	An exponential function like y = 2^x describes this type of growth: doubling, tripling, or increasing by a large factor for each step.
	•	Key Idea: Exponential growth starts small and grows big very fast.
	
	2.	Logarithmic Growth:
	•	Logarithmic growth is the inverse of exponential growth.
	•	A logarithmic function like y = \log_2(x) answers the question: How many steps (divisions, reductions, or multiplications) does it take to reach a particular size?
	•	Key Idea: Logarithmic growth starts big and shrinks slowly, flattening as it progresses.

	The final time complexity of O(n \log n) comes from combining the work done at each partition (O(n)) with the number of recursive levels (O(\log n)). Since partitioning happens at every level, the total work is: O(n) \times O(\log n) = O(n \log n).

	
	
	Anyway, How would we do this in problem to have better time complexity?



	second solution:
	We use the Boyer-Moore Voting Algorithm. O(n) time and O(1) space complexity. 
	first we create some candidate variable, let's initialize it to be 0.
	we also set the count to be 0.
	then we loop through the array: 
	if the count is 0 at this point, we set the candidate to the current element. if the current element matches the candidate, increment the count. if not, decrement the count. at the end of this loop, we should get the majority element. everything after that is actually optional. Let's see how this happens using an example:
	nums = [3, 3, 4, 2, 4, 4, 4, 3, 4, 4].

	looping through the array:

	Element	 candidate	  count	    Explanation
	  3			3			1		since count == 0, set candidate = 3.
	  3			3			2		Element matches candidate, increment count.
	  4			3			1		Does not match, decrement count.
	  2			3			0		Does not match, decrement count to 0.
	  4			4			1		count == 0, set candidate = 4.
	  4			4			2		Matches candidate, increment count.
	  4			4			3		Matches candidate, increment count.
	  3			4			2		Does not match, decrement count.
	  4			4			3		Matches candidate, increment count.
	  4			4			4		Matches candidate, increment count.

	  since majority element is guaranteed, we don't need to verify. In the verification we just count the candidate appearances and check it's greater than len of array /2. 


BestTimeToBuyAndSellStock.java


ou are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


	First solution:

	In the first solution I attempted, I initialized profit to 0. then i started looping through the array, from start to the element before last. take for example array [1,2,4]. The code takes element at index 0 (1), and compares it to element at 0+1 (being 2). the difference betweeen 1 and 2 is -1. this means second number is larger than first and the result is negative, meaning we have profit. if the day at which we bought stock were 2, and the next day 1, we dont have profit and the result is positive (1). Basically, I am searching for the smallest number for profit, signifying the greatest absolute difference between buy day and sell day. Since now the difference between 1 and 2 is negative, it is less than our initial profit which was initialized to be 0. so we replace it and set new profit to be -1. in the next iteration we compare 1 to 4. the difference is -3, which is less than our profit which was sset to be -1, so we overwrite it. profit is now -3. then the  outer for loop jumps to the next index, and we are comparing 2 to next index which holds 4. 2-4 is -2, but this is not less than our current profit which is -3 from the last iteration. this means the maximum profit we can obtain from this sequence of numbers is if we buy stock on the first day (index 0, value 1) and sell on the 3rd day (index 2, value 4) as the absolute difference between those two days is the greatest. We then simply return the absolute value of the profit, which is 3.
	If the array were sorted, meaning stock value drops after each day, such as for [4,2,1], 4-1 is 3, not greater than 0 so nothing happens to profit and it remains 0. 2-1 is 1, again profit doesn't change. in the nxt iteration of outside loop, 2-1 is 1, again greater than 0 and profit stays at 0. This means that for such arrays we will simply return 0 like the problem asks.

	PROBLEM: nested for loops have time complexity O(n) in this case, which is bad but also means LeetCode won't accept it. I had to think of something better.