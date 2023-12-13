package modelo;


public class Persona {
    private String nombre,correo,telefono;
    private int cedula;

    public Persona() {
    }

    public Persona(String nombre, String correo, String telefono, int cedula) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", cedula=" + cedula + '}';
    }
    
}
