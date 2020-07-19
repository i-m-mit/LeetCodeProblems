package Util;

import CommonDS.*;

public class InputHelper {

    /**
     * Converts the first index of the commandline into Tree
     * 
     * @param args command line argument straight from main() method
     * @return root node of tree
     */
    public static TreeNode argsToTreeNode(String[] args) {
        checkInputArgs(args);
        String[] sInputs = stringToArray(args[0]);
        Integer[] input = argsToIntegerArray(sInputs);
        return TreeNode.createTree(input);
    }

    /**
     * Converts the first index of the commandline into Linked List
     * 
     * @param args command line argument straight from main() method
     * @return head node of linked list
     */
    public static ListNode argsToLisNode(String[] args) {
        checkInputArgs(args);
        String[] sInputs = stringToArray(args[0]);
        Integer[] input = argsToIntegerArray(sInputs);
        return ListNode.createLinkedList(input);
    }

    /**
     * Split the string into array of strings
     * 
     * @param args
     * @return array of strings
     */
    private static String[] stringToArray(String arg) {
        String sInput = arg.replace("[", "");
        sInput = sInput.replace("]", "");
        sInput = sInput.replace(" ", "");
        return sInput.split(",");
    }

    /**
     * Converts the first index of the commandline arguments into int array
     * 
     * @param args command line argument straight from main() method
     * @return converted int array
     */
    public static int[] stringToIntegers(String[] args) {
        checkInputArgs(args);
        String[] sInputs = stringToArray(args[0]);
        return argsToIntArray(sInputs);
    }

    /**
     * Converts the first index of the commandline arguments into 2D int array
     * 
     * @param args command line argument straight from main() method
     * @return converted int array
     */
    public static int[][] stringTo2DIntegerArray(String[] args) {
        checkInputArgs(args);
        String[] arrays = args[0].split("\\],\\[");
        int[][] retArray = new int[arrays.length][];
        int i = 0;
        for (String sInput : arrays) {
            retArray[i++] = stringToIntegers(new String[] { sInput });
        }
        return retArray;
    }

    /**
     * Converts string array into Integer array
     * 
     * @param args string array to be converted into Integer array
     * @return converted Integer array
     */
    public static Integer[] argsToIntegerArray(String[] args) {
        checkInputArgs(args);
        Integer[] retArray = new Integer[args.length];
        int i = 0;
        for (String s : args) {
            try {
                retArray[i] = Integer.parseInt(s);
            } catch (Exception e) {
                retArray[i] = null;
            }
            i++;
        }
        return retArray;
    }

    /**
     * Converts string array into int array
     * 
     * @param args string array to be converted into int array
     * @return converted int array
     */
    public static int[] argsToIntArray(String[] args) {
        checkInputArgs(args);
        int[] retArray = new int[args.length];
        int i = 0;
        for (String s : args) {
            try {
                retArray[i] = Integer.parseInt(s);
            } catch (Exception e) {

            }
            i++;
        }
        return retArray;
    }

    /**
     * Checks if input arguments are valid or not and throws exception if not
     * 
     * @param args command line argument straight from main() method
     */
    private static void checkInputArgs(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Input arguments are not adequate. Please check input arguments!!");
        }
    }
}