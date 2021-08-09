package mz.co.ldevz.services;


import mz.co.ldevz.entity.Usuario;
import mz.co.ldevz.temp.CurrentUser;

import org.springframework.security.core.userdetails.UserDetailsService;

//Service Pattern for User
public interface UserService extends UserDetailsService {

	public Usuario findUserByEmail(String email);

	public void saveUser(CurrentUser currentUser);

	public Long getLoggedUserId();
}
