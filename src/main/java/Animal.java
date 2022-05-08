import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return name.equals(animal.name) &&
                type.equals(animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,type);
    }
}
