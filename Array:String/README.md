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



************************SOLUTION************************

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

