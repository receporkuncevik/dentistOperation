package converter;

import entity.Doktor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.DoktorModel;

@FacesConverter(value = "doktorConverter")
public class DoktorConverter implements Converter {

    private DoktorModel doktorModel;

    public DoktorModel getDoktorModel() {
        if (doktorModel == null) {
            this.doktorModel = new DoktorModel();
        }
        return doktorModel;
    }

    public void setDoktorModel(DoktorModel doktorModel) {
        this.doktorModel = doktorModel;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getDoktorModel().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Doktor d = (Doktor) t;
        return String.valueOf(d.getId());
    }

}
