package utility;


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;


/**
 * This class opens a connection with the chosen api, reading and copying the response json in a String
 * which gets parsed in the form of a JSONObject
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class GetInfoFromJSON {

	/**
	 * This method gets the JSONObject from the list_folder api called on the specified path, which gives
	 * all the files inside the folder
	 *
	 * @return the JSONObject relative to the chosen account
	 */
	public ArrayList<FileModel> getInfo() {
		
		ArrayList<FileModel> lista = new ArrayList<FileModel>();
		
		String url = "https://api.dropboxapi.com/2/files/list_folder";
		try {

			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			openConnection.setRequestMethod("POST");
			openConnection.setRequestProperty("Authorization",
					"Bearer k1nzns5DDcMAAAAAAAAAARZGF2TNlUKiZ29wZAfB1KLgCnvucm8bC9ACEfBPjqZj");
			openConnection.setRequestProperty("Content-Type", "application/json");
			openConnection.setRequestProperty("Accept", "application/json");
			openConnection.setDoOutput(true); //to enable the input of body
			String jsonBody = "{\r\n" + "    \"path\": \"\",\r\n" 
					+ "    \"recursive\": true,\r\n" // in order to view eventual sub-folders
					+ "    \"include_media_info\": false,\r\n" 
					+ "    \"include_deleted\": false,\r\n"
					+ "    \"include_has_explicit_shared_members\": true,\r\n" // in order to view if a file is shared
					+ "    \"include_mounted_folders\": true,\r\n" 
					+ "    \"include_non_downloadable_files\": true\r\n"
					+ "}";
			
			//	to convert from String to bytes
			
			try (OutputStream os = openConnection.getOutputStream()) { //to read the body with the parameters for the api
				byte[] input = jsonBody.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			InputStream in = openConnection.getInputStream();

			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);

				while ((line = buf.readLine()) != null) {
					data += line;
					
				}
			} finally {
				in.close();
			}
			
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
			JSONArray info = (JSONArray) obj.get("entries");
			
			for (int i=0; i< info.size(); i++) {
				JSONObject obj2 = (JSONObject) info.get(i);
				
				String tag = (String) obj2.get(".tag");
				String name = (String) obj2.get("name");
				String extension;
				Number size;
				String date;
				boolean shared;
				
				if (!(tag.equals("folder"))) {
					
					if(name.lastIndexOf("." ) >= 0) // check if "." is present in the String name
					{
					extension = name.substring(name.lastIndexOf("."));
					}
					else extension = "unknown"; 
					
					date = (String) obj2.get("server_modified");
					size = (Number) obj2.get("size");
					shared = (boolean) obj2.get("has_explicit_shared_members");
				} 
				else // sets null all the parameters that are prsent in file but not in folder
				{
					extension = "null";
					size = 0;
					date = "null";
					shared = false;
				}
				
				String path = (String) obj2.get("path_display");
				String id = (String) obj2.get("id");
				
				
				FileModel file = new FileModel(tag, name, extension, path, id, size, date, shared);
				lista.add(file);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista; //returns the JSONObject got from the api
	}
	
	}