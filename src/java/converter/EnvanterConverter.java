package converter;

import entity.Envanter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.EnvanterModel;

@FacesConverter(value = "envanterConverter")
public class EnvanterConverter implements Converter {

    private EnvanterModel envanterModel;

    public EnvanterModel getEnvanterModel() {
        if (envanterModel == null) {
            this.envanterModel = new EnvanterModel();
        }
        return envanterModel;
    }

    public void setEnvanterModel(EnvanterModel envanterModel) {
        this.envanterModel = envanterModel;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getEnvanterModel().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Envanter d = (Envanter) t;
        return String.valueOf(d.getId());
    }

}
