/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;


public class Cliente {
    
    private int idCliente;
    private String nombre;
    private String ApeMat;
    private String ApePat;
    private String telefo;
    private int edad;

    public Cliente(int idCliente, String ApeMat, String ApePat, String nombre, String telefo, int edad) {
        this.idCliente = idCliente;
        this.ApeMat = ApeMat;
        this.ApePat = ApePat;
        this.nombre = nombre;
        this.telefo = telefo;
        this.edad = edad;
    }
    
     public Cliente(){
        this(0,"","","","",0);
    }

    public Cliente(int aInt, String string, String string0, String string1, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApeMat() {
        return ApeMat;
    }

    public void setApeMat(String ApeMat) {
        this.ApeMat = ApeMat;
    }

    public String getApePat() {
        return ApePat;
    }

    public void setApePat(String ApePat) {
        this.ApePat = ApePat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefo() {
        return telefo;
    }

    public void setTelefo(String telefo) {
        this.telefo = telefo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", ApeMat=" + ApeMat + ", ApePat=" + ApePat + ", nombre=" + nombre + ", telefo=" + telefo + ", edad=" + edad + '}';
    }
    
    
    
    
}
