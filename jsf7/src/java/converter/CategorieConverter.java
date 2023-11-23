/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.lang.annotation.Annotation;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ma.projet.beans.Categorie;
import ma.projet.service.CategorieService;

/**
 *
 * @author MAYSSAE JABBAR
 */
@FacesConverter("categorieConverter")
public class CategorieConverter implements Converter{

    
   @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            int categoryId = Integer.parseInt(value);
            CategorieService categorieService = context.getApplication().evaluateExpressionGet(context, "#{categorieService}", CategorieService.class);

            // Ensure that the categorieService is not null before calling getById
            if (categorieService != null) {
                return categorieService.getById(categoryId);
            } else {
                // Handle the case where categorieService is null (log a warning, throw an exception, etc.)
                return null;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid category ID format", e);
        }
    }
    

   @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || !(value instanceof Categorie)) {
            return null;
        }

        return String.valueOf(((Categorie) value).getId());
    }
    
}
