package com.telenorrozgaarservice.script;

import com.agiserver.helper.common.AbstractBaseAgiScript;
import com.mm.menuengine.MenuEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;

public class getMenu extends AbstractBaseAgiScript {
	private static final Logger logger = Logger.getLogger(getMenu.class);

	public getMenu() {
	}

	public void service(AgiRequest request, AgiChannel channel) throws AgiException {
		try {
			String cellno = channel.getVariable("DB_CLI");
			String menu_id = channel.getVariable("MENU_TYPE");
			String max_seg = channel.getVariable("MAX_SEG");
			HashMap<String, Object> params = new HashMap();
			params.put("menu_type", menu_id);
			params.put("required_seg_count", max_seg);
			params.put("cellno", cellno);
			

			MenuEngine me = new MenuEngine();
			List<Map<String, String>> menu = me.getSegments(params);
			int i = 1;
			for (Map<String, String> item : menu) {
				logger.info("MENU_SEG_" + i + ": " + (String) item.get("seg_file") + ", MENU_SEG_ID_" + i + ": "
						+ (String) item.get("seg_id") + ", MENU_SEG_TYPE_" + i + ": " + (String) item.get("seg_type")
						+ ", DTMF_FILE_" + i + ": " + (String) item.get("dtmf_file"));
				if (item.containsKey("val1")) {
					logger.info("val1_" + i + ":" + (String) item.get("val1"));
					channel.setVariable("VAL1_" + i, (String) item.get("val1"));
				}
				if (item.containsKey("val2")) {
					logger.info("val2_" + i + ":" + (String) item.get("val2"));
					channel.setVariable("VAL2_" + i, (String) item.get("val2"));
				}
				if (item.containsKey("val3")) {
					logger.info("val3_" + i + ":" + (String) item.get("val3"));
					channel.setVariable("VAL3_" + i, (String) item.get("val3"));
				}
				if (item.containsKey("val4")) {
					logger.info("val4_" + i + ":" + (String) item.get("val4"));
					channel.setVariable("VAL4_" + i, (String) item.get("val4"));
				}
				if (item.containsKey("val5")) {
					logger.info("val5_" + i + ":" + (String) item.get("val5"));
					channel.setVariable("VAL5_" + i, (String) item.get("val5"));
				}
				channel.setVariable("MENU_SEG_" + i, (String) item.get("seg_file"));
				channel.setVariable("MENU_SEG_ID_" + i, (String) item.get("seg_id"));
				channel.setVariable("MENU_SEG_TYPE_" + i, (String) item.get("seg_type"));
				channel.setVariable("DTMF_FILE_" + i, (String) item.get("dtmf_file"));
				i++;
			}
			channel.setVariable("MENU_SEG_COUNT", "" + menu.size());
			logger.info("MENU_SEG_COUNT:" + menu.size());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
