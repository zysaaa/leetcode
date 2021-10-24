package again.search;

/**
 * @description: 二分查找 -- 递归 or not 递归
 *
 * 经典bug: https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
 *
 * @author: zysaaa
 * @date: 2021/10/21 15:42
 */
public class 二分查找 {

    public static void main(String[] args) {
        //System.out.println(new 二分查找().binarySearch_递归(new int[] {2}, 2));
    }

    /*public int binarySearch_递归(int[] nums, int target) {
        return doSearch(nums, 0, nums.length - 1, target);
    }

    public int doSearch(int[] nums, int left, int right, int target) {
        // 注意，不是 >=
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target){
            return doSearch(nums, left, mid - 1, target);
        } else {
            return doSearch(nums,mid + 1, right, target);
        }
    }*/

    public int binarySearch_非递归(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid ;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

}
