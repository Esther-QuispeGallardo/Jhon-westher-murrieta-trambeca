/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.ClienteDao;
import Dao.MascotaDao;
import Dao.MascotaPorClienteDao;
import Dao.PersonalDao;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

@ManagedBean
//@RequestScoped
@ViewScoped
public class MascotaPorClienteBean {
     private boolean banderaSelect = false;
   private ArrayList listaCliente; 
    private ArrayList listaMascota; 
   private int idCliente;
   private int idMascota;
   private Mascotaporcliente mascotaporcliente;
   private MascotaporclienteId mascotaporclienteId;
public  MascotaPorClienteBean(){
    listaCliente=new ArrayList();
    mascotaporcliente=new Mascotaporcliente();
    mascotaporclienteId=new MascotaporclienteId();
     listarCombos();
}
public  void   listarCombos(){
    ClienteDao  clienteDao=new ClienteDao();
    listaCliente=clienteDao.listarCliente();
    MascotaDao  mascotaDao=new MascotaDao();
    listaMascota=mascotaDao.listarMascota();
            
}
public String guardarMascotaporCliente() {

     try {

            MascotaPorClienteDao mascotaPorClienteDao = new MascotaPorClienteDao();
              mascotaporclienteId.setClienteIdCliente(idCliente);
        mascotaporclienteId.setMascotaIdMascota(idMascota);

        mascotaporcliente.setId(mascotaporclienteId);
            boolean respuesta= mascotaPorClienteDao.guardarMascotaPorCliente(mascotaporcliente);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistrarMascotaCliente";
    }
  public String actualizarMascotaporcliente() {
        try {
            MascotaPorClienteDao mascotaDao = new MascotaPorClienteDao();
            boolean respuesta = mascotaDao.actualizar(mascotaporcliente);
            if (respuesta){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistrarMascotaCliente";

    }

    public ArrayList<Mascotaporcliente> listarMascotaporcliente() {
        ArrayList<Mascotaporcliente> lista = new ArrayList<>();
        MascotaPorClienteDao mascotaDao = new MascotaPorClienteDao();
        lista = mascotaDao.listarMascotaPorCliente();
        return lista;
    }

    public String eliminar() {
        MascotaPorClienteDao mascotaDao = new MascotaPorClienteDao();
        boolean respuesta = mascotaDao.eliminar(mascotaporcliente);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistrarMascotaCliente";
    }

    public String limpiar() {
        return "/RegistrarMascotaCliente";
    }





   public void selectBandera() {
        banderaSelect = true;
    }

    public ArrayList getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList listaCliente) {
        this.listaCliente = listaCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public ArrayList getListaMascota() {
        return listaMascota;
    }

    public void setListaMascota(ArrayList listaMascota) {
        this.listaMascota = listaMascota;
    }

    public Mascotaporcliente getMascotaporcliente() {
        return mascotaporcliente;
    }

    public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }

    public MascotaporclienteId getMascotaporclienteId() {
        return mascotaporclienteId;
    }

    public void setMascotaporclienteId(MascotaporclienteId mascotaporclienteId) {
        this.mascotaporclienteId = mascotaporclienteId;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
    
}
