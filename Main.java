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

            String[] campos = entrada.split(",");

            char comando = campos[0].charAt(0);

            switch(comando){
                case 'I':   // inserir produtos
                    if(sebo.insertProduct(campos)){
                        System.out.println("Operação realizada com sucesso");
                    }
                    break;

                case 'A':   // adicionar produtos ao estoque
                    long codeAdd = Long.parseLong(campos[1]);
                    int quantAdd = Integer.parseInt(campos[2]);
                    if(sebo.addProducts(codeAdd, quantAdd)){
                        System.out.println("Operação realizada com sucesso: " + codeAdd);
                    }
                    break;

                case 'V':   // vender produtos do estoque
                    long codeSold = Long.parseLong(campos[1]);
                    int quantSold = Integer.parseInt(campos[2]);

                    if(sebo.soldProducts(codeSold, quantSold)){
                        System.out.println("Operação realizada com sucesso: " + codeSold);
                    }
                    break;

                case 'P':   // Procurar produtos
                    System.out.println("\nProcurando: " + campos[1]);

                    Product produtoBuscado;
                    if(isNumeric(campos[1])){
                        produtoBuscado = sebo.getProduct(Long.parseLong(campos[1]));
                    } else {
                        produtoBuscado = sebo.getProduct(campos[1]);
                    }

                    if (produtoBuscado != null) {
                        System.out.println("Encontrado:");

                        produtoBuscado.printDetails();
                    } else {
                        System.out.println("Produto não encontrado: " + campos[1]);
                    }
                    break;

                case 'S':   // sumário da loja
                    sebo.printSumario();
                    break;

                default:
                    System.out.println("Comando inválido.");
                    break;
            }
        }
        scanner.close();
    }

    public static boolean isNumeric(String str){
        try {
            Long.parseLong(str); 
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}