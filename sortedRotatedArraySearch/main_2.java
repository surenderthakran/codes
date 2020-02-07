/**
 * Given a sorted rotated array, find the index of a given element.
 *
 * In this method we would use recursion.
 * 1. Find a mid point in the array.
 * 2. If the mid point holds the searched number, return mid.
 * 3. If the sorted half holds the required number.
 *   a. Perform a binary search on the half.
 * 4. Else, recur from point 1 for the other half.
 */
