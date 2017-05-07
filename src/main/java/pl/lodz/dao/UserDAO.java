package pl.lodz.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import pl.lodz.models.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

	public User findById(int id);
	
}
