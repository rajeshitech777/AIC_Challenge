/**
 * 
 */
package com.springboard.solutions.set1;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author CharlesDarwin
 *
 */
public class SolutionJsonRecordsTest {
	static final Logger logger = Logger.getLogger(SolutionBalancedBracketTest.class);
	
	@Test	
	public void printGradesTest() {
		SolutionJsonRecords sj = new SolutionJsonRecords();
		StringBuffer jsonData = new StringBuffer()
				.append( "{ \"report\": [ " )
				//each record
				.append( " { " )
				.append( " \"enrollment\" : \"e123\", " )
				.append( " \"name\" : \"Mat\", " )
				
				.append( " \"subject\" : [ " )
				
					.append( " { " )
					.append( " \"code\" : \"c1\", " )
					.append( " \"grade\" : \"A\", " )	
					.append( " }, " )
					.append( " { " )
					.append( " \"code\" : \"c2\", " )
					.append( " \"grade\" : \"B\", " )	
					.append( " } " )					
				
				.append( " ] " )
				
				.append( " } " )
				//
				.append( " { " )
				.append( " \"enrollment\" : \"new\", " )
				.append( " \"name\" : \"Julie\", " )
				
				.append( " \"subject\" : [ " )
				
					.append( " { " )
					.append( " \"code\" : \"aaa1\", " )
					.append( " \"grade\" : \"C\", " )	
					.append( " } " )
			
		
				.append( " ] " )				
				
				.append( " } " )				
				.append( "] }" );
		sj.printGrades(jsonData);
	}

}
