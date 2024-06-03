package model;

public class ITWorker extends Worker {
    private final Category category;

    public ITWorker(String nombre, String apellidos, String DNI, int edad, String email, int experiencia, Category category) {
        super(nombre, apellidos, DNI, edad, email, experiencia);
        this.category = category;
    }

    @Override
    public String getRole() {
        return category.getCategory();
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return super.toString() +
                " category=" + category +
                '}';
    }

    public enum Category {
        FULLSTACK("FullStack"),
        BACKEND("BackEnd"),
        FRONTEND("FrontEnd");

        private String category;
        Category(String category){
            this.category = category;
        }
        public String getCategory() {
            return category;
        }

        public static Category getCategoriaFromString(String category) throws Exception{
            for(Category category1 : Category.values()){
                if (category1.getCategory().equals(category))
                        return category1;
            }
            throw new Exception("Error: non valid category");
        }

    }

}
