import java.io.Serializable;

public abstract class Worker implements Payable, Comparable<Worker>, Serializable {
    private String nombre;
    private String apellidos;
    private String DNI;
    private int edad;
    private String email;
    protected int experiencia;

    public Worker(String nombre, String apellidos, String DNI, int edad, String email, int experiencia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.edad = edad;
        this.email = email;
        this.experiencia = experiencia;
    }

    public abstract String getRole();

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public int getExperiencia() {
        return experiencia;
    }

    @Override
    public int hashCode() {
        return getDNI().toLowerCase().hashCode();
    }

    @Override
    public int compareTo(Worker o) {
        return (apellidos.compareToIgnoreCase(o.apellidos)==0)?
                nombre.compareToIgnoreCase(o.nombre):
                apellidos.compareToIgnoreCase(o.apellidos);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(!(obj instanceof Worker)) return false;
        Worker p = (Worker) obj;
        return p.getDNI().equalsIgnoreCase(getDNI());
    }

    @Override
    public String getFullName(){
        return getNombre() + " " + getApellidos();
    }
    @Override
    public int getYearsExperience(){
        return getExperiencia();
    }

}
