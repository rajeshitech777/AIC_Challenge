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
public class SolutionDraft1Test {
	
	static final Logger logger = Logger.getLogger(SolutionDraft1Test.class);
	
	@Test
	public void testSum() {
		SolutionDraft1 soln = new SolutionDraft1();
		logger.info( "Testing sum" );
		int i = soln.sum(1, 1);
		assertEquals( i, 2);
	}

}
