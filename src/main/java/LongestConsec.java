/*
You are given an array strarr of strings and an integer k. Your task is to return the first longest string consisting of k consecutive strings taken in the array.
Example:

longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"

n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
Note

consecutive strings : follow one after another without an interruption

 */

public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {

        String maxString = "";
        for (int i = 0; i < strarr.length - k + 1; i++) {
            String corentString = "";

            for (int j = 0; j < k; j++){
                corentString += strarr[i+j];
                if (corentString.length() > maxString.length()){
                    maxString = corentString;
                }
            }
        }
        return maxString;
    }
}
