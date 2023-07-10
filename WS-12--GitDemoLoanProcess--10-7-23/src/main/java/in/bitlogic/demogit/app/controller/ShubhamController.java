package in.bitlogic.demogit.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.model.GitDemo;


@RestController
public class ShubhamController 
{
	
	@Autowired
	LoanService ls;
	
	//[1] POST API
	
	@PostMapping("/saveP")
public GitDemo saveP(@RequestBody GitDemo p)
{
	System.out.println(p.getFirstName());
	ls.saveP(p);
	return p;
}
	
	
	

	//[2] GET API
	
//	@GetMapping("/viewS")
//	public List viewS()
//	{
//		List<Supplier> ls=ps.viewS();
//		return ls;
//	}

	//[3] PATCH API

	
//			@PutMapping("/updateS/{sid}")
//			public Supplier updateS(@RequestBody Supplier s,@PathVariable int sid)
//			{
//				s.setSid(sid);
//				ps.updateS(s);
//				return s;
//			}

	

	//[4] DELETE API

//			@DeleteMapping("/deleteS/{sid}")
//			public List deleteS(@PathVariable int sid)
//			{
//				ps.deleteS(sid);
//				List<Supplier> ls=ps.viewS();
//				return ls;
//			}

}


