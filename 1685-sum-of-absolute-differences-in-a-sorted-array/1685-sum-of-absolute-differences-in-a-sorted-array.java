class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Total sum of all elements
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int current = nums[i];

            // Contribution from elements on the left
            int leftCount = i;
            int leftContribution = current * leftCount - leftSum;

            // Contribution from elements on the right
            int rightCount = n - i - 1;
            int rightSum = totalSum - leftSum - current;
            int rightContribution = rightSum - current * rightCount;

            result[i] = leftContribution + rightContribution;

            // Add current element to left side
            leftSum += current;
        }

        return result;
    }
}