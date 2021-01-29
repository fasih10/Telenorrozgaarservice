

package com.telenorrozgaarservice.script;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;

import com.agiserver.helper.DBHelper;
import com.agiserver.helper.common.AbstractBaseAgiScript;
//import java.sql.Connection;

public class Bookmark extends AbstractBaseAgiScript{
	private static final Logger logger = Logger.getLogger(Bookmark.class);

	@Override
	public void service(AgiRequest request, AgiChannel channel) throws AgiException {
		 Connection con = null;
		 Statement mystatement = null;
		    String url = "jdbc:mysql://localhost:3306/telenorrozgaarservice";
		    String username = "root";
		    String password = "Fas@10";

		    ResultSet rs;
		    int count=0;
	
		
		try {
			
			 Class.forName("com.mysql.jdbc.Driver");
		      con = DriverManager.getConnection(url, username, password);
		      mystatement = con.createStatement();

		      //System.out.println("Connected!");
			/*
			 * This line checks if DB_CLI is not empty or null in request parameters, if it is null then it takes value from channel variable.
			String cellno = request.getParameter("DB_CLI")==null || request.getParameter("DB_CLI").isEmpty()?channel.getVariable("DB_CLI"):request.getParameter("DB_CLI");
			*/
			/*
			 * DB_CLI is variable name which is set inside asterisk dialplan code
			 */
			String currentcontent = channel.getVariable("CurrentContent");
			String cellno= channel.getVariable("DB_CLI");
			logger.info("variables recieved => CURRENT CONTENT:"+currentcontent);
			logger.info("variables recieved => cellno:"+cellno);
			
			
			
			
			
			String number=cellno;
			String sql ="SELECT COUNT(bookmark_id) FROM Bookmark WHERE CellNo = " + number ;
			rs = mystatement.executeQuery(sql);
			
			
			  while(rs.next())
              {
               count= rs.getInt("COUNT(bookmark_id)");
                 System.out.println(count);
                 
              }
			 if(count>0)
			 {
				 DBHelper.getInstance().executeDml("UPDATE Bookmark SET CellNo=?,BookmarkName=? WHERE CellNo=?", con, new Object[] {cellno,currentcontent,cellno});
					System.out.println("Updated");
			 }
			 else
			 {
				 DBHelper.getInstance().executeDml("INSERT INTO Bookmark (BookmarkName,CellNo) VALUES (?,?)", con, new Object[] {currentcontent,cellno});
				 
				System.out.println("Inserted");
			 }
			 

			
			
			
			
			
			
			
			
			
			
			
			
		}
		catch (Exception ex) {
			logger.error("Exception in Checksubscription class: ", ex);
			logger.error(ex.getMessage(), (Throwable) ex);
		}


	}

}
