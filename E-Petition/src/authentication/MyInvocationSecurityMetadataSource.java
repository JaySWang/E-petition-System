package authentication;

import java.util.ArrayList;  
import java.util.Collection;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
  
import org.springframework.security.access.ConfigAttribute;  
import org.springframework.security.access.SecurityConfig;  
import org.springframework.security.web.FilterInvocation;  
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;  

import tools.AntUrlPathMatcher;
  
import tools.UrlMatcher;  
  
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {   
    private UrlMatcher urlMatcher = new AntUrlPathMatcher();   
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
      
    public MyInvocationSecurityMetadataSource() {  
        }     

      
    //参数是要访问的url，返回这个url对于的所有权限（或角色）  
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {   
       
    	//加载所有url和权限（或角色）的对应关系
    	
    	if(resourceMap==null){
    		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();   
            Collection<ConfigAttribute> atts1 = new ArrayList<ConfigAttribute>();   
            ConfigAttribute ca1 = new SecurityConfig("ROLE_NO");  
            atts1.add(ca1);   
            resourceMap.put("/index.jsp", atts1); 
            
            Collection<ConfigAttribute> atts2 =new ArrayList<ConfigAttribute>();  
            ConfigAttribute ca2 = new SecurityConfig("ROLE_OFFICER");  
            atts2.add(ca2);  
            resourceMap.put("/JSP/officer/*", atts2);     
            
//            Collection<ConfigAttribute> atts3 =new ArrayList<ConfigAttribute>();  
//            ConfigAttribute ca3 = new SecurityConfig("ROLE_ADMIN");  
//            atts3.add(ca3);  
//            resourceMap.put("/**", atts3);   
            
            Collection<ConfigAttribute> atts4 =new ArrayList<ConfigAttribute>();  
            ConfigAttribute ca4 = new SecurityConfig("ROLE_ADMIN");  
            atts4.add(ca4);  
            resourceMap.put("/JSP/admin/*", atts4);   
            
            
    	}
    	
    	
    	
    	
    	// 将参数转为url      
        String url = ((FilterInvocation)object).getRequestUrl();    
        
        Iterator<String>ite = resourceMap.keySet().iterator();   
        Collection<ConfigAttribute> cas = new ArrayList<ConfigAttribute>();   

        
        while (ite.hasNext()) {           
            String resURL = ite.next();    
            if (urlMatcher.pathMatchesUrl(resURL, url)) { 
            	
            	cas.addAll(resourceMap.get(resURL));
                }         
            }   
        return cas;      
        }    
    
    
    public boolean supports(Class<?>clazz) {   
            return true;    
            }   
    public Collection<ConfigAttribute> getAllConfigAttributes() {   
        return null;    
        }  
    }  