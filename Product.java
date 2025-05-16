public class Product {
    private int code;
    private String nome;

    public Product(int newCode, String newNome){
        this.code = newCode;
        this.nome = newNome
    }

    public int getCode(){
        if(code != null){
            return code;
        }
    }

    public String getNome(){
        if(nome != null){
            return nome;
        }
    }

    public void printDetails(){
        System.out.println("Código: " + getCode());
        System.out.println("Nome: " + getNome());
    }
}