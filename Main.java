import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store sebo = new Store(100000);

        while(scanner.hasNextLine()){
            String entrada = scanner.nextLine();

            if (entrada.isEmpty()) {
                continue;
            }

            String[] campos = entrada.split(", ");

            char comando = campos[0].charAt(0);

            switch(comando){
                case 'I':   // inserir produtos
                    sebo.insertProduct(campos);
                    break;

                case 'A':   // adicionar produtos ao estoque
                    int codeAdd = Integer.parseInt(campos[1]);
                    int quantAdd = Integer.parseInt(campos[2]);
                    sebo.addProducts(codeAdd, quantAdd);
                    break;

                case 'V':   // vender produtos do estoque
                    int codeSold = Integer.parseInt(campos[1]);
                    int quantSold = Integer.parseInt(campos[2]);
                    sebo.soldProducts(codeSold, quantSold);
                    break;

                case 'P':   // Procurar produtos
                    Product produtoBuscado;
                    if(isNumeric(campos[1])){
                        produtoBuscado = sebo.getProduct(Integer.parseInt(campos[1]));
                    } else {
                        produtoBuscado = sebo.getProduct(campos[1]);
                    }
                    if (produtoBuscado != null) {
                        produtoBuscado.printDetails();
                        int quant = sebo.getQuantProduto(produtoBuscado.getCode());
                        System.out.println("Quantidade em estoque: " + quant);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 'S':   // sumário da loja
                    sebo.printSumario();
                    scanner.close();
                    return;

                default:
                    System.out.println("Comando inválido.");
                    break;
            }
        }
        scanner.close();
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); 
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}