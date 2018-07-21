package App;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StockApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@RequestMapping(value="/user", method = RequestMethod.POST)
	public void  user(String t /*ModelMap model,Principal principal,HttpServletResponse response*/)  throws Exception {
		
	//	model.addAttribute("username", principal.getName());
		
		String str = null;
		str = t;
		
	//	principal.
		//String str = principal.toString();
		//return principal;
	  //  response.sendRedirect("home");


		
	//	return principal;

		
	/*	//return principal;
		ModelAndView modelAndView = new ModelAndView("home");
	    modelAndView.addObject("username", principal.getName());
	    return modelAndView;
	    
		/*new ModelAnd 
		model.addAttribute("username", principal.getName());
		return "home";*/
	}

}
