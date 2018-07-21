package App.controller;

import java.text.ParseException;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import App.model.Seller;
import App.model.User;
import App.service.*;

@SessionAttributes({"id","firstname","lastname","email"})
@Controller
public class newsellerController {

	@Autowired
	private SellerService service;
	
	 @Autowired
	   private User user;
	
/*	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void callback(@RequestParam("client_id") String client_id,
			@RequestParam("redirecwt_uri") String redirect_uri,
			@RequestParam("state") String state,
			@RequestParam("scope") String scope,
			@RequestParam("client_id") String response_type) throws Exception {
		
		String str1 = client_id;
		String str2 = state;
		String str3 = redirect_uri;

	
	}*/
		
		
		
	@RequestMapping(value="/abc", method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
	public void abc(@RequestBody String idTokenString,HttpSession session) throws Exception {
		
		
		if(session.getAttribute("firstname") !=null) return;
        
		 final  HttpTransport transport = new NetHttpTransport();
		 final JsonFactory jsonFactory = new JacksonFactory();

		
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
			    // Specify the CLIENT_ID of the app that accesses the backend:
			    .setAudience(Collections.singletonList("829531720886-70786br6h9df1as2a0o05k4q7t50us7b.apps.googleusercontent.com"))
			    // Or, if multiple clients access the backend:
			    //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
			    .build();

			// (Receive idTokenString by HTTPS POST)

			GoogleIdToken idToken = verifier.verify(idTokenString);
			if (idToken != null) 
			{
			  Payload payload = idToken.getPayload();

			  // Print user identifier
			  String userId = payload.getSubject();
			  System.out.println("User ID: " + userId);

			  // Get profile information from payload
			  String email = payload.getEmail();
			  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			  String name = (String) payload.get("name");
			  String pictureUrl = (String) payload.get("picture");
			  String locale = (String) payload.get("locale");
			  String familyName = (String) payload.get("family_name");
			  String givenName = (String) payload.get("given_name");

			  if(emailVerified)
			  {
				  session.setAttribute("id", userId);
			  user.setEmail(email);
			  }
			  
			  session.setAttribute("firstname", givenName);
			  user.setFirstname(givenName);
			  
			  session.setAttribute("lastname", familyName);
			  user.setLastname(familyName);
			  
			  session.setAttribute("email", email);
			  user.setId(userId);

			  // Use or store profile information
			  // ...

			} 
			else
			{
			  System.out.println("Invalid ID token.");
			}
			
		//return "index";

	}


	@GetMapping("/seller")	
	public String home(ModelMap model )
	{
		//request.setAttribute("mode", "MODE_HOME");
		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "newseller";
	}
	
	@RequestMapping(value="/newseller", method = RequestMethod.GET)
	public String createSeller(ModelMap model){


		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_NEW");

		return "newseller";
	}
	
	@RequestMapping(value="/saveseller", method = RequestMethod.GET)
	public String saveSeller(ModelMap model){

		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
			return "newseller";
	}
	
	@RequestMapping(value="/newseller", method = RequestMethod.POST)
	public String saveSeller(@ModelAttribute Seller sell, BindingResult bindingResult,ModelMap model){

		service.addSellerData(sell);
		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		
		
		return "redirect:/saveseller";
	}
	
	@RequestMapping(value="/updateseller", method = RequestMethod.GET)
	public String updateTask(@RequestParam long id,ModelMap model)
	{
		Seller s = service.findOne(id);
		model.addAttribute("sellerobj",s);
		model.addAttribute("mode", "MODE_UPDATE");
		return "newseller";
	}
	
	@RequestMapping(value="/deleteseller", method = RequestMethod.GET)
	public String deleteTask(@RequestParam long id,ModelMap model)
	{
		service.deleteSellerData(id);
		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "newseller";
	}
	
	/*@RequestMapping(value="/error", method = RequestMethod.POST)
	public String error(ModelMap model){


		return "index";
	}
	
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String error1(ModelMap model){


		return "index";
	}*/
	
}
