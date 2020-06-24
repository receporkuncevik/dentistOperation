package converter;

import entity.Tedavi;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.TedaviModel;

@FacesConverter(value = "tedaviConverter")
public class TedaviConverter implements Converter {

    private TedaviModel tedaviModel;

    public TedaviModel getTedaviModel() {
        if (tedaviModel == null) {
            this.tedaviModel = new TedaviModel();
        }
        return tedaviModel;
    }

    public void setTedaviModel(TedaviModel tedaviModel) {
        this.tedaviModel = tedaviModel;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getTedaviModel().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Tedavi d = (Tedavi) t;
        return String.valueOf(d.getId());
    }

}
