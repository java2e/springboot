package invitaz.core.filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.GenericFilterBean;


public class PostAuditLoggingFilter extends GenericFilterBean 
{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
//    public static final String SESSION_KEY = "SessionID";
//    public static final String CLIENT_IP_KEY = "ClientIP";
//    public static final String REQUEST_KEY = "RequestID";
//    public static final String USERNAME_KEY = "Username";
//    public static final String URI_KEY = "URI";
//    public static final String HOSTNAME_KEY = "Hostname";
//    public static final String HOST_IP_KEY = "HostIP";
//	
//    private static final Logger LOGGER = LogManager.getLogger(PostAuditLoggingFilter.class);
//   // private InetAddress ip = null;
//    private String requestKey;
//    //private String requestKey = "";
//    
//    @Autowired
//    private SessionedUserService sessionedUserService;
// 
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
//    {
//    	long start = System.currentTimeMillis();
//    	requestKey = ThreadContext.get(REQUEST_KEY);
//    	HttpServletRequest httpRequest = (HttpServletRequest)request;
//    	//String sessionKey = RandomGenerator.getInstance().getRandomUUIDString();
//    	String sessionKey = getSessionKeyAndSetIfNoneExists(httpRequest);
//    	//requestKey = RandomGenerator.getInstance().getRandomIntegerLeftPadWithZeros(999999, 6);
//    	String URI = ThreadContext.get(URI_KEY);
//    	
//    	//ip = InetAddress.getLocalHost();
//        try 
//        {   
//            //LOGGER.debug(ip.toString()+"|"+ username+"|"+ httpRequest.getRequestURI()  +"|"+sessionKey+"|"+requestKey+ "|" + format(getClass().getName()) + "|doFilter|Now auditting request...");
//            fillInContext(sessionKey);            
//            LOGGER.info(requestKey +  "|"+ format(getClass().getName()) + "|doFilter|AUDIT BEGAN FOR USER: "+ ThreadContext.get(USERNAME_KEY) + ", SESSION/REQUEST:" + sessionKey + "/" + requestKey);
//            chain.doFilter(request, response);
//        } 
//        finally
//        {
//            emptyContext();
//            //LOGGER.debug(ip.toString()+"|"+ username +"|"+ httpRequest.getRequestURI() +"|"+sessionKey+"|"+requestKey+ "|" + format(getClass().getName()) + "|doFilter|("+(System.currentTimeMillis() - start)+" ms) finally run.. Auditting request ended successfully");
//            LOGGER.info(requestKey + "|"+ format(getClass().getName()) + "|doFilter|AUDIT ENDED FOR USER. SESSION/REQUEST:" + sessionKey + "/" + requestKey);            
//        }
//    }
//      
//    
//    /*
//     * fills in context request with the given parameters
//     */
//    private void fillInContext(String sessionKey)
//    {
//    	//ThreadContext.put(CLIENT_IP_KEY, clientIP);
//        //ThreadContext.put(HOST_IP_KEY, hostIP);
//        //ThreadContext.put(HOSTNAME_KEY, hostName);
//        ThreadContext.put(SESSION_KEY, sessionKey);
//        //ThreadContext.put(REQUEST_KEY, requestKey);
//        //ThreadContext.put(USERNAME_KEY, userName);
//       // ThreadContext.put(URI_KEY, URI);
//        String URI = ThreadContext.get(URI_KEY);
//	if (StringUtils.isNotBlank(URI) && URI.contains(Constants.REST_URLS_WITH_DOMAIN_NAME_SLASH_PREFIXED))//rest service
//	{//extract user from token
//	    if(!URI.contains(Constants.LOGIN_REST_URL) && !URI.contains(Constants.LOGOUT_REST_URL))//if not login or logout url
//	    {
//		//UserInfoResponseDTO userFromRestStatelessSessionIfExists = sessionedUserService.getCurrentUser();
//		//UserSummaryDTO userFromRestStatelessSessionIfExists = sessionedUserService.getCurrentUserSummaryDTO();
//		
//	   ThreadContext.put(USERNAME_KEY, "ADMIN");
////	    	
////	    	if(userFromRestStatelessSessionIfExists != null)
////		{
////		    ThreadContext.put(USERNAME_KEY, "ADMIN");
////		}
////		else
////		{
////		    ThreadContext.put(USERNAME_KEY, Constants.ANONYMOUS_LABEL);
////		}
////	    }
////	    else
////	    {
////		ThreadContext.put(USERNAME_KEY, Constants.ANONYMOUS_LABEL);
////	    }
//	} 
//	else
//	{
//	    if(SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() !=null)
//            {
//        	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        	if(user != null)
//        	{
//        	    ThreadContext.put(USERNAME_KEY, user.getUsername());
//        	}
//        	else
//        	{	
//        	    ThreadContext.put(USERNAME_KEY, "Authenticated Null");
//        	}
//            }
//	    else
//	    {
//        	ThreadContext.put(USERNAME_KEY, Constants.ANONYMOUS_LABEL);
//	    }
//	}
//    }
//    
//    /*
//     * Empties remote context
//     */
//    private void emptyContext()
//    {
//    	//ThreadContext.remove(CLIENT_IP_KEY);
//    	//ThreadContext.remove(HOST_IP_KEY);
//    	//ThreadContext.remove(HOSTNAME_KEY);
//    	ThreadContext.remove(SESSION_KEY);
//    	//ThreadContext.remove(REQUEST_KEY);
//    	ThreadContext.remove(USERNAME_KEY);
//    	//ThreadContext.remove(URI_KEY);
//    }
//    
////    /*
////     * Extracts user name from external context
////     */
////    private String extractUserNameFromSecurityContext()
////    {
////    	String toReturn = Constants.ANONYMOUS_LABEL;
////    	if(SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() !=null)
////    	{
////    	    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////    	    if(user != null)
////    	    {
////    		toReturn = user.getUsername();
////    	    }
////    	    else
////    	    {    			
////    		toReturn = Constants.AUTHENTICATED_BUT_NO_USERNAME;
////    	    }
////    	}
////    	return toReturn;
////    }
////    
////    private String extractUserNameFromRestContext()
////    {
////	return "REST";
////    }
//    
//    /*
//     * Gets session key according to gui or rest request, and sets a key if none exists
//     */
//    private String getSessionKeyAndSetIfNoneExists(HttpServletRequest httpRequest)
//    {
//	String toReturn = null;
//	HttpSession httpSessionIfExists = getHttpSessionIfExists();
//	String currentURI = (httpRequest == null) ? "Unknown URI" : httpRequest.getRequestURI();
//	if(httpSessionIfExists != null)
//	{
//	    toReturn = (String)httpSessionIfExists.getAttribute(SESSION_KEY);
//	    if(toReturn == null)
//	    {
//		String newSessionId = RandomGenerator.getInstance().getRandomUUIDString();
//		httpSessionIfExists.setAttribute(SESSION_KEY, newSessionId);		
//		//LOGGER.info(""+ip+"|"+ extractUserNameFromSecurityContext()+"|"+ currentURI  +"|"+newSessionId+"|"+requestKey+ "|"+ format(AuditLoggingFilter.class.getName())+"|getSessionKeyAndSetIfNoneExists|Setting a new key to session: " + newSessionId);
//		LOGGER.info(requestKey+ "|"+ format(PostAuditLoggingFilter.class.getName())+"|getSessionKeyAndSetIfNoneExists|Setting a new key to session: " + newSessionId);
//		toReturn = newSessionId;
//	    }
//	}   
//	else
//	{
//	    String newSessionId = RandomGenerator.getInstance().getRandomUUIDString();
//	    //LOGGER.info(""+ip+"|"+ extractUserNameFromSecurityContext()+"|"+ currentURI  +"|"+newSessionId+"|"+requestKey+ "|"+format(AuditLoggingFilter.class.getName())+"|getSessionKeyAndSetIfNoneExists|Setting a new key to sessionless (anonymous) request: " + newSessionId);
//	    LOGGER.info(requestKey+ "|"+format(PostAuditLoggingFilter.class.getName())+"|getSessionKeyAndSetIfNoneExists|Setting a new key to SESSIONLESS (anonymous) request: " + newSessionId);
//	    toReturn = newSessionId;
//	}
//	return toReturn;	
//    }
//    
//    private HttpSession getHttpSessionIfExists()
//    {
//	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//	HttpSession session = attr.getRequest().getSession(false);
//	return session;
//    }
}
