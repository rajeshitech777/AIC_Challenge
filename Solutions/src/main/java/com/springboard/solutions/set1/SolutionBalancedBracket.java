/**
 * 
 */
package com.springboard.solutions.set1;

/**
 * @author CharlesDarwin
 *
 */
public class SolutionBalancedBracket {
	
	//[{(1+2)*(x-4)}]
	public boolean checkBalanced(String[] args, StringBuffer outputBuffer ) {
		boolean balanced = false;
		if ( 0 == args.length) {
			return balanced;
		}
		
		char x;
		int op=0, cl=0;
				
		for( String a: args) {
			for( int i=0; i<a.length(); i++ ) {
				x = a.charAt(i);
				if ( x == '[' ||  x == '{' ||  x == '('  ) {
					op++ ;	
					outputBuffer.append( x );
				}
				else if ( x == ']' ||  x == '}' ||  x == ')'  ) {
					cl++;
					outputBuffer.append( x );
				}
				else {
					//do nothing
				}
			}
		}
		balanced = (op==cl);
		System.out.println(balanced + " " + outputBuffer.toString());
		return balanced;		
	}
	

}
