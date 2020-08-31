package io.github.mohsensalahshoor.permutations;



import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
This class is responsible for testing the PermutationsFinder class
The PermutationsFinder class must
1# Have a find method that takes only 1 argument that is of type String
2# The find method must return a Set<String> of all the permutations of the given string
3# The find method must throw java.lang.IllegalArgumentException if the given string is null or empty
4# The find method must throw java.lang.IllegalArgumentException if there are duplicate characters
in the given string.
 */
public class PermutationsFinderTest {
    private final static String EXAMPLE_STRING_THREE_CHARS = "abc";
    private final static String EXAMPLE_STRING_TWO_CHARS = "ab";

    @Test
    public void instantiationTest(){
        PermutationsFinder pf = new PermutationsFinder();
    }


    @Test
    public void testFindMethodWithTwoChars(){
        var expectedPerms = Set.of("ab", "ba");

        PermutationsFinder pf = new PermutationsFinder();
        Set<String> perms = pf.find(EXAMPLE_STRING_TWO_CHARS);

        assertEquals(perms, expectedPerms);
    }

    @Test
    public void testFindMethodWithThreeChars(){
        var expectedPerms = Set.of("abc", "bac", "cab", "acb", "bca", "cba");

        PermutationsFinder pf = new PermutationsFinder();
        Set<String> perms = pf.find(EXAMPLE_STRING_THREE_CHARS);

        assertEquals(perms, expectedPerms);
    }

    @Test
    public void testAcceptsNullOrEmpty(){
        PermutationsFinder pf = new PermutationsFinder();

        assertThrows(IllegalArgumentException.class, () -> pf.find(null) );

        assertThrows(IllegalArgumentException.class, () -> pf.find(""));
    }

    @Test
    public void testAcceptsDuplicateChars(){
        String sWithDuplicates = "ABB";

        PermutationsFinder pf = new PermutationsFinder();

        assertThrows(IllegalArgumentException.class, () -> pf.find(sWithDuplicates));
    }

}
