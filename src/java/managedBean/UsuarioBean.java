/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.ClienteDao;
import Dao.MascotaDao;
import Dao.PersonalDao;
import Dao.UsuarioDao;
import entidades.Cliente;
import entidades.Personal;
import entidades.Usuario;
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
@ManagedBean(name = "usuarioBean") 
@ViewScoped
public class UsuarioBean implements Serializable{
   private boolean  banderSelect=false;
  private Usuario usuario;
  private Personal personal;
  private Cliente cliente;
    private ArrayList listaCliente; 
    private ArrayList listaPersonal;
    
    private int idCliente;
    private int idPersonal;
    
    public UsuarioBean() {
        this.usuario=new Usuario();
        listaCliente=new ArrayList();
        listaPersonal=new ArrayList();
        usuario=new Usuario();
        listarCombos();
    }

    public  void   listarCombos(){
    ClienteDao  clienteDao=new ClienteDao();
    listaCliente=clienteDao.listarCliente();
    PersonalDao  personalDao =new PersonalDao();
    listaPersonal=personalDao.listarPersonal();
            
}
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
    public String guardarUsuario() {

     try {

            UsuarioDao  usuarioDao=new UsuarioDao();
            personal.setIdPersonal(idPersonal);
            cliente.setIdCliente(idCliente);
            usuario.setCliente(cliente);
            usuario.setPersonal(personal);
            boolean respuesta= usuarioDao.guardarUsuario(usuario);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Erroreeewewewew::: " + e);
        }
        return "/RegistrarUsuario";
    }
        public String actualizarUsuario() {

    
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            boolean respuesta = usuarioDao.actualizarUsuario(usuario);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (Exception e) {
            
            System.out.println(" erroasasas"+e);
        }
        return "/RegistrarUsuario";
    }
      public ArrayList<Usuario> listar() {

        ArrayList<Usuario> lista = new ArrayList<>();

        UsuarioDao usuarioDao = new UsuarioDao();
        lista = usuarioDao.listarUsuario();

        return lista;

    }
      public  String limpiar(){
        return "/RegistrarUsuario";
    }
          public String eliminarUsuario(){
         UsuarioDao dao = new UsuarioDao();
            boolean respuesta= dao.eliminarUsuario(usuario);
            if(respuesta){
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto","Registro Borrado con exito"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error","No se pudo eliminar"));
            }
            return "/RegistrarUsuario.xhtml";
        
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
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
