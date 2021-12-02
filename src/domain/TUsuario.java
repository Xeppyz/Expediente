package domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TUsuario {
    Connection cn;
    Statement stn;
    ResultSet rs;
    
    public TUsuario(){
        cn = Conexion.getConexion();
    }
    public void cargarDatos(){
        try {
            stn=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=stn.executeQuery("SELECT * FROM Usuario");
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void agregar(Usuario e){
        try {
            rs.afterLast();
            rs.moveToInsertRow();
            rs.updateString("usuario", e.getUsuario());
            rs.updateString("clave", e.getClave());
            rs.insertRow();
            
            JOptionPane.showMessageDialog(null, "Cuenta Creada", "Crear Cuenta", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(TUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Usuario leerRegistro(int i){
         try {
            Usuario e = new Usuario();
            this.rs.absolute(i);
            e.setUsuario(rs.getString("usuario"));
            e.setClave(rs.getString("clave"));
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(TUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Usuario leerRegistroActual(){
        try {
            Usuario e = new Usuario();
            e.setUsuario(this.rs.getString("usuario"));
            e.setClave(this.rs.getString("clave"));
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(TUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean siguiente(){
        try {
        if(rs.next()!=false){
            return true;
        }
        else{
            rs.previous();
            return false;
        }
        } catch (SQLException ex) {
                Logger.getLogger(TUsuario.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
        
    }
    public boolean anterior(){
        try {
        if(rs.previous()!=false){
            return true;
        }
        else{
            rs.next();
            return false;
        }
        } catch (SQLException ex) {
                Logger.getLogger(TUsuario.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
//    public boolean buscar(Usuario m){
//       boolean found = false;
//       Usuario ex = this.leerRegistro(1);
//        do{
//            
//            if(ex.getUsuario().equals(m.getUsuario())&& ex.getClave().equals(m.getClave())){
//            found =  true;
//           }else if(this.siguiente()){
//              ex = this.leerRegistroActual(); 
//           }else{
//               break;
//           }  
//        }while(found==false);
//       
//        return found;
//       
//    }
}
