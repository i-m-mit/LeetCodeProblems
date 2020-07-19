package Util;

public class ArrayToString {

    /**
     * Convert int array into printable representation
     * 
     * @param input 1D int array
     * @return string representation of the array
     */
    public static String convert1DArrayToString(int[] input) {
        if (input.length == 0)
            return "";
        StringBuffer buffer = new StringBuffer("[");
        for (int element : input) {
            buffer.append(element + ", ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("]");

        return buffer.toString();
    }

    /**
     * Convert 2D int array into printable representation
     * 
     * @param input @D int array
     * @return string representation of the array
     */
    public static String convert2DArrayToString(int[][] input) {
        if (input.length == 0)
            return "";
        StringBuffer buffer = new StringBuffer("[");
        for (int[] subArray : input) {
            buffer.append("[");
            for (int element : subArray) {
                buffer.append(element + ", ");
            }
            buffer.deleteCharAt(buffer.length() - 1);
            buffer.deleteCharAt(buffer.length() - 1);
            buffer.append("], ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("]");

        return buffer.toString();
    }
}