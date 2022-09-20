// https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-swaps-to-make-palindrome-e931689f8cae

/*
public static int getSwapsToMakePalindrome(String s) {
    if (!isShuffledPalindrome(s)) {
      return -1;
    }
     char[] chars = s.toCharArray();

     int left = 0;
     int mid = chars.length / 2;

     int count = 0;
     while (left <= mid) {
       int right = chars.length - 1 - left;

       if (chars[left] == chars[right]) {
         left++;
         continue;
       } else {
         int r = right;
         while (r > left) {
           if (chars[left] == chars[r]) {
             break;
           }
           r--;
         }
         if (r > left) {
           swap(chars, r, right);
           count += (right - r);
         } else {
           swap(chars, left, left + 1);
           count++;
         }
       }
     }

     return count;
   }

  private static void swap(char[] chars, int first, int second) {
    char tmp = chars[first];
    chars[first] = chars[second];
    chars[second] = tmp;
  }

  private static boolean isShuffledPalindrome(String s) {
    HashMap<Character, Integer> freqMap = new HashMap<>();

    int oddFreq = 0;
    for (char ch : s.toCharArray()) {
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    for (Integer freq : freqMap.values()) {
      if (!isEven(freq)) {
        oddFreq++;
      }
    }

    return oddFreq <= 1;
  }

  private static boolean isEven(int n) {
    return n % 2 == 0;
  }
 */