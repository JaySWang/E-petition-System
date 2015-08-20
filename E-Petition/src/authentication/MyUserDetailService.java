package authentication;
import java.util.ArrayList;
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import service.IUserService;

public class MyUserDetailService implements UserDetailsService {
	IUserService us;
	//1 get user's authority by username when the user try to login
    //2 return and put the user information in the SecurityContextHolder of Spring
	//  to let it be used by AccessDecisionManager
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException   {   
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>(); 
        model.User u = us.getUserByName(username);    
        String password=u.getPassword();     
        GrantedAuthorityImpl auth=new GrantedAuthorityImpl(u.getRole());   
        auths.add(auth);

        User user = new User(username, password, true, true, true, true, auths); 
        return user;  
        } 
	
	
	
	
    public IUserService getUs() {
		return us;
	}


	public void setUs(IUserService us) {
		this.us = us;
	}
	

}
