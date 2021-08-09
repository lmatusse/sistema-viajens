package mz.co.ldevz.dao;

import mz.co.ldevz.entity.Usuario;

//DAO Pattern for User
public interface UserDao {

    public Usuario findUserByEmail(String email);

    public Usuario findUserByUsername(String username);
    
    public void saveUser(Usuario user);
        
}
