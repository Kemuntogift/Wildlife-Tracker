import java.util.Objects;

public class Rangers {
    private int id;

    private String name;
    private int badge_number;


    public Rangers(String name, int badge_number) {
        this.name = name;
        this.badge_number = badge_number;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public int getBadge_number() {
        return badge_number;
    }
    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rangers rangers = (Rangers) o;
        return id == rangers.id &&
                name == rangers.name &&
                badge_number == rangers.badge_number;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, badge_number);
    }
}
