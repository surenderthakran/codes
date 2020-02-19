class Main {
  public static void main(String[] args) {

    System.out.println("Binary ==============================");

    int decimal = 224;
    System.out.println("Binary: " + Integer.toBinaryString(decimal));
    System.out.println("Decimal: " + decimal);
    System.out.println("highestOneBit: " + Integer.highestOneBit(decimal));
    System.out.println("lowestOneBit: " + Integer.lowestOneBit(decimal));
    System.out.println("numberOfLeadingZeros: " + Integer.numberOfLeadingZeros(decimal));
    System.out.println("numberOfTrailingZeros: " + Integer.numberOfTrailingZeros(decimal));

    System.out.println("\nDecimal ==============================");

    int binary = 0b11100000;
    System.out.println("Binary: " + Integer.toBinaryString(binary));
    System.out.println("Decimal: " + binary);
    System.out.println("highestOneBit: " + Integer.highestOneBit(binary));
    System.out.println("lowestOneBit: " + Integer.lowestOneBit(binary));
    System.out.println("numberOfLeadingZeros: " + Integer.numberOfLeadingZeros(binary));
    System.out.println("numberOfTrailingZeros: " + Integer.numberOfTrailingZeros(binary));

    System.out.println("\nUnsigned Decimal ==============================");

    int unsignedDecimal = Integer.parseUnsignedInt("224");
    System.out.println("Binary: " + Integer.toBinaryString(unsignedDecimal));
    System.out.println("Decimal: " + unsignedDecimal);
    System.out.println("highestOneBit: " + Integer.highestOneBit(unsignedDecimal));
    System.out.println("lowestOneBit: " + Integer.lowestOneBit(unsignedDecimal));
    System.out.println("numberOfLeadingZeros: " + Integer.numberOfLeadingZeros(unsignedDecimal));
    System.out.println("numberOfTrailingZeros: " + Integer.numberOfTrailingZeros(unsignedDecimal));

    System.out.println("\nUnsigned Binary ==============================");

    int unsignedBinary = Integer.parseUnsignedInt("11100000", 2);
    System.out.println("Binary: " + Integer.toBinaryString(unsignedBinary));
    System.out.println("Decimal: " + unsignedBinary);
    System.out.println("highestOneBit: " + Integer.highestOneBit(unsignedBinary));
    System.out.println("lowestOneBit: " + Integer.lowestOneBit(unsignedBinary));
    System.out.println("numberOfLeadingZeros: " + Integer.numberOfLeadingZeros(unsignedBinary));
    System.out.println("numberOfTrailingZeros: " + Integer.numberOfTrailingZeros(unsignedBinary));
  }
}
