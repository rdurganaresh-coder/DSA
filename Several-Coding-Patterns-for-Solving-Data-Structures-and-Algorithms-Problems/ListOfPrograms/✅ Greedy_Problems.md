# Greedy for Beginners: Problems & Sample Solutions

Based on the compilation by Jayant Shekhar, this guide provides a structured breakdown of essential Greedy problems categorized by data structures and core techniques. It includes optimal C++ solutions for the trickier problems.

## 📊 Problem Categorization

### 🔀 Sort / Array
*   [Jump Game](https://leetcode.com/problems/jump-game/)
*   [Jump Game II](https://leetcode.com/problems/jump-game-ii/)
*   [Gas Station](https://leetcode.com/problems/gas-station/)
*   [Candy](https://leetcode.com/problems/candy/)
*   [Remove K Digits](https://leetcode.com/problems/remove-k-digits/)
*   [Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/)
*   [Assign Cookies](https://leetcode.com/problems/assign-cookies/)
*   [Boats to Save People](https://leetcode.com/problems/boats-to-save-people/)
*   [Bag of Tokens](https://leetcode.com/problems/bag-of-tokens/)
*   [Number of Burgers with No Waste of Ingredients](https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/)
*   [Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height/)
*   [Play with Chips / Minimum Cost to Move Chips to Same Place](https://leetcode.com/problems/play-with-chips/)
*   [Previous Permutation With One Swap](https://leetcode.com/problems/previous-permutation-with-one-swap/)
*   [Lemonade Change](https://leetcode.com/problems/lemonade-change/)

### 🔑 Hash / Multi-set
*   [Task Scheduler](https://leetcode.com/problems/task-scheduler/)
*   [Partition Labels](https://leetcode.com/problems/partition-labels/)
*   [Car Pooling](https://leetcode.com/problems/car-pooling/)
*   [Divide Array in Sets of K Consecutive Numbers](https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/)
*   [Group the People Given the Group Size They Belong To](https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/)
*   [Cinema Seat Allocation](https://leetcode.com/problems/cinema-seat-allocation/)
*   [Construct K Palindrome Strings](https://leetcode.com/problems/construct-k-palindrome-strings/)
*   [Advantage Shuffle](https://leetcode.com/problems/advantage-shuffle/)

### 🧵 Strings
*   [Reorganize String](https://leetcode.com/problems/reorganize-string/)
*   [String Without AAA or BBB](https://leetcode.com/problems/string-without-aaa-or-bbb/)
*   [Check If a String Can Break Another String](https://leetcode.com/problems/check-if-a-string-can-break-another-string/)
*   [Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/)

### 🌲 Heap / Priority Queue
*   [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)
*   [Reduce Array Size to The Half](https://leetcode.com/problems/reduce-array-size-to-the-half/)

### 🥞 Stack
*   [Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

---

## 💻 Sample Solutions (C++)

### 1. Divide Array in Sets of K Consecutive Numbers
```cpp
class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        int n = nums.size();
        if (n % k != 0) return false;
        
        map<int, int> hm;
        for (int i = 0; i < n; i++)
            hm[nums[i]]++;

        for (auto it = hm.begin(); it != hm.end(); it++) {
            if (hm[it->first] > 0) {
                for (int i = k - 1; i >= 0; i--) {
                    hm[it->first + i] -= hm[it->first];
                    if (hm[it->first + i] < 0)
                        return false;
                }
            }
        }
        return true;
    }
};
```

### 2. Car Pooling
```cpp
class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        int trip_len = 1001;
        vector<int> stops(trip_len, 0);

        for (int i = 0; i < trips.size(); i++) {
            stops[trips[i][1]] += trips[i][0];
            stops[trips[i][2]] -= trips[i][0];
        }

        for (int i = 0; i < trip_len; i++) {
            if (i != 0) stops[i] += stops[i - 1];
            if (stops[i] > capacity)
                return false;
        }
        return true;
    }
};
```

### 3. Reorganize String
```cpp
class Solution {
    static bool compare(pair<char, int> p1, pair<char, int> p2) {
        return p1.second > p2.second;
    }
public:
    string reorganizeString(string S) {
        int n = S.length();
        unordered_map<char, int> m;
        vector<pair<char, int>> v;

        for (int i = 0; i < n; i++) 
            m[S[i]]++;

        for(auto it = m.begin(); it != m.end(); it++) {
            if (it->second > (n + 1) / 2)
                return "";
            v.push_back(make_pair(it->first, it->second));
        }

        sort(v.begin(), v.end(), compare);
        string str;
        for (int i = 0; i < v.size(); i++) {
            while (v[i].second--)
                str += v[i].first;
        }

        string ans;
        int size = str.size();
        int i = 0, j = (size - 1) / 2 + 1;

        while (i < (size - 1) / 2 + 1) {
            ans += str[i];
            if (j < size) ans += str[j]; // Guard for safe index handling
            i++; j++;
        }
        return ans;
    }
};
```

### 4. Candy
```cpp
class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        if (n == 0) return 0;

        vector<int> left(n, 1); 
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }

        int sum = left[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                left[i] = max(left[i], left[i + 1] + 1);
            sum += left[i];
        }
        return sum;
    }
};
```
A curated list of greedy problems focused on maximizing or minimizing objectives, frequently featured in recent contests, top interview tracks, and online assessments (OAs).

| Problem ID | Problem Name / Link | Key Technique / Approach |
| :--- | :--- | :--- |
| **LC 45** | [Jump Game II](https://leetcode.com/problems/jump-game-ii/) | Track the maximum reachable index within the current jump range to minimize total jumps. |
| **LC 134** | [Gas Station](https://leetcode.com/problems/gas-station/) | Monitor net gas balance deficit; identify the starting point when total gas $\ge$ total cost. |
| **LC 135** | [Candy](https://leetcode.com/problems/candy) | Multi-pass approach (left-to-right, right-to-left) to minimize total candies given to neighbors. |
| **LC 881** | [Boats to Save People](https://leetcode.com/problems/boats-to-save-people/) | Two-pointer strategy: pair the heaviest and lightest individuals to minimize total boats. |
| **LC 1247** | [Minimum Swaps to Make Strings Equal](https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/) | Count mismatched patterns ("xy" and "yx"); pair identical mismatches first to minimize swaps. |
| **LC 1833** | [Maximum Ice Cream Bars](https://leetcode.com/problems/maximum-ice-cream-bars/) | Sort prices in ascending order and buy the cheapest bars first to maximize the count. |
| **LC 2240** | [Number of Ways to Buy Pens and Pencils](https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/) | Iterate through possible counts of the first item to find valid combinations for the second. |
| **LC 2244** | [Minimum Rounds to Complete All Tasks](https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/) | Count task frequencies; prioritize processing items in groups of 3 to minimize rounds. |
| **LC 2279** | [Maximum Bags with Full Capacity of Rocks](https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/) | Calculate remaining capacities, sort them ascending, and fill the closest bags to maximize full bags. |
| **LC 2405** | [Optimal Partition of String](https://leetcode.com/problems/optimal-partition-of-string/) | Use a hash set to track unique characters; split as soon as a duplicate appears to minimize partitions. |
| **LC 2410** | [Maximum Matching of Players with Trainers](https://leetcode.com/problems/maximum-matching-of-players-with-trainers/) | Sort both arrays; pair the smallest capable trainer with the smallest available player to maximize matches. |
| **LC 2439** | [Minimize Maximum of Array](https://leetcode.com/problems/minimize-maximum-of-array/) | Track prefix sums and averages from left to right to calculate the minimum upper bound. |
| **LC 2541** | [Minimum Operations to Make Array Equal II](https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii/) | Track positive and negative differences of elements; verify net balance is zero to calculate minimum operations. |
| **LC 2567** | [Minimum Score by Changing Two Elements](https://leetcode.com/problems/minimum-score-by-changing-two-elements/) | Sort array; eliminate the two largest, two smallest, or one of each to minimize the distance score. |
| **LC 2611** | [Mice and Cheese](https://leetcode.com/problems/mice-and-cheese/) | Calculate reward differences ($reward1 - reward2$), sort descending, and greedily pick top items to maximize score. |
| **LC 2654** | [Minimum Number of Operations to Make All Array Elements Equal to 1](https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/) | Find the shortest subarray with a Greatest Common Divisor (GCD) of 1 to minimize reduction operations. |
| **LC 2734** | [Lexicographically Smallest String After Substring Operation](https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/) | Locate the first non-'a' character and shift consecutive non-'a' characters to minimize lexicographical order. |
| **LC 2800** | [Shortest String That Contains Three Strings](https://leetcode.com/problems/shortest-string-that-contains-three-strings/) | Try all permutations of merging string pairs to find the overall minimal length sequence. |
| **LC 2808** | [Minimum Seconds to Equalize a Circular Array](https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array/) | Group indices by value; find the largest gap between identical elements to minimize time needed to spread values. |
