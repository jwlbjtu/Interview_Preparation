package two_sigma.set1;

import static org.junit.Assert.*;

import org.junit.Test;

public class WildcardMatchingTest {

	@Test
	public void testRecursive() {
		// test empty match
		assertTrue(WildcardMatching.recursive("", ""));
		assertFalse(WildcardMatching.recursive("", "?"));
		assertTrue(WildcardMatching.recursive("", "*"));
		assertFalse(WildcardMatching.recursive("", "a*"));
		assertTrue(WildcardMatching.recursive("", "**"));
		// test exact match
		assertTrue(WildcardMatching.recursive("a", "a"));
		assertTrue(WildcardMatching.recursive("abc", "abc"));
		assertFalse(WildcardMatching.recursive("abc", "abb"));
		assertFalse(WildcardMatching.recursive("a", ""));
		// test question mark match
		assertTrue(WildcardMatching.recursive("a", "?"));
		assertFalse(WildcardMatching.recursive("ac", "?"));
		assertFalse(WildcardMatching.recursive("a", "a?"));
		assertFalse(WildcardMatching.recursive("a", "?a"));
		assertFalse(WildcardMatching.recursive("a", "??"));
		assertTrue(WildcardMatching.recursive("ab", "??"));
		// test star match
		assertTrue(WildcardMatching.recursive("", "*"));
		assertTrue(WildcardMatching.recursive("a", "*"));
		assertTrue(WildcardMatching.recursive("abc", "*"));
		assertTrue(WildcardMatching.recursive("abc", "a*"));
		assertFalse(WildcardMatching.recursive("abc", "b*"));
		assertTrue(WildcardMatching.recursive("abc", "*c"));
		assertFalse(WildcardMatching.recursive("abc", "*d"));
		assertTrue(WildcardMatching.recursive("abbbdddccc", "a*c"));
		assertFalse(WildcardMatching.recursive("abc", "a*d"));
		// test question and star match
		assertTrue(WildcardMatching.recursive("a", "?*"));
		assertTrue(WildcardMatching.recursive("a", "*?"));
		assertTrue(WildcardMatching.recursive("ab", "*?"));
		assertFalse(WildcardMatching.recursive("a", "??*"));
		assertTrue(WildcardMatching.recursive("abc", "a?*c"));
		assertFalse(WildcardMatching.recursive("abc", "a?*d"));
		assertFalse(WildcardMatching.recursive("abc", "?*?d"));
		assertTrue(WildcardMatching.recursive("abc", "a***?c"));
	}

	@Test
	public void testIsMathDP() {
		// test empty match
		assertTrue(WildcardMatching.isMathDP("", ""));
		assertFalse(WildcardMatching.isMathDP("", "?"));
		assertTrue(WildcardMatching.isMathDP("", "*"));
		assertFalse(WildcardMatching.isMathDP("", "a*"));
		assertTrue(WildcardMatching.isMathDP("", "**"));
		// test exact match
		assertTrue(WildcardMatching.isMathDP("a", "a"));
		assertTrue(WildcardMatching.isMathDP("abc", "abc"));
		assertFalse(WildcardMatching.isMathDP("abc", "abb"));
		assertFalse(WildcardMatching.isMathDP("a", ""));
		// test question mark match
		assertTrue(WildcardMatching.isMathDP("a", "?"));
		assertFalse(WildcardMatching.isMathDP("ac", "?"));
		assertFalse(WildcardMatching.isMathDP("a", "a?"));
		assertFalse(WildcardMatching.isMathDP("a", "?a"));
		assertFalse(WildcardMatching.isMathDP("a", "??"));
		assertTrue(WildcardMatching.isMathDP("ab", "??"));
		// test star match
		assertTrue(WildcardMatching.isMathDP("", "*"));
		assertTrue(WildcardMatching.isMathDP("a", "*"));
		assertTrue(WildcardMatching.isMathDP("abc", "*"));
		assertTrue(WildcardMatching.isMathDP("abc", "a*"));
		assertFalse(WildcardMatching.isMathDP("abc", "b*"));
		assertTrue(WildcardMatching.isMathDP("abc", "*c"));
		assertFalse(WildcardMatching.isMathDP("abc", "*d"));
		assertTrue(WildcardMatching.isMathDP("abbbdddccc", "a*c"));
		assertFalse(WildcardMatching.isMathDP("abc", "a*d"));
		// test question and star match
		assertTrue(WildcardMatching.isMathDP("a", "?*"));
		assertTrue(WildcardMatching.isMathDP("a", "*?"));
		assertTrue(WildcardMatching.isMathDP("ab", "*?"));
		assertFalse(WildcardMatching.isMathDP("a", "??*"));
		assertTrue(WildcardMatching.isMathDP("abc", "a?*c"));
		assertFalse(WildcardMatching.isMathDP("abc", "a?*d"));
		assertFalse(WildcardMatching.isMathDP("abc", "?*?d"));
		assertTrue(WildcardMatching.isMathDP("abc", "a***?c"));
	}

	@Test
	public void testBacktracking() {
		// test empty match
		assertTrue(WildcardMatching.backtracking("", ""));
		assertFalse(WildcardMatching.backtracking("", "?"));
		assertTrue(WildcardMatching.backtracking("", "*"));
		assertFalse(WildcardMatching.backtracking("", "a*"));
		assertTrue(WildcardMatching.backtracking("", "**"));
		// test exact match
		assertTrue(WildcardMatching.backtracking("a", "a"));
		assertTrue(WildcardMatching.backtracking("abc", "abc"));
		assertFalse(WildcardMatching.backtracking("abc", "abb"));
		assertFalse(WildcardMatching.backtracking("a", ""));
		// test question mark match
		assertTrue(WildcardMatching.backtracking("a", "?"));
		assertFalse(WildcardMatching.backtracking("ac", "?"));
		assertFalse(WildcardMatching.backtracking("a", "a?"));
		assertFalse(WildcardMatching.backtracking("a", "?a"));
		assertFalse(WildcardMatching.backtracking("a", "??"));
		assertTrue(WildcardMatching.backtracking("ab", "??"));
		// test star match
		assertTrue(WildcardMatching.backtracking("", "*"));
		assertTrue(WildcardMatching.backtracking("a", "*"));
		assertTrue(WildcardMatching.backtracking("abc", "*"));
		assertTrue(WildcardMatching.backtracking("abc", "a*"));
		assertFalse(WildcardMatching.backtracking("abc", "b*"));
		assertTrue(WildcardMatching.backtracking("abc", "*c"));
		assertFalse(WildcardMatching.backtracking("abc", "*d"));
		assertTrue(WildcardMatching.backtracking("abbbdddccc", "a*c"));
		assertFalse(WildcardMatching.backtracking("abc", "a*d"));
		// test question and star match
		assertTrue(WildcardMatching.backtracking("a", "?*"));
		assertTrue(WildcardMatching.backtracking("a", "*?"));
		assertTrue(WildcardMatching.backtracking("ab", "*?"));
		assertFalse(WildcardMatching.backtracking("a", "??*"));
		assertTrue(WildcardMatching.backtracking("abc", "a?*c"));
		assertFalse(WildcardMatching.backtracking("abc", "a?*d"));
		assertFalse(WildcardMatching.backtracking("abc", "?*?d"));
		assertTrue(WildcardMatching.backtracking("abc", "a***?c"));
	}

}
