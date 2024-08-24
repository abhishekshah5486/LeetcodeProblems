class Solution {
    public boolean exist(char[][] board, String word) {
        List<List<Character>> arr = new ArrayList<>();
        for (int j=0; j<board.length; j++){
            List<Character> temp = new ArrayList<>();
            for (int k=0; k<board[0].length; k++){
                temp.add(board[j][k]);
            }
            arr.add(temp);
        }
        boolean ans = false;
        for (int j=0; j<arr.size(); j++){
            for (int k=0; k<arr.get(0).size(); k++){
                if (arr.get(j).get(k) == word.charAt(0)){
                    ans = ans || solveWordSearch_I(arr, word, j, k, 1);
                }
                if (ans) break;
            }
        }
        return ans;
    }
    public static boolean solveWordSearch_I(List<List<Character>> board, String word, int r, int c, int idx){
        if (idx == word.length()) return true;

        int[][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };
        char blockedVal = board.get(r).get(c);
        board.get(r).set(c, '.');
        for (int j=0; j<directions.length; j++){
            int nr = r + directions[j][0];
            int nc = c + directions[j][1];
            if (nr >= 0 && nc >= 0 && nr < board.size() && nc < board.get(0).size() && board.get(nr).get(nc) == word.charAt(idx) && board.get(nr).get(nc) != '.'){
                if (solveWordSearch_I(board, word, nr, nc, idx + 1)) return true;
            }
        }
        board.get(r).set(c, blockedVal);
        return false;
    }
}