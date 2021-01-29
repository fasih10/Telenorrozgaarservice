

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


import com.agiserver.helper.common.AbstractBaseAgiScript;
//import java.sql.Connection;

public class Content extends AbstractBaseAgiScript{
	private static final Logger logger = Logger.getLogger(Content.class);

	@Override
	public void service(AgiRequest request, AgiChannel channel) throws AgiException {
		 Connection con = null;
		  Statement mystatement = null;
		    String url = "jdbc:mysql://localhost:3306/telenorrozgaarservice";
		    String username = "root";
		    String password = "Fas@10";
		    
		    ResultSet rs;
		String[]ContentList=new String[5];
		String[]Content=new String[5];
		Content[0]="CONTENT1";
		Content[1]="CONTENT2";
		Content[2]="CONTENT3";
		Content[3]="CONTENT4";
		Content[4]="CONTENT5";
		
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
			String cellno = channel.getVariable("DB_CLI");
			
			
			logger.info("variables recieved => cellno:"+cellno);
			
			String sql ="SELECT ContentName FROM content";
			rs = mystatement.executeQuery(sql);
			
			int i=0;
			  while(rs.next())
              {
               ContentList[i]= rs.getString("ContentName");
                 i++;
              }
			  rs.close();

			 for(i=0;i<ContentList.length;i++)
			 {
				 System.out.println(ContentList[i]);
				 channel.setVariable(Content[i], ContentList[i]);
			 }
			/*channel.setVariable("CONTENT1", ContentList[0]);
			channel.setVariable("CONTENT2", ContentList[1]);
			channel.setVariable("CONTENT3", ContentList[2]);
			channel.setVariable("CONTENT4", ContentList[3]);
			channel.setVariable("CONTENT5", ContentList[4]);
*/			
			
			
		} catch (Exception ex) {
			logger.error("Exception in Checksubscription class: ", ex);
			logger.error(ex.getMessage(), (Throwable) ex);
		}


	}

}
