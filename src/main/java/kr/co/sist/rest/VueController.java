package kr.co.sist.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueController {
	@GetMapping("/appVue")
	public String vueIndex() {
		return "redirect:/index.html";
	}
	
	@GetMapping("/frontVue")
	public String vueFront() {
		return "frontVue";
	}
	
	@GetMapping("/dataBinding")
	public String dataBinding() {
		return "dataBinding";
	}
	
	@GetMapping("/vIf")
	public String vIf() {
		return "vIf";
	}
	
	@GetMapping("/clickEvt")
	public String clickEvt() {
		return "clickEvt";
	}
	
	@GetMapping("/function")
	public String function() {
		return "function";
	}
	@GetMapping("/vFor")
	public String vFor() {
		return "vFor";
	}
	@GetMapping("/objCopy")
	public String objCopy() {
		return "objCopy";
	}
	@GetMapping("/useAxios")
	public String useAxios() {
		return "useAxios";
	}
	
}
