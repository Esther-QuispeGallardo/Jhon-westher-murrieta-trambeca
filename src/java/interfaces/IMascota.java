/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author MARTIN
 */
public interface IMascota {

    public abstract boolean guardarMascota(Mascota mascota);

    public abstract ArrayList<Mascota> listarMascota();

    public abstract boolean actualizar(Mascota mascota);

    public abstract ArrayList<Mascota> listarRaza(Session sesion);

    public abstract ArrayList<Mascota> listarNombreMascota(Session sesion);

    public abstract Integer contarResgistro(Session sesion);

    public abstract boolean eliminar(Mascota mascota);
}
