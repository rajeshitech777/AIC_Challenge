/**
 * 
 */
package com.springboard.solutions.set1;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

/**
 * @author CharlesDarwin
 *
 */
public class SolutionBalancedBracketTest {
	
	static final Logger logger = Logger.getLogger(SolutionBalancedBracketTest.class);
	
	@Test
	public void testCheckBalanced() {
		SolutionBalancedBracketTest soln = new SolutionBalancedBracketTest();
		logger.info( "Testing SolutionBalancedBracketTest" );
		StringBuffer outputBuffer = new StringBuffer();
		String[] args = new String[] { "[[{(1+2)*(x-4)}]" };		
		boolean result = new SolutionBalancedBracket().checkBalanced(args, outputBuffer);
		assertTrue(result);
	}

}
