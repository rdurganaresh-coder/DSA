# Pattern 2: Two Pointers

In problems where we deal with sorted arrays (or <b>LinkedList</b>s) and need to find a set of elements that fulfill certain constraints, the <b>two pointers</b> approach becomes quite useful. The set of elements could be a pair, a triplet or even a subarray. For example, take a look at the following problem:

> Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

To solve this problem, we can consider each element one by one (pointed out by the first pointer) and iterate through the remaining elements (pointed out by the second pointer) to find a pair with the given sum. The <b>time complexity</b> of this algorithm will be `O(N^2)` where `N` is the number of elements in the input array.

Given that the input array is sorted, an efficient way would be to start with one pointer in the beginning and another pointer at the end. At every step, we will see if the numbers pointed by the <b>two pointers</b> add up to the target sum. If they do not, we will do one of two things:
1. If the sum of the two numbers pointed by the <b>two pointers</b> is greater than the target sum, this means that we need a pair with a smaller sum. So, to try more pairs, we can decrement the end-pointer.
2. If the sum of the two numbers pointed by the <b>two pointers</b> is smaller than the target sum, this means that we need a pair with a larger sum. So, to try more pairs, we can increment the start-pointer.

## 🌴 Pair with Target Sum  aka "Two Sum" (easy) 
https://leetcode.com/problems/two-sum/
> Given an array of sorted numbers and a `target` sum, find a pair in the array whose sum is equal to the given `target`.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given `target`.

Since the given array is sorted, a brute-force solution could be to iterate through the array, taking one number at a time and searching for the second number through <b>Binary Search</b>. The <b>time complexity</b> of this algorithm will be `O(N*logN)`. Can we do better than this?

We can follow the <b>Two Pointers</b> approach. We will start with one pointer pointing to the beginning of the array and another pointing at the end. At every step, we will see if the numbers pointed by the <b>two pointers</b> add up to the `target` sum. If they do, we have found our pair; otherwise, we will do one of two things:
1. If the sum of the two numbers pointed by the <b>two pointers</b> is greater than the `target` sum, this means that we need a pair with a smaller sum. So, to try more pairs, we can decrement the end-pointer.
2. If the sum of the two numbers pointed by the <b>two pointers</b> is smaller than the `target` sum, this means that we need a pair with a larger sum. So, to try more pairs, we can increment the start-pointer.
### Brute Force Solution
> [!NOTE]
> **Language:** JavaScript
````js
function pairWithTargetSum(nums, target) {
  for (let i = 0; i < nums.length; i++) {
    for(let j = 1; j < nums.length; j++) {
      if((nums[i] + nums[j]) === target) {
        //they cannot be at the same index
        if(i !== j) {
          return [i, j]
        }
      } 
    }
  }
}
````
---
> [!NOTE]
> **Language:** Java
- This approach checks all possible pairs of elements in the array using two nested loops to see if their sum matches the target.

```java
public class Solution {
    public static int[] pairWithTargetSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    if (i != j) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{};
    }
}
```
### Complexity Analysis
* **Time Complexity:** $O(N^2)$ due to the nested loops traversing the array.
* **Space Complexity:** $O(1)$ because it only uses a few pointers and no extra data structures.

---
## Approach 2: Optimized (HashMap)

This approach uses a Hash Map to store the numbers and their indices as we iterate. For each number, it checks if its complement (`target - current_number`) already exists in the map.

```java
import java.util.HashMap;

public class Solution {
    public static int[] pairWithTargetSumOptimized(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```
### Complexity Analysis
* **Time Complexity:** $O(N)$ as it iterates through the array exactly once, looking up items in the map in $O(1)$ time on average.
* **Space Complexity:** $O(N)$ because, in the worst-case scenario, it stores up to $N$ elements in the Hash Map.
### Two pointer Solution
Assume the input is sorted
> [!NOTE]
> **Language:** JavaScript
````js
function pairWithTargetSum(arr, target) {
  let start = 0
  let end = arr.length-1
  
  while(start < end) {
    let currentSum = arr[start] + arr[end]
    
    if(currentSum === target) {
      return [start, end]
    }
    
    if(currentSum < target) {
      start++
    } else {
      end--
    }
  }
  return 0  
}

pairWithTargetSum([1, 2, 3, 4, 6], 6)
//[1,3]

pairWithTargetSum([2, 5, 9, 11], 11)
//[0,2]
````
> [!NOTE]
> **Language:** Java
```java
public class Solution {
    public static int[] pairWithTargetSum(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            int currentSum = arr[start] + arr[end];
            
            if (currentSum == target) {
                return new int[]{start, end};
            }
            
            if (currentSum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1}; // Returns [-1, -1] if no matching pair is found
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] result1 = pairWithTargetSum(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]"); // Output: [1, 3]

        // Test Case 2
        int[] result2 = pairWithTargetSum(new int[]{2, 5, 9, 11}, 11);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]"); // Output: [0, 2]
    }
}

```
- The <b>time complexity</b> of the above algorithm will be `O(N)`, where `N` is the total number of elements in the given array.
- The algorithm runs in constant space `O(1)`.

### ❗ Hash Table Solution 

Instead of using a two-pointer or a binary search approach, we can utilize a <b>HashTable</b> to search for the required pair. We can iterate through the array one number at a time. Let’s say during our iteration we are at number `X`, so we need to find `Y` such that `“X + Y == Target”`. We will do two things here:
1. Search for `Y` (which is equivalent to `“Target - X”`) in the HashTable. If it is there, we have found the required pair.
2. Otherwise, insert `“X”` in the HashTable, so that we can search it for the later numbers.

> [!NOTE]
> **Language:** JavaScript
````js
function pairWithTargetSum(nums, target) {
  //Instead of using a two-pointer or a binary search approach, 
  //we can utilize a HashTable to search for the required pair. 
  //We can iterate through the array one number at a time. 
  //Let’s say during our iteration we are at number ‘X’, 
  //so we need to find ‘Y’ such that “X + Y == Target”. 
  
  //We will do two things here:
  const arr = {}
  for(let i = 0; i < nums.length; i ++){
    let item = nums[i]
     
    if(target - item in arr) {
      //1. Search for ‘Y’ (which is equivalent to “Target - X”) in the HashTable. 
      //If it is there, we have found the required pair
      return [arr[target - item], i]
    }
    arr[nums[i]] = i
    //2. Otherwise, insert “X” in the HashTable, so that we can search it for the later numbers.
  }
  return [-1, -1]
}

pairWithTargetSum([1, 2, 3, 4, 6], 6)//[1, 3]
pairWithTargetSum([2, 5, 9, 11], 11)//[0, 2]
pairWithTargetSum([2, 7, 11, 15], 9)//[0, 1]
pairWithTargetSum([3, 2, 4], 6)//[1, 2]
pairWithTargetSum([3, 3], 6)//[0, 1]
````
> [!NOTE]
> **Language:** Java
```java
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public static int[] pairWithTargetSum(int[] nums, int target) {
        // Using a HashMap as our HashTable
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            int complement = target - item;
            
            // 1. Search for 'Y' (Target - X) in the HashTable
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // 2. Otherwise, insert 'X' with its index into the HashTable
            map.put(item, i);
        }
        
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{1, 2, 3, 4, 6}, 6)));   // [1, 3]
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{2, 5, 9, 11}, 11)));   // [0, 2]
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{2, 7, 11, 15}, 9)));   // [0, 1]
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{3, 2, 4}, 6)));        // [1, 2]
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{3, 3}, 6)));           // [0, 1]
    }
}

```
- The <b>time complexity</b> of the above algorithm will be `O(N)`, where `N` is the total number of elements in the given array.
- The <b>space complexity</b> will also be `O(N)`, as, in the worst case, we will be pushing `N` numbers in the HashTable.
## Remove Duplicates (easy)
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

> Given an array of sorted numbers, <b>remove all duplicates</b> from it. You should <b>not use any extra space</b>; after removing the duplicates </i>in-place</i> return the length of the subarray that has no duplicate in it.

In this problem, we need to remove the duplicates </i>in-place</i> such that the resultant length of the array remains sorted. As the input array is sorted, therefore, one way to do this is to shift the elements left whenever we encounter duplicates. In other words, we will keep one pointer for iterating the array and one pointer for placing the next non-duplicate number. So our algorithm will be to iterate the array and whenever we see a non-duplicate number we move it next to the last non-duplicate number we’ve seen.

<b>Assume the input is sorted</b>

> [!NOTE]
> **Language:** JavaScript
````js
function removeDuplicates(arr) {
  //shift the elements left when we encounter duplicates
  
  //one pointer for iterating
  let i = 1
  
  //one pointer for placing this next non-duplicate
  let nextNonDupe = 1

  while(i < arr.length) {
    if(arr[nextNonDupe -1] !== arr[i]) {
      arr[nextNonDupe] = arr[i]
      nextNonDupe++
    }
    i++
  }
  return nextNonDupe  
}

removeDuplicates([2, 3, 3, 3, 6, 9, 9])
//4, The first four elements after removing the duplicates will be [2, 3, 6, 9].

removeDuplicates([2, 2, 2, 11])
//2, The first two elements after removing the duplicates will be [2, 11].
````

> [!NOTE]
> **Language:** Java
```java
public class Solution {
    public static int removeDuplicates(int[] arr) {
        // Handle empty array edge case safely
        if (arr.length == 0) {
            return 0;
        }

        // Pointer for iterating
        int i = 1;
        
        // Pointer for placing the next non-duplicate element
        int nextNonDupe = 1;

        while (i < arr.length) {
            if (arr[nextNonDupe - 1] != arr[i]) {
                arr[nextNonDupe] = arr[i];
                nextNonDupe++;
            }
            i++;
        }
        return nextNonDupe;  
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {2, 3, 3, 3, 6, 9, 9};
        int length1 = removeDuplicates(arr1);
        System.out.println("Length: " + length1); // Output: 4
        // Array becomes: [2, 3, 6, 9, 6, 9, 9]

        // Test Case 2
        int[] arr2 = {2, 2, 2, 11};
        int length2 = removeDuplicates(arr2);
        System.out.println("Length: " + length2); // Output: 2
        // Array becomes: [2, 11, 2, 11]
    }
}

```
- The <b>time complexity</b> of the above algorithm will be `O(N)`, where `N` is the total number of elements in the given array.
- The algorithm runs in constant space `O(1)`.

### Remove Element
https://leetcode.com/problems/remove-element/

> Given an unsorted array of numbers and a target `key`, remove all instances of `key` </i>in-place</i> and return the new length of the array.

> [!NOTE]
> **Language:** JavaScript
````js
function removeElement(arr, key) {
  //pointed for index of the next element which is not the key
  let nextElement = 0;

  for (i = 0; i < arr.length; i++) {
    if (arr[i] !== key) {
      arr[nextElement] = arr[i];
      nextElement++;
    }
  }
  return nextElement;
}

removeElement([3, 2, 3, 6, 3, 10, 9, 3], 3);
//4
// The array, [2, 6, 10, 9], will have a length of after removing every 'key'.

removeElement([2, 11, 2, 2, 1], 2);
// 2
// The array, [11, 1], will have a length of 2 after removing every 'key'.
````

> [!NOTE]
> **Language:** Java
```java
public class ArrayModifier {
    public static int removeElement(int[] arr, int key) {
        // Points to the index of the next element that is not the key
        int nextElement = 0; 
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }
        
        // Returns the new length of the array after removing 'key'
        return nextElement; 
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {3, 2, 3, 6, 3, 10, 9, 3};
        int length1 = removeElement(arr1, 3); 
        System.out.println(length1); // Output: 4
        
        // Test Case 2
        int[] arr2 = {2, 11, 2, 2, 1};
        int length2 = removeElement(arr2, 2);
        System.out.println(length2); // Output: 2
    }
}

```
- The <b>time complexity</b> of the above algorithm will be `O(N)`, where `N` is the total number of elements in the given array.
- The algorithm runs in constant space `O(1)`.

## Squaring a Sorted Array (easy)
https://leetcode.com/problems/squares-of-a-sorted-array/

This is a straightforward question. The only trick is that we can have negative numbers in the input array, which will make it a bit difficult to generate the output array with squares in sorted order.

An easier approach could be to first find the index of the first non-negative number in the array. After that, we can use <b>Two Pointers</b> to iterate the array. One pointer will move forward to iterate the non-negative numbers, and the other pointer will move backward to iterate the negative numbers. At any step, whichever number gives us a bigger square will be added to the output array. 

Since the numbers at both ends can give us the largest square, an alternate approach could be to use <b>two pointers</b> starting at both ends of the input array. At any step, whichever pointer gives us the bigger square, we add it to the result array and move to the next/previous number according to the pointer. 

> [!NOTE]
> **Language:** JavaScript
````js
function makeSquares(arr) {
  //The only trick is that we can have negative numbers in the input array, which will make it a bit difficult to generate the output array with squares in sorted order.
  //An easier approach could be to first find the index of the first non-negative number in the array. 
  //After that, we can use Two Pointers to iterate the array. 
  //One pointer will move forward to iterate the non-negative numbers
  //the other pointer will move backward to iterate the negative numbers. At any step, whichever number gives us a bigger square will be added to the output array.
  //Since the numbers at both ends can give us the largest square, an alternate approach could be to use two pointers starting at both ends of the input array. At any step, whichever pointer gives us the bigger square, we add it to the result array and move to the next/previous number according to the pointer. 
  
  const n = arr.length;
  let squares = Array(n).fill(0)
  let highestSquareIndex = n - 1
  let start = 0
  let end = n-1
  while(start<= end) {
    let startSquare = arr[start] * arr[start]
    let endSquare = arr[end] * arr[end]
    
    if(startSquare > endSquare) {
      squares[highestSquareIndex]  = startSquare
      start++
    } else {
      squares[highestSquareIndex]  = endSquare
      end--
    }
    highestSquareIndex--
  }
  return squares
}

makeSquares([-2, -1, 0, 2, 3])
//[0, 1, 4, 4, 9]

makeSquares([-3, -1, 0, 1, 2])
//[0, 1, 1, 4, 9]
````
> [!NOTE]
> **Language:** Java
```java
import java.util.Arrays;

public class SortedSquares {
    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIndex = n - 1;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int startSquare = arr[start] * arr[start];
            int endSquare = arr[end] * arr[end];

            if (startSquare > endSquare) {
                squares[highestSquareIndex] = startSquare;
                start++;
            } else {
                squares[highestSquareIndex] = endSquare;
                end--;
            }
            highestSquareIndex--;
        }
        return squares;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {-2, -1, 0, 2, 3};
        int[] result1 = makeSquares(arr1);
        System.out.println(Arrays.toString(result1)); // Output: [0, 1, 4, 4, 9]

        // Test Case 2
        int[] arr2 = {-3, -1, 0, 1, 2};
        int[] result2 = makeSquares(arr2);
        System.out.println(Arrays.toString(result2)); // Output: [0, 1, 1, 4, 9]
    }
}

```
- The above algorithm’s <b>time complexity</b> will be `O(N)` as we are iterating the input array only once.
- The above algorithm’s <b>space complexity</b> will also be `O(N)`; this space will be used for the output array.

## 🌟 Triplet Sum to Zero (medium)
https://leetcode.com/problems/3sum/

> Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

This problem follows the <b>Two Pointers</b> pattern and shares similarities with [Pair with Target Sum](#🌴-pair-with-target-sum-aka-"two-sum"-easy). A couple of differences are that the input array is not sorted and instead of a pair we need to find triplets with a target sum of zero.

To follow a similar approach, first, we will sort the array and then iterate through it taking one number at a time. Let’s say during our iteration we are at number `X`, so we need to find `Y` and `Z` such that `X + Y + Z == 0`. At this stage, our problem translates into finding a pair whose sum is equal to `-X` (as from the above equation `Y + Z == -X`).

Another difference from <b>[Pair with Target Sum](#🌴-pair-with-target-sum-aka-"two-sum"-easy)</b> is that we need to find all the unique triplets. To handle this, we have to skip any duplicate number. Since we will be sorting the array, so all the duplicate numbers will be next to each other and are easier to skip.

> [!NOTE]
> **Language:** JavaScript
````js
function searchTriplets(arr) {
  arr.sort((a, b) => a - b);
  const triplets = [];

  for (i = 0; i < arr.length; i++) {
    if (i > 0 && arr[i] === arr[i - 1]) {
      //skip the same element to avoid dupes
      continue;
    }
    searchPair(arr, -arr[i], i + 1, triplets);
  }
  return triplets;
}

function searchPair(arr, targetSum, start, triplets) {
  let end = arr.length - 1;

  while (start < end) {
    const currentSum = arr[start] + arr[end];
    if (currentSum === targetSum) {
      //found the triplet
      triplets.push([-targetSum, arr[start], arr[end]]);
      start++;
      end--;
      while (start < end && arr[start] === arr[start - 1]) {
        //skip same element to avoid duplicates
        start++;
      }
      while (start < end && arr[end] === arr[end + 1]) {
        //skip same element to avoid duplicates
        end--;
      }
    } else if (targetSum > currentSum) {
      //we need a pair with a bigger sum
      start++;
    } else {
      //we need a pair with a smaller sum
      end--;
    }
  }
}

searchTriplets([-3, 0, 1, 2, -1, 1, -2]); 
//[[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]

searchTriplets([-5, 2, -1, -2, 3]); 
//[[-5, 2, 3], [-2, -1, 3]]
````

> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        // Sort the array in place
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Skip the same element to avoid duplicates
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            searchPair(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int start, List<List<Integer>> triplets) {
        int end = arr.length - 1;

        while (start < end) {
            int currentSum = arr[start] + arr[end];
            if (currentSum == targetSum) {
                // Found the triplet - add it as a list to our results
                triplets.add(Arrays.asList(-targetSum, arr[start], arr[end]));
                start++;
                end--;

                // Skip same element to avoid duplicates from left
                while (start < end && arr[start] == arr[start - 1]) {
                    start++;
                }
                // Skip same element to avoid duplicates from right
                while (start < end && arr[end] == arr[end + 1]) {
                    end--;
                }
            } else if (targetSum > currentSum) {
                // We need a pair with a bigger sum
                start++;
            } else {
                // We need a pair with a smaller sum
                end--;
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {-3, 0, 1, 2, -1, 1, -2};
        System.out.println(searchTriplets(arr1)); 
        // Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]

        // Test Case 2
        int[] arr2 = {-5, 2, -1, -2, 3};
        System.out.println(searchTriplets(arr2)); 
        // Output: [[-5, 2, 3], [-2, -1, 3]]
    }
}

```
- Sorting the array will take `O(N * logN)`. The `searchPair()` function will take `O(N)`. As we are calling `searchPair()` for every number in the input array, this means that overall `searchTriplets()` will take `O(N * logN + N^2)`, which is asymptotically equivalent to `O(N^2)`.
- Ignoring the space required for the output array, the <b>space complexity</b> of the above algorithm will be `O(N)` which is required for sorting.

## Triplet Sum Close to Target (medium)
https://leetcode.com/problems/3sum-closest/

> Given an array of unsorted numbers and a `targetSum`, find a <b>triplet in the array whose sum is as close to the `targetSum` as possible</b>, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

This problem follows the <b>Two Pointers</b> pattern and is quite similar to <b>[Triplet Sum to Zero](#🌟-triplet-sum-to-zero-medium)</b>.

We can follow a similar approach to iterate through the array, taking one number at a time. At every step, we will save the difference between the triplet and the `targetSum`, so that in the end, we can return the triplet with the closest sum.

> [!NOTE]
> **Language:** JavaScript
````js
function tripletSumCloseToTarget(arr, targetSum){
  arr.sort((a, b) => a - b)
  
  let smallestDifference = Infinity
  
  for(let i = 0; i < arr.length - 2; i++) {
    let start = i + 1
    let end = arr.length - 1
    
    while(start < end) {
      const targetDifference = targetSum - arr[i] - arr[start] - arr[end]
      
      if(targetDifference === 0) {
        //we've found a triplet with an exact sum
        //so return the sum of all the numbers
        return targetSum - targetDifference
      }
      
      if(Math.abs(targetDifference) < Math.abs(smallestDifference)) {
        //save the closet difference
        smallestDifference = targetDifference
      }
      //the second part of the followinf 'if' is to handle the smallest sum
      //when we have more than one solution
      if(Math.abs(targetDifference) < Math.abs(smallestDifference) || (Math.abs(targetDifference) === Math.abs(smallestDifference) && targetDifference > smallestDifference)) {
        //save the closest and the biggest difference
        smallestDifference = targetDifference
      }
      
      if(targetDifference > 0) {
        //we need a triplet with a bigger sum
        start++
      } else {
        //we need a triplet with a smaller sum
        end--
      }
    }
  }
  return targetSum - smallestDifference
}

tripletSumCloseToTarget([-2, 0, 1, 2], 2)//1, he triplet [-2, 1, 2] has the closest sum to the target.
tripletSumCloseToTarget([-3, -1, 1, 2], 1)//0, The triplet [-3, 1, 2] has the closest sum to the target.
tripletSumCloseToTarget([1, 0, 1, 1], 100)//3, The triplet [1, 1, 1] has the closest sum to the target.
tripletSumCloseToTarget([-1,2,1,-4], 1)//2, The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
````

> [!NOTE]
> **Language:** Java
```java
import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int tripletSumCloseToTarget(int[] arr, int targetSum) {
        // Sort the array in place
        Arrays.sort(arr);
        
        int smallestDifference = Integer.MAX_VALUE;

        // Loop runs up to arr.length - 2 to leave room for the two pointers
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int targetDifference = targetSum - arr[i] - arr[start] - arr[end];

                // Found a triplet with an exact sum
                if (targetDifference == 0) {
                    return targetSum; // targetSum - 0 is just targetSum
                }

                // Handle updating the smallest difference. 
                // We check if it's a tighter gap, OR if gaps are equal, choose the one yielding a smaller sum (larger targetDifference)
                if (Math.abs(targetDifference) < Math.abs(smallestDifference) || 
                   (Math.abs(targetDifference) == Math.abs(smallestDifference) && targetDifference > smallestDifference)) {
                    smallestDifference = targetDifference;
                }

                if (targetDifference > 0) {
                    // We need a triplet with a bigger sum
                    start++;
                } else {
                    // We need a triplet with a smaller sum
                    end--;
                }
            }
        }
        return targetSum - smallestDifference;
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println(tripletSumCloseToTarget(new int[]{-2, 0, 1, 2}, 2));  // Output: 1
        
        // Test Case 2
        System.out.println(tripletSumCloseToTarget(new int[]{-3, -1, 1, 2}, 1)); // Output: 0
        
        // Test Case 3
        System.out.println(tripletSumCloseToTarget(new int[]{1, 0, 1, 1}, 100)); // Output: 3
        
        // Test Case 4
        System.out.println(tripletSumCloseToTarget(new int Schubert[]{-1, 2, 1, -4}, 1)); // Output: 2
    }
}

```
- Sorting the array will take `O(N* logN)`. Overall, the function will take `O(N * logN + N^2)`, which is asymptotically equivalent to `O(N^2)`
- The above algorithm’s <b>space complexity</b> will be `O(N)`, which is required for sorting.
## Triplets with Smaller Sum (medium)
https://leetcode.com/problems/3sum-smaller/

> Given an array `arr` of unsorted numbers and a `target` sum, count all triplets in it such that `arr[i] + arr[j] + arr[k] < target` where `i`, `j`, and `k` are three different indices. Write a function to return the count of such triplets.

This problem follows the <b>Two Pointers pattern</b> and shares similarities with <b>Triplet Sum to Zero</b>. The only difference is that, in this problem, we need to find the triplets whose sum is less than the given target. To meet the condition `i != j != k` we need to make sure that each number is not used more than once.

Following a similar approach, first, we can sort the array and then iterate through it, taking one number at a time. Let’s say during our iteration we are at number `X`, so we need to find `Y` and `Z` such that `X + Y + Z < target`. At this stage, our problem translates into finding a pair whose sum is less than `“target - X”` (as from the above equation `Y + Z == target - X`). We can use a similar approach as discussed in <b>Triplet Sum to Zero</b>.

> [!NOTE]
> **Language:** JavaScript
````js
function tripletWithSmallerSum (arr, target) {
  arr.sort((a, b) => a -b)
  let count = 0;
  
  for(let i = 0; i < arr.length - 2; i++){
    count += searchPair(arr, target - arr[i], i)
  }
  return count;
};

function searchPair(arr, targetSum, first){
  let count = 0
  let start = first + 1
  let end = arr.length -1
  
  while(start < end) {
    if(arr[start] + arr[end] < targetSum) {
      //we found the a triplet
      //since arr[end] >= arr[start], therefore, we can replace arr[end]
      //by any number between start and end to get a sum less than the targetSum
      count += end - start
      start++
    } else {
      //we need a pair with a smaller sum
      end--
    }
  }
  return count
  
}

tripletWithSmallerSum ([-1, 0, 2, 3], 3)//2, There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
tripletWithSmallerSum ([-1, 4, 2, 1, 3], 5)//4, There are four triplets whose sum is less than the target: [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
tripletWithSmallerSum ([-2,0,1,3], 2)//2, Because there are two triplets which sums are less than 2: [-2,0,1], [-2,0,3]
tripletWithSmallerSum ([], 0)//0
tripletWithSmallerSum ([0], 0)//0
````

> [!NOTE]
> **Language:** Java
```java
import java.util.Arrays;

public class TripletWithSmallerSum {
    public static int tripletWithSmallerSum(int[] arr, int target) {
        // Sort the array in place
        Arrays.sort(arr);
        int count = 0;
        
        // Loop runs up to arr.length - 2 to allow room for the two pointers
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int start = first + 1;
        int end = arr.length - 1;
        
        while (start < end) {
            if (arr[start] + arr[end] < targetSum) {
                // Since the array is sorted, if arr[start] + arr[end] < targetSum,
                // then replacing arr[end] with any element between start and end 
                // will also result in a valid sum.
                count += end - start;
                start++;
            } else {
                // We need a pair with a smaller sum
                end--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println(tripletWithSmallerSum(new int[]{-1, 0, 2, 3}, 3));    // Output: 2
        
        // Test Case 2
        System.out.println(tripletWithSmallerSum(new int[]{-1, 4, 2, 1, 3}, 5)); // Output: 4
        
        // Test Case 3
        System.out.println(tripletWithSmallerSum(new int[]{-2, 0, 1, 3}, 2));    // Output: 2
        
        // Test Case 4
        System.out.println(tripletWithSmallerSum(new int[]{}, 0));               // Output: 0
        
        // Test Case 5
        System.out.println(tripletWithSmallerSum(new int[]{0}, 0));              // Output: 0
    }
}

```
- Sorting the array will take `O(N * logN)`. The `searchPair()` will take `O(N)`. So, overall `searchTriplets()` will take `O(N * logN + N^2)`, which is asymptotically equivalent to `O(N^2)`.
- The <b>space complexity</b> of the above algorithm will be `O(N)` which is required for sorting if we are not using an </i>in-place</i> sorting algorithm.

> Write a function to return the list of all such triplets instead of the count. How will the <b>time complexity</b> change in this case?

> [!NOTE]
> **Language:** JavaScript
````js
function tripletWithSmallerSum (arr, target) {
  arr.sort((a, b) => a -b)
  const triplets = []
  
  for(let i = 0; i < arr.length - 2; i++){
    searchPair(arr, target - arr[i], i, triplets)
  }
  return triplets;
};

function searchPair(arr, targetSum, first, triplets){
  
  let start = first + 1
  let end = arr.length -1
  
  while(start < end) {
    if(arr[start] + arr[end] < targetSum) {
      //we found the a triplet
      //since arr[end] >= arr[start], therefore, we can replace arr[end]
      //by any number between start and end to get a sum less than the targetSum
      for(let i = end; i > start; i--){
        triplets.push(arr[first], arr[start], arr[end])
      }
      start++
    } else {
      //we need a pair with a smaller sum
      end--
    }
  }
}
````

> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSumList {
    public static List<List<Integer>> tripletWithSmallerSum(int[] arr, int target) {
        // Sort the array in place
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        
        for (int i = 0; i < arr.length - 2; i++) {
            searchPair(arr, target - arr[i], i, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {
        int start = first + 1;
        int end = arr.length - 1;
        
        while (start < end) {
            if (arr[start] + arr[end] < targetSum) {
                // Since arr[start] + arr[end] < targetSum, replacing arr[end] 
                // with any element from 'end' down to 'start + 1' is also valid.
                for (int i = end; i > start; i--) {
                    triplets.add(Arrays.asList(arr[first], arr[start], arr[i]));
                }
                start++;
            } else {
                // We need a pair with a smaller sum
                end--;
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {-1, 0, 2, 3};
        System.out.println(tripletWithSmallerSum(arr1, 3));
        // Output: [[-1, 0, 3], [-1, 0, 2]]

        // Test Case 2
        int[] arr2 = {-1, 4, 2, 1, 3};
        System.out.println(tripletWithSmallerSum(arr2, 5));
        // Output: [[-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]]
    }
}

```
- Sorting the array will take `O(N * logN)`. The `searchPair()`, in this case, will take `O(N^2)`; the main while loop will run in `O(N)` but the nested for loop can also take `O(N)` - this will happen when the target sum is bigger than every triplet in the array.  So, overall `searchTriplets()` will take `O(N * logN + N^3)`, which is asymptotically equivalent to `O(N^3)`.
- Ignoring the space required for the output array, the <b>space complexity</b> of the above algorithm will be `O(N)` which is required for sorting.
## 🌟 Subarrays with Product Less than a Target (medium)
https://leetcode.com/problems/subarray-product-less-than-k/

> Given an array with positive numbers and a `targetSum`, find all of its contiguous subarrays whose <b>product is less than the `targetSum`</b>.

This problem follows the <b>Sliding Window</b> and the <b>Two Pointers</b> pattern and shares similarities with <b>[Triplets with Smaller Sum](#triplets-with-smaller-sum-medium)</b> with two differences:
1. In this problem, the input array is not sorted.
2. Instead of finding triplets with sum less than a target, we need to find all subarrays having a product less than the target.
The implementation will be quite similar to <b>[Triplets with Smaller Sum](#triplets-with-smaller-sum-medium)</b>.

> [!NOTE]
> **Language:** JavaScript
````js
function findSubarrays(arr, target) {
  let result = []
  let product = 1
  let start = 0
  
  for(let end = 0; end < arr.length; end++) {
    product *= arr[end]
    while(product >= target && start < arr.length) {
      product /= arr[start]
      start++
    }
    //since the product of all numbers from start to end is less than the target. 
    //Therefore, all subarrays from start to end will have a product less than the target too; 
    //to avoid duplicates, we will start with a subarray containing only arr[end] and then extend it
    const tempList = []
    for(let i = end; i > start -1; i--) {
      tempList.unshift(arr[i])
      result.push(tempList)
    }
  }
  return result
}

findSubarrays([2, 5, 3, 10], 30)//[2], [5], [2, 5], [3], [5, 3], [10] There are six contiguous subarrays whose product is less than the target.
findSubarrays([8, 2, 6, 5], 50)//[8], [2], [8, 2], [6], [2, 6], [5], [6, 5] There are seven contiguous subarrays whose product is less than the target.
findSubarrays([10, 5, 2, 6], 100)//The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
````

> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanTarget {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        double product = 1; // Using double to prevent integer overflow for large products
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            product *= arr[end];
            
            // Shrink the window until the product is less than the target
            while (product >= target && start <= end) {
                product /= arr[start];
                start++;
            }

            // Since the product of all numbers from start to end is less than the target,
            // all subarrays ending at 'end' and starting from anywhere between 'start' and 'end' 
            // will also have a product less than the target.
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = end; i >= start; i--) {
                tempList.addFirst(arr[i]); // Equivalent to JS unshift()
                
                // We create a new copy of the current state of tempList and add it to the result
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {2, 5, 3, 10};
        System.out.println(findSubarrays(arr1, 30));
        // Output: [[2], [5], [2, 5], [3], [5, 3], [10]]

        // Test Case 2
        int[] arr2 = {8, 2, 6, 5};
        System.out.println(findSubarrays(arr2, 50));
        // Output: [[8], [2], [8, 2], [6], [2, 6], [5], [6, 5]]

        // Test Case 3
        int[] arr3 = {10, 5, 2, 6};
        System.out.println(findSubarrays(arr3, 100));
        // Output: [[10], [5], [10, 5], [2], [5, 2], [6], [2, 6], [5, 2, 6]]
    }
}

```

- The main for-loop managing the sliding window takes `O(N)` but creating subarrays can take up to `O(N^2)` in the worst case. Therefore overall, our algorithm will take `O(N^3)`.
- Ignoring the space required for the output list, the algorithm runs in `O(N)` space which is used for the temp list.

## Dutch National Flag Problem (medium)
https://leetcode.com/problems/sort-colors/

> Given an array containing `0`s, `1`s and `2`s, sort the array </i>in-place</i>. You should treat numbers of the array as objects, hence, we can’t count `0`s, `1`s, and `2`s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called <b>Dutch National Flag problem</b>.

The brute force solution will be to use an <i>in-place</i> sorting algorithm like <i>Heapsort</i> which will take `O(N*logN)`. Can we do better than this? Is it possible to sort the array in one iteration?

We can use a <b>Two Pointers</b> approach while iterating through the array. Let’s say the <b>two pointers</b> are called `low` and `high` which are pointing to the first and the last element of the array respectively. So while iterating, we will move all `0`s before `low` and all `2`s after `high` so that in the end, all `1`s will be between `low` and `high`.

> [!NOTE]
> **Language:** JavaScript
````js
function dutchFlagSort(arr) {
  //all elements < low are 0, and all elements > high are 2
  //all elements >= low < i are 1
  let low = 0
  let high = arr.length - 1
  let i = 0
  
  while(i <= high) {
    if(arr[i] === 0) {
      //swap
      //[arr[i], arr[low]] = [arr[low], arr[i]]
      let temp = arr[i]
      arr[i] = arr[low]
      arr[low] = temp
      //increment i and low
      i++
      low++
    } else if(arr[i] === 1){
      i++
    } else{
      //the case for arr[i] === 2
      //swap
      // [arr[i], arr[high]] = [arr[high], arr[i]]
      temp = arr[i]
      arr[i] = arr[high]
      arr[high] = temp
      //decrement high only, after the swap the number
      //at index i could be 0, 1, or 2
      high--
    }
  }
  return arr
}

console.log(dutchFlagSort([1, 0, 2, 1, 0]))//[0 0 1 1 2]
console.log(dutchFlagSort([2, 2, 0, 1, 2, 0]))//[0 0 1 2 2 2 ]
````

> [!NOTE]
> **Language:** Java
```java
import java.util.Arrays;

public class DutchNationalFlag {
    
    public static int[] dutchFlagSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int i = 0;
        
        while (i <= high) {
            if (arr[i] == 0) {
                // Swap arr[i] and arr[low]
                int temp = arr[i];
                arr[i] = arr[low];
                arr[low] = temp;
                
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // Case for arr[i] == 2
                // Swap arr[i] and arr[high]
                int temp = arr[i];
                arr[i] = arr[high];
                arr[high] = temp;
                
                // Do not increment i, as the swapped element needs validation
                high--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 0, 2, 1, 0};
        System.out.println(Arrays.toString(dutchFlagSort(test1))); // [0, 0, 1, 1, 2]

        int[] test2 = {2, 2, 0, 1, 2, 0};
        System.out.println(Arrays.toString(dutchFlagSort(test2))); // [0, 0, 1, 2, 2, 2]
    }
}

```
- The <b>time complexity</b> of the above algorithm will be `O(N)` as we are iterating the input array only once.
- The algorithm runs in constant space `O(1)`.

## 🌟 Quadruple Sum to Target (medium)
https://leetcode.com/problems/4sum/

> Given an array of unsorted numbers and a `targetSum`, find all <b>unique quadruplets</b> in it, whose <b>sum is equal to the `targetSum`</b>.

This problem follows the <b>Two Pointers</b> pattern and shares similarities with <b>[Triplet Sum to Zero](#🌟-triplet-sum-to-zero-medium)</b>.

We can follow a similar approach to iterate through the array, taking one number at a time. At every step during the iteration, we will search for the quadruplets similar to <b>Triplet Sum to Zero</b> whose sum is equal to the given `target`.

> [!NOTE]
> **Language:** JavaScript
````js
function searchQuads (arr, target) {
  //sort the array
  arr.sort((a,b) => a -b)
  
  let quads = []
   
  for(let i = 0; i < arr.length-3; i++) {
    //skip the same element to avoid duplicate quadruplets
    if(i > 0 && arr[i] === arr[i-1]) {
      continue
    }
    for(let j = i +1; j < arr.length-2; j++) {
      //skip the same element to avoid duplicate quadruplets
      if(j > i + 1 && arr[j] === arr[j-1]){
        continue
      }
      searchPairs(arr, target, i, j, quads)
    }
  }
  return quads
}

function searchPairs(arr, targetSum, first, second, quads) {
  let start = second + 1
  let end = arr.length -1
  
  while(start < end) {
    const sum = arr[first] + arr[second] + arr[start] + arr[end]
    if(sum === targetSum) {
      //found the quadruplet
      quads.push([arr[first], arr[second], arr[start], arr[end]])
      start++
      end--
      while(start < end && arr[start] === arr[start -1]){
        //skip the same element to avoid duplicate quadruplets
        start++
      }
      while(start < end && arr[end] === arr[end -1]){
        //skip the same element to avoid duplicate quadruplets
        end--
      }
    } else if(sum < targetSum) {
      //we need a pair with a bigger sum
      start++
    } else {
      //we need a pair with a smaller sum
      end--
    }
  }
}

searchQuads([4,1,2,-1,1,-3], 1)//-3, -1, 1, 4], [-3, 1, 1, 2]
searchQuads([2,0,-1,1,-2,2], 2)//[-2, 0, 2, 2], [-1, 0, 1, 2]
````

> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> searchQuads(int[] arr, int target) {
        // Sort the array to use two-pointer technique
        Arrays.sort(arr);
        List<List<Integer>> quads = new ArrayList<>();

        for (int i = 0; i < arr.length - 3; i++) {
            // Skip the same element to avoid duplicate quadruplets
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < arr.length - 2; j++) {
                // Skip the same element to avoid duplicate quadruplets
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                searchPairs(arr, target, i, j, quads);
            }
        }
        return quads;
    }

    private static void searchPairs(int[] arr, int targetSum, int first, int second, List<List<Integer>> quads) {
        int start = second + 1;
        int end = arr.length - 1;

        while (start < end) {
            // Note: If working with extreme inputs, use long to avoid integer overflow:
            // long sum = (long)arr[first] + arr[second] + arr[start] + arr[end];
            int sum = arr[first] + arr[second] + arr[start] + arr[end];

            if (sum == targetSum) {
                // Found the quadruplet
                quads.add(Arrays.asList(arr[first], arr[second], arr[start], arr[end]));
                start++;
                end--;

                // Skip the same elements to avoid duplicate quadruplets
                while (start < end && arr[start] == arr[start - 1]) {
                    start++;
                }
                while (start < end && arr[end] == arr[end + 1]) { // Fixed index lookback logic for 'end' pointer tracking
                    end--;
                }
            } else if (sum < targetSum) {
                // We need a pair with a bigger sum
                start++;
            } else {
                // We need a pair with a smaller sum
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2, -1, 1, -3};
        System.out.println(searchQuads(arr1, 1)); 
        // Expected Outputs: [[-3, -1, 1, 4], [-3, 1, 1, 2]]

        int[] arr2 = {2, 0, -1, 1, -2, 2};
        System.out.println(searchQuads(arr2, 2)); 
        // Expected Outputs: [[-2, 0, 2, 2], [-1, 0, 1, 2]]
    }
}

```
- Sorting the array will take `O(N*logN)`. Overall `searchQuads()` will take `O(N * logN + N³)`, which is asymptotically equivalent to `O(N³)`.
- The <b>space complexity</b> of the above algorithm will be `O(N)` which is required for sorting.
## 🌟 Comparing Strings containing Backspaces (medium)
https://leetcode.com/problems/backspace-string-compare/
>Given two strings containing backspaces (identified by the character `#`), check if the two strings are equal.

To compare the given strings, first, we need to apply the backspaces. An efficient way to do this would be from the end of both the strings. We can have separate pointers, pointing to the last element of the given strings. We can start comparing the characters pointed out by both the pointers to see if the strings are equal. If, at any stage, the character pointed out by any of the pointers is a backspace (`#`), we will skip and apply the backspace until we have a valid character available for comparison.

> [!NOTE]
> **Language:** JavaScript
````js
function backspaceCompare(str1, str2) {
  //use two pointer approach to compare the strings
  let pointerOne = str1.length -1
  let pointerTwo = str2.length -1
  
  while(pointerOne >= 0 || pointerTwo >= 0){
    let i = getNextChar(str1, pointerOne)
    let j = getNextChar(str2, pointerTwo)
    
    if(i < 0 && j < 0){
      //reached the end of both strings
      return true
    } 
     if(i < 0 || j < 0){
      //reached the end of both strings
      return false
    } 
    if(str1[i] !== str2[j]){
      //check if the characters are equal
      return false
    }
    pointerOne = i - 1
    pointerTwo = j -1
  }
  return true
}


function getNextChar(str, index) {
  let backspaceCount = 0
  while(index >= 0) {
    if(str[index] === '#'){
      //found a backspace character
      backspaceCount++
    } else if(backspaceCount > 0) {
      //a non-backspace character
      backspaceCount--
    } else {
      break
    }
    //skip a backspace or valid character
    index--
  }
  return index
}

backspaceCompare("xy#z", "xzz#")//true, After applying backspaces the strings become "xz" and "xz" respectively.
backspaceCompare("xy#z", "xyz#")//false, After applying backspaces the strings become "xz" and "xy" respectively.
backspaceCompare("xp#", "xyz##")//true, After applying backspaces the strings become "x" and "x" respectively.  In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
backspaceCompare("xywrrmp", "xywrrmu#p")//true, After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
````

> [!NOTE]
> **Language:** Java
```java
public class BackspaceStringCompare {

    public static boolean backspaceCompare(String str1, String String2) {
        // Use two pointer approach to compare the strings
        int pointerOne = str1.length() - 1;
        int pointerTwo = String2.length() - 1;

        while (pointerOne >= 0 || pointerTwo >= 0) {
            int i = getNextChar(str1, pointerOne);
            int j = getNextChar(String2, pointerTwo);

            // Reached the end of both strings
            if (i < 0 && j < 0) {
                return true;
            }
            // Reached the end of one string early
            if (i < 0 || j < 0) {
                return false;
            }
            // Check if the characters are equal
            if (str1.charAt(i) != String2.charAt(j)) {
                return false;
            }
            
            pointerOne = i - 1;
            pointerTwo = j - 1;
        }
        return true;
    }

    private static int getNextChar(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                // Found a backspace character
                backspaceCount++;
            } else if (backspaceCount > 0) {
                // A non-backspace character
                backspaceCount--;
            } else {
                break;
            }
            // Skip a backspace or valid character
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("xy#z", "xzz#"));       // true
        System.out.println(backspaceCompare("xy#z", "xyz#"));       // false
        System.out.println(backspaceCompare("xp#", "xyz##"));       // true
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p")); // true
    }
}

```
- The <b>time complexity</b> of the above algorithm will be `O(M+N)` where `M` and `N` are the lengths of the two input strings respectively.
- The algorithm runs in constant space `O(1)`.

## 🌟 Minimum Window Sort (medium)
https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

> Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

As we know, once an array is sorted (in ascending order), the smallest number is at the beginning and the largest number is at the end of the array. So if we start from the beginning of the array to find the first element which is out of sorting order i.e., which is smaller than its previous element, and similarly from the end of array to find the first element which is bigger than its previous element, will sorting the subarray between these two numbers result in the whole array being sorted?

Let’s try to understand this with the Example mentioned above. In the following array, what are the first numbers out of sorting order from the beginning and the end of the array:

````
[1, 3, 2, 0, -1, 7, 10]
````
Starting from the beginning of the array the first number out of the sorting order is `2` as it is smaller than its previous element which is `3`.
Starting from the end of the array the first number out of the sorting order is `0` as it is bigger than its previous element which is `-1`

As you can see, sorting the numbers between `3` and `-1` will not sort the whole array. To see this, the following will be our original array after the sorted subarray:
````
[1, -1, 0, 2, 3, 7, 10]
````
The problem here is that the smallest number of our subarray is `-1` which dictates that we need to include more numbers from the beginning of the array to make the whole array sorted. We will have a similar problem if the maximum of the subarray is bigger than some elements at the end of the array. To sort the whole array we need to include all such elements that are smaller than the biggest element of the subarray. So our final algorithm will look like:
1. From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subarray.
2. Find the maximum and minimum of this subarray.
3. Extend the subarray from beginning to include any number which is bigger than the minimum of the subarray.
4. Similarly, extend the subarray from the end to include any number which is smaller than the maximum of the subarray.

> [!NOTE]
> **Language:** JavaScript
````js
function shortestWindowSort(arr) {
  let low = 0
  let high = arr.length - 1
  
  //find the first number out of sorting order from the beginning
  while(low < arr.length -1 && arr[low] <= arr[low+1]){
    low++
  }
  if(low === arr.length - 1) {
    // if the array is already sorted
    return 0
  }
  //find the first number out of sorting order from the end
  while(high > 0 && arr[high] >= arr[high - 1]){
    high--
  }
  
  //find the max and min of the subarray
  let subArrayMax = -Infinity
  let subArrayMin = Infinity
  
  for(let k = low; k < high + 1; k++) {
    subArrayMax = Math.max(subArrayMax, arr[k])
    subArrayMin = Math.min(subArrayMin, arr[k])
  }
  
  //extend the subarray to include any number which is bigger than the minumum of the subarray
  while(low > 0 && arr[low -1] > subArrayMin) {
    low--
  }
  //extend the subarray to include any number which is small than the maximum of the subarray
  while(high < arr.length - 1 && arr[high + 1] < subArrayMax){
    high++
  }
  
  return high - low + 1
}

shortestWindowSort([1,2,5,3,7,10,9,12])
//5, We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted

shortestWindowSort([1,3,2,0,-1,7,10])
//5, We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted

shortestWindowSort([1,2,3])
//0, The array is already sorted

shortestWindowSort([3,2,1])
// 3, The whole array needs to be sorted.
````

> [!NOTE]
> **Language:** Java
```java
public class ShortestWindowSort {

    public static int shortestWindowSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        // Find the first number out of sorting order from the beginning
        while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }
        
        // If the array is already sorted
        if (low == arr.length - 1) {
            return 0;
        }
        
        // Find the first number out of sorting order from the end
        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }
        
        // Find the max and min of the subarray
        int subArrayMax = Integer.MIN_VALUE;
        int subArrayMin = Integer.MAX_VALUE;
        
        for (int k = low; k <= high; k++) {
            subArrayMax = Math.max(subArrayMax, arr[k]);
            subArrayMin = Math.min(subArrayMin, arr[k]);
        }
        
        // Extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low - 1] > subArrayMin) {
            low--;
        }
        
        // Extend the subarray to include any number which is smaller than the maximum of the subarray
        while (high < arr.length - 1 && arr[high + 1] < subArrayMax) {
            high++;
        }
        
        return high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println(shortestWindowSort(new int[]{1, 2, 5, 3, 7, 10, 9, 12})); // 5
        System.out.println(shortestWindowSort(new int[]{1, 3, 2, 0, -1, 7, 10}));    // 5
        System.out.println(shortestWindowSort(new int[]{1, 2, 3}));                 // 0
        System.out.println(shortestWindowSort(new int[]{3, 2, 1}));                 // 3
    }
}

```
- The <b>time complexity</b> of the above algorithm will be `O(N)`.
- The algorithm runs in constant space `O(1)`.
