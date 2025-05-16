import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Entrada
        

        // Separar a entrada pelos campos
        String[] campos = entrada.split(", ");

        // Verificar se a operação é "I" (Inserir)
        if (campos[0].equals("I")) {
            // Criação do objeto Livro a partir dos campos
            String codigo = campos[2];
            String nome = campos[3];
            String autor = campos[4];
            String editora = campos[5];
            int ano = Integer.parseInt(campos[6]);
            String edicao = campos[7];
            int paginas = Integer.parseInt(campos[8]);
            String idioma = campos[9];

            // Criar o livro
            Livro livro = new Livro(codigo, nome, autor, editora, ano, edicao, paginas, idioma);

            // Exibir o livro inserido
            System.out.println("Livro inserido: " + livro);
        }
    }
}
