package LambdaExpressionComparison;

import java.util.Arrays;

public class Program {
  public static void main(String[] args) {
    Integer[] arr = { 1, 2, 3, 4, 5 };

    System.out.println(Arrays.toString(arr));

    Arrays.sort(arr, (a, b) -> b - a);

    System.out.println(Arrays.toString(arr));
  }
}
