/**
 * Representa um aluno em uma instituição de ensino.
 * Classe baseada no exemplo do <a href="https://apexapps.oracle.com/pls/apex/f?p=44785:145:0::::P145_EVENT_ID,P145_PREV_PAGE:4887,143">Curso JDK 8 MOOC: Lambdas and Streams Introduction</a>.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Student{
    private int id;
    private String name;
    private char gender;
    private double score;
    private int gradYear;
    private Course course;

    public Student(){
    }

    /**
     * Cria um estudante.
     * Este construtor possui uma quantidade mais do que recomendável de parâmetros (3).
     * O mesmo é usado apenas para facilitar a geração de dados aleatórios,
     * mas é uma péssima prática em projetos reais.
     * No entanto, observe que o construtor não é público (é package),
     * não podendo ser usado fora do pacote.
     *
     * @param id matrícula do estudante
     * @param name nome do estudante
     * @param gender sexo do estudante
     * @param score nota do estudante
     * @param gradYear ano de graduação
     * @param course curso matriculado
     */
    Student(int id, String name, char gender, double score, int gradYear, Course course){
        setId(id);
        setName(name);
        setGender(gender);
        setScore(score);
        setGradYear(gradYear);
        setCourse(course);
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

    public char getGender() {
        return gender;
    }

    public final void setGender(char gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public final void setScore(double score) {
        this.score = score;
    }

    public int getGradYear() {
        return gradYear;
    }

    public final void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public Course getCourse() {
        return course;
    }

    public final void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString(){
        final String courseName = String.format("%-35s", course == null ? "" : "Curso: " + course.getName());
        return String.format(
                "Id: %6d Nome: %-30s Sexo: %c Nota: %5.2f Ano Grad: %4d %s",
                id, name, gender, score, gradYear, courseName);
    }
}
