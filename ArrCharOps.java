/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */

/*/Implementation notes
The println(char[]) method: The code is given.
The charAt(char[],int) method: In this particular method you have to assume that the array is
not empty, meaning that it contains at least one element.
The lastIndexOf(char[]) method: Note that a for loop can also be written backwards: instead of
iterating, say, from 0 up to 10, you can iterate from 10 down to 0.

Introduction to CS, RUNI, 2024 / Homework 4 / page 2
The concat(char[], char[]) method: One thing that you must do in this method, at some point,
is creating a new array that will contain the concatenation of the two given arrays.
The compareTo(String, String) method: Unlike all the other methods in this class, this method
operates on strings, and not on arrays. An equivalent method that operates on arrays of characters
can easily developed, but we decided not to do it, since it complicates the method’s testing. So,
this will be a good opportunity to practice the syntax differences between array processing and
string processing.
Note that in this method you have to assume that both strings are not empty./*/

public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        //char[] arr3 = {'m','y','c','o','d','e'};
        //char[] arr4 = {'c','l','e','a','r','l','y'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
       // System.out.println(charAt(arr3,2)); 
       System.out.println(charAt(arr1,2));      
       //System.out.println(equals(arr1,arr4)); 
       System.out.println(equals(arr1, arr2));    
        //System.out.println(indexOf(arr1,'t'));  
        System.out.println(indexOf(arr1,'l'));
        //System.out.println(indexOf(arr1,'t',3));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
       //System.out.println("index = " + index);
       //System.out.println("arr = " + arr);
       int i;
       char c = '0';

        for( i = 0; i<=index; i++){
            //System.out.println("i= " + i);
            //System.out.println("char = " + arr [i]);
           c=arr[i];

        }

        return c;
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] somearray, char[] someotherarray) { //used to be arr1 and arr2
        int length1 = somearray.length;
        int length2 = someotherarray.length;
        //System.out.println("length 1: " + length1);
        //System.out.println("length 2: " + length2);
        if (length1 != length2) {
            return false;
            }
        int i;
        for(i=0; i<somearray.length; i++){
            if (somearray[i] != someotherarray[i]){
                return false;        
            }

        }
       return true;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
       // System.out.println("in function indeof");
      //  println(arr);
      //  System.out.println("char: " + ch);
        int i;
        for(i=0; i<arr.length; i++){
            if (arr[i] == ch){
                return i;
            }

        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        //System.out.println("in function idexof");
       // println(arr);
       // System.out.println("char: " + ch);
      //  System.out.println("from index: " + fromIndex);
        //OLD CODE - START
        /*int i;
        for (i=fromIndex; i < arr.length; i++ ){
            if(arr[i] == ch){
                return i;
            }
        }
        for (i=0; i<fromIndex; i++){
            if(arr[i] == ch){
                return i;
            }
        }
        
        return -1; */
        //OLD CODE - END
        int i;
        int firstIndex=-1;

        for (i=fromIndex; i < arr.length; i++ ){
            if(arr[i] == ch){
                if (firstIndex==-1 || i<firstIndex){
                    firstIndex=i;
                }
                //return i;
            }
        }    
        for (i=0; i<fromIndex; i++) {
            if(arr[i] == ch){
                if (firstIndex==-1 || i<firstIndex){
                    firstIndex=i;
                }
            } 
        }    
        return firstIndex;   
    }



    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
       //System.out.println("in function LastIndexOf");
     //  println(arr);
       //System.out.println("char: " + ch);
        int i;
        for(i=arr.length-1; i>=0; i--){
            if (arr[i] == ch){
                return i;
            }

        }
        return -1;
    }
    
    /* Returns an array which is the concatanation of the two given arrays.
    */
   /*/The concat(char[], char[]) method: One thing that you must do in this method, at some point,
    is creating a new array that will contain the concatenation of the two given arrays.*/
    public static char[] concat(char[] arr1, char[] arr2) {
        //System.out.println("function of concat");
        char[] result = new char[arr1.length + arr2.length];
        int i;
        for(i=0; i<arr1.length; i++){
            result[i] = arr1[i];  
        }
        int j;
         for(j=0; j<arr2.length; j++){
            result[i] = arr2[j];  
            i++;
        }
        return result;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        //System.out.println("in function subArray");
        char[] result = new char[endIndex - beginIndex];
        int i;
        int j=0;
        for(i=beginIndex; i < endIndex; i++){
            result[j] = arr[i];
            j++;
        }
        return result;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        //System.out.println("in function hash");
        long hash = 0;
        int i;
        if(arr.length==0){
            return 0;
        }
        for(i=0; i<arr.length; i++ ){
            hash += (long) arr[i] * (long) Math.pow(7, (arr.length - i - 1));
        }

        return hash;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        //System.out.println("functionofcompareto");  
        int i;
        int length; 

        if(str1.isEmpty() || str2.isEmpty()){
            return -2;
        }
  
        if(str1.length()<=str2.length()){
            length = str1.length();
        }
        else{
            length = str2.length();
        }

        for(i=0; i<str1.length();i++){
            if(str1.charAt(i) < str2.charAt(i)){
                return -1;
            }
            if(str1.charAt(i) > str2.charAt(i)){
                return 1;
            }      

        }
        if(str1.length()==str2.length()){
            return 0;
        }
        if(str1.length()>str2.length()){
            return 1;
        }
        if(str1.length()<str2.length()){
            return -1;
        }
        return -2;
    }
}
