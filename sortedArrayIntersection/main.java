import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args) {
    System.out.println(getIntersection(new int[]{1,2,3,4,5}, new int[]{3,4,5,6,7}));
  }

  static int[] getIntersection(int[] one, int[] two) {
    int i, j = 0;
    int length = Math.max(one.length, two.length);
    List<Integer> result = new ArrayList<>();;

    while (i < one.length || j < two.length) {
      if (one[i] == two[j]) {
        result.add(one[i]);
        i++;
        j++;
      }

      if (one[i] < two[j]) {
        i++;
        continue;
      }

      if (one[i] > two[j]) {
        j++;
        continue;
      }
    }

    return result.toArray();
  }
}
