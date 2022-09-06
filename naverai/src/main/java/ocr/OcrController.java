package ocr;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.naverai.Ninf;

import tts.TtsService;

@Controller
public class OcrController {

	@Autowired
	OcrService ocrService; 
		
	@GetMapping("/ocrinput")
	public String ocrinput(Model model) {
		
		File f = new File(Ninf.path);
		String[] fileList = f.list();
		
		model.addAttribute("filelist", fileList);
		
		return "ocr/ocrinput"; 
	}

	@GetMapping("/ocrresult")
	public String ocrresult(String textimage, Model model) {
	
			String ocrresult = ocrService.test(textimage);
		
		model.addAttribute("ocrresult", ocrresult);
	
		// 이름만 리턴하는 것. 파일은 AI 에서 생성해줌 
		return "ocr/ocrresult";
	}


	
	
	
	
}
