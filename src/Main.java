import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) {

    Solution1 solution1 = new Solution1();
    int a[] = {1,2,3,4,5,6,7};
//    Solution1.sortedSquares(a);
//
//    for (int i : Solution1.sortedSquares(a)) {
//      System.out.println(i);

      Solution2 solution2 = new Solution2();
      solution2.rotate(a, 3);





  }


  public static class Solution2 {
    public void rotate(int[] nums, int k) {
      List<Integer> squareNumbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
      Collections.rotate(squareNumbers, k);
      int[] ints = squareNumbers.stream().mapToInt(Integer::intValue).toArray();
      System.out.println(Arrays.toString(ints).replaceAll("\\s+", ""));
    }
  }

  public static class Solution1 {
    public static int[] sortedSquares(int[] nums) {
      List<Integer> squareNumbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
      Function<Integer, Integer> square = x -> x * x;
      List<Integer> integerList = squareNumbers.stream().map(square).sorted().collect(Collectors.toList());
      return integerList.stream().mapToInt(Integer::intValue).toArray();
    }
  }

  public static class Solution3 {
    public int search(int[] nums, int target) {
      int index = -1;
      for (int o = 0; o < nums.length; o++) {
        if(nums[o] == target){
          index = o;
        }
      }
      return index;
    }
  }

  public static class Solution4 {
    public int searchInsert(int[] nums, int target) {
      int index = 0;
      boolean isTarget = false;
      for (int o = 0; o < nums.length; o++) {
        if (nums[o] == target) {
          index = o;
          isTarget = true;
        }
      }
      if (!isTarget) {
        for (int o = 0; o < nums.length; o++) {
          if (nums[o] <= target) {
            index = 1 + o;
          }
        }
      }
      return index;
    }
  }
}

