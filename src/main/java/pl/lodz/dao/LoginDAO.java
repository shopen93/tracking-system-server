package pl.lodz.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import pl.lodz.models.Login;

@Transactional
public interface LoginDAO extends CrudRepository<Login, Integer> {

	public Login findByLogin(String login);
	
}
