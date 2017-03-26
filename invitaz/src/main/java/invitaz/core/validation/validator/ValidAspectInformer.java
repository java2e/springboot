package invitaz.core.validation.validator;


public class ValidAspectInformer 
{
	private static final ValidAspectInformer INSTANCE = new ValidAspectInformer();
	private ThreadLocal<String> path = new ThreadLocal<String>();
	
	private ValidAspectInformer(){}
	
	public static ValidAspectInformer getInstance()
	{
		return INSTANCE;
	}
	
	public String getPath()
	{
		return path.get();
	}
	
	public void setPath(String pathStr)
	{
		this.path.set(pathStr);
	}
	
	public void remove()
	{
	    path.remove();
	}
}
