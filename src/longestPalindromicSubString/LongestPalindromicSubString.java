package longestPalindromicSubString;

/**
 * Given a string s, return the longest palindromic substring in s
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 */

@SuppressWarnings("unused")
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String test1 = "abba";
        String test2 = "racecar";
        String test3 = "abbbbdasgdu";

        System.out.println("longest substring for test1: " + getLongestPalindromicSubString(test1));
        System.out.println("longest substring for test2: " + getLongestPalindromicSubString(test2));
        System.out.println("longest substring for test3: " + getLongestPalindromicSubString(test3));
    }

    public static String getLongestPalindromicSubString(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // handle 2 cases:
            // 1) when there is a special character in between two strings: eg-> racecar
            // 2) when there is a regular palindrome: eg -> abba

            // handling case 1:
            int len1 = expandAroundCenter(s, i, i);

            // handling case 2:
            int len2 = expandAroundCenter(s, i, i + 1);

            // get the max of both the strings:
            int lenMax = Math.max(len1, len2);

            if (lenMax > end - start) {
                start = i - ((lenMax - 1) / 2);
                end = i + ((lenMax) / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        if (s == null || left > right) return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
