/* A bracket is considered to be any one of the following characters: ( ) { } [ or ].

Two brackets are a matched pair if the an opening bracket i.e. ( [ or { occurs to the left of a closing bracket i.e. ) ] or } of the same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.

Function Description - Complete the function isBalanced in the editor below.

isBalanced has the following parameter(s):
s: a string of brackets

Constraints
All characters are in the sequences { }  ( ) and  [ ].

Output Format
For each string, return YES or NO: YES if the sequence is balanced or NO if it is not.
*/

import java.io.*;
import java.util.*;

class Test {
    private static String isBalanced(String s){
        // Your code here

        List<Character> tempList = new ArrayList<>();
        Map<Character, Character> closing = new HashMap<>();
        closing.put(')', ')');
        closing.put('}', '}');
        closing.put(']', ']');
        closing.put('(', ')');
        closing.put('{', '}');
        closing.put('[', ']');

        for(int j=0; j<s.length(); j++){
            if(tempList.size()>0 && s.charAt(j)==closing.get(tempList.get(tempList.size()-1))){
                tempList.remove(tempList.size()-1);
            } else {
                tempList.add(s.charAt(j));
            }
        }

        if(tempList.size()==0) return "YES"; else return "NO" ;
    }

    public static void main(String[] args) {
        System.out.println( isBalanced( "{[()]}" ) );       // Should be YES
        System.out.println( isBalanced( "{{[[(())]]}}" ) ); // Should be YES
        System.out.println( isBalanced( "[]{}" ) );         // Should be YES
        System.out.println( isBalanced( "{[(])}" ) );       // Should be NO
        System.out.println( isBalanced( "[({}" ) );         // Should be NO
        System.out.println( isBalanced( "[]}" ) );          // Should be NO
        System.out.println( isBalanced( "[}]" ) );          // Should be NO
    }
}

