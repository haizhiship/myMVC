package net.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import net.spring.model.Contact;

@Component
public class ContactDAO extends JdbcDaoSupport {

	public void add(Contact contact) {
		String sql = "insert into contact(name,address,id,email,telephone) values(?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, contact.getName(), contact.getAddress(), contact.getId(), contact.getEmail(),
				contact.getTelephone());
	}

	public void update(Contact contact) {
		System.out.print("Update");
	}

	public List<Contact> findAll() {
		// List<Contact> list = new ArrayList<Contact>();
		//// Contact con1 = new Contact();
		//// con1.setName("zx");
		//// con1.setAddress("mm");
		//// list.add(con1);
		//// Contact con2 = new Contact();
		//// con2.setName("xcx");
		//// con2.setAddress("xx");
		//// list.add(con2);
		// String sql="select * from contact";
		// list=this.getJdbcTemplate().queryForList(sql);

		// return (List<Contact>) this.getJdbcTemplate().queryForList("select *
		// from contact", null,
		// new int[] { java.sql.Types.VARCHAR }, Contact.class);
		String sql = "select * from contact";
		List<Contact> contacts = new ArrayList<Contact>();
		List<Map<String, Object>> rows = this.getJdbcTemplate().queryForList(sql);
		for (Map rs : rows) {
			Contact contact = new Contact();
			contact.setName((String) rs.get("name"));
			contact.setAddress((String) rs.get("address"));
			contact.setEmail((String) rs.get("email"));
			contact.setId((Integer) rs.get("id"));
			contact.setTelephone((String) rs.get("telephone"));
			contacts.add(contact);
		}
		return contacts;

	}

	public Contact findById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from contact where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), id);
	}

	class ContactRowMapper implements RowMapper<Contact> {
		// rs为返回结果集，以每行为单位封装着
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {

			Contact contact = new Contact();
			contact.setName(rs.getString("name"));
			contact.setAddress(rs.getString("address"));
			contact.setEmail((String) rs.getString("email"));
			contact.setId((Integer) rs.getInt("id"));
			contact.setTelephone((String) rs.getString("telephone"));
			return contact;
		}

	}

	public void saveOrUpdate(Contact contact) {
		String sql = "update contact set name=?,address=?,id=?,email=?,telephone=? where id=?";
		this.getJdbcTemplate().update(sql, contact.getName(), contact.getAddress(), contact.getId(), contact.getEmail(),
				contact.getTelephone(), contact.getId());

	}

	public void deleteByName(Contact contact) {
		String sql = "delete from contact where id=?";
		this.getJdbcTemplate().update(sql, contact.getId());

	}
}
