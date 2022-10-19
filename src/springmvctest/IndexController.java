package springmvctest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String showPage(Model model) {
		if (AccountDatabase.getInstance().getSignedInAccount() == null)
			model.addAttribute("accountMessage", "not logged in");
		else model.addAttribute("accountMessage", "logged in as " + AccountDatabase.getInstance().getSignedInAccount().getUsername());
		return "index";
	}
}
