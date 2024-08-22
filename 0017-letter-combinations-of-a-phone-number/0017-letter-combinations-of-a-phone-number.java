class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        StringBuilder currCombination = new StringBuilder();
        solveLetterCombinations(map, ans, currCombination, digits, 0);
        return ans;
    }
    public static void solveLetterCombinations(Map<Character, String> map, List<String> ans, StringBuilder currCombination, String digits, int idx){
        if (digits.isEmpty()) return;
        if (idx == digits.length()){
            StringBuilder replicateLetterCombination = new StringBuilder(currCombination);
            ans.add(replicateLetterCombination.toString());
            return;
        }
        String str = map.get(digits.charAt(idx));
        for (int j=0; j<str.length(); j++){
            currCombination.append(str.charAt(j));
            solveLetterCombinations(map, ans, currCombination, digits, idx + 1);
            currCombination.deleteCharAt(currCombination.length() - 1);
        }
    }
}