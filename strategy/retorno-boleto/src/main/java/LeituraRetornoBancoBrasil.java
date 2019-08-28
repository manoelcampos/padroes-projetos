import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    public List<Boleto> lerArquivo(String nomeArquivo) throws UncheckedIOException {
        try {
            //new BufferedReader(new FileReader(nomeArquivo));
            Files.newBufferedReader(Paths.get(nomeArquivo));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return Collections.emptyList();
    }
}
