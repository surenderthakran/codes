package com.surenderthakran.coding.classwithinsertrandompeekanddelete;

/**
 * Design a class for a jar containing coloured marbles which supports the following operations:
 *
 * <p>1. Add marbles to jar. 2. Randomly take a marble from the jar, identify its color and put it
 * back in the jar. 3. Randomly take a marble from the jar and identify its color.
 *
 * <p>Solution is to use a List data structure to hold marbles in the jar. For fetching random
 * marbles, we use java.util's Random class.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

enum Colour {
  RED,
  BLUE,
  GREEN
}

class Marble {
  private final Colour colour;

  Marble(Colour colour) {
    this.colour = colour;
  }

  Colour getColour() {
    return this.colour;
  }
}

class Jar {
  List<Marble> marbleList;

  Jar() {
    this.marbleList = new ArrayList<Marble>();
  }

  void insertMarbles(Marble[] marbles) {
    for (Marble marble : marbles) {
      marbleList.add(marble);
    }
  }

  Marble peekRandomMarble() {
    return this.marbleList.get(this.getRandomListIndex());
  }

  Marble removeRandomMarble() {
    return this.marbleList.remove(this.getRandomListIndex());
  }

  int getSize() {
    return this.marbleList.size();
  }

  Colour[] getMarbleColours() {
    return this.marbleList.stream().map(marble -> marble.getColour()).toArray(Colour[]::new);
  }

  private int getRandomListIndex() {
    Random random = new Random();
    return random.ints(0, this.marbleList.size()).findFirst().getAsInt();
  }
}

class Main {
  public static void main(String[] args) {
    Marble red1 = new Marble(Colour.RED);
    Marble red2 = new Marble(Colour.RED);
    Marble red3 = new Marble(Colour.RED);

    Marble blue1 = new Marble(Colour.BLUE);
    Marble blue2 = new Marble(Colour.BLUE);
    Marble blue3 = new Marble(Colour.BLUE);
    Marble blue4 = new Marble(Colour.BLUE);

    Marble green1 = new Marble(Colour.GREEN);
    Marble green2 = new Marble(Colour.GREEN);

    Jar jar = new Jar();
    jar.insertMarbles(new Marble[] {red1, blue1, green1, red2, blue2, green2, red3, blue3, blue4});

    System.out.println("Jar size: " + jar.getSize());
    System.out.println(Arrays.toString(jar.getMarbleColours()));

    for (int i = 0; i < 5; i++) {
      System.out.println(jar.peekRandomMarble().getColour());
      System.out.println(jar.removeRandomMarble().getColour());

      System.out.println("Jar size: " + jar.getSize());
      System.out.println(Arrays.toString(jar.getMarbleColours()));
    }
  }
}
