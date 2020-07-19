package Util;

import java.util.List;

public class ListToString {

    /**
     * Convert generic list into printable representation
     * 
     * @param input 1D generic list
     * @return string representation of the list
     */
    public static <T> String convertListToString(List<T> input) {
        if (input == null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer("[");
        for (T element : input) {
            buffer.append(element.toString() + ", ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("]");

        return buffer.toString();
    }

    /**
     * Convert generic list into printable representation
     * 
     * @param input 1D generic list
     * @return string representation of the list
     */
    public static <T> String convert2DListToString(List<List<T>> input) {
        if (input == null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer("[\n");
        for (List<T> subList : input) {
            buffer.append("\t[");
            if (subList.size() == 0) {
                buffer.append(", ");
            }
            for (T element : subList) {
                buffer.append(element.toString() + ", ");
            }
            buffer.deleteCharAt(buffer.length() - 1);
            buffer.deleteCharAt(buffer.length() - 1);
            buffer.append("],\n");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("\n]");

        return buffer.toString();
    }
}