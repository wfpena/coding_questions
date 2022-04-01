class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int product = Integer.MIN_VALUE, currProduct = 1,
            maxProduct = 1, minProduct = 1,
            tmp = 0;
        for(int end = 0; end < nums.length; end++)
            product = Math.max(product, nums[end]);
        
        System.out.println(product);
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                maxProduct = 1;
                minProduct = 1;
            } else {
                tmp = maxProduct * nums[i];

                maxProduct = Math.max(Math.max(maxProduct * nums[i], minProduct * nums[i]),nums[i]);
                minProduct = Math.min(Math.min(tmp, minProduct * nums[i]), nums[i]);

                product = Math.max(product, maxProduct);                
            }         
            
        }
        
        return product;
    }
}