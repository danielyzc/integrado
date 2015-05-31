/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.UbicacionFisicaFacadeLocal;
import be.Empleado;
import be.UbicacionFisica;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named("managedBeanUbicacionFisica")
@SessionScoped
public class ManagedBeanUbicacionFisica implements Serializable {

    @EJB
    private UbicacionFisicaFacadeLocal ubicacionFisicaFacade;
    private UbicacionFisica objetoCrear;
    private UbicacionFisica objetoSeleccionado;
    private List<UbicacionFisica> listaObjeto;
    private List<SelectItem> objetoItems = new LinkedList<SelectItem>();

    public ManagedBeanUbicacionFisica() {
        objetoCrear = new UbicacionFisica();
        objetoSeleccionado = new UbicacionFisica();
        listaObjeto = new LinkedList<UbicacionFisica>();
    }

    public UbicacionFisica getObjetoCrear() {
        return objetoCrear;
    }

    public void setObjetoCrear(UbicacionFisica objetoCrear) {
        this.objetoCrear = objetoCrear;
    }

    public UbicacionFisica getObjetoSeleccionado() {
        return objetoSeleccionado;
    }

    public void setObjetoSeleccionado(UbicacionFisica objetoSeleccionado) {
        this.objetoSeleccionado = objetoSeleccionado;
    }

    public List<UbicacionFisica> getListaObjeto() {

        try {
            listaObjeto = new LinkedList<UbicacionFisica>();
            listaObjeto = ubicacionFisicaFacade.UbicacionFisica_lista();
        } catch (Exception e) {
        }
        return listaObjeto;
    }

    public void setListaObjeto(List<UbicacionFisica> listaObjeto) {
        this.listaObjeto = listaObjeto;
    }

    public List<SelectItem> getObjetoItems() {
        objetoItems = new LinkedList<SelectItem>();
        for (UbicacionFisica p : ubicacionFisicaFacade.UbicacionFisica_lista()) {
            objetoItems.add(new SelectItem(p, p.getNombreUbicacionFisica() + " " + p.getDescripcionUbicacionFisica()));
        }
        return objetoItems;
    }

    public void setObjetoItems(List<SelectItem> objetoItems) {
        this.objetoItems = objetoItems;
    }

    public UbicacionFisica getObjeto(int id) {
        return ubicacionFisicaFacade.find(new UbicacionFisica(id));
    }

    public void preparaNew() {
        objetoCrear = new UbicacionFisica();
    }

    public void crear(Empleado objetoEmpleado) {
        try {
            // este es el que modifica
            objetoCrear.setEmpleado(objetoEmpleado);
            // este es el que crea
            objetoCrear.setEmpleado1(objetoEmpleado);
            objetoCrear.setEstadoExistencia(1);
            objetoCrear.setFechaRegistro(new Date());
            ubicacionFisicaFacade.create(objetoCrear);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("REGISTRO GRABADO CON EXITO", "NUEVO TIEM"));

        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("ERROR AL GRABAR", "ERROR"));
        }
    }

    public void editar(Empleado objetoEmpleado) {
        try {
             // este es el que modifica
            objetoCrear.setEmpleado(objetoEmpleado);
            ubicacionFisicaFacade.edit(objetoSeleccionado);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("REGISTRO EDITADO CON EXITO", "EXITO"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("ERROR AL EDITAR", "ERROR"));
        }

    }

    public void eliminar(Empleado objetoEmpleado) {
        try {
             // este es el que modifica
            objetoCrear.setEmpleado(objetoEmpleado);
            objetoSeleccionado.setEstadoExistencia(0);
            ubicacionFisicaFacade.edit(objetoSeleccionado);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("REGISTRO ELIMINADO CON EXITO", "EXITO"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("ERROR AL ELIMINAR", "ERROR"));
        }
    }
}
