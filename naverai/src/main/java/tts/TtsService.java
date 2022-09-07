package tts;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.naverai.NaverService;
import com.example.naverai.Ninf;
@Service
public class TtsService implements NaverService{

	// 꼼수 
	@Override
	public String test(String image) {
		// 아래 꼼수 test를 사용하는 것. 선택안할시 nara 
		return test(image, "nara");  
	}
	
	//진짜 쓸꺼 오버로딩 
	public String test(String image, String speaker) {
		//text 파일로 주기 
		String mp3 = null;
		
	     String clientId = Ninf.voice_id;//애플리케이션 클라이언트 아이디값";
	     String clientSecret = Ninf.voice_key;//애플리케이션 클라이언트 시크릿값";
	     try {
	    	
	    	 // 텍스트 => 파일 만들기 
	    	 String input = image;
	    	 FileWriter fw = new FileWriter(Ninf.path + image);
	    	 fw.write(input); 
	    	 fw.close();

	    	 
	    	 
	    	 
	    	 // 파일 읽어오기 => text로 넣기 
	    	 String mytext = "";
	    	 FileReader fr = new FileReader(Ninf.path + image);
	    	 Scanner sc = new Scanner(fr); 
	    	 while(sc.hasNextLine()) {
	    		 mytext += sc.nextLine();
	    	 }
	    	 
	         String text = URLEncoder.encode(mytext, "UTF-8"); 
	         
	         
	         String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
	         URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("POST");
	         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	         // post request
	         // 스피커 파라미터로 넣기 
	         String postParams = "speaker=" + speaker + "&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
	         con.setDoOutput(true);
	         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	         wr.writeBytes(postParams);
	         wr.flush();
	         wr.close();
	         int responseCode = con.getResponseCode();
	         BufferedReader br;
	         if(responseCode==200) { // 정상 호출
	             InputStream is = con.getInputStream();
	             int read = 0;
	             byte[] bytes = new byte[1024];
	             // 랜덤한 이름으로 mp3 파일 생성
	             // 이름 / 위치 재설정 
	             SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	             String tempname = sdf.format(new Date());
	             //String tempname = Long.valueOf(new Date().getTime()).toString();
	             File f = new File(Ninf.path + tempname + ".mp3");
	             // return 할 파일 명 
	             mp3 = tempname + ".mp3";
	             f.createNewFile();
	             OutputStream outputStream = new FileOutputStream(f);
	             while ((read =is.read(bytes)) != -1) {
	                 outputStream.write(bytes, 0, read);
	             }
	             is.close();
	             System.out.println("TTS 실행 완료");
	         } else {  // 오류 발생
	             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	             String inputLine;
	             StringBuffer response = new StringBuffer();
	             while ((inputLine = br.readLine()) != null) {
	                 response.append(inputLine);
	             }
	             br.close();
	             System.out.println(response.toString());
	         }
	     } catch (Exception e) {
	         System.out.println(e);
	     }
		return mp3;
	}
	
	
	
	
	
}
