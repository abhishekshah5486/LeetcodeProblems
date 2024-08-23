class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> currIPSequence = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solveRestoreIPAddress(ans, currIPSequence, s, 0, s.length() - 1);
        return ans;
    }
    public static void solveRestoreIPAddress(List<String> ans, List<String> currIPSequence, String str, int s, int e){
        if (currIPSequence.size() > 4) return;
        if (s > e){
            if (currIPSequence.size() < 4) return;
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<currIPSequence.size(); j++){
                sb.append(currIPSequence.get(j));
                if (j != currIPSequence.size() - 1) sb.append(".");
            }
            ans.add(sb.toString());
            return;
        }
        for (int j=s; j<=e; j++){
            String substr = subStr(str, s, j);
            if (isValidOctet(substr)){
                currIPSequence.add(substr);
                solveRestoreIPAddress(ans, currIPSequence, str, j + 1, e);
                currIPSequence.remove(currIPSequence.size() - 1);
            }
        }
    }
    public static String subStr(String str, int j, int k){
        StringBuilder sb = new StringBuilder();
        for (int idx = j; idx<=k; idx++){
            sb.append(str.charAt(idx));
        }
        return sb.toString();
    }
    public static boolean isValidOctet(String octet){
        if (octet.length() > 1 && octet.charAt(0) == '0') return false;
        int octetNum = 0;
        for (int j=0; j<octet.length(); j++){
            char ch = octet.charAt(j);
            octetNum = octetNum * 10 + (ch - '0');
            if (octetNum > 255) return false;
        }
        return true;
    }
}