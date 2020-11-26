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
     * Converts the first index of the commandline into Tree
     * 
     * @param args  command line argument straight from main() method
     * @param index index of command line argument array
     * @return root node of tree
     */
    public static TreeNode argsToTreeNode(String[] args, int index) {
        checkInputArgs(args);
        String[] sInputs = stringToArray(args[index]);
        Integer[] input = argsToIntegerArray(sInputs);
        return TreeNode.createTree(input);
    }

    /**
     * Converts the first index of the commandline into N-aryTree
     * 
     * @param args command line argument straight from main() method
     * @return root node of n-ary tree
     */
    public static NaryTreeNode argsToNaryTreeNode(String[] args) {
        checkInputArgs(args);
        String[] sInputs = stringToArray(args[0]);
        Integer[] input = argsToIntegerArray(sInputs);
        return NaryTreeNode.createTree(input);
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
     * Converts the first index of the commandline into Linked List
     * 
     * @param args command line argument straight from main() method
     * @param index index of command line argument array
     * @return head node of linked list
     */
    public static ListNode argsToLisNode(String[] args, int index) {
        checkInputArgs(args);
        String[] sInputs = stringToArray(args[index]);
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
     * Converts the first index of the commandline arguments into char array
     * 
     * @param args command line argument straight from main() method
     * @return converted char array
     */
    public static char[] stringToChars(String[] args) {
        checkInputArgs(args);
        String[] sInputs = stringToArray(args[0]);
        return argsToCharArray(sInputs);
    }

    /**
     * Converts the first index of the commandline arguments into int array
     * 
     * @param args  command line argument straight from main() method
     * @param index index of string in args[]
     * @return converted int array
     */
    public static int[] stringToIntegers(String[] args, int index) {
        checkInputArgs(args);
        if (index >= args.length) {
            throw new IllegalArgumentException("Index not present in args[]");
        }
        String[] sInputs = stringToArray(args[index]);
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
     * Converts the first index of the commandline arguments into 2D char array
     * 
     * @param args command line argument straight from main() method
     * @return converted char array
     */
    public static char[][] stringTo2DCharArray(String[] args) {
        checkInputArgs(args);
        String[] arrays = args[0].split("\\],\\[");
        char[][] retArray = new char[arrays.length][];
        int i = 0;
        for (String sInput : arrays) {
            retArray[i++] = stringToChars(new String[] { sInput });
        }
        return retArray;
    }

    /**
     * Converts string array into Integer array
     * 
     * @param args string array to be converted into Integer array
     * @return converted Integer array
     */
    private static Integer[] argsToIntegerArray(String[] args) {
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
    private static int[] argsToIntArray(String[] args) {
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
     * Converts string array into char array
     * 
     * @param args string array to be converted into char array
     * @return converted char array
     */
    public static char[] argsToCharArray(String[] args) {
        checkInputArgs(args);
        char[] retArray = new char[args.length];
        int i = 0;
        for (String s : args) {
            try {
                retArray[i] = s.charAt(1);
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

    /**
     * Converts string array into char array
     * 
     * @param args command line argument straight from main() method
     * @return converted char array
     */
    public static char[] argsToCharacterArray(String[] args) {
        checkInputArgs(args);
        String input = args[0];
        input = input.replace("[", "").replace("]", "");
        String[] chars = input.split(",");
        char[] retArray = new char[chars.length];
        int i = 0;
        for (String s : chars) {
            retArray[i++] = s.charAt(0);
        }
        return retArray;
    }
}