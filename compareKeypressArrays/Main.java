package com.surenderthakran.codes.comparekeypressarrays;

/**
 * Given two arrays of keypresses, determine if they would print the same string.
 *
 * <p>The keypress arrays can only contain lowercase characters and backspace character represented
 * by '#';
 */
class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert Solution1.areKeypressArraysEqual(
              new char[] {'a', 'b', 'c', '#', 'd'}, new char[] {'a', 'c', '#', 'b', 'd'})
          == true;
      assert Solution1.areKeypressArraysEqual(
              new char[] {'a', 'b', 'c', '#', 'd', 'e'}, new char[] {'a', 'c', '#', 'b', 'd'})
          == false;
      assert Solution1.areKeypressArraysEqual(
              new char[] {'#', 'a', 'b', 'c', '#', 'd'}, new char[] {'a', 'c', '#', 'b', 'd'})
          == true;
      assert Solution1.areKeypressArraysEqual(
              new char[] {'a', 'b', 'c', '#', 'd', 'e', '#'}, new char[] {'a', 'c', '#', 'b', 'd'})
          == true;
      assert Solution1.areKeypressArraysEqual(
          new char[] {'a', 'b', 'c', '#', 'd','#', '#'}, new char[] {'a'})
          == true;

      assert Solution2.areKeypressArraysEqual(
          new char[] {'a', 'b', 'c', '#', 'd'}, new char[] {'a', 'c', '#', 'b', 'd'})
          == true;
      assert Solution2.areKeypressArraysEqual(
          new char[] {'a', 'b', 'c', '#', 'd', 'e'}, new char[] {'a', 'c', '#', 'b', 'd'})
          == false;
      assert Solution2.areKeypressArraysEqual(
          new char[] {'#', 'a', 'b', 'c', '#', 'd'}, new char[] {'a', 'c', '#', 'b', 'd'})
          == true;
      assert Solution2.areKeypressArraysEqual(
          new char[] {'a', 'b', 'c', '#', 'd', 'e', '#'}, new char[] {'a', 'c', '#', 'b', 'd'})
          == true;
      assert Solution2.areKeypressArraysEqual(
          new char[] {'a', 'b', 'c', '#', 'd','#', '#'}, new char[] {'a'})
          == true;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
