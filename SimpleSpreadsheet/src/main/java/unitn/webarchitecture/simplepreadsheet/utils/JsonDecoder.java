package unitn.webarchitecture.simplepreadsheet.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import java.util.Map;

/**
 * @author shaker
 *
 */
public class JsonDecoder {
	JsonObject jsonObject;
	String inputJSONString;
	Map<String,JsonValue> jsonObjectMap;

	public JsonDecoder(String jsonString) {
		this.inputJSONString=jsonString;
		InputStream is;
		jsonObject=null;
		jsonObjectMap=null;
		try {
			if(!jsonString.isEmpty()) {

				is = new ByteArrayInputStream(jsonString.getBytes("UTF-8")); //jsonString.getBytes("UTF-8")
				JsonReader jsonReader = Json.createReader(is);
				jsonObject = jsonReader.readObject();
				jsonObjectMap=jsonObject;
				jsonReader.close();
				is.close();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return the jsonObject
	 */
	public JsonObject getJsonObject() {
		return jsonObject;
	}
	/**
	 * @return the inputJSONString
	 */
	public String getInputJSONString() {
		return inputJSONString;
	}
	/**
	 * @return the jsonObjectMap
	 */
	public Map<String, JsonValue> getJsonObjectMap() {
		return jsonObjectMap;
	}
	
	public String getEString(String s) {
		try{
			return this.jsonObject.getString(s);
		}catch(NullPointerException n) {
			return "";
		}
	}
	public int getEInt(String s) {
		try{
			return this.jsonObject.getInt(s);
		}catch(NullPointerException n) {
			return 0;
		}catch(Exception e) {
			return 0;
		}
	}
	public String getIntString(String s) {
		try{
			return this.jsonObject.getString(s);
		}catch(NullPointerException n) {
			return "0";
		}catch(Exception e) {
			return "0";
		}
	}
	/**
	 * 
	 * @param s
	 * @return null if NullPointerException
	 */
	public String getNString(String s) {
		try{
			return this.jsonObject.getString(s);
		}catch(NullPointerException n) {
			return null;
		}catch(ClassCastException cE) {
			return null;
		}
	}
	/**
	 * 
	 * @param string
	 * @return true if available, otherwise false
	 */
	public boolean isParameterPresent(String string) {
		return this.jsonObject.containsKey(string);
	}
}
