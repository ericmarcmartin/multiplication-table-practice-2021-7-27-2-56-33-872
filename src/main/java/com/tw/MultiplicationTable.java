package com.tw;

public class MultiplicationTable {
    public String create(int startNumber, int endNumber) {
        String multiplicationTable = "";
        if (isValid(isNumberInRange(startNumber, endNumber), isEndBiggerThanStart(startNumber, endNumber))) {
            multiplicationTable = generateMultiplicationTable(startNumber, endNumber);
        } else {
            return null;
        }
        System.out.println(multiplicationTable);
        return multiplicationTable;
    }

    public static String generateMultiplicationTable(int startNumber, int endNumber) {
        String multiplicationTable = "";
        multiplicationTable = generateMultiplicationLine(startNumber, endNumber, multiplicationTable);
        return multiplicationTable;
    }

    private static String generateMultiplicationLine(int startNumber, int endNumber, String multiplicationTable) {
        int multiplicationLine = startNumber;
        for (int i = startNumber; i <= endNumber; i++) {
            multiplicationTable = generateMultiplicationExpression(startNumber, multiplicationTable, multiplicationLine, i);
            if (multiplicationLine <= endNumber) {
                multiplicationLine++;
                multiplicationTable = multiplicationTable.concat(System.lineSeparator());
            }
        }
        return multiplicationTable;
    }

    private static String generateMultiplicationExpression(int startNumber, String multiplicationTable, int multiplicationLine, int i) {
        for (int j = startNumber; j <= multiplicationLine; j++) {
            multiplicationTable = multiplicationTable.concat(j + "*" + i + "=" + (j * i) + "  ");
        }
        return multiplicationTable;
    }

    private boolean isValid(boolean numberInRange, boolean endBiggerThanStart) {
        return numberInRange && endBiggerThanStart;
    }

    private boolean isEndBiggerThanStart(int startNumber, int endNumber) {
        return endNumber >= startNumber;
    }

    private boolean isNumberInRange(int startNumber, int endNumber) {
        return (startNumber >= 1 && startNumber <= 1000) && (
                endNumber >= 1 && endNumber <= 1000);
    }
}
