package net.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.spring.model.Contact;
import net.spring.server.ContactService;

@Controller
@RequestMapping("/user")
public class ContactController {

	private ContactService contactService;

	@RequestMapping("/addUser")
	public String add(Contact contact) {
		contactService.add(contact);
		return "redirect:display";
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(Contact contact) {
		contactService.saveOrUpdate(contact);
		return "redirect:display";
	}

	@RequestMapping("/deleteByName")
	public String deleteByName(Contact contact) {
		contactService.deleteByName(contact);
		return "redirect:display";
	}

	@RequestMapping("/add")
	public String add() {
		return "AddUser";
	}

	@RequestMapping("/edit")
	public String Edit(String id, Model model) {
		Contact contact = contactService.findById(id);
		model.addAttribute("item", contact);
		return "editItem";
	}

	@RequestMapping("/display")
	public String display(Model model) {
		List<Contact> list = contactService.findAll();
		model.addAttribute("list", list);
		return "display";

	}

	public ContactService getContactService() {
		return contactService;
	}

	@Resource
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
}
