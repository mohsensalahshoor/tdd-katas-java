package io.github.mohsensalahshoor.permutations;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is capable of finding all the permutations of a given string
 * using the Heap's algorithm.
 * To get all the permutations of a given string:
 * Set<String> perms = new PermutationsFinder().find(<string>);
 * @see <a href="https://en.wikipedia.org/wiki/Heap%27s_algorithm" target="_blank">https://en.wikipedia.org/wiki/Heap%27s_algorithm</a>
 */
public class PermutationsFinder {

    private Set<String> perms;

    /**
     * This method returns all the permutations of the given string
     * using the Heap's algorithm.
     * Throws java.lang.IllegalArgumentException if the string is null,
     * empty, or has duplicate characters.
     * The fact that it throws java.lang.IllegalArgumentException is because
     * the Heap's algorithm works on n different objects.
     * @param s the string to find all the permutations of
     * @return All the permutations of the parameter s
     * @see <a href="https://en.wikipedia.org/wiki/Heap%27s_algorithm" target="_blank">https://en.wikipedia.org/wiki/Heap%27s_algorithm</a>
     */
    public Set<String> find(String s) {
        if (s == null || s.isEmpty() || !hasUniqueLetters(s))
            throw new IllegalArgumentException("The specified string is either null, or empty, " +
                    "or contains duplicate characters");
        char[] chars = s.toCharArray();
        perms = new HashSet<>();
        permute(chars, chars.length);
        return perms;
    }

    public void permute(char[] v, int n) {
        /*
            This method uses the Heap's algorithm to find all
            the permutations of parameter v.
            Each time it finds a new permutation, it adds the
            permutation to the perms instance variable of the
            current class.
        */
        if (n == 1)
        {
            perms.add(String.copyValueOf(v));
        }
        else
        {
            for (int i = 0; i < n; i++)
            {
                permute(v, n - 1);
                if (n % 2 == 1)
                {
                    swap(v, 0, n - 1);
                }
                else
                {
                    swap(v, i, n - 1);
                }
            }
        }
    }
    private static void swap(char[] v, int i, int j) {
        char t = v[i];
        v[i] = v[j];
        v[j] = t;
    }
    private boolean hasUniqueLetters(String s) {
        /*
            This method assumes that string s is unicode
            It detects if s has duplicate characters this way:
            First it declares a boolean array of the size of unicode
            characters(65536). And then it iterates through the string
            char by char. For each character, it replaces the corresponding
            position (the numerical equivalence of char) in the array with true.
            If the position is already true, then the character is
            a duplicate in the string.
            It will immediately return false if s has more than 65536 characters, since
            there are at least 2 characters that are the same.

         */
        if (s.length() > 65536) return false;
        boolean[] char_set = new boolean[65536];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

}
