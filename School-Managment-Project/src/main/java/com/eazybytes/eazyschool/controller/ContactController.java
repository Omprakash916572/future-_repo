package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class ContactController {

	private final ContactService contactService;

	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping("/contact")
	public String displayContactPage(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.html";
	}

	/*
	 * @RequestMapping(value = "/saveMsg",method = POST) public ModelAndView
	 * saveMessage(@RequestParam String name, @RequestParam String mobileNum,
	 * 
	 * @RequestParam String email, @RequestParam String subject, @RequestParam
	 * String message) { log.info("Name : " + name); log.info("Mobile Number : " +
	 * mobileNum); log.info("Email Address : " + email); log.info("Subject : " +
	 * subject); log.info("Message : " + message); return new
	 * ModelAndView("redirect:/contact"); }
	 */

	@RequestMapping(value = "/saveMsg", method = POST)
	public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
		if (errors.hasErrors()) {
			log.error("Contact form validation failed due to : " + errors.toString());
			return "contact.html";
		}
		contactService.saveMessageDetails(contact);
		return "redirect:/contact";
	}

//	@RequestMapping("/displayMessages")
//	public ModelAndView displayMessages(Model model) {
//		List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
//		ModelAndView modelAndView = new ModelAndView("messages.html");
//		modelAndView.addObject("contactMsgs", contactMsgs);
//		return modelAndView;
	//}

	@RequestMapping(value = "/closeMsg", method = GET)
	public String closeMsg(@RequestParam int id) {
		contactService.updateMsgStatus(id);
		return "redirect:/displayMessages";
	}

	@RequestMapping(value = "/display/{pageNum}",method = GET)
	public List<Contact> displayMessages(@PathVariable int pageNum, @RequestParam String sortField, @RequestParam String sortDir) {
		
		Page<Contact> msgPage = contactService.findMsgsForTest(pageNum, sortField, sortDir);

		List<Contact> contactMsgs = msgPage.getContent();

//		System.out.println(pageNum);
//		System.out.println(msgPage.getTotalPages());
//		System.out.println(msgPage.getTotalElements());
//		System.out.println(sortField);
//		System.out.println(sortDir);

		System.out.println(contactMsgs.toString());
		return contactMsgs;
	}

}
