
import java.util.Arrays;

public class ArrayPractice {

  // Remove duplicates from the array
  static int[] nums = { 1, 2, 3, 3, 4, 5, 5 }; // 1 2 3 4 5 6
  static int[] stocks = { 7, 1, 5, 3, 6, 4 };
  static int[] numbers = { 1, 2, 3, 4, 5, 6 };

  public static void main(String[] args) {

    int value = removeDuplicatesFromSortedArray(nums);
    int maxProfit = calculateMaxProfit(stocks);
    int maxProfit2 = calculateMaxProfit2(stocks);
    rotate(numbers, 3);
    System.out.println("value " + value);
    System.out.println("maxProfit " + maxProfit);
    System.out.println("maxProfit2 " + maxProfit2);
  }

  // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
  // 1, 2, 3, 3, 4, 5, 5
  //    2!=1
  static int removeDuplicatesFromSortedArray(int[] nums) {
    int k = 1;
    for (int j = 1; j < nums.length; j++) { // T: O(n)
      if (nums[j] != nums[j - 1]) {
        nums[k] = nums[j];
        k++;
      }
    }
    System.out.println("removeDuplicatesFromSortedArray " + Arrays.toString(Arrays.copyOf(nums, k)));
    return k;
  }

  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/2133258486/
  // 7, 1, 5, 3, 6, 4
  // 1. price=7; minPrice=7; maxProfit=0
  // 2. price=1; minPrice=1; maxProfit=0
  // 3. price=5; minPrice=1; maxProfit=4;
  // 4. price=3; minPrice=1; maxProfit4;
  // 5. price=6; minPrice=1 maxProfit=5;
  // 6. price=4 minPrice=1 maxProfit=5;
  // T: O(n) S: O(1)
  static int calculateMaxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      }
      if (price - minPrice > maxProfit) {
        maxProfit = price - minPrice;
      }
    }
    return maxProfit;
  }

  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
  // 7, 1, 5, 3, 6, 4
  // 0: 1>7; maxProfit 0; false
  // 1: 5>1; maxProfit 4; true
  // 2: 3>5: maxProfit 4; false
  // 3: 6>3: maxProfit 4+3=7; true
  // 4: 4>6 maxProfit 7; false
  // maxProfit = 7
  // T: O(n) S: O(1)
  static int calculateMaxProfit2(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit = maxProfit + prices[i] - prices[i - 1];
      }
    }
    return maxProfit;
  }

  // https://leetcode.com/problems/rotate-array/
  public static void rev(int[] nums, int start, int end) {
    while (start <= end) {
      int temp = start;
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
    System.out.println("rev " + Arrays.toString(Arrays.copyOf(nums, nums.length - 1)));
  }

  // [1,2,3,4,5,6,7], k = 3
  public static void rotate(int[] nums, int k) {
    int n = nums.length;

    if (k % n == 0) {
      return;
    }
    k = k % n;
    System.out.println("K "+k+" "+k % n);
    rev(nums, 0, n - 1); // T: O(n) S: O(1)
    rev(nums, 0, k - 1);
    rev(nums, k - 1, n - 1);
  }

}
