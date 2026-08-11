class Solution {
    public static List<List<Integer>> tripletsWithSum0(List<Integer> nums) {
        Collections.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.size() - 2 && nums.get(i) <= 0; i++) {
            if (i > 0 && nums.get(i).equals(nums.get(i - 1))) continue;
            int left = i + 1;
            int right = nums.size() - 1;
            while (left < right) {
                int currSum = nums.get(i) + nums.get(left) + nums.get(right);
                if (currSum == 0) {
                    triplets.add(List.of(nums.get(i), nums.get(left), nums.get(right)));
                    left++;
                    right--;
                    while (left < right && nums.get(left).equals(nums.get(left - 1))) left++;
                    while (left < right && nums.get(right).equals(nums.get(right + 1))) right--;
                } else if (currSum < 0) left++;
                else right--;
            }
        }
        return triplets;
    }
}
