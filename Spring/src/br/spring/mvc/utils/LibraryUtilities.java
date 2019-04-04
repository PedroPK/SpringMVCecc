package br.spring.mvc.utils;

public class LibraryUtilities {
	
	public static boolean isStringValid(String pString) {
		boolean answer = false;
		
		if (
				pString != null		&&
				!pString.isEmpty()
		) {
			answer = true;
		}
		
		return answer;
	}
	
}