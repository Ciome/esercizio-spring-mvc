package springmvctest;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("account", new Account());
		return "login-form";
	}
	
	@RequestMapping("/loginAccount")
	public String loginAccount(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors())
			return "login-form";
		else
		{
			if (AccountDatabase.getInstance().signInAccount(account)) {
				model.addAttribute("loginResult", "signed in as " + account.getUsername());
				return "login-result";
			}
			else {
				model.addAttribute("loginErrorMessage", "wrong credentials");
				return "login-form";
			}
			
		}	
	}
}
