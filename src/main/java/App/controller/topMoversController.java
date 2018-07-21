package App.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
import App.model.movers.GainersList;
import App.model.quotes.StockQuote;
import App.service.SellerService;
import App.service.StockService;

import com.google.api.client.http.javanet.NetHttpTransport;


@Controller
public class topMoversController {

	@Autowired
	private StockService stockService;
	
	@RequestMapping(value="/movers", method = RequestMethod.GET)
	public String index(ModelMap model,HttpSession session) throws Exception {
		
		if(session.getAttribute("firstname") ==null) 
		{
			return "redirect:/errorPae";
		}

		
		List<GainersList> gainersList = stockService.getStockGainersList();
		model.addAttribute("gainersList", gainersList);

		List<GainersList> loosersList = stockService.getStockLoosersList();
		model.addAttribute("loosersList", loosersList);
		
		List<GainersList> mostActiveList = stockService.getMostActiveList();
		model.addAttribute("mostActiveList", mostActiveList);
		
		
		return "topMovers";

	}
	
	
	
}
