
package validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("customValidator")
public class CustomValidator implements Validator{

    /**
     *
     * @param fc
     * @param uic
     * @param t
     * @throws ValidatorException
     */
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
        //Alan boş geçilmez kontrolü burada sağlandı.
        if(t != null){
            if(t.toString().trim().equals("")){
                FacesMessage message = new FacesMessage(uic.getAttributes().get("label")+" Alanı Boş Geçilemez.");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }
    }
    
}
