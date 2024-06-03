import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        // cargar datos desde csv
        List<Worker> workers = cargarDatos("documento.csv");
        System.out.println(getPersonsSorted(workers));
/*
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

    private static List<Worker> cargarDatos(String file) {

        List<Worker> workers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String l;
            br.readLine(); // Eliminamos la primera linea
            while ((l = br.readLine()) != null) {
                String[] fields = l.split(";");
                String nombre = fields[0];
                String apellidos = fields[1];
                String DNI = fields[2];
                int edad = Integer.parseInt(fields[3]);
                String mail = fields[4];
                int experiencia = Integer.parseInt(fields[5]);

                try{
                    if (fields[6].equals("")) {
                        String departmentString = fields[7];
                        NonITWorker.Department department = NonITWorker.Department.getDepartmentFromString(departmentString);
                        workers.add(new NonITWorker(nombre,apellidos,DNI,edad,mail,experiencia,department));
                    } else {

                        String categoriaString = fields[6];
                        ITWorker.Categoria categoria = ITWorker.Categoria.getCategoriaFromString(categoriaString);
                        workers.add(new ITWorker(nombre,apellidos,DNI,edad,mail,experiencia,categoria));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return workers;
    }

    private static Collection<Payable> getPersonsSorted(List<Worker> workers) {
        return workers.stream().sorted().collect(Collectors.toList());
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