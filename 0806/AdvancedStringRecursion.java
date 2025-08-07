public class AdvancedStringRecursion {
    // 所有排列組合
    public static void permute(String s, String result) {
        if (s.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            permute(s.substring(0, i) + s.substring(i + 1), result + s.charAt(i));
        }
    }

    // 字串匹配
    public static boolean match(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        if (pattern.charAt(0) == '*') {
            return match(text, pattern.substring(1)) ||
                   (!text.isEmpty() && match(text.substring(1), pattern));
        } else if (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0))) {
            return match(text.substring(1), pattern.substring(1));
        } else {
            return false;
        }
    }

    // 移除重複字符
    public static String removeDuplicates(String s, String seen) {
        if (s.isEmpty()) return "";
        char c = s.charAt(0);
        if (seen.indexOf(c) != -1)
            return removeDuplicates(s.substring(1), seen);
        else
            return c + removeDuplicates(s.substring(1), seen + c);
    }

    // 所有子字串組合
    public static void substrings(String s, String curr, int index) {
        if (index == s.length()) {
            System.out.println(curr);
            return;
        }
        substrings(s, curr, index + 1); // 不選
        substrings(s, curr + s.charAt(index), index + 1); // 選
    }
}
