package com.telenorrozgaarservice.script;


import java.sql.Connection;
import java.sql.DriverManager;


//import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;

import com.agiserver.helper.DBHelper;
import com.agiserver.helper.common.AbstractBaseAgiScript;
//import java.sql.Connection;

public class UnSub extends AbstractBaseAgiScript{
	private static final Logger logger = Logger.getLogger(UnSub.class);

	@Override
	public void service(AgiRequest request, AgiChannel channel) throws AgiException {
		 Connection con = null;
		
		    String url = "jdbc:mysql://localhost:3306/telenorrozgaarservice";
		    String username = "root";
		    String password = "Fas@10";
		  
		
		try {
			
			 Class.forName("com.mysql.jdbc.Driver");
		      con = DriverManager.getConnection(url, username, password);
		     
		      //System.out.println("Connected!");
			/*
			 * This line checks if DB_CLI is not empty or null in request parameters, if it is null then it takes value from channel variable.
			String cellno = request.getParameter("DB_CLI")==null || request.getParameter("DB_CLI").isEmpty()?channel.getVariable("DB_CLI"):request.getParameter("DB_CLI");
			*/
			/*
			 * DB_CLI is variable name which is set inside asterisk dialplan code
			 */
			String cellno = channel.getVariable("DB_CLI");
			
			
			logger.info("variables recieved => cellno:"+cellno);
			
			String sql ="DELETE FROM user_details WHERE Cellno = ?"  ;
			
			 
			 DBHelper.getInstance().executeDml(sql, con, 
						new Object[] {cellno} );
			 
			 
			 
			System.out.println(cellno + "is deleted sucessfully");
			
			 
			
			
		} catch (Exception ex) {
			logger.error("Exception in Checksubscription class: ", ex);
			logger.error(ex.getMessage(), (Throwable) ex);
		}


	}

}
