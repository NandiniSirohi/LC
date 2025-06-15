class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int maxNum = num, minNum = num;

        // Generate max number by replacing the first digit that's not 9 with 9
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxNum = Integer.parseInt(s.replace(c, '9'));
                break;
            }
        }

        // Generate min number
        if (s.charAt(0) != '1') {
            minNum = Integer.parseInt(s.replace(s.charAt(0), '1'));
        } else {
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    minNum = Integer.parseInt(s.replace(c, '0'));
                    break;
                }
            }
        }

        return maxNum - minNum;
    }
}
