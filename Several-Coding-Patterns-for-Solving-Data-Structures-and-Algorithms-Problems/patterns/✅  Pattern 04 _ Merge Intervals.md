# Pattern 4 : Merge Intervals
This pattern describes an efficient technique to deal with overlapping intervals. In a lot of problems involving intervals, we either need to find overlapping intervals or merge intervals if they overlap.

Given two intervals (`a` and `b`), there will be six different ways the two intervals can relate to each other:
1. `a` and `b`do not overlap
2. `a` and `b` overlap, `b` ends after `a`
3. `a` completely overlaps `b`
4. `a` and `b` overlap, `a` ends after `b`
5. `b` completly overlaps `a`
6. `a` and `b` do not overlap

Understanding the above six cases will help us in solving all intervals related problems.
![](./images/mergeintervals.png)

## Merge Intervals (medium)
https://leetcode.com/problems/merge-intervals/

> Given a list of intervals, <b>merge all the overlapping intervals</b> to produce a list that has only mutually exclusive intervals.

Our goal is to merge the intervals whenever they overlap. 
The diagram above clearly shows a merging approach. Our algorithm will look like this:

1. Sort the intervals on the `startTime` to ensure `a.start <= b.start`
2. If `a` overlaps `b` (i.e. `b.start <= a.end`), we need to merge them into a new interval `c` such that:
````
    c.start = a.start
    c.end = max(a.end, b.end)
````
We will keep repeating the above two steps to merge `c` with the next interval if it overlaps with `c`.

> [!NOTE]
> **Language:** JavaScript

````js
class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }

  get_interval() {
    return "[" + this.start + ", " + this.end + "]";
  }
}

function merge (intervals) {
  if(intervals.length < 2) {
    return intervals
  }
  
  //sort the intervals on the startTime
  intervals.sort((a,b) => a.start - b.start)
  const mergedIntervals = []
  
  let start = intervals[0].start
  let end = intervals[0].end
  
  for(let i = 1; i < intervals.length; i++) {
    const interval = intervals[i]
    if(interval.start <= end) {
      //overlapping intervals, adjust the end
      end = Math.max(interval.end, end)    
    } else {
      //non-overlapping intercal, add the precious interval and reset
      mergedIntervals.push(new Interval(start, end))
      start = interval.start
      end = interval.end
    }
  }
  //add the last interval
  mergedIntervals.push(new Interval(start, end))
  return mergedIntervals;
};

merged_intervals = merge([new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)
//Output: [[1,5], [7,9]]
//Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].


merged_intervals = merge([new Interval(6, 7), new Interval(2, 4), new Interval(5, 9)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)
//Output: [[2,4], [5,9]]
//Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].


merged_intervals = merge([new Interval(1, 4), new Interval(2, 6), new Interval(3, 5)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)
//Output: [[1,6]]
//Explanation: Since all the given intervals overlap, we merged them into one.
````
> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String getInterval() {
        return "[" + this.start + ", " + this.end + "]";
    }
}

public class Main {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }

        // 1. Sort the intervals by their start time
        intervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        
        // 2. Initialize tracking variables with the first interval
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            if (current.start <= end) {
                // Overlapping intervals: extend the end if necessary
                end = Math.max(current.end, end);
            } else {
                // Non-overlapping interval: commit the previous interval and reset tracker
                mergedIntervals.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }

        // 3. Add the final tracked interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        // Test Case 1
        List<Interval> input1 = Arrays.asList(new Interval(1, 4), new Interval(2, 5), new Interval(7, 9));
        printResults(merge(input1)); // Output: [[1, 5], [7, 9]]

        // Test Case 2
        List<Interval> input2 = Arrays.asList(new Interval(6, 7), new Interval(2, 4), new Interval(5, 9));
        printResults(merge(input2)); // Output: [[2, 4], [5, 9]]

        // Test Case 3
        List<Interval> input3 = Arrays.asList(new Interval(1, 4), new Interval(2, 6), new Interval(3, 5));
        printResults(merge(input3)); // Output: [[1, 6]]
    }

    private static void printResults(List<Interval> intervals) {
        StringBuilder result = new StringBuilder();
        for (Interval inv : intervals) {
            result.append(inv.getInterval()).append(" ");
        }
        System.out.println("Merged intervals: " + result.toString().trim());
    }
}

```
#### OR 
> [!NOTE]
> **Language:** JavaScript
````js
function merge(intervals) {
  if(intervals.length < 2) return intervals
  
  //sort
  intervals.sort((a,b) => a[0]-b[0])
  
  for(let i = 1; i < intervals.length; i++) {
    let current = intervals[i]
    let previous = intervals[i-1]
    
    if(current[0] <= previous[1]) {
      intervals[i] = [previous[0], Math.max(previous[1], current[1])]
      intervals.splice(i-1, 1)
      i--
    }
  }
  
  return intervals
}

merge([[1,4], [2,5], [7,9]])//[[1,5], [7,9]], Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
merge([[6,7], [2,4], [5,9]])//[[2,4], [5,9]], Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
merge([[1,4], [2,6], [3,5]])//[[1,6]], Since all the given intervals overlap, we merged them into one.
merge([[2,5]])
````
> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        // 1. Sort the 2D array by the start times (index 0)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();
        
        // 2. Initialize tracking with the very first interval
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // If the next interval's start overlaps with the current interval's end
            if (nextInterval[0] <= currentInterval[1]) {
                // Merge them by updating the end boundary in place
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // Non-overlapping: move the tracking pointer to the new interval
                currentInterval = nextInterval;
                mergedList.add(currentInterval);
            }
        }

        // 3. Convert the list back into a primitive 2D array
        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] test1 = {{1, 4}, {2, 5}, {7, 9}};
        System.out.println(Arrays.deepToString(merge(test1))); // [[1, 5], [7, 9]]

        // Test Case 2
        int[][] test2 = {{6, 7}, {2, 4}, {5, 9}};
        System.out.println(Arrays.deepToString(merge(test2))); // [[2, 4], [5, 9]]

        // Test Case 3
        int[][] test3 = {{1, 4}, {2, 6}, {3, 5}};
        System.out.println(Arrays.deepToString(merge(test3))); // [[1, 6]]
    }
}

```
- The time complexity of the above algorithm is `O(N * logN)`, where `N` is the total number of intervals. We are iterating the intervals only once which will take `O(N)`, in the beginning though, since we need to sort the intervals, our algorithm will take `O(N * logN)`.
- The space complexity of the above algorithm will be `O(N)` as we need to return a list containing all the merged intervals. We will also need `O(N)` space for sorting

>  Given a set of intervals, find out if any two intervals overlap.
````
Intervals: [[1,4], [2,5], [7,9]]
Output: true
Explanation: Intervals [1,4] and [2,5] overlap
````

 We can follow the same approach as discussed above to find if any two intervals overlap.
 > [!NOTE]
> **Language:** JavaScript
 ````js
 function anyOverlap(intervals) {
  //edge cases?
  if(intervals.length < 2) return false
  
  //already sorted?
  intervals.sort((a, b) => a[0] - b[0])
  
  for(let i = 1; i < intervals.length; i++) {
    let current = intervals[i]
    let previous = intervals[i-1]
   if(current[0] <= previous[1]) return true
  }
  
  return false
}

anyOverlap([[1,4], [2,5], [7,9]])//true, Intervals [1,4] and [2,5] overlap
anyOverlap([[1,2], [3,4], [5,6]])
anyOverlap([[1,2]])
 ````
 > [!NOTE]
> **Language:** Java
```java
import java.util.Arrays;

public class Main {
    public static boolean anyOverlap(int[][] intervals) {
        // 1. Handle edge cases where no overlap is possible
        if (intervals == null || intervals.length < 2) {
            return false;
        }

        // 2. Sort the intervals by their start time (index 0)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a, b));

        // 3. Linear scan with early exit (short-circuit)
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] previous = intervals[i - 1];

            // If current start is less than or equal to previous end
            if (current <= previous) {
                return true; // Overlap detected immediately
            }
        }

        return false; // Traversed the entire list with no overlaps found
    }

    public static void main(String[] args) {
        // Test Case 1: True
        int[][] test1 = {{1, 4}, {2, 5}, {7, 9}};
        System.out.println("Test 1 Overlaps: " + anyOverlap(test1)); // true

        // Test Case 2: False
        int[][] test2 = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println("Test 2 Overlaps: " + anyOverlap(test2)); // false

        // Test Case 3: False (single interval)
        int[][] test3 = {{1, 2}};
        System.out.println("Test 3 Overlaps: " + anyOverlap(test3)); // false
    }
}

```
 ## Insert Interval (medium)
 https://leetcode.com/problems/insert-interval/
 
 > Given a list of non-overlapping intervals sorted by their `startTime`, <b>insert a given interval at the correct position</b> and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

If the given list was not sorted, we could have simply appended the new interval to it and used the `merge()` function from <b>Merge Intervals</b>. But since the given list is sorted, we should try to come up with a solution better than `O(N * logN)`

When inserting a new interval in a sorted list, we need to first find the correct index where the new interval can be placed. In other words, we need to skip all the intervals which end before the start of the new interval. So we can iterate through the given sorted listed of intervals and skip all the intervals with the following condition:
`intervals[i].end < newInterval.start`
Once we have found the correct place, we can follow an approach similar to <b>Merge Intervals</b> to insert and/or merge the new interval. Let’s call the new interval `a` and the first interval with the above condition `b`. There are five possibilities:

The diagram above clearly shows the merging approach. To handle all four merging scenarios, we need to do something like this:
````
    c.start = min(a.start, b.start)
    c.end = max(a.end, b.end)
````
Our overall algorithm will look like this:

1. Skip all intervals which end before the start of the new interval, i.e., skip all `intervals` with the following condition:
````
    intervals[i].end < newInterval.start
````
2. Let’s call the last interval `b` that does not satisfy the above condition. If `b` overlaps with the new interval `a` (i.e. `b.start <= a.end`), we need to merge them into a new interval `c`:
````
    c.start = min(a.start, b.start)
    c.end = max(a.end, b.end)
````
3. We will repeat the above two steps to merge `c` with the next overlapping interval.

> [!NOTE]
> **Language:** JavaScript
````js
class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }

  print_interval() {
    process.stdout.write(`[${this.start}, ${this.end}]`);
  }
}

function insert (intervals, newInterval) {
  let merged = [];
  let i = 0
  
  //skip and add to output all intervals that come before the newInterval
  while(i < intervals.length && intervals[i].end < newInterval.start) {
    merged.push(intervals[i])
    i++
  }
  
  // merge all intervals that overlap with newInterval
  while(i < intervals.length && intervals[i].start <= newInterval.end) {
    newInterval.start = Math.min(intervals[i].start, newInterval.start)
    newInterval.end = Math.max(intervals[i].end, newInterval.end)
    i++
  }
  
  //insert the newInterval
  merged.push(newInterval)
  
  //add all the remaining intervals to the output
  while(i < intervals.length) {
    merged.push(intervals[i])
    i++
  }
  return merged;
};

//Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
// Output: [[1,3], [4,7], [8,12]]
// Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
process.stdout.write('Intervals after inserting the new interval: ');
let result = insert([
  new Interval(1, 3),
  new Interval(5, 7),
  new Interval(8, 12),
], new Interval(4, 6));
for (i = 0; i < result.length; i++) {
  result[i].print_interval();
}
console.log();

// Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
// Output: [[1,3], [4,12]]
// Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
process.stdout.write('Intervals after inserting the new interval: ');
result = insert([
  new Interval(1, 3),
  new Interval(5, 7),
  new Interval(8, 12),
], new Interval(4, 10));
for (i = 0; i < result.length; i++) {
  result[i].print_interval();
}
console.log();

// Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
// Output: [[1,4], [5,7]]
// Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
process.stdout.write('Intervals after inserting the new interval: ');
result = insert([new Interval(2, 3),
  new Interval(5, 7),
], new Interval(1, 4));
for (i = 0; i < result.length; i++) {
  result[i].print_interval();
}
console.log();
````
> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;

    // Constructor
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // Method to print the interval
    void printInterval() {
        System.out.print("[" + this.start + ", " + this.end + "]");
    }
}

public class Main {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> merged = new ArrayList<>();
        int i = 0;

        // Skip and add to output all intervals that come before the newInterval
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            merged.add(intervals.get(i));
            i++;
        }

        // Merge all intervals that overlap with newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        // Insert the newInterval
        merged.add(newInterval);

        // Add all the remaining intervals to the output
        while (i < intervals.size()) {
            merged.add(intervals.get(i));
            i++;
        }

        return merged;
    }

    public static void main(String[] args) {
        // Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
        // Output: [[1,3], [4,7], [8,12]]
        System.out.print("Intervals after inserting the new interval: ");
        List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(1, 3));
        intervals1.add(new Interval(5, 7));
        intervals1.add(new Interval(8, 12));

        List<Interval> result = insert(intervals1, new Interval(4, 6));
        for (Interval interval : result) {
            interval.printInterval();
        }
        System.out.println();

        // Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
        // Output: [[1,3], [4,12]]
        System.out.print("Intervals after inserting the new interval: ");
        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1, 3));
        intervals2.add(new Interval(5, 7));
        intervals2.add(new Interval(8, 12));

        result = insert(intervals2, new Interval(4, 10));
        for (Interval interval : result) {
            interval.printInterval();
        }
        System.out.println();

        // Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
        // Output: [[1,4], [5,7]]
        System.out.print("Intervals after inserting the new interval: ");
        List<Interval> intervals3 = new ArrayList<>();
        intervals3.add(new Interval(2, 3));
        intervals3.add(new Interval(5, 7));

        result = insert(intervals3, new Interval(1, 4));
        for (Interval interval : result) {
            interval.printInterval();
        }
        System.out.println();
    }
}

```
#### OR
> [!NOTE]
> **Language:** JavaScript

````js
function insert(intervals, newInterval) {
  let merged = []
  
  let i = 0
  
  //skip and add to output all intervals that come before the newInterval
  while(i < intervals.length && intervals[i][1] < newInterval[0]) {
    merged.push(intervals[i])
    i++
  }
  
  //merge all intervals that overlap with newInterval
  while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
    newInterval[0] = Math.min(intervals[i][0], newInterval[0])
    newInterval[1] = Math.max(intervals[i][1], newInterval[1])
    i++
  }
  
  //insert the newInterval
  merged.push(newInterval)
  
  //add the remaining intervals to the output
  while(i < intervals.length) {
    merged.push(intervals[i])
    i++
  }
  
  return merged
}

insert([[1,3], [5,7], [8,12]], [4,6])//[[1,3], [4,7], [8,12]], After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
insert([[1,3], [5,7], [8,12]], [4,10])// [[1,3], [4,12]], After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
insert([[2,3],[5,7]], [1,4])//[[1,4], [5,7]], After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
````
> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalInserter {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Skip and add to output all intervals that come before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // 2. Merge all intervals that overlap with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        // Insert the merged newInterval
        merged.add(newInterval);

        // 3. Add the remaining intervals to the output
        while (i < n) {
            merged.add(intervals[i]);
            i++;
        }

        // Convert the dynamic list back to a 2D primitive int array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] intervals1 = {{1, 3}, {{5, 7}, {8, 12}};
        int[] newInterval1 = {4, 6};
        System.out.println(Arrays.deepToString(insert(intervals1, newInterval1)));
        // Output: [[1, 3], [4, 7], [8, 12]]

        // Test Case 2
        int[][] intervals2 = {{1, 3}, {5, 7}, {8, 12}};
        int[] newInterval2 = {4, 10};
        System.out.println(Arrays.deepToString(insert(intervals2, newInterval2)));
        // Output: [[1, 3], [4, 12]]

        // Test Case 3
        int[][] intervals3 = {{2, 3}, {5, 7}};
        int[] newInterval3 = {1, 4};
        System.out.println(Arrays.deepToString(insert(intervals3, newInterval3)));
        // Output: [[1, 4], [5, 7]]
    }
}

```
- As we are iterating through all the intervals only once, the time complexity of the above algorithm is `O(N)`, where `N` is the total number of intervals.
- The space complexity of the above algorithm will be `O(N)` as we need to return a list containing all the merged intervals.

## Intervals Intersection (medium)
https://leetcode.com/problems/interval-list-intersections/

> Given two lists of intervals, find the <b>intersection of these two lists</b>. Each list consists of <b>disjoint intervals sorted on their `startTime`</b>.

This problem follows the [Merge Intervals pattern](#pattern-4--merge-intervals). As we have discussed under <b>Insert Interval</b>, there are five overlapping possibilities between two intervals`a` and `b`. A close observation will tell us that whenever the two intervals overlap, one of the interval’s `startTime` lies within the other interval. This rule can help us identify if any two intervals overlap or not.

![](./images/mergeintervals.png)

Now, if we have found that the two intervals overlap, how can we find the overlapped part?

Again from the above diagram, the overlapping interval will be equal to:

    start = max(a.start, b.start)
    end = min(a.end, b.end) 
That is, the highest `startTime` and the lowest `endTime` will be the overlapping interval.

So our algorithm will be to iterate through both the lists together to see if any two intervals overlap. If two intervals overlap, we will insert the overlapped part into a result list and move on to the next interval which is finishing early.

> [!NOTE]
> **Language:** JavaScript
````js
function findIntersection(firstIntervals, secondIntervals) {
  let result = []
  
  let i = 0
  let j = 0
  
  while(i < firstIntervals.length && j < secondIntervals.length) {
    //check if intervals overlap and firstIntervals[i] start time
    //lies within the other secondIntervals[j]
    let firstOverlapsSecond = firstIntervals[i][0] >= secondIntervals[j][0] && firstIntervals[i][0] <= secondIntervals[j][1]
    
    //check if intervals overlap and firstIntervals[j]'s start time 
    //lies within the other secondInterval[i]
    let secondOverlapsFirst = secondIntervals[j][0] >= firstIntervals[i][0] && secondIntervals[j][0] <= firstIntervals[i][1]
    
    //store the intersection part
    if(firstOverlapsSecond || secondOverlapsFirst) {
      result.push([Math.max(firstIntervals[i][0], secondIntervals[j][0]), Math.min(firstIntervals[i][1], secondIntervals[j][1])])
    }
    
    //move next from the interval which is finishing first
    if(firstIntervals[i][1] < secondIntervals[j][1]) {
      i++
    } else {
      j++
    }
  }
  
  return result
}


findIntersection([[1, 3], [5, 6], [7, 9]], [[2, 3], [5, 7]])//[2, 3], [5, 6], [7, 7], The output list contains the common intervals between the two lists.
findIntersection([[1, 3], [5, 7], [9, 12]], [[5, 10]])// [5, 7], [9, 10], The output list contains the common intervals between the two lists.
````
> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {

    public static int[][] findIntersection(int[][] firstIntervals, int[][] secondIntervals) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while (i < firstIntervals.length && j < secondIntervals.length) {
            // Check if intervals overlap and firstIntervals[i] start time lies within secondIntervals[j]
            boolean firstOverlapsSecond = firstIntervals[i][0] >= secondIntervals[j][0] 
                                       && firstIntervals[i][0] <= secondIntervals[j][1];
            
            // Check if intervals overlap and secondIntervals[j] start time lies within firstIntervals[i]
            boolean secondOverlapsFirst = secondIntervals[j][0] >= firstIntervals[i][0] 
                                       && secondIntervals[j][0] <= firstIntervals[i][1];
            
            // Store the intersection part
            if (firstOverlapsSecond || secondOverlapsFirst) {
                int start = Math.max(firstIntervals[i][0], secondIntervals[j][0]);
                int end = Math.min(firstIntervals[i][1], secondIntervals[j][1]);
                result.add(new int[]{start, end});
            }
            
            // Move next from the interval which is finishing first
            if (firstIntervals[i][1] < secondIntervals[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        // Convert the dynamic list back to a 2D primitive int array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] first1 = {{1, 3}, {5, 6}, {7, 9}};
        int[][] second1 = {{2, 3}, {5, 7}};
        System.out.println(Arrays.deepToString(findIntersection(first1, second1)));
        // Output: [[2, 3], [5, 6], [7, 7]]

        // Test Case 2
        int[][] first2 = {{1, 3}, {5, 7}, {9, 12}};
        int[][] second2 = {{5, 10}};
        System.out.println(Arrays.deepToString(findIntersection(first2, second2)));
        // Output: [[5, 7], [[9, 10]]
    }
}

```
- As we are iterating through both the lists once, the time complexity of the above algorithm is `O(N + M)`, where `N` and `M` are the total number of intervals in the input arrays respectively.
- Ignoring the space needed for the result list, the algorithm runs in constant space `O(1)`.
## Conflicting Appointments (medium)
https://leetcode.com/problems/meeting-rooms/

> Given an array of intervals representing`N` appointments, find out if a person can <b>attend all the appointments</b>.

The problem follows the [Merge Intervals pattern](#pattern-4--merge-intervals). We can sort all the intervals by `startTime` and then check if any two intervals overlap. A person will not be able to attend all appointments if any two appointments overlap.
> [!NOTE]
> **Language:** JavaScript

````js
function canAttendAllAppointments(appointmentTimes) {
  //sort intervals by start time
  appointmentTimes.sort((a,b) => a[0] -b[0])
  
  //check if any two intervals overlap
  for(let i = 1; i < appointmentTimes.length; i++) {
    if(appointmentTimes[i][0] < appointmentTimes[i-1][1]) {
      //note that in the comparison above, it is < and not <=
      //while merging we needed <= comparison, as we will be merging the two 
      //intervals have conditions appointmentTimes[i][0] === appointmentTimes[i-1][1]
      //but such intervals don't represent conflicting appointments
      //as one starts right after the other
      return false
    }
  }
  return true
}

canAttendAllAppointments([[1,4], [2,5], [7,9]])//false, Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
canAttendAllAppointments([[6,7], [2,4], [8,12]])//true, None of the appointments overlap, therefore a person can attend all of them.
canAttendAllAppointments([[4,5], [2,3], [3,6]])//false, Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
````
> [!NOTE]
> **Language:** Java
```java
import java.util.Arrays;

public class AppointmentScheduler {

    public static boolean canAttendAllAppointments(int[][] appointmentTimes) {
        // Sort intervals by start time
        Arrays.sort(appointmentTimes, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Check if any two intervals overlap
        for (int i = 1; i < appointmentTimes.length; i++) {
            if (appointmentTimes[i][0] < appointmentTimes[i - 1][1]) {
                // Note that in the comparison above, it is < and not <=
                // While merging we needed <= comparison, as we will be merging the two 
                // intervals having conditions appointmentTimes[i][0] == appointmentTimes[i-1][1]
                // But such intervals don't represent conflicting appointments
                // As one starts right after the other
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] appts1 = {{1, 4}, {2, 5}, {7, 9}};
        System.out.println(canAttendAllAppointments(appts1)); // Output: false

        // Test Case 2
        int[][] appts2 = {{6, 7}, {2, 4}, {8, 12}};
        System.out.println(canAttendAllAppointments(appts2)); // Output: true

        // Test Case 3
        int[][] appts3 = {{4, 5}, {2, 3}, {3, 6}};
        System.out.println(canAttendAllAppointments(appts3)); // Output: false
    }
}

```
- The time complexity of the above algorithm is `O(N*logN)`, where `N` is the total number of appointments. Though we are iterating the intervals only once, our algorithm will take `O(N * logN)` since we need to sort them in the beginning.
- The space complexity of the above algorithm will be `O(N)`, which we need for sorting. 

> 🌟 Given a list of appointments, find all the conflicting appointments.
````
Appointments: [[4,5], [2,3], [3,6], [5,7], [7,8]]
Output: 
[4,5] and [3,6] conflict. 
[3,6] and [5,7] conflict.
````
### REVIEW
> [!NOTE]
> **Language:** JavaScript
````js
function whatAreTheConflicts(appointmentTimes)  {
  
  // appointmentTimes.sort((a,b) => a[0]-b[0])
  
  let conflicts = []
  
  for(let i = 0; i < appointmentTimes.length -1; i++) {
    for(let j = 1; j < appointmentTimes.length; j++) {
      if((j!==i) && (appointmentTimes[i][1] > appointmentTimes[j][0])) {
        conflicts.push([appointmentTimes[j], appointmentTimes[i]])
      } 
    }
 }
 // console.log(appointmentTimes)
 return conflicts
}


 whatAreTheConflicts([[4,5], [2,3], [3,6], [5,7], [7,8]])
//[4,5] and [3,6] conflict. 
//[3,6] and [5,7] conflict.
````
> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppointmentConflicts {

    public static List<int[][]> whatAreTheConflicts(int[][] appointmentTimes) {
        List<int[][]> conflicts = new ArrayList<>();
        
        int n = appointmentTimes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                if ((j != i) && (appointmentTimes[i][1] > appointmentTimes[j][0])) {
                    conflicts.add(new int[][]{appointmentTimes[j], appointmentTimes[i]});
                }
            }
        }
        return conflicts;
    }

    public static void main(String[] args) {
        int[][] appts = {{4, 5}, {2, 3}, {3, 6}, {5, 7}, {7, 8}};
        
        List<int[][]> conflicts = whatAreTheConflicts(appts);
        
        // Print the conflicting pairs cleanly
        for (int[][] pair : conflicts) {
            System.out.println(Arrays.toString(pair[0]) + " and " + Arrays.toString(pair[1]) + " conflict.");
        }
    }
}

```

## 🌟 Minimum Meeting Rooms (hard) 
https://leetcode.com/problems/meeting-rooms-ii/

> Given a list of intervals representing the start and `endTime` of`N` meetings, find the <b>minimum number of rooms</b> required to <b>hold all the meetings</b>.


#### Example :
````
Meetings: [[4,5], [2,3], [2,4], [3,5]]
Output: 2
Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
````

Let’s take the example mentioned  above and try to follow our <b>Merge Intervals approach</b>:

1. Sorting these meetings on their `startTime` will give us: `[[2,3], [2,4], [3,5], [4,5]]`
2. Merging overlapping meetings:

- `[2,3]` overlaps with `[2,4]`, so after merging we’ll have => `[[2,4], [3,5], [4,5]]`
- `[2,4]` overlaps with `[3,5]`, so after merging we’ll have => `[[2,5], [4,5]]`
- `[2,5]` overlaps `[4,5]`, so after merging we’ll have => `[2,5]`

Since all the given meetings have merged into one big meeting `([2,5])`, does this mean that they all are overlapping and we need a minimum of four rooms to hold these meetings? You might have already guessed that the answer is NO! As we can clearly see, some meetings are mutually exclusive. For example, `[2,3]` and `[3,5]` do not overlap and can happen in one room. So, to correctly solve our problem, we need to keep track of the mutual exclusiveness of the overlapping meetings.

Here is what our strategy will look like:

1. We will sort the meetings based on `startTime`.
2. We will schedule the first meeting (let’s call it `m1`) in one room (let’s call it `r1`).
3. If the next meeting `m2` is not overlapping with `m1`, we can safely schedule it in the same room `r1`.
4. If the next meeting `m3` is overlapping with `m2` we can’t use `r1`, so we will schedule it in another room (let’s call it `r2`).
5. Now if the next meeting `m4` is overlapping with `m3`, we need to see if the room `r1` has become free. For this, we need to keep track of the `endTime` of the meeting happening in it. If the `endTime` of `m2` is before the `startTime` of `m4`, we can use that room `r1`, otherwise, we need to schedule `m4` in another room `r3`.

We can conclude that we need to <b>keep track of the ending time of all the meetings currently happening</b> so that when we try to schedule a new meeting, we can see what meetings have already ended. We need to put this information in a data structure that can easily give us the smallest ending time. A <i>Min-Heap</i> would fit our requirements best.

So our algorithm will look like this:

1. Sort all the meetings on their `startTime`.
2. Create a <i>min-heap</i> to store all the active meetings. This <i>min-heap</i> will also be used to find the active meeting with the smallest `endTime`.
3. Iterate through all the meetings one by one to add them in the <i>min-heap</i>. Let’s say we are trying to schedule the meeting `m1`.
4. Since the <i>min-heap</i> contains all the active meetings, so before scheduling `m1` we can remove all meetings from the heap that have ended before `m1`, i.e., remove all meetings from the heap that have an `endTime` smaller than or equal to the `startTime` of `m1`.
5. Now add `m1` to the heap.
6. The heap will always have all the overlapping meetings, so we will need rooms for all of them. Keep a counter to remember the maximum size of the heap at any time which will be the minimum number of rooms needed.

> [!NOTE]
> **Language:** JavaScript
````js
function minMeetingRooms(meetings) {
  //JavaScript does not come with built in Heap, so I used an array to keep track of rooms and sorted by end time at each call
  if(meetings == null) return 0
  if(meetings.length <= 1) return meetings.length
  
  //helper that returns the meeting room with the earliest end time
  function getEarliest(room) {
    room.sort((a,b) => a[1]-b[1])
    return rooms[0]
  }
  
  //sort meetings on start time
  meetings.sort((a,b) => a[0]-b[0])
  
  let rooms = [meetings[0]]
  
  for(let i = 1; i < meetings.length; i++) {
    let earliestRoom = getEarliest(rooms)
    let currentTime = meetings[i]
    
    //if the room time ends before the currentTime interval starts
    //then use the room and update the room end time to currentTime
    if(earliestRoom[1] <= currentTime[0]) {
      earliestRoom[1] = currentTime[1]
    } else {
      //create room
      rooms.push(currentTime)
    }
  }
  return rooms.length
}

minMeetingRooms()
minMeetingRooms([[1,4]])
minMeetingRooms([[1,4], [2,5], [7,9]])//2, Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later.
minMeetingRooms([[6,7], [2,4], [8,12]])//1, None of the meetings overlap, therefore we only need one room to hold all meetings.
minMeetingRooms([[1,4], [2,3], [3,6]])//2, Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to hold all the meetings.
minMeetingRooms([[4,5], [2,3], [2,4], [3,5]])//2, We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
````
> [!NOTE]
> **Language:** Java
```java
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static int minMeetingRooms(int[][] meetings) {
        if (meetings == null || meetings.length == 0) {
            return 0;
        }

        // 1. Sort the meetings by their start times
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Use a Min-Heap to track the end times of active rooms
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        // Add the end time of the first meeting
        rooms.add(meetings[0][1]);

        // 3. Iterate through the remaining meetings
        for (int i = 1; i < meetings.length; i++) {
            // If the room with the earliest end time is free, reuse it
            if (rooms.peek() <= meetings[i][0]) {
                rooms.poll();
            }
            
            // Add the current meeting's end time to the heap (allocates/updates a room)
            rooms.add(meetings[i][1]);
        }

        // The size of the heap represents the minimum rooms required
        return rooms.size();
    }

    public static void main(String[] args) {
        // Test cases from your prompt
        System.out.println(minMeetingRooms(new int[][]{})); // 0
        System.out.println(minMeetingRooms(new int[][]{{1, 4}})); // 1
        System.out.println(minMeetingRooms(new int[][]{{1, 4}, {2, 5}, {7, 9}})); // 2
        System.out.println(minMeetingRooms(new int[][]{{6, 7}, {2, 4}, {8, 12}})); // 1
        System.out.println(minMeetingRooms(new int[][]{{1, 4}, {2, 3}, {3, 6}})); // 2
        System.out.println(minMeetingRooms(new int[][]{{4, 5}, {2, 3}, {2, 4}, {3, 5}})); // 2
    }
}

```
- The time complexity of the above algorithm is `O(N*logN)`, where `N` is the total number of meetings. This is due to the sorting that we did in the beginning. Also, while iterating the meetings we might need to poll/offer meeting to the priority queue. Each of these operations can take `O(logN)`. Overall our algorithm will take `O(NlogN)`.
- The space complexity of the above algorithm will be `O(N)` which is required for sorting. Also, in the worst case scenario, we’ll have to insert all the meetings into the Min Heap (when all meetings overlap) which will also take `O(N)` space. The overall space complexity of our algorithm is `O(N)`.

### Similar Problems
> Given a list of intervals, find the point where the maximum number of intervals overlap.

> Given a list of intervals representing the arrival and departure times of trains to a train station, our goal is to find the minimum number of platforms required for the train station so that no train has to wait.

Both of these problems can be solved using the `approach` discussed above.


## 🌟 Maximum CPU Load (hard)
https://leetcode.com/problems/car-pooling/

We are given a list of `jobs`. Each job has a `startTime`, an `endTime`, and a `CPU load` when it is running. Our goal is to find the  <b>Maximum CPU Load</b> at any time if all the `jobs` are <b>running on the same machine</b>.

### Example 1:
````
Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the 
jobs are running at the same time i.e., during the time interval (2,4).
````
### Example 2:
````
Jobs: [[6,7,10], [2,4,11], [8,12,15]]
Output: 15
Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
````
### Example 3:
````
Jobs: [[1,4,2], [2,4,1], [3,6,5]]
Output: 8
Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4]. 
````

The problem follows the [Merge Intervals pattern](#pattern-4--merge-intervals) and can easily be converted to <b>[Minimum Meeting Rooms](#🌟-minimum-meeting-rooms-hard)</b>. Similar to [Minimum Meeting Rooms](#🌟-minimum-meeting-rooms-hard) where we were trying to find the maximum number of meetings happening at any time, for  <b>Maximum CPU Load</b> we need to find the maximum number of `jobs` running at any time. We will need to keep a running count of the maximum  <b>CPU Load</b> at any time to find the overall maximum load.
> [!NOTE]
> **Language:** JavaScript

````js
function findMaxCPULoad(jobs) {
  //sort the jobs by startTime
  jobs.sort((a, b) => a[0]-b[0])
  
  let maxCPULoad = 0
  
 //consolidate jobs that overlap
  for(let i = 1; i < jobs.length; i++) {
    let current = jobs[i]
    let previous = jobs[i-1]
   
    if(current[0] < previous[1]){
      jobs[i] = [previous[0], current[1], previous[2] + current[2]]
      jobs.splice(i-1, 1)
      i--
    }
  }
  
  //set maximum load
  for(let i = 0; i < jobs.length; i++) {
    maxCPULoad = Math.max(maxCPULoad, jobs[i][2]) 
  }

  return maxCPULoad;
};

 findMaxCPULoad([[1,4,3], [2,5,4], [7,9,6]])//7, Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the jobs are running at the same time i.e., during the time interval (2,4). 
 findMaxCPULoad([[6,7,10], [2,4,11], [8,12,15]])//15, None of the jobs overlap, therefore we will take the maximum load of any job which is 15. 
 findMaxCPULoad([[1,4,2], [2,4,1], [3,6,5]])//8, Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4]. 
 ````
 > [!NOTE]
> **Language:** Java
```java
import java.util.Arrays;
import java.util.PriorityQueue;

public class CPULoad {

    public static int findMaxCPULoad(int[][] jobs) {
        if (jobs == null || jobs.length == 0) {
            return 0;
        }

        // 1. Sort the jobs by their start times
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        int maxCPULoad = 0;
        int currentCPULoad = 0;

        // 2. Min-Heap to track active jobs, sorted by their end times
        // Each element in the heap is a job array: [start, end, load]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // 3. Iterate through all jobs
        for (int[] currentJob : jobs) {
            // Remove all jobs from the heap that have ended before the current job starts
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= currentJob[0]) {
                currentCPULoad -= minHeap.poll()[2];
            }

            // Add the current job to the heap and add its load
            minHeap.add(currentJob);
            currentCPULoad += currentJob[2];

            // Keep track of the maximum load seen at any point in time
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }

        return maxCPULoad;
    }

    public static void main(String[] args) {
        // Test cases from your prompt
        System.out.println(findMaxCPULoad(new int[][]{{1, 4, 3}, {2, 5, 4}, {7, 9, 6}})); // 7
        System.out.println(findMaxCPULoad(new int[][]{{6, 7, 10}, {2, 4, 11}, {8, 12, 15}})); // 15
        System.out.println(findMaxCPULoad(new int[][]{{1, 4, 2}, {2, 4, 1}, {3, 6, 5}})); // 8
    }
}

```
- The time complexity of the above algorithm is `O(N*logN)`, where `N` is the total number of `jobs`. This is due to the sorting that we did in the beginning. Also, while iterating the `jobs`, we might need to poll/offer `jobs` to the priority queue. Each of these operations can take `O(logN)`. Overall our algorithm will take `O(NlogN)`.
- The space complexity of the above algorithm will be `O(N)`, which is required for sorting. Also, in the worst case, we have to insert all the `jobs` into the priority queue (when all `jobs` overlap) which will also take `O(N)` space. The overall space complexity of our algorithm is `O(N)`.
## 🌟 Employee Free Time (hard)
https://leetcode.com/problems/employee-free-time/ 
> For `K` employees, we are given a list of intervals representing the working hours of each employee. Our goal is to find out if there is a <b>free interval that is common to all employees</b>. You can assume that each list of employee working hours is sorted on the `startTime`.

This problem follows the [Merge Intervals pattern](#pattern-4--merge-intervals). Let’s take the an example:
````
Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
Output: [4,6], [8,9]
````
One simple solution can be to put all employees' working hours in a list and sort them on the `startTime`. Then we can iterate through the list to find the gaps. Let’s dig deeper. Sorting the intervals of the above example will give us:
````
[1,3], [2,4], [6,8], [9,12]
````
We can now iterate through these intervals, and whenever we find non-overlapping intervals (e.g., `[2,4]` and `[6,8]`), we can calculate a free interval (e.g., `[4,6]`). 
> [!NOTE]
> **Language:** JavaScript
````js
function findEmployeeFreeTime (schedules) {
  let freeTime = [];
  
  //combine all schedules
  let allTime = []
  
  for(let i = 0; i < schedules.length; i++) {
    for(let j = 0; j <  schedules[i].length; j++) {
      allTime.push(schedules[i][j])
    }
  }
  allTime.sort((a,b) => a[0]-b[0])

  //merge overlap
  for(let i = 1; i < allTime.length; i++) {
    let current = allTime[i]
    let previous = allTime[i-1]
   
    if(current[0] <= previous[1]) {
      allTime[i] = [previous[0], current[1]]
      allTime.splice(i-1, 1)
      i-- 
    }
  }
  //whatever is not accounted for is free time
  for(let i = 1; i < allTime.length; i++) {
    freeTime.push([allTime[i-1][1], allTime[i][0]])
  }
    return freeTime;
};

findEmployeeFreeTime ([[[1,3], [5,6]], [[2,3], [6,8]]])//[3,5], Both the employees are free between [3,5].
findEmployeeFreeTime ([[[1,3], [9,12]], [[2,4]], [[6,8]]])//[4,6], [8,9], All employees are free between [4,6] and [8,9].
findEmployeeFreeTime ([[[1,3]], [[2,4]], [[3,5], [7,9]]])//[5,7], ll employees are free between [5,7].
````
> [!NOTE]
> **Language:** Java
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    // Definition for an Interval
    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        if (schedule == null || schedule.isEmpty()) {
            return result;
        }

        // 1. Flatten all employee schedules into a single list
        List<Interval> allTime = new ArrayList<>();
        for (List<Interval> employeeSchedule : schedule) {
            allTime.addAll(employeeSchedule);
        }

        // 2. Sort the intervals by their start times
        Collections.sort(allTime, (a, b) -> Integer.compare(a.start, b.start));

        // 3. Merge overlapping intervals and find gaps concurrently
        Interval previous = allTime.get(0);
        
        for (int i = 1; i < allTime.size(); i++) {
            Interval current = allTime.get(i);

            // If the current interval overlaps with the previous one, merge them
            if (current.start <= previous.end) {
                previous.end = Math.max(previous.end, current.end);
            } else {
                // If there is no overlap, the gap between them is free time
                result.add(new Interval(previous.end, current.start));
                previous = current;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Helper to run the test cases matching your prompt format
        
        // Case 1: [[[1,3], [5,6]], [[2,3], [6,8]]]
        List<List<Interval>> schedule1 = List.of(
            List.of(new Interval(1, 3), new Interval(5, 6)),
            List.of(new Interval(2, 3), new Interval(6, 8))
        );
        System.out.println(findEmployeeFreeTime(schedule1)); // [[3, 5]]

        // Case 2: [[[1,3], [9,12]], [[2,4]], [[6,8]]]
        List<List<Interval>> schedule2 = List.of(
            List.of(new Interval(1, 3), new Interval(9, 12)),
            List.of(new Interval(2, 4)),
            List.of(new Interval(6, 8))
        );
        System.out.println(findEmployeeFreeTime(schedule2)); // [[4, 6], [8, 9]]

        // Case 3: [[[1,3]], [[2,4]], [[3,5], [7,9]]]
        List<List<Interval>> schedule3 = List.of(
            List.of(new Interval(1, 3)),
            List.of(new Interval(2, 4)),
            List.of(new Interval(3, 5), new Interval(7, 9))
        );
        System.out.println(findEmployeeFreeTime(schedule3)); // [[5, 7]]
    }
}

```
- This algorithm will take `O(N * logN)` time, where `N` is the total number of intervals. This time is needed because we need to sort all the intervals. 
- The space complexity will be `O(N)`, which is needed for sorting. 

#### Can we find a better solution?

One fact that we are not utilizing is that each employee list is individually sorted!

How about we take the first interval of each employee and insert it in a <i>Min-Heap</i>. This <i>Min-Heap</i> can always give us the interval with the smallest `startTime`. Once we have the smallest start-time interval, we can then compare it with the next smallest start-time interval (again from the <i>Heap</i> to find the gap. This interval comparison is similar to what we suggested in the previous approach.

Whenever we take an interval out of the <i>Min-Heap</i>, we can insert the same employee’s next interval. This also means that we need to know which interval belongs to which employee.
- The above algorithm’s time complexity is `O(N*logK)`, where `N` is the total number of intervals, and `K` is the total number of employees. This is because we are iterating through the intervals only once (which will take `O(N)`), and every time we process an interval, we remove (and can insert) one interval in the <i>Min-Heap</i>, (which will take `O(logK)`. At any time, the heap will not have more than `K` elements.
- The space complexity of the above algorithm will be `O(K)` as at any time, the heap will not have more than `K` elements.

