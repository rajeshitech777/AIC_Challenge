/**
 * 
 */
package com.springboard.solutions.set1;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author CharlesDarwin
 *
 */
public class SolutionShortendedUrl {
	static final Logger logger = Logger.getLogger(SolutionShortendedUrl.class);

	public void makeShortenedUrls(String fileName) {

		FileInputStream inputStream = null;
		Scanner sc = null;
		String currentURL = "";
		String shortenedUrl = "";
		StringBuffer result = new StringBuffer();

		try {
			inputStream = new FileInputStream(fileName);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				currentURL = sc.nextLine();
				shortenedUrl = shorten(currentURL);
				logger.debug("currentURL=" + currentURL + "\n shortened:" + shortenedUrl);
				result.append(shortenedUrl).append("\n");
			}
			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} catch (Exception e) {
			logger.fatal("issue:" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (sc != null) {
					sc.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		System.out.println(result.toString());
	}

	/**
	 * shorten algorithm
	 * 
	 * @param inUrl
	 * @return
	 */
	private String shorten(String inUrl) {
		StringBuffer result = new StringBuffer();
		int len = inUrl.length();
		if ( len == 0 ) {
			return "";
		}
		
		int i = inUrl.indexOf(".com");
		if ( i > 0 ) {
			i += 4;
		}
		logger.debug("i=" + i );		
		if ( i < 0 ) {
			i = inUrl.indexOf(".edu");
			i += 4;
		}
		if ( i < 0 ) {
			i = inUrl.indexOf(".org");
			i += 4;
		}
		if ( i < 0 ) {
			//other domains
			int x = inUrl.indexOf( "//" );
			String xUrl = inUrl.substring(x+3); // gives full url after //
			i = xUrl.indexOf( "/" ); //first slash
			i += 4;
		}
		
		String domain = inUrl.substring(0,i);		
		String uri = inUrl.substring(i);
		result.append( domain ).append( "/");
		
		String[] splitRecords = uri.split( "/" );
		String shortString = "";
		StringBuffer companySSBuffer = new StringBuffer();
		int sz = 0;
		
		//for each block take the first 2 character
		int splitCount = splitRecords.length;
		logger.debug( "split count=" + splitCount );
		
		if ( splitCount == 2 ) {
			companySSBuffer.append( splitRecords[1] );
		}
		for(int k=0; k<splitCount; k++ ) {			
			shortString = splitRecords[k];
			//logger.debug("domain=" + domain + " ss===" + shortString ); 
			if ( shortString.length() > 3 ) {
				companySSBuffer.append(shortString.substring(0,3) );
			}	
			if ( shortString.length() >= 2 ) {
				companySSBuffer.append(shortString.substring(0,2) );
			}
			else if ( shortString.length() == 1 ) {				
				companySSBuffer.append(shortString.charAt(0) );
			}	
		}
		
		
		if ( companySSBuffer.toString().length() > 6 ) {
			result.append( companySSBuffer.toString().substring(0,6) );
		}
		else {
			result.append( companySSBuffer.toString() );
		}
		
		//logger.debug(inUrl + "test ");
		logger.debug( result.toString() );
		System.out.println( result.toString() );
		return result.toString();
	}

}
