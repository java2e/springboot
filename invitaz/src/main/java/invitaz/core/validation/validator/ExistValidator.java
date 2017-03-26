package invitaz.core.validation.validator;

import java.util.Arrays;

import org.apache.commons.collections.CollectionUtils;


public class ExistValidator 
{
	/**
	 * Checks whether the argument given contains the current request mapping.
	 * @param restList List of rest services written in "/pathObject/pathFunction" format
	 * @return true if the current rest is in "to be validated" list, false otherwise.
	 */
	protected boolean isCurrentToBeValidated(String [] methods)
	{
		if(methods != null && methods.length > 0)
		{
			String currentPath = ValidAspectInformer.getInstance().getPath();
			for(String eachValidationRange:Arrays.asList(methods))
			{
				if(currentPath.equals(eachValidationRange) || currentPath.endsWith("."+eachValidationRange) || CollectionUtils.isEmpty(Arrays.asList(methods))) // a package prefixed class.method should exactly match or .class.method should match (Ambiguity of class names is user responsibility)
				{
					return true;
				}
			}
			return false;
		}
		else//pass method check since array is null
		{
			return true;
		}
		
	}
}
