package com.practice.leetCode;

public class LongestPallindromicString {

	public static void main(String[] args) {
		PalStringSolution obj = new PalStringSolution();
		String str = "abb";
		String sub = obj.longestPalindrome(str);
		System.out.println("sub: "+sub);
		
		//String test = new String("a").substring(0, 1);
		//System.out.println("test: "+test);
	}

}

class PalStringSolution {
	public String longestPalindrome(String s) {
		String str = "";
		int start = 0;
		int end = s.length()-1;
		int maxSubLength = 0;
		int record_start= start;
		int record_end = end;
		int count = 0;
		if(s.length() == 0) return str;
		if(s.length() == 1) return s;
		for(int i=0; i< s.length(); i++){
			start = i;
			record_start = start;
			end = s.length()-1;
			while(end >= start){
				char c1 = s.charAt(start);
				char c2= s.charAt(end);
				if(c1 == c2 && end !=start){
					//record_end= end;
					end--;
					start++;
					count = count + 2;
				}else{
					if(c1==c2 && end == start) {
						count++;
						break;
					}
					end--;
					record_end = end;
				}
			}
			if((start == end || end == start-1) && count > str.length()){
				maxSubLength = count;
				System.out.println("record_start: "+record_start);
				System.out.println("record_end: "+record_end);
				str = s.substring(record_start, record_end+1);
				System.out.println("str: "+str);


			}
			count = 0;
			/*if(maxSubLength == count && (start == end || end == start-1)){
				//maxSubLength = count;
				//System.out.println(record_start);
				//System.out.println(record_end);
				String alt = s.substring(record_start, record_end+1);
				System.out.println("str = "+str);
				System.out.println("alt = "+alt);


			}*/




		}
		return str;
	}



}
