package invitaz.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import invitaz.core.dto.BaseDTO;
import invitaz.core.utils.Constants;
import invitaz.core.validation.validator.LocaleValid;
import invitaz.core.validation.validator.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Component
public class LoginRequestDTO extends BaseDTO
{    
    @NotBlank(exceptionCode=Constants.ERROR_EMPTY_OR_NULL_PARAMETER_WHILE_LOGIN_LOGOUT, exceptionMsgParams={"en=Username,tr=Kullanıcı adı"})
    private String username;
    
    @NotBlank(exceptionCode=Constants.ERROR_EMPTY_OR_NULL_PARAMETER_WHILE_LOGIN_LOGOUT, exceptionMsgParams={"en=Password,tr=Şifre"})
    private String password;
    
    @NotBlank(exceptionCode=Constants.ERROR_EMPTY_OR_NULL_PARAMETER_WHILE_LOGIN_LOGOUT, exceptionMsgParams={"en=Locale,tr=Dil alanı"})
    @LocaleValid(exceptionCode=Constants.ERROR_NOT_VALID_LOCALE_PARAMETER_WHILE_LOGIN_LOGOUT,exceptionMsgParams={"en=Locale,tr=Dil alanına (locale)"})
    private String locale;
}
