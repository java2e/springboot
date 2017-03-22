package invitaz.core.rest;

public enum Status 
{
	SUCCESS("1"), FAIL("0");

	private String value;

	private Status(String value) 
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
}	