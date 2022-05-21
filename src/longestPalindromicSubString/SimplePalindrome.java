package longestPalindromicSubString;

/**
 * A program to check if the string is a plindrome...
 */
public class SimplePalindrome {
    public static void main(String[] args) {
        String test1 = "abba";
        String test2 = "racecar";
        String test3 = "racecars";

        System.out.println(test1 + " is a palindrome: " + isAPalindrome(test1));
        System.out.println(test2 + " is a palindrome: " + isAPalindrome(test2));
        System.out.println(test3 + " is a palindrome: " + isAPalindrome(test3));

        System.out.println(test1 + " is a palindrome: " + isAPalindromeV2(test1));
        System.out.println(test2 + " is a palindrome: " + isAPalindromeV2(test2));
        System.out.println(test3 + " is a palindrome: " + isAPalindromeV2(test3));

    }

    public static boolean isAPalindrome(String s) {
        if (s.length() == 0 || s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static boolean isAPalindromeV2(String s) {
        if (s.length() < 1) return false;

        StringBuffer stringBuffer = new StringBuffer(s);
        if (stringBuffer.toString().equals(stringBuffer.reverse().toString())) {
            return true;
        }
        return false;
    }

}
