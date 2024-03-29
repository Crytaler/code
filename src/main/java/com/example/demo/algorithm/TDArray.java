package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TDArray
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/8/8 下午2:26
 * @Version 1.0
 **/
public class TDArray {

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = spiralOrder(nums);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while(left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                res.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    res.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length, column = grid[0].length;
        if(grid == null || rows == 0 || column == 0) {
            return 0;
        }
        for(int i = 1; i < rows; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i = 1; i < column; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < column; j++) {
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[rows-1][column-1];
    }

}
