public class Product {
    private long code;
    private String nome;

    public Product(long newCode, String newNome){
        this.code = newCode;
        this.nome = newNome;
    }

    public long getCode(){
        return code;
    }

    public String getNome(){
        return nome;
    }

    public void printDetails(){
        System.out.println("Código: " + getCode());
        System.out.println("Título: " + getNome());
    }
}