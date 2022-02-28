class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        int size = 1;
        for (int i = 0; i < nums.length; i++) {
            int startIndex = (i >= 1 && nums[i] == nums[i-1]) ? size : 0;
            size = result.size();
            System.out.println("size: " + size);
            for (int j = startIndex; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(new ArrayList<>(tmp));
            }
            printMatrix(result);
        }
        return result;
    }
    
    private void printMatrix(List<List<Integer>> l) {
        for (List<Integer> row : l) {
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
}