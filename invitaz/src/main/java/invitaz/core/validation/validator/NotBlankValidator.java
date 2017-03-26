package invitaz.core.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;


public class NotBlankValidator extends ExistValidator implements ConstraintValidator<NotBlank, String>
{
    private String[] method;

    @Override
    public void initialize(NotBlank constraintAnnotation)
    {
	this.method = constraintAnnotation.method();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
	if (isCurrentToBeValidated(method))
	{
	    if (StringUtils.isNotBlank(value))
	    {
		return true;
	    } else
	    {
		return false;
	    }
	}
	return true;
    }

}