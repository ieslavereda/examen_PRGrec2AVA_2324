import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

/*
        // cargar datos desde csv
        Set<Worker> Workers = cargarDatos("documento.csv");

        // pasar de Set<Persona> a Map<Titulo,List<NonITWorker>>
        Map<Titulo,List<NonITWorker>> alumnosTitulo = getAlumnosTitulo(Workers);

        // imprimir carnets de alumnos ordenados edad
        imprimirCarnets(getAlumnosSortedByAge(Workers));

        // imprimir carnets de todos ordenados alfabeticamente
        System.out.println("1111111111111111111111111111111111111111111");
        imprimirCarnets(getPersonsSorted(Workers));
        System.out.println("1111111111111111111111111111111111111111111");

        // guardar listado de alumnos de 1DAW
        save(alumnosTitulo.get(Titulo.ASIR_1));

        // guardar personas como objeto
        saveAsObject(Workers);

        // cargar personas
        //loadObjectFile();
*/
    }

    /*
    private static Set<Worker> loadObjectFile() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas"))){

            return (Set<Worker>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveAsObject(Set<Worker> Workers) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas"))) {

            oos.writeObject(Workers);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Collection<Payable> getPersonsSorted(Set<Worker> Workers) {
        return Workers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Payable> getAlumnosSortedByAge(Set<Worker> Workers){

        return Workers.stream()
                .filter(p -> p instanceof NonITWorker)
                .map(p-> (NonITWorker)p)
                .sorted(Comparator.comparingInt(Worker::getEdad))
                .collect(Collectors.toList());

    }

    private static Map<Titulo, List<NonITWorker>> getAlumnosTitulo(Set<Worker> Workers) {

        Map<Titulo, List<NonITWorker>> titulos= new HashMap<>();

        Workers.stream()
                .filter( p -> p instanceof NonITWorker)
                .map(Worker -> (NonITWorker) Worker)
                .forEach( alumno -> {
                    if(titulos.containsKey(alumno.getTitulo()))
                        titulos.get(alumno.getTitulo()).add(alumno);
                    else
                        titulos.put(alumno.getTitulo(),new ArrayList<>(List.of(alumno)));
                });

     */

        /*
        for(Persona persona : personas){
            if(persona instanceof NonITWorker){
                NonITWorker alumno = (NonITWorker) persona;
                if(titulos.containsKey(alumno.getTitulo()))
                    titulos.get(alumno.getTitulo()).add(alumno);
                else {
                    titulos.put(alumno.getTitulo(),new ArrayList<>(List.of(alumno)));
                }
            }
        }
        */
/*
        return titulos;
    }

    private static Set<Worker> cargarDatos(String file) {

        Set<Worker> Workers = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String l;
            br.readLine(); // Eliminamos la primera linea
            while ((l = br.readLine()) != null) {
                String[] fields = l.split(",");
                String nombre = fields[1];
                String apellidos = fields[2];
                int edad = Integer.parseInt(fields[5]);
                String mail = fields[6];

                if (fields[0].equalsIgnoreCase("NonITWorker")) {
                    try {
                        String NIA = fields[3];
                        Curso curso = Curso.getCursoFromInt(Integer.parseInt(fields[7]));
                        Ciclo ciclo = Ciclo.valueOf(fields[8]);
                        Titulo titulo = Titulo.getTitulo(curso, ciclo);
                        Workers.add(new NonITWorker(nombre, apellidos, edad, mail, NIA, titulo));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    String DNI = fields[4];
                    Workers.add(new ITWorker(nombre, apellidos, edad, mail, DNI));
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Workers;
    }

    private static void imprimirCarnets(Collection<Payable> payables){
        for(Payable i : payables){
            System.out.println("-----------------------");
            System.out.println(i.getTipo());
            System.out.println(i.getFullName());
            System.out.println("-----------------------");
        }
    }

    private static void save(Collection<NonITWorker> alumnos){

        try(PrintWriter pw = new PrintWriter(new FileWriter("alumnos.csv"))){
            String linea="Nombre,Apellidos,NIA,Edad,Mail,Curso,Ciclo";
            pw.println(linea);

            for (NonITWorker alumno:alumnos)
                pw.println(alumno.getNombre()+","+alumno.getApellidos()+","+alumno.getNIA()+","+alumno.getEdad()+","+alumno.getEmail()+","+alumno.getTitulo());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

 */
}