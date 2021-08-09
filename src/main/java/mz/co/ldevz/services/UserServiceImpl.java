package mz.co.ldevz.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.ldevz.entity.Perfil;
import mz.co.ldevz.entity.Provincia;
import mz.co.ldevz.entity.Usuario;
import mz.co.ldevz.repository.RoleRep;
import mz.co.ldevz.repository.UserRep;
import mz.co.ldevz.temp.CurrentUser;

@Service
public class UserServiceImpl implements UserService {
	
	// service pattern to manage transactionals  
	//	and handel services for user between server and client

	private UserRep userRepository;
	
	private RoleRep roleRepository;

	@Autowired
	public UserServiceImpl(UserRep userRepository, RoleRep roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	// bcrypt passwords
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// check existing of user by email
	@Override
	@Transactional
	public Usuario findUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	// transfer data between temp User and User class after check it to save it 
	@Override
	@Transactional
	
	public void saveUser(CurrentUser currentUser) {
		Usuario user = new Usuario();
		//Perfil perfil=new Perfil();

		// bcrypt password to save it hashing in database
		user.setPassword(passwordEncoder.encode(currentUser.getPassword()));
		
		user.setUsername(currentUser.getUsername());
		user.setEmail(currentUser.getEmail());
				// give user default role of "employee"
		//user.setRoles(roleRepository.findByName(perfil.getName()));
		user.setRoles(Arrays.asList(roleRepository.findByName("CLIENTE")));
		/*user.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
		user.setRoles(Arrays.asList(roleRepository.findByName("FUNCIONARIO")));*/
		userRepository.save(user);
	}

	// get logged user id using logged email
	@Override
	@Transactional
	public Long getLoggedUserId() {
		Usuario user = userRepository.findByUsername(loggedUserEmail());
		return user.getId();
	}

	// security login check valid username and role
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	// Authority role for user
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Perfil> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	// get current logged user email using security user details principal
	private String loggedUserEmail() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}
	public List<Usuario> listar()
	{
		return userRepository.findAll();
	}

}
