package com.RestaurantApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
public class LoginDataController {
	
	@Autowired
	private LoginDataService loginser;
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	private TableService tservice;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
   
	@GetMapping("/login")
	public String adminPage(@RequestParam("username") String name,@RequestParam("password") int pass,Model m) {
	    String login_name;
	    int login_pass;
		// staff entry
		List<LoginData> staffid=loginser.findall();
		for(int i=1; i<staffid.size();i++) {
		   login_name=staffid.get(i).getUsername();
		   login_pass=staffid.get(i).getPassword();
		   if(login_name.equals(name) && login_pass==pass) { 
			   m.addAttribute(("staffdetails"), staffid.get(i));
			   List<Tables> lt= tservice.findall();
			  
			   m.addAttribute("Tables", lt);
			   return"staffpage";
		   }
		}
		// admin login entry only
		LoginData adminid= loginser.findid(1);
		
		if((name.equals(adminid.getUsername())) && (pass==adminid.getPassword())) {
			List<LoginData> staffs=loginser.findall();
			m.addAttribute("staffs", staffs);
			return "adminpage";
		}
		else
			return "incorrect";
	}
	
	@GetMapping("/tableorder/{tableno}")
	public String tableitems(@PathVariable("tableno") int tableno,Model m) {
		List<Products> productlist=pservice.pfindAll();
		m.addAttribute("tableno", tableno);
		m.addAttribute("products", productlist);
		return "tableorder";
	}
	
	@GetMapping("/staffdetails")
	public String staffdetails() {
		return"adminpage";
	}

	@PostMapping("/staffdetails")
	public String staffDetails(
			@RequestParam("Sid") int Sid,
			@RequestParam("Susername") String Susername,
			@RequestParam("Spassword") int Spassword,
			@RequestParam("Sname") String Sname,
			@RequestParam("Snumber") int Snumber,
			@RequestParam("Saddress") String Saddress,
			@RequestParam("Sdoj") String Sdoj,
			@RequestParam("Sdesgination") String Sdesgination,Model m) {
 		 LoginData ld=new LoginData(Sid, Susername, Spassword, Sname, Snumber, Saddress, Sdoj, Sdesgination);
 		 loginser.save(ld);
 		List<LoginData> staffs=loginser.findall();
		m.addAttribute("staffs", staffs);
		return"adminpage";
	}
	
	// product adding
	@GetMapping("/productmanagement")
	public String product(Model m) {
		List<Products> p=pservice.pfindAll();
		m.addAttribute("Products", p);
		return"productmanagement";
	}
	
	@PostMapping("/productmanagement")
	public String productman(
			@RequestParam("product_id") int pid,
			@RequestParam("product_name") String pname,
			@RequestParam("product_rate") double prate,
	        @RequestParam("product_desc") String pdesc,Model m){
		Products p=new Products(pid, pname, prate, pdesc);
		pservice.Psave(p);
		List<Products> p1=pservice.pfindAll();
		m.addAttribute("Products", p1);
		return"productmanagement";
	}
	
	// adminpage edit and delete option
	@DeleteMapping("/delete/{id}")
	public String deletestaff(@PathVariable(name="id") int  id) {
		 loginser.delete(id); 
		System.out.println("deleted"+id+"id Staff");
		return"redirect:/staffdetails";
	}
	// sending data to edit staff page
	@PutMapping("/edit/{id}")
	public String editstaff(@PathVariable(name="id") int id,Model m) {
		LoginData l=loginser.findid(id);
		m.addAttribute("staff", l);
		return"editstaff";
	}
	
	
	// productmanagement page edit and delete
	// delete
	@DeleteMapping("/deleteproduct/{product_id}")
	public String deleteproduct(@PathVariable(name="product_id") int id) {
		pservice.pdelete(id);
		return"redirect:/productmanagement";
	}
	
	//edit
	@PutMapping("/editproduct/{product_id}")
	public String editproduct(@PathVariable(name="product_id") int id,Model m) {
		Products p=pservice.pfindid(id);
		m.addAttribute("product", p);
		System.out.println(p);
	
		return"editproduct";
	}
	
}
