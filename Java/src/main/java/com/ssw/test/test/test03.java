package com.ssw.test.test;

/**
 * @Author: ssw
 * @DateTime: 2021/10/17 22:59
 * @Description: 二分查找
 *
 *  给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，
 *  写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *  示例 1:
 *      输入: nums = [-1,0,3,5,9,12], target = 9
 *      输出: 4
 *      解释: 9 出现在 nums 中并且下标为 4
 */
public class test03 {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int mid = -1;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else if(nums[mid] > target)
                high = mid -1;
            else
                break;
        }
        if(low<=high)
            return mid;
        else
            return -1;
    }

}