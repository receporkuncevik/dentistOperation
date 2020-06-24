package converter;

import entity.Randevu;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.RandevuModel;

@FacesConverter(value = "randevuConverter")
public class RandevuConverter implements Converter {

    private RandevuModel randevuModel;

    public RandevuModel getRandevuModel() {
        if (randevuModel == null) {
            this.randevuModel = new RandevuModel();
        }
        return randevuModel;
    }

    public void setRandevuModel(RandevuModel randevuModel) {
        this.randevuModel = randevuModel;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getRandevuModel().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Randevu r = (Randevu) t;
        return String.valueOf(r.getId());
    }

}
