/**
 * Design a class for a jar containing coloured marbles which supports the following operations:
 *
 * 1. Add marbles to jar.
 * 2. Randomly take a marble from the jar, identify its color and put it back in the jar.
 * 3. Randomly take a marble from the jar and identify its color.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

enum Colour {
  RED, BLUE, GREEN, YELLOW, ORANGE, BLACK, BROWN
}

class Marble {
  private Colour colour;

  Marble(Colour colour) {
    this.colour = colour;
  }

  Colour getColour() {
    return this.colour;
  }
}

class Jar {
  List<Marble> marbleList;
  Map<Marble, Integer> marbleMap;

  Jar() {
    this.marbleList = new ArrayList<Marble>();
    this.marbleMap = new HashMap<Marble, Integer>();
  }

  void insertMarbles(Marble[] marbles) {
    for (Marble marble : marbles) {
      marbleList.add(marble);
      marbleMap.put(marble, marbleList.size() - 1);
    }
  }

  Marble peekRandomMarble() {}

  Marble removeRandomMarble() {}

  private Marble getRandomFromList() {

  }
}

class Main {
  public static void main (String[] args) {
    Marble red = new Marble(Colour.RED);

    Jar jar = new Jar();
    jar.insertMarbles(new Marble[]{red});
  }
}
