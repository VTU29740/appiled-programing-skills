import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Step 1: Store allowed characters in a boolean array (or HashSet)
        boolean[] isAllowed = new boolean[26];
        for (char c : allowed.toCharArray()) {
            isAllowed[c - 'a'] = true;
        }

        int count = 0;

        // Step 2: Check each word
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!isAllowed[c - 'a']) {
                    isConsistent = false;
                    break; // Stop checking this word as soon as an invalid character is found
                }
            }
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}