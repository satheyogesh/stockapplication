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
import App.model.quotes.StockQuote;

import com.google.api.client.http.javanet.NetHttpTransport;


@Controller
public class errorController {

	@RequestMapping(value="/errorPae", method = RequestMethod.GET)
	public String errorGet(ModelMap model) throws Exception {
				
		return "err";

	}

	@RequestMapping(value="/errorPae", method = RequestMethod.POST)
	public String errorPost(ModelMap model) throws Exception {
				
		return "err";

	}

	
	
}
