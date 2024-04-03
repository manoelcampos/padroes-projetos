
import com.manoelcampos.modelo.Paciente;

public class Principal {
    public static void main(String[] args) {
        Paciente paciente =
                Paciente.builder()
                        .nome("Raysa")
                        .cpf("00000000000")
                        .sexo('F')
                        .cidade("Palmas").uf("TO")
                        .build();

        System.out.println(paciente);
    }
}
