public class Animal {
    public int id;
    public String name;
    public String type;
    private String health;
    private String age;
    public static final String ANIMAL_TYPE="normal";



    public Animal(String name, String type) {
        this.name = name;
        this.type = ANIMAL_TYPE;
    }

    public String getName(){
        return name;
    }
    public String getType() {
        return type;
    }
}
