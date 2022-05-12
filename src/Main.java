import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) {


  }


  public static class RotateArray {
    public void rotate(int[] nums, int k) {
      List<Integer> squareNumbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
      Collections.rotate(squareNumbers, k);
      int[] ints = squareNumbers.stream().mapToInt(Integer::intValue).toArray();
      System.out.println(Arrays.toString(ints).replaceAll("\\s+", ""));
    }
  }

  public static class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
      List<Integer> squareNumbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
      Function<Integer, Integer> square = x -> x * x;
      List<Integer> integerList = squareNumbers.stream().map(square).sorted().collect(Collectors.toList());
      return integerList.stream().mapToInt(Integer::intValue).toArray();
    }
  }

  public static class BinarySearch {
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

  public static class SearchInsertPosition {
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

