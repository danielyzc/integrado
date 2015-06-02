/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.ZonaCiudadFacadeLocal;
import be.UbicacionFisica;
import be.ZonaCiudad;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named("managedBeanZonaCiudad")
@SessionScoped
public class ManagedBeanZonaCiudad implements Serializable {
    @EJB
    private ZonaCiudadFacadeLocal zonaCiudadFacade;
    private ZonaCiudad objetoCrear;
    private ZonaCiudad objetoSeleccionado;
    private List<ZonaCiudad> listaObjeto;
    private List<SelectItem> objetoItems = new LinkedList<SelectItem>();

    public ManagedBeanZonaCiudad() {
        objetoCrear = new ZonaCiudad();
        objetoSeleccionado = new ZonaCiudad();
        listaObjeto = new LinkedList<ZonaCiudad>();
    }

    public ZonaCiudad getObjetoCrear() {
        return objetoCrear;
    }

    public void setObjetoCrear(ZonaCiudad objetoCrear) {
        this.objetoCrear = objetoCrear;
    }

    public ZonaCiudad getObjetoSeleccionado() {
        return objetoSeleccionado;
    }

    public void setObjetoSeleccionado(ZonaCiudad objetoSeleccionado) {
        this.objetoSeleccionado = objetoSeleccionado;
    }

    public List<ZonaCiudad> getListaObjeto() {
    try {
            listaObjeto = new LinkedList<ZonaCiudad>();
            listaObjeto = zonaCiudadFacade.ZonaCiudad_lista();
        } catch (Exception e) {
        }
        return listaObjeto;
    }

    public void setListaObjeto(List<ZonaCiudad> listaObjeto) {
        this.listaObjeto = listaObjeto;
    }

    public List<SelectItem> getObjetoItems() {
        objetoItems = new LinkedList<SelectItem>();
        for (ZonaCiudad p : zonaCiudadFacade.ZonaCiudad_lista()) {
            objetoItems.add(new SelectItem(p, p.getDescripcionZonaCiudad()));
        }
        return objetoItems;
    }

    public void setObjetoItems(List<SelectItem> objetoItems) {
        this.objetoItems = objetoItems;
    }
    public void crear() {
        try {
            objetoCrear.setEstadoExistencia(1);
            objetoCrear.setFechaRegistro(new Date());
            zonaCiudadFacade.create(objetoCrear);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("REGISTRO GRABADO CON EXITO", "NUEVO TIEM"));

        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("ERROR AL GRABAR", "ERROR"));
        }
    }

    public void editar() {
        try {
            zonaCiudadFacade.edit(objetoSeleccionado);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("REGISTRO EDITADO CON EXITO", "EXITO"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("ERROR AL EDITAR", "ERROR"));
        }

    }

    public void eliminar() {
        try {
            objetoSeleccionado.setEstadoExistencia(0);
            zonaCiudadFacade.edit(objetoSeleccionado);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("REGISTRO ELIMINADO CON EXITO", "EXITO"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("ERROR AL ELIMINAR", "ERROR"));
        }
    }
}
