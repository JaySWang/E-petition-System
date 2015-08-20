package authentication;
import java.util.Collection;  
import java.util.Iterator;  
  
import org.springframework.security.access.AccessDecisionManager;  
import org.springframework.security.access.AccessDeniedException;  
import org.springframework.security.access.ConfigAttribute;  
import org.springframework.security.access.SecurityConfig;  
import org.springframework.security.authentication.InsufficientAuthenticationException;  
import org.springframework.security.core.Authentication;  
import org.springframework.security.core.GrantedAuthority;  



public class MyAccessDecisionManager  implements AccessDecisionManager{
	//to check whether a user has the authority to access particular resource  
	
    //authentication comes from the SecurityContextHolder in Spring,which contains the user's authority  
    //object contains the url that the user wants to access  
    //configAttributes is authorities needed to access the url
	public void decide(Authentication authentication, Object object,      
            Collection<ConfigAttribute> configAttributes)   
                    throws AccessDeniedException, InsufficientAuthenticationException {  
        if(configAttributes == null){   
            return;         
        }    
          
        Iterator<ConfigAttribute> ite=configAttributes.iterator();  
        while(ite.hasNext()){  
            ConfigAttribute ca=ite.next();    
            String needRole=((SecurityConfig)ca).getAttribute();  
            if(needRole.equals("ROLE_NO")){
        		return;
        	}
            for(GrantedAuthority ga : authentication.getAuthorities()){               	
                if(needRole.equals(ga.getAuthority())){    
                	//the user has the authority
                    return;                
        }              
    }        
}      
        //the user does not have the authority to access the url  
        throw new AccessDeniedException("no right");     
}     
	
	
	
    public boolean supports(ConfigAttribute attribute) {   
        return true;  
    }    
    public boolean supports(Class<?>clazz) {  
        return true;   
        }   
	
	
}
