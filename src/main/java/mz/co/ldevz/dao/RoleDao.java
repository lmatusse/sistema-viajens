package mz.co.ldevz.dao;
import mz.co.ldevz.entity.Perfil;

//DAO Pattern for Role
public interface RoleDao {

	public Perfil findRoleByName(String roleName);
	
}
