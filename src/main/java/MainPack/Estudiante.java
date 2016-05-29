package MainPack;

/**
 *
 * Created by Eduardo veras on 29-May-16.
 */
public class Estudiante {

    public Estudiante(int Mat, String nom, String apell,String tell)
    {
        this.matricula=Mat;
        this.nombre= nom;
        this.apellido= apell;
        this.telefono=tell;
    }
    private int matricula;
    private String nombre;
    private String apellido;
    private String telefono;


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
