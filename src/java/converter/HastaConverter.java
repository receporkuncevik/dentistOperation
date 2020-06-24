package converter;

import entity.Hasta;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.HastaModel;

@FacesConverter(value = "hastaConverter")
public class HastaConverter implements Converter {

    private HastaModel hastaModel;

    public HastaModel getHastaModel() {
        if (hastaModel == null) {
            this.hastaModel = new HastaModel();
        }
        return hastaModel;
    }

    public void setHastaModel(HastaModel hastaModel) {
        this.hastaModel = hastaModel;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getHastaModel().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Hasta h = (Hasta) t;
        return String.valueOf(h.getId());
    }

}
