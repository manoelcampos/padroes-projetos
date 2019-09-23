/**
 * Representa um curso de uma instituição de ensino.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Course{
    private int id;
    private String name;
    private int semesters;
    private Campus campus;

    public Course(){
    }

    public Course(int id, String name, int semesters, Campus campus){
        setId(id);
        setName(name);
        setSemesters(semesters);
        setCampus(campus);
    }

    public int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public int getSemesters() {
        return semesters;
    }

    public final void setSemesters(int semesters) {
        this.semesters = semesters;
    }

    public Campus getCampus() {
        return campus;
    }

    private void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public String toString(){
        return String.format("Id: %6d Nome: %-30s Semestres: %4d", id, name, semesters);
    }
}
