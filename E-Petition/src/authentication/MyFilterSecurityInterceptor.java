package authentication;
import java.io.IOException;  

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
  
import org.springframework.security.access.SecurityMetadataSource;  
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;  
import org.springframework.security.access.intercept.InterceptorStatusToken;  
import org.springframework.security.web.FilterInvocation;  
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;  



public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor
										implements Filter {    
    private FilterInvocationSecurityMetadataSource securityMetadataSource;  
    //intercept all the requests 
    public void doFilter(ServletRequest request, ServletResponse response, 
    			FilterChain chain) throws IOException, ServletException {   
        FilterInvocation fi = new FilterInvocation(request, response, chain);   
        invoke(fi);    
        }  
    public void invoke(FilterInvocation fi) throws IOException, ServletException {  
        //fi contains the intercepted url  
        //1 call getAttributes(Object object) in MyInvocationSecurityMetadataSource
    	//  to get the authority needed for the requested url
        //2 call decide() in MyAccessDecisionManager to check whether
    	//  the user has the authority to access the url
        InterceptorStatusToken token = super.beforeInvocation(fi);  
        try {  
            //invoke next Filter  
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());     
            } finally {   
                super.afterInvocation(token, null);    
            }     
        }  
    
    
    
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {    
        return this.securityMetadataSource;    
        }     
      
    public Class<? extends Object> getSecureObjectClass() {   
        return FilterInvocation.class;      
        }    
      
  
    
    
    public SecurityMetadataSource obtainSecurityMetadataSource() {   
        return this.securityMetadataSource;     
        }   
    public void setSecurityMetadataSource(  
            FilterInvocationSecurityMetadataSource newSource)  
    {   
        this.securityMetadataSource = newSource;   
    }   
    public void destroy() {    
          
    }     
    public void init(FilterConfig arg0) throws ServletException {    
          
    }    
}  
