package tencent50;

class search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        // find the index of the minimum
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        System.out.println("min: " + low);
        // search between 0 : min -1 or min : nums.length - 1
        int min = low;
        low = (target <= nums[nums.length - 1])? min : 0;
        high = (target > nums[nums.length - 1])? min - 1: nums.length - 1;
        System.out.println("left: " + low + " right: " + high);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}