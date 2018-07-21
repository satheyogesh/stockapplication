package App.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import App.model.User;
import App.model.quotes.StockQuote;
import App.service.SellerService;
import App.service.StockService;

import com.google.api.client.http.javanet.NetHttpTransport;


@Controller
public class homeController {

	@Autowired
	private StockService stockService;
	   
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		return "index";

	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String indexq(ModelMap model) {
		
		return "index";

	}
	
	@RequestMapping(value="/quotes", method = RequestMethod.POST)
	public String getStockQuotes(@RequestParam("stockSearch") String stockSearch ,ModelMap model,HttpSession session) throws Exception  {
		
		if(session.getAttribute("firstname") ==null) 
		{
			return "redirect:/errorPae";
		}
		
		List<StockQuote> stockList =   stockService.getStockQuotesList(stockSearch);
		model.addAttribute("stockList", stockList);
		return "home";

	}
	
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public void callback(@RequestBody String idTokenString,HttpSession session) throws Exception {
		
		String str1 = idTokenString;
		System.out.println(str1);
			
	}
		
	
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String userpost(ModelMap model,HttpSession session) {
		
		if(session.getAttribute("firstname") ==null) 
		{
			return "redirect:/errorPae";
		}

		//model.addAttribute("username", principal.getName());
		return "home";
	}
	

	
}
