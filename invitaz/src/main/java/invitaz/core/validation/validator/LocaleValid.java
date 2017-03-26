package invitaz.core.validation.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {LocaleValidator.class})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface LocaleValid 
{
	 String [] method() default {};
	 String [] exceptionMsgParams() default {};
	 String message() default "{0} not seems to be a valid locale.";	  
	 String exceptionCode() default "-1";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
}
