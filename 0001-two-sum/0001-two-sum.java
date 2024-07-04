class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int length0fArr = nums.length;
        int targetIndex[] = new int[2];

        for (int j=0; j<length0fArr; j++ ) {
            for ( int k=(j+1); k<length0fArr; k++ ) {
                if ( (nums[k]+nums[j]) == target ) {
                    targetIndex[0] = j;
                    targetIndex[1] = k;
                    
                    return targetIndex;
                }
            }
        }
        return targetIndex;
    }
}