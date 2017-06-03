package net.spring.server;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.spring.dao.ContactDAO;
import net.spring.model.Contact;

@Component
public class ContactService {

	private ContactDAO contactDao;

	public ContactDAO getContactDao() {
		return contactDao;
	}

	@Resource
	public void setContactDao(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}

	public void add(Contact contact) {
		contactDao.add(contact);
	}

	public void update(Contact contact) {
		contactDao.update(contact);
	}

	public List<Contact> findAll() {
		return contactDao.findAll();
	}

	public Contact findById(String id) {
		return contactDao.findById(id);

	}

	public void saveOrUpdate(Contact contact) {
		contactDao.saveOrUpdate(contact);

	}

	public void deleteByName(Contact contact) {
		contactDao.deleteByName(contact);

	}
}
