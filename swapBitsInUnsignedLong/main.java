class Main {
  public static void main(String[] args) {

    System.out.println("Binary ==============================");

    int decimal = Integer.MAX_VALUE;
    System.out.println("Binary: " + Integer.toBinaryString(decimal));
    System.out.println("Decimal: " + decimal);
    System.out.println("highestOneBit: " + Integer.highestOneBit(decimal));
    System.out.println("lowestOneBit: " + Integer.lowestOneBit(decimal));
    System.out.println("numberOfLeadingZeros: " + Integer.numberOfLeadingZeros(decimal));
    System.out.println("numberOfTrailingZeros: " + Integer.numberOfTrailingZeros(decimal));

    int reverseDecimal = Integer.reverse(decimal);
    System.out.println("\nreversed Value in Decimal: " + reverseDecimal);
    System.out.println("reversed Value in Binary: " + Integer.toBinaryString(reverseDecimal));

    int reverseBytesDecimal = Integer.reverseBytes(decimal);
    System.out.println("\nbyte Reversed Value in Decimal: " + reverseBytesDecimal);
    System.out.println("byte Reversed Value in Binary: " + Integer.toBinaryString(reverseBytesDecimal));

    int rotateLeftDecimal = Integer.rotateLeft(decimal, 3);
    System.out.println("\nleft Rotated Value in Decimal: " + rotateLeftDecimal);
    System.out.println("left Rotated Value in Binary: " + Integer.toBinaryString(rotateLeftDecimal));

    int rotateRightDecimal = Integer.rotateRight(decimal, 3);
    System.out.println("\nright Rotated Value in Decimal: " + rotateRightDecimal);
    System.out.println("right Rotated Value in Binary: " + Integer.toBinaryString(rotateRightDecimal));

    // System.out.println("\nDecimal ==============================");
    //
    // int binary = 0b11100000;
    // System.out.println("Binary: " + Integer.toBinaryString(binary));
    // System.out.println("Decimal: " + binary);
    // System.out.println("highestOneBit: " + Integer.highestOneBit(binary));
    // System.out.println("lowestOneBit: " + Integer.lowestOneBit(binary));
    // System.out.println("numberOfLeadingZeros: " + Integer.numberOfLeadingZeros(binary));
    // System.out.println("numberOfTrailingZeros: " + Integer.numberOfTrailingZeros(binary));
    //
    // int reverseBinary = Integer.reverse(binary);
    // System.out.println("\nreversed Value in Decimal: " + reverseBinary);
    // System.out.println("reversed Value in Binary: " + Integer.toBinaryString(reverseBinary));
    //
    // int reverseBytesBinary = Integer.reverseBytes(binary);
    // System.out.println("\nbyte Reversed Value in Decimal: " + reverseBytesBinary);
    // System.out.println("byte Reversed Value in Binary: " + Integer.toBinaryString(reverseBytesBinary));
    //
    // int rotateLeftBinary = Integer.rotateLeft(binary, 3);
    // System.out.println("\nleft Rotated Value in Decimal: " + rotateLeftBinary);
    // System.out.println("left Rotated Value in Binary: " + Integer.toBinaryString(rotateLeftBinary));
    //
    // int rotateRightBinary = Integer.rotateRight(binary, 3);
    // System.out.println("\nright Rotated Value in Decimal: " + rotateRightBinary);
    // System.out.println("right Rotated Value in Binary: " + Integer.toBinaryString(rotateRightBinary));

    System.out.println("\nUnsigned Decimal ==============================");

    int unsignedDecimal = Integer.parseUnsignedInt("2147483647") - Integer.parseUnsignedInt("2147483647");
    System.out.println("Binary: " + Integer.toBinaryString(unsignedDecimal));
    System.out.println("Decimal: " + unsignedDecimal);
    System.out.println("Unsigned Value: " + Integer.toUnsignedString(unsignedDecimal));
    System.out.println("highestOneBit: " + Integer.highestOneBit(unsignedDecimal));
    System.out.println("lowestOneBit: " + Integer.lowestOneBit(unsignedDecimal));
    System.out.println("numberOfLeadingZeros: " + Integer.numberOfLeadingZeros(unsignedDecimal));
    System.out.println("numberOfTrailingZeros: " + Integer.numberOfTrailingZeros(unsignedDecimal));

    int reverseUnsignedDecimal = Integer.reverse(unsignedDecimal);
    System.out.println("\nreversed Value in Decimal: " + reverseUnsignedDecimal);
    System.out.println("reversed Value in Binary: " + Integer.toBinaryString(reverseUnsignedDecimal));

    int reverseBytesUnsignedDecimal = Integer.reverseBytes(unsignedDecimal);
    System.out.println("\nbyte Reversed Value in Decimal: " + reverseBytesUnsignedDecimal);
    System.out.println("byte Reversed Value in Binary: " + Integer.toBinaryString(reverseBytesUnsignedDecimal));

    int rotateLeftUnsignedDecimal = Integer.rotateLeft(unsignedDecimal, 3);
    System.out.println("\nleft Rotated Value in Decimal: " + rotateLeftUnsignedDecimal);
    System.out.println("left Rotated Value in Binary: " + Integer.toBinaryString(rotateLeftUnsignedDecimal));

    int rotateRightUnsignedDecimal = Integer.rotateRight(unsignedDecimal, 3);
    System.out.println("\nright Rotated Value in Decimal: " + rotateRightUnsignedDecimal);
    System.out.println("right Rotated Value in Binary: " + Integer.toBinaryString(rotateRightUnsignedDecimal));

    // System.out.println("\nUnsigned Binary ==============================");
    //
    // int unsignedBinary = Integer.parseUnsignedInt("11100000", 2);
    // System.out.println("Binary: " + Integer.toBinaryString(unsignedBinary));
    // System.out.println("Decimal: " + unsignedBinary);
    // System.out.println("highestOneBit: " + Integer.highestOneBit(unsignedBinary));
    // System.out.println("lowestOneBit: " + Integer.lowestOneBit(unsignedBinary));
    // System.out.println("numberOfLeadingZeros: " + Integer.numberOfLeadingZeros(unsignedBinary));
    // System.out.println("numberOfTrailingZeros: " + Integer.numberOfTrailingZeros(unsignedBinary));
    //
    // int reverseUnsignedBinary = Integer.reverse(unsignedBinary);
    // System.out.println("\nreversed Value in Decimal: " + reverseUnsignedBinary);
    // System.out.println("reversed Value in Binary: " + Integer.toBinaryString(reverseUnsignedBinary));
    //
    // int reverseBytesUnsignedBinary = Integer.reverseBytes(unsignedBinary);
    // System.out.println("\nbyte Reversed Value in Decimal: " + reverseBytesUnsignedBinary);
    // System.out.println("byte Reversed Value in Binary: " + Integer.toBinaryString(reverseBytesUnsignedBinary));
    //
    // int rotateLeftUnsignedBinary = Integer.rotateLeft(unsignedBinary, 3);
    // System.out.println("\nleft Rotated Value in Decimal: " + rotateLeftUnsignedBinary);
    // System.out.println("left Rotated Value in Binary: " + Integer.toBinaryString(rotateLeftUnsignedBinary));
    //
    // int rotateRightUnsignedBinary = Integer.rotateRight(unsignedBinary, 3);
    // System.out.println("\nright Rotated Value in Decimal: " + rotateRightUnsignedBinary);
    // System.out.println("right Rotated Value in Binary: " + Integer.toBinaryString(rotateRightUnsignedBinary));
  }
}
