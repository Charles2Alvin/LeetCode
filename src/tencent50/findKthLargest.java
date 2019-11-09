package tencent50;

import java.util.*;
import java.util.stream.Collectors;

class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        return list.get(k);
    }
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
    int[] nums;
    int kSmallest;
    public void swap(int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
    public int partition(int left, int right, int pivotIndex)  {
        // 先把pivot放在最右端
        int pivot = nums[pivotIndex];
        swap(pivotIndex, right);
        // 记录比pivot小的元素应存放的下标
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(i, storeIndex);
                storeIndex++;
            }
        }
        // 把pivot放到比它小的元素后面
        swap(storeIndex, right);
        return storeIndex;
    }
    public int quickSelect(int left, int right) {
        if (left == right) {
            return nums[left];
        }
        // 随机选择一个元素作为pivot
        int pivotIndex = partition(left, right, left + new Random().nextInt(right - left));
        if (pivotIndex == kSmallest) {
            return nums[kSmallest];
        } else if (pivotIndex < kSmallest) {
            return quickSelect(pivotIndex + 1, right);
        } else {
            return quickSelect(left, pivotIndex - 1);
        }
    }
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        this.nums = nums;
        this.kSmallest = n - k;
        return quickSelect(0, n - 1);
    }

}