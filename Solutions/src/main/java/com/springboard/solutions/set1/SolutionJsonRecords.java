/**
 * 
 */
package com.springboard.solutions.set1;

import java.util.*;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author CharlesDarwin
 *
 */
public class SolutionJsonRecords {
	static final Logger logger = Logger.getLogger(SolutionJsonRecords.class);
	
	public void printGrades( StringBuffer jsonData ) {
		
		StringBuffer resultBuffer = new StringBuffer();
		logger.debug( "printGrades" );
 
		JSONParser parser = new JSONParser();
		try {    
			 Object obj = parser.parse(jsonData.toString());
			 JSONObject jsonObject =  (JSONObject) obj;
			 
			 JSONArray reportArray = (JSONArray) jsonObject.get("report");	
			 Iterator<JSONObject> itReport = reportArray.iterator();
			 logger.debug( "size=" + reportArray.size() );
			 JSONObject enrollmentRecord = null;
			 JSONArray subjectArray = null;
			 JSONObject subjectRecord = null;
			 
			 String code = null;
			 String grade = null;
			 String enrollment = null;
			 String name = null;
			 
			 Iterator<JSONObject> itSubjectReport;
			 
			 while( itReport.hasNext() ) {
				 enrollmentRecord = itReport.next();
				 System.out.println( ">>" + enrollmentRecord.toJSONString() );
				 
				 enrollment = (String) enrollmentRecord.get("enrollment");
				 name = (String) enrollmentRecord.get("name");
				 subjectArray = (JSONArray) enrollmentRecord.get("subject");
				 
				 
				 //iterate through subjects
				 itSubjectReport = subjectArray.iterator();
				 while( itSubjectReport.hasNext() ) {
					 subjectRecord = itSubjectReport.next();
					 code = (String) subjectRecord.get("code");
					 grade = (String) subjectRecord.get("grade");	
					 resultBuffer.append( code )
					 .append( " " ).append( grade )
					 .append( " " ).append( enrollment )
					 .append( " " ).append( name )
					 .append( "\n" );
				 }
				 
				 
				 logger.debug( "subjects" + subjectArray.toString() );
			 }
			 
			 //System.out.println( reportArray.toJSONString() );
			 //String name = (String) jsonObject.get("name");
			 System.out.println( resultBuffer.toString() );
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}


