package domain;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marcelo
 * @version 1.0
 * @created 26-Nov-2021 6:27:26 PM
 */
public class Clinica {

	private Registro m_Registro = new Registro();
	private Usuario m_Usuario;
        private Paciente p = new Paciente();
        private TPaciente tt = new TPaciente();
        private TUsuario usu=new TUsuario();

	public Clinica(){
            
	}

	public void finalize() throws Throwable {

	}
	public void agregarPaciente(Paciente p){
            m_Registro.crearPaciente(p);
	}
        public void agregarCita(Cita m){
            this.m_Registro.cargarCita();
            this.m_Registro.crearCita(m);
        }
        public void cargarCita() {
            this.m_Registro.cargarCita();
        }
        public Cita leerCita(){
            Cita n;
            this.cargarCita();
            return n = this.m_Registro.leerCita(1);
        }
        public Cita leerCitaActual(){
            Cita n;
            return n = this.m_Registro.leerCitaAct();
        }

         public boolean sigCita(){
            boolean sig = this.m_Registro.siguienteCita();
            return sig;
        }
        public boolean antCtia(){
            boolean ant = this.m_Registro.anteriorCita();
            return ant;
        }
        
        public void modificarCita(Cita m){
            
            this.m_Registro.modificarCita(m);
        }
        
        public void eliminarCita(){
            this.m_Registro.eliminarCita();
        }

        
        public void crearRegistro(Registro m){
            this.m_Registro.cargarRegistro();
            this.m_Registro.crearRegistro(m);
        }
        
        public Registro leerRegistroAct(){
            Registro n;
            return n = this.m_Registro.leerRegistroAct();
        }
        public Registro leerRegistro(){
            Registro n;
            this.cargarRegistro();
            n=this.m_Registro.leerRegistro(1);
            return n;
        }
        public boolean sigRegistro(){
            boolean sig = this.m_Registro.siguienteReg();
            return sig;
        }
        public boolean antRegistro(){
            boolean ant = this.m_Registro.anteriorReg();
            return ant;
        }
        
        public void modificarRegistro(Registro m){
            
            this.m_Registro.modificarReg(m);
        }
        
        public void eliminarRegistro(){
            this.m_Registro.eliminarReg();
        }

	
        public void cargarRegistro(){
            this.m_Registro.cargarRegistro();
        }
        public void cargarPacientes(){
            this.m_Registro.cargarPaciente();
        }
       
        public Paciente leerPaciente(){
            this.cargarPacientes();
            this.p=this.m_Registro.leerPaciente(1);
            
            return p;
        }
        public Paciente leerPacienteAct(){
            return this.p = this.m_Registro.leerPacienteAct();
        }
        public boolean sigPaciente(){
            boolean sig = this.m_Registro.siguientePac();
            return sig;
        }
        public boolean antPaciente(){
            boolean ant = this.m_Registro.anteriorPac();
            return ant;
        }
        
////        public boolean buscarUsuario(Usuario e) {
//////            int l = 1;
//////          Usuario n = this.leerUsuario(1);
//////          boolean f = false;
//////          
//////          do{
//////          if(n.getUsuario().compareTo(e.getUsuario())==0&&n.getClave().compareTo(e.getClave())==0){
//////              f = true;
//////          }else if(this.sigUsuario()){
//////              l++;
//////              n = this.leerUsuario(l);
//////          }else{
//////              break;
//////          }
//////          }while(f==false);
//////          return f;
////        }
        
        public boolean sigUsuario(){
            boolean sig = this.usu.siguiente();
            return sig;
        }
        public Usuario leerUsuario(int i){
            this.cargarUsuarios();
            this.m_Usuario = this.usu.leerRegistro(i);
            return m_Usuario;
        }

	public void crearUsuario(String usuario, String clave){
            this.m_Usuario = new Usuario();
            this.m_Usuario.setUsuario(usuario);
            this.m_Usuario.setClave(clave);
            this.usu.agregar(m_Usuario);
	}
        public void cargarUsuarios(){
            this.usu.cargarDatos();
        }

    

        
        
}//end Clinica