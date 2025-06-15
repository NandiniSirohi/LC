class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int maxVal = num;
        int minVal = num;

        for (char from = '0'; from <= '9'; from++) {
            for (char to = '0'; to <= '9'; to++) {
                if (from == to) continue;
                String replaced = s.replace(from, to);
                int val = Integer.parseInt(replaced);
                maxVal = Math.max(maxVal, val);
                minVal = Math.min(minVal, val);
            }
        }

        return maxVal - minVal;
    }
}
