/**
 * Representa um campus de uma instituição de ensino.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Campus {
    private int id;
    private String name;

    public Campus(){}

    public Campus(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
