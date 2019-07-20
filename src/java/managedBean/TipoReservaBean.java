/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.TipoReservaDao;
import entidades.Tiporeserva;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;

/**
 *
 * @author Computer
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class TipoReservaBean implements Serializable {

    /**
     * SE COMUNICA CON EL DAO
     */
    private Tiporeserva tiporeserva;
    private boolean  banderSelect=false;

    public TipoReservaBean() {
        this.tiporeserva = new Tiporeserva();

    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

    public String guardarTiporeserva() {
        try {

            TipoReservaDao tiporeservaDao = new TipoReservaDao();
            boolean respuesta = tiporeservaDao.guardarTiporeserva(tiporeserva);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se regidtro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistrarTiporeserva";
    }

    public String actualizarTiporeserva() {
        try {
            TipoReservaDao tiporeservaDao = new TipoReservaDao();
            boolean respuesta = tiporeservaDao.actualizarTiporeserva(tiporeserva);
            if (respuesta){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistrarTiporeserva";

    }

    public ArrayList<Tiporeserva> listarTiporeservas() {
        ArrayList<Tiporeserva> lista = new ArrayList<>();
        TipoReservaDao tiporeservaDao = new TipoReservaDao();
        lista = tiporeservaDao.listarTiporeserva();
        return lista;
    }

    public String eliminar() {
        TipoReservaDao tiporeservaDao = new TipoReservaDao();
        boolean respuesta = tiporeservaDao.eliminarTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistrarTiporeserva";
    }

    public String limpiar() {
        return "/RegistrarTiporeserva";
    }
    public  void selectBandera(){
        banderSelect=true;
    }

    public boolean isBanderSelect() {
        return banderSelect;
    }

    public void setBanderSelect(boolean banderSelect) {
        this.banderSelect = banderSelect;
    }
    

}
