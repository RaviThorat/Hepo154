package in.bitlogic.demogit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.model.GitDemo;
@RestController
public class RajController {
	
//	@RequestMapping("/edit")
//	public String editData(@RequestParam("gitId") int gitId ,Model m)
//	{
//		Student s=hs.editData(gitId);S
//		m.addAttribute("data", s);
//		return "edit";
//	}
	
	@Autowired
	LoanService ls;
	
	
	@PutMapping(value="/bilogic/{}")
	public String updateData(@PathVariable int gitId)
	{
		return ls.updatedata();
	
	}

	

}
