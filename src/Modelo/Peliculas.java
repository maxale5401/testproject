package Modelo;


public class Peliculas {
    private String Codigo;
    private String Nombre;
    private String Genero;
    private String Clasificacion;
    private int Fecha;

    public Peliculas() {
    }

    public Peliculas(String Codigo, String Nombre, String Genero, String Clasificacion, int Fecha) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Clasificacion = Clasificacion;
        this.Fecha = Fecha;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
}
