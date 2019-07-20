/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.ClienteDao;
import entidades.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author MARTIN
 */
@ManagedBean(name = "ClienteBean") 
@ViewScoped
public class ClienteBean implements Serializable{

  private Cliente cliente;
    public ClienteBean() {
        this.cliente=new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
    public String guardarCliente() {

     try {

            ClienteDao  clienteDao=new ClienteDao();
            boolean respuesta= clienteDao.guardarCliente(cliente);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Erroreeewewewew::: " + e);
        }
        return "/RegistrarCliente";
    }
        public String actualizarCliente() {

    
        try {
            ClienteDao clienteDao = new ClienteDao();
            boolean respuesta = clienteDao.actualizarCliente(cliente);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (Exception e) {
            
            System.out.println(" erroasasas"+e);
        }
        return "/RegistrarCliente";
    }
      public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();

        ClienteDao clienteDao = new ClienteDao();
        lista = clienteDao.listarCliente();

        return lista;

    }
      public  String limpiar(){
        return "/RegistrarCliente";
    }
          public String eliminarCliente(){
         ClienteDao dao = new ClienteDao();
            boolean respuesta= dao.eliminarCliente(cliente);
            if(respuesta){
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto","Registro Borrado con exito"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error","No se pudo eliminar"));
            }
            return "/RegistrarCliente.xhtml";
        
    }
}
