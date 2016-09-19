package pland.com.springaction4thedition.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pland.com.springaction4thedition.data.Spitter;
import pland.com.springaction4thedition.data.SpitterRepository;

//@Repository("jdbcSpitterRepository") //It will be automatically created by component-scanning
public class JdbcSpitterRepository implements SpitterRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECT_SPITTER = "select id, username, password, firstname, lastname, email from Spitter";

	@Autowired
	public JdbcSpitterRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;		
	}


	public Spitter save(Spitter spitter) {
		
		System.out.println("This is in JdbcSpitterRepository");
		
		Long id = spitter.getId();
		if (id == null) {
			long spitterId = insertSpitterAndReturnId(spitter);
			return new Spitter(spitterId, spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(), spitter.getLastName());
		} else {
			jdbcTemplate.update("update Spitter set username=?, password=?, email=? where id=?",					
					spitter.getUsername(),
					spitter.getPassword(),
					spitter.getEmail(),
					id);
		}
		return spitter;
	}

	/**
	 * Inserts a spitter using SimpleJdbcInsert. 
	 * Involves no direct SQL and is able to return the ID of the newly created Spitter.
	 * @param spitter a Spitter to insert into the databse
	 * @return the ID of the newly inserted Spitter
	 */
	private long insertSpitterAndReturnId(Spitter spitter) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Spitter");
		jdbcInsert.setGeneratedKeyName("id");
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("username", spitter.getUsername());
		args.put("password", spitter.getPassword());
		args.put("firstname", spitter.getFirstName());
		args.put("lastname", spitter.getLastName());
		args.put("email", spitter.getEmail());
		long spitterId = jdbcInsert.executeAndReturnKey(args).longValue();
		return spitterId;
	}



  public Spitter findOne(long id) {
	return jdbcTemplate.queryForObject(
			SELECT_SPITTER + " where id=?", new SpitterRowMapper(), id);
  }

	public Spitter findByUsername(String username) {
		return jdbcTemplate.queryForObject("select id, username, password, firstname, lastname, email from Spitter where username=?", new SpitterRowMapper(), username);
  }

//	public List<Spitter> findAll() {
//		return jdbcTemplate.query("select id, username, password, fullname, email, updateByEmail from Spitter order by id", new SpitterRowMapper());
//	}

	private static final class SpitterRowMapper implements RowMapper<Spitter> {
		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String email = rs.getString("email");
			return new Spitter(id, username, password, firstname, lastname);
		}		
	}




}
