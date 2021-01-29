

package com.telenorrozgaarservice.script;


import java.sql.Connection;
import java.sql.DriverManager;

//import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;

import com.agiserver.helper.DBHelper;
import com.agiserver.helper.DatabaseException;
import com.agiserver.helper.common.AbstractBaseAgiScript;
//import java.sql.Connection;

public class MainMenu extends AbstractBaseAgiScript{
	private static final Logger logger = Logger.getLogger(MainMenu.class);

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
			String Profession = channel.getVariable("Profession");
			String JobExperience = channel.getVariable("JobExperience");
			String JobWorkplace = channel.getVariable("JobWorkplace");
			String Age = channel.getVariable("Age");
			String Gender = channel.getVariable("Gender");
			String count = channel.getVariable("COUNT");
			logger.info("variables recieved => cellno:"+cellno);
			logger.info("variables recieved => profession:"+Profession);
			logger.info("variables recieved => JobExperiance:"+JobExperience);
			logger.info("variables recieved => JobWorkPLace:"+JobWorkplace);
			logger.info("variables recieved => Age:"+Age);
			logger.info("variables recieved => Gender:"+Gender);
			logger.info("variables recieved => COUNT:"+count);
			
			
			
		
			if(count.equals("No"))
			{
				System.out.println("Going to Insert");
			DBHelper.getInstance().executeDml("INSERT into user_details(Cellno,Profession,JobExperience,JobWorkplace,Age,Gender) VALUES(?,?,?,?,?,?)", con, 
				new Object[] {cellno,Profession,JobExperience,JobWorkplace,Age,Gender} );
			
			System.out.println("Inserted");
			}
			if(count.equals("Yes"))
			{
				System.out.println("Going to Update");
				DBHelper.getInstance().executeDml("UPDATE user_details SET Cellno=?,Profession=?,JobExperience=?,JobWorkplace=?,Age=?,Gender=? WHERE Cellno=?", con, 
						new Object[] {cellno,Profession,JobExperience,JobWorkplace,Age,Gender,cellno} );
				System.out.println("Updated");
			}
		} catch (DatabaseException ex) {
			logger.error("Exception in checksubscription class: ", ex);
			logger.error(ex.getMessage(), (Throwable) ex);
		}catch (Exception ex) {
			logger.error("Exception in Checksubscription class: ", ex);
			logger.error(ex.getMessage(), (Throwable) ex);
		}


	}

}
