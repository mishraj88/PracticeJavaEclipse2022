package com.practice.string;

import java.util.HashMap;

public class MaxSubStrLnthWithNoRepeatingChars {

	public static void main(String[] args) {
		Solution obj = new Solution();
		String str = "bbbbb";
		int length = obj.lengthOfLongestSubstring(str);
		System.out.println("Length : " + length);
	}

}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 ) return 0;
        if(s == null) return 0;
        
    	HashMap<Character, Integer> map = new HashMap<>();
        //StringBuilder sb = new StringBuilder();
        //String maxSubstring = "";
        int maxSubLength = 1;
        
        int start = 0;
        int end = start;
        //char curr = s.charAt(start);
        //System.out.println("startChar: "+curr);
        //map.put(curr, start);
        
        //sb.append(s.charAt(start));
        do{
            char c = s.charAt(end);
            //System.out.println("start : "+start+", end: "+end+ ", endChar: "+c);
            if(map.get(c) == null || map.get(c) < start){
                map.put(c, end);
                //sb.append(c);
                end++;
            }else{
            	//System.out.println("====");
                //int length = sb.length();
                int length = end - start;
                //System.out.println(" start: "+start+ " , end ="+end+ ", currlength = "+length);
                if(maxSubLength < length){
                    maxSubLength = length;
                    //maxSubstring = sb.toString();
                    //sb.delete(0, length);
                    
					/*
					 * System.out.println("maxSub length: "+maxSubLength);
					 * System.out.println("start: "+start+" , end: "+end);
					 */
                }
                int newStart = map.get(c)+1;
                if(newStart > start)
                    start = newStart;
                else
                	start =start+1;
//                System.out.println("after moving start: "+start);
                map.put(c, end);
                //if(end < s.length())
                end = end+1;
//                System.out.println("before new iterations :start = " +start+" and  end: "+end);
                
//                System.out.println( "====");
            }
            
           
        }while(start < s.length() && end < s.length());
        if(end == s.length()){
            int diff = end -start;
            if(maxSubLength < diff) maxSubLength = diff;
            
        }
        return maxSubLength;
        
        
    }
}
