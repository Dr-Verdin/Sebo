public class Product {
    private int code;
    private String nome;

    public Product(int newCode, String newNome){
        this.code = newCode;
        this.nome = newNome;
    }

    public int getCode(){
        return code;
    }

    public String getNome(){
        return nome;
    }

    public void printDetails(){
        System.out.println("Código: " + getCode());
        System.out.println("Nome: " + getNome());
    }
}