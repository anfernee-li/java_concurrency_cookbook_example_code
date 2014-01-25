/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Leetcode_addBinary;

/**
 *
 * @author anferneelee
 */
public class Leetcode_addBinary {
    public static String addBinary(String a, String b) {
        return add(a, b);
    }
    
    public static String[] lookUpTable = {
        "0+0+0=00",
        "0+0+1=01",
        "0+1+0=01",
        "1+0+0=01",
        "1+1+0=10",
        "1+0+1=10",
        "0+1+1=10",
        "1+1+1=11",
    };
    
    public static String lookUp(char a, char b, char c) {
        String formula = String.format("%c+%c+%c=", a, b, c);
        for(String s: lookUpTable) {
            if (s.startsWith(formula)){
                return s.substring(s.indexOf("=")+1);
            }
        }
        throw new IllegalArgumentException();
    }
    
    public static String zeroPad(String s, int length) {
        while(s.length()<length){
            s = "0"+s;
        }
        return s;
    }
    
    public static String add(String s1, String s2) {
        int length = Math.max(s1.length(), s2.length());
        s1 = zeroPad(s1, length);
        s2 = zeroPad(s2, length);
        String result = "";
        char carry = '0';
        for (int i=length-1; i>=0; i--) {
            String columnResult = lookUp(s1.charAt(i), s2.charAt(i), carry);
            result = columnResult.charAt(1) + result;
            carry = columnResult.charAt(0);
        }
        if (carry == '1') {
            result = carry + result;
        }
        return result;
    }
    
    public static void main(String[] args) {
        String a = "1";
        String b = "1";
        String result = addBinary(a, b);
        System.out.printf("%s + %s = %s\n", a, b, result);
    }
}
