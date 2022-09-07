package chatbot;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.naverai.Ninf;

import tts.TtsService;

@Controller
public class ChatbotController {
	
	@Autowired
	ChatbotService chatbotService;
	
	@Autowired
	TtsService ttsService; 
	
	@GetMapping("/chatinput")
	public String chatinput() {
		return "chatbot/chatinput";
	}
	
	@ResponseBody
	@GetMapping("/chatresult")
	public String chatresult(String request, String event, Model model){
	
		String response = "";
		if(event.equals("대화입력")) {
			response = chatbotService.test(request, "send");
		}else {
			response = chatbotService.test(request, "open");
			}
	
		System.out.println(response);
		return response;
	}

	@ResponseBody
	@GetMapping("/chatvoice")
	public String chatvoice(String textresult, Model model){
		System.out.println("textresult : " + textresult);
		String mp3 = ttsService.test(textresult);
		System.out.println("mp3: " + mp3);
		return "{\"resultmp\" : \"" + mp3 + "\" }";

	}
	
	
	

}
