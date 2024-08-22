class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currPermuteSeq = new ArrayList<>();
        solvePermuteUnique(ans, currPermuteSeq, nums, 0);
        return ans;
    }
    public static void solvePermuteUnique(List<List<Integer>> ans, List<Integer> currPermuteSeq, int[] arr, int idx){
        if (idx == arr.length){
            List<Integer> replicatePermuteSeq = new ArrayList<>(currPermuteSeq);
            ans.add(replicatePermuteSeq);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int j=idx; j<arr.length; j++){
            if (!set.contains(arr[j])){
                set.add(arr[j]);
                currPermuteSeq.add(arr[j]);
                swap(arr, idx, j);
                solvePermuteUnique(ans, currPermuteSeq, arr, idx + 1);
                currPermuteSeq.remove(currPermuteSeq.size() - 1);
                swap(arr, idx, j);
            }
        }
    }
    public static void swap(int[] arr, int s, int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}