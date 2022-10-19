package springmvctest;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("account", new Account());
		return "registration-form";
	}
	
	@RequestMapping("/registerAccount")
	public String registerAccount(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "registration-form";
		} else if (AccountDatabase.getInstance().registerAccount(account)) {
			model.addAttribute("registrationResult", "registered account " + account.getUsername());
			return "registration-result";
		} else {
			model.addAttribute("registerErrorMessage", "account already exists");
			return "registration-form";
		}
		
	}
	
}
