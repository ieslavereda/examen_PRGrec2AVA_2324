import model.ITWorker;
import model.NonITWorker;
import model.Payable;
import model.Worker;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        // cargar datos desde csv
        List<Worker> workers = cargarDatos("documento.csv");
        System.out.println(getPersonsSorted(workers));
        System.out.println(getITbyRole(workers));
        printPayable(getPersonsSorted(workers));
        System.out.println(getITWorkersSortedByExperience(workers));
        saveAsObject(workers);
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
                        ITWorker.Category category = ITWorker.Category.getCategoriaFromString(categoriaString);
                        workers.add(new ITWorker(nombre,apellidos,DNI,edad,mail,experiencia, category));
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

    private static Map<ITWorker.Category, List<ITWorker>> getITbyRole(List<Worker> Workers) {

        Map<ITWorker.Category, List<ITWorker>> categories= new HashMap<>();

        Workers.stream()
                .filter( p -> p instanceof ITWorker)
                .map(itWorker -> (ITWorker) itWorker)
                .forEach( itWorker -> {
                if(categories.containsKey(itWorker.getCategory()))
                    categories.get(itWorker.getCategory()).add(itWorker);
                else
                    categories.put(itWorker.getCategory(),new ArrayList<>(List.of(itWorker)));
                });
        return categories;
    }

    private static void printPayable(Collection<Payable> payables){
        for(model.Payable i : payables){
            System.out.println("Name: " + i.getFullName() + " YoE: " + i.getYearsExperience() + " Role: " + i.getRole());
        }
    }

    private static List<Payable> getITWorkersSortedByExperience(List<Worker> workers){

        return workers.stream()
                .filter(p -> p instanceof ITWorker)
                .map(p-> (ITWorker) p)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(model.Worker::getYearsExperience)))
                .collect(Collectors.toList());
    }

    private static void saveAsObject(List<Worker> workers) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("workers.dat"))) {
            oos.writeObject(workers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}