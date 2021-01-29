package com.telenorrozgaarservice.common;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.BaseAgiScript;

import com.agiserver.helper.common.ConfigurationLoader;

public abstract class Utils extends BaseAgiScript
{
	private static final Logger logger = Logger.getLogger(Utils.class);

	public static String makeWebServiceRequest(String uri)
			throws IOException
	{
		BufferedReader in=null;
		String baseUrl=ConfigurationLoader.getProperty("base.url");
		URL url = new URL(new StringBuilder().append(baseUrl).append("/").append(uri).toString());


		logger.debug(new StringBuilder().append("requestUrl: ").append(url).toString());

		HttpURLConnection http = (HttpURLConnection)url.openConnection();

		StringBuilder body = new StringBuilder(100);

		label155: 
			try {  in = new BufferedReader(new InputStreamReader(http.getInputStream()));
			try
			{
				String inputLine;
				while ((inputLine = in.readLine()) != null)
				{

					body.append(inputLine);
				}
			} catch (IOException e) {
				logger.error("ERROR", e);
				if (in == null) break label155; 
			}

			}
		finally
		{
			if(in!=null){
				in.close();
			}
			if (http != null) {
				http.disconnect();
			}
		}

		return body.toString();
	}

	public static String createUrlParams(String ...params) throws IndexOutOfBoundsException{
		StringBuilder urlParams = new StringBuilder();
		for(int i=0;i<params.length;i+=2) {
			urlParams.append(params[i]);
			urlParams.append("=");
			urlParams.append(params[i+1]);
			if(i!=params.length-2)
				urlParams.append("&");
		}
		
		return urlParams.toString();
	}
	public static void logUserActivity(String cellNumber, String activity) {
		StringBuilder requestUrl = new StringBuilder();
		requestUrl.append("LOG_USER_ACTIVITY");
		requestUrl.append("?");
		requestUrl.append("msisdn");
		requestUrl.append("=");
		requestUrl.append(cellNumber);
		requestUrl.append("&");
		requestUrl.append("activity_type");
		requestUrl.append("=");
		requestUrl.append(activity);
		try
		{
			makeWebServiceRequest(requestUrl.toString());
		} catch (IOException e) {
			logger.debug("Unable to track Activity; MSISDN: " + cellNumber + "; Activity: LOGIN");
			logger.debug("", e);
		}
	}

	public static String formatCellNumber(String cellNumber)
	{
		if (cellNumber.startsWith("+92"))
			cellNumber = cellNumber.substring(1);
		else if (cellNumber.startsWith("0092"))
			cellNumber = cellNumber.substring(2);
		else if (cellNumber.startsWith("03"))
			cellNumber = "92" + cellNumber.substring(1);
		else if (cellNumber.startsWith("3")) {
			cellNumber = "92" + cellNumber;
		}
		return cellNumber;
	}
}


