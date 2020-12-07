import templatemethod.ClasseAbstrata;
import templatemethod.SubClasse1;
import templatemethod.SubClasseN;

/**
 * Classe cliente, que usa o as classes que implementam o padrão Template Method.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        ClasseAbstrata objeto1 = new SubClasse1();
        objeto1.templateMethod();

        ClasseAbstrata objetoN = new SubClasseN();
        objetoN.templateMethod();
    }
}
