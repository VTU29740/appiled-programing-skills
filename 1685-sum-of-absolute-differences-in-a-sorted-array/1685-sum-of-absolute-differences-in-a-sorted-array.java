class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int[] result = new int[n];
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            // Elements to the right of index i sum up to totalSum - leftSum - nums[i]
            int rightSum = totalSum - leftSum - nums[i];

            int leftCount = i;
            int rightCount = n - 1 - i;

            int leftDiff = leftCount * nums[i] - leftSum;
            int rightDiff = rightSum - rightCount * nums[i];

            result[i] = leftDiff + rightDiff;

            // Add current element to leftSum for the next iteration
            leftSum += nums[i];
        }

        return result;
    }
}