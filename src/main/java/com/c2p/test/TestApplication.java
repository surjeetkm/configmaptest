package com.c2p.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//@SpringBootApplication
//@ComponentScan(basePackages = {"com.c2p.test","com.c2p.config"})
public class TestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TestApplication.class, args);
		List<JSONObject> list = new ArrayList<JSONObject>();
		String string="[{\"from\":\"2021-01-30\",\"to\":\"2021-05-30\"}]";
		try {
		    int i;
		    JSONArray array = new JSONArray(string);
		    for (i = 0; i < array.length(); i++) {
		        list.add(array.getJSONObject(i));
		    }
		    System.out.println(list);
		} catch (JSONException e) {
		    System.out.println(e.getMessage());
		}
	}

}
