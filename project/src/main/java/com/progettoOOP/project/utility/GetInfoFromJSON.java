package utility;


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
//import java.net.URI;
import java.net.URL;
//import java.net.URLConnection;
//import java.nio.file.Files;
//import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class GetInfoFromJSON {

	public static ArrayList getInfo() {
		
		ArrayList<FileModel> lista = new ArrayList<>();
		
		String url = "https://api.dropboxapi.com/2/files/list_folder";
		try {

			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			openConnection.setRequestMethod("POST");
			openConnection.setRequestProperty("Authorization",
					"Bearer k1nzns5DDcMAAAAAAAAAARZGF2TNlUKiZ29wZAfB1KLgCnvucm8bC9ACEfBPjqZj");
			openConnection.setRequestProperty("Content-Type", "application/json");
			openConnection.setRequestProperty("Accept", "application/json");
			openConnection.setDoOutput(true); // per permettere l'inserimento del body
			String jsonBody = "{\r\n" + "    \"path\": \"\",\r\n" 
					+ "    \"recursive\": false,\r\n"
					+ "    \"include_media_info\": false,\r\n" 
					+ "    \"include_deleted\": false,\r\n"
					+ "    \"include_has_explicit_shared_members\": false,\r\n"
					+ "    \"include_mounted_folders\": true,\r\n" 
					+ "    \"include_non_downloadable_files\": true\r\n"
					+ "}";
			
			//	converte la stringa in byte
			try (OutputStream os = openConnection.getOutputStream()) {
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
					System.out.println(line);
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
				
				if (!(tag.equals("folder"))) {
					extension = name.substring(name.lastIndexOf(".", 0));
				} 
				else 
				{
					extension = "null";
				}
				
				String path = (String) obj2.get("path_display");
				String id = (String) obj2.get("id");
				//String rev = (String) obj2.get("rev");
				Number size = (Number) obj2.get("size");
				boolean shared_id = (boolean) obj2.get("shared_folder_id");
				
				FileModel file = new FileModel(tag, name, extension, path, id, size, shared_id);
				lista.add(file);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void PrintLista(ArrayList<FileModel> lista) {
		for (FileModel i :lista) {
			System.out.println(i.toString());
		}
	}
	
	}
