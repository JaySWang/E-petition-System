package authentication;
import java.util.ArrayList;
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

	 
    //登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException   {   
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>(); 
         
        GrantedAuthorityImpl auth1=new GrantedAuthorityImpl("ROLE_USER");   
        GrantedAuthorityImpl auth2=new GrantedAuthorityImpl("ROLE_ADMIN");   
        GrantedAuthorityImpl auth3=new GrantedAuthorityImpl("ROLE_OFFICER");   

        String password="";
        
        if(username.equals("admin")){ 
            auths=new ArrayList<GrantedAuthority>(); 
            auths.add(auth1);
            auths.add(auth2);    
            password="admin";
        }else if(username.equals("user")){
        	 auths=new ArrayList<GrantedAuthority>(); 
             auths.add(auth1);
             
             password="user";
        }else if(username.equals("officer")){
        	 auths=new ArrayList<GrantedAuthority>(); 
        	 auths.add(auth1);
             auths.add(auth3);
             
             password="officer";
        }
         
        User user = new User(username, password, true, true, true, true, auths); 
        return user;  
        } 
	
	
	
	

}
