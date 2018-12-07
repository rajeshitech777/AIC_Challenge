/**
 * 
 */
package com.springboard.solutions.set1;

import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author CharlesDarwin
 *
 */
public class SolutionShortendedUrlTest {
	
static final Logger logger = Logger.getLogger(SolutionShortendedUrlTest.class);
	
	@Test	
	public void makeShortenedUrlsTest() {
		try {
			URL dataFile = SolutionShortendedUrlTest.class.getClassLoader().getResource("shortenUrls.txt");			
			SolutionShortendedUrl s1 = new SolutionShortendedUrl();
			s1.makeShortenedUrls(dataFile.getPath());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
