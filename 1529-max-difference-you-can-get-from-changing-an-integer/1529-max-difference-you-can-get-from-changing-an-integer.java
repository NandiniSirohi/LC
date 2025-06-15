class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int maxNum = num;
        int minNum = num;

        // Maximize: Replace the first digit that is not 9 with 9
        for (char c : s.toCharArray()) {
            if (c != '9') {
                String maxStr = s.replace(c, '9');
                maxNum = Integer.parseInt(maxStr);
                break;
            }
        }

        // Minimize: 
        // If the first digit is not 1, replace it with 1 (avoid leading zero)
        // Else replace the first non-zero and non-one digit (excluding first) with 0
        if (s.charAt(0) != '1') {
            String minStr = s.replace(s.charAt(0), '1');
            minNum = Integer.parseInt(minStr);
        } else {
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    String minStr = s.replace(c, '0');
                    minNum = Integer.parseInt(minStr);
                    break;
                }
            }
        }

        return maxNum - minNum;
    }
}
