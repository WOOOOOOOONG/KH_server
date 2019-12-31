package controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class PM10Get {

	private final String USER_AGENT = "Mozilla/5.0";
	
	public static void main(String[] args) {
		PM10Get http = new PM10Get();
		try {
			http.sendGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendGet() throws Exception {
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/HanokStayInformationService/hanokStayInformationList?ServiceKey=FaiAwbJIcAjZeb%2B0CDBtgA0uVXgSzmKOqsdY8JlOzsbnROgr%2FMvpt%2BVDDdfFQK8QrL6TzL9JdJTDGn9H18n5Kg%3D%3D&langType=KOR&titleKorean=&buildingPhases=&folkVillage=&areaCode=&sigunguCode=&numOfRows=10&pageNo=1";
		Node seoul = null;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			response.append(inputLine);
		}
		in.close();
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			FileOutputStream output = new FileOutputStream("./PM10");
			output.write(response.toString().getBytes());
			output.close();
			
			Document doc = dBuilder.parse("./PM10");
			doc.getDocumentElement().normalize();
			
			Element body = (Element)doc.getElementsByTagName("body").item(0);
			Element items = (Element)body.getElementsByTagName("items").item(0);
			Element item = (Element)items.getElementsByTagName("item").item(0);
			seoul = item.getElementsByTagName("seoul").item(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
