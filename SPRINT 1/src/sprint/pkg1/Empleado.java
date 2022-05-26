/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint.pkg1;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author alumne
 */
class Empleado implements Serializable{
    public String nombre;
    public String user;
    public String password;
    public String rol;
    public double sueldo;
    public int año;
    public int mes;
    public int dia;
    private Date fechaContrato;
    
    public Empleado(){
        
    }
    
    public Empleado(String s, double d, int año, int mes, int dia){
        nombre = s;
        sueldo = d;
        GregorianCalendar calendario = new GregorianCalendar(año, mes-1,dia);
        Date fechaContrato = calendario.getTime();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getSueldo(){
        return sueldo;
    }
    
    public int getAño() {
        return año;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getDia(){
        return dia;
    }
    // SETTERS
    public void setNombre(String s) {
        nombre = s;
    }
    
    public void setSueldo(double d){
        sueldo = d;
    }
    
    public void setAño(int i) {
        año = i;
    }
    
    public void setMes(int i) {
        año = i;
    }
    
    public void setDia(int i) {
        año = i;
    }
    
    public Date getFechaContrato(){
        return fechaContrato;
    }
    
    public String toString(){
        return "Nombre: " + nombre + ", sueldo: " + sueldo + ", fecha de contrato: "+ fechaContrato;
    }
    
    
}

class Administrador extends Empleado{
    
    public Administrador(String s, double d, int año, int mes, int dia){
        super(s,d,año,mes,dia);
                
    }
    
    public double getSueldo(){
        return sueldo;
    }
       
}
