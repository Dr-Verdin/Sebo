import java.util.*;

public class Store {
    private Map<Long, Product> produtos = new HashMap<>();    // ter controle sobre os produtos
    private Map<Long, Integer> estoque = new HashMap<>();     // ter controle sobre a quantidade de cada item
    private int quantProdutosMax;
    private int quantProdutosAtual;

    public Store(int lenMax){
        this.quantProdutosMax = lenMax;
        this.quantProdutosAtual = 0;
    }

    public Product getProduct(long code){
        return produtos.get(code);
    }

    public Product getProduct(String nome){
        for (Product p : produtos.values()) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public int getQuantProduto(long code){
        return estoque.getOrDefault(code, 0);
    }

    private void newBook(String[] campos){
        long code = Long.parseLong(campos[2]);
        String nomeLivro = campos[3];
        String autor = campos[4];
        String editora = campos[5];
        int ano = Integer.parseInt(campos[6]);
        int edicao = Integer.parseInt(campos[7]);
        int paginas = Integer.parseInt(campos[8]);
        String idioma = campos[9];

        Book newBook = new Book(code, nomeLivro, autor, editora, ano, edicao, paginas, idioma);

        produtos.put(newBook.getCode(), newBook);
        estoque.put(newBook.getCode(), 0);
    }

    private void newCd(String[] campos){
        long code = Long.parseLong(campos[2]);
        String album = campos[3];
        String artista = campos[4];
        int numTrilhas = Integer.parseInt(campos[5]);
        String gravadora = campos[6];
        int ano = Integer.parseInt(campos[7]);

        Cd newCd = new Cd(code, album, artista, numTrilhas, gravadora, ano);

        produtos.put(newCd.getCode(), newCd);
        estoque.put(newCd.getCode(), 0);
    }

    private void newDvd(String[] campos){
        long code = Long.parseLong(campos[2]);
        String filme = campos[3];
        String diretor = campos[4];
        String idioma = campos[5];
        String genero = campos[6];
        int ano = Integer.parseInt(campos[7]);
        String nacionalidade = campos[8];

        Dvd newDvd = new Dvd(code, filme, diretor, idioma, genero, ano, nacionalidade);

        produtos.put(newDvd.getCode(), newDvd);
        estoque.put(newDvd.getCode(), 0);
    }

    public boolean insertProduct(String[] campos){
        if(campos[1].equals("Livro")){
            System.out.println("\nOperação inserir livro: " + campos[2]);
        } else if(campos[1].equals("CD")){
            System.out.println("\nOperação inserir CD: " + campos[2]);
        } else if(campos[1].equals("DVD")){
            System.out.println("\nOperação inserir DVD: " + campos[2]);
        } else {
            System.out.println("\nTipo de produto inválido.");
            return false;
        }

        long code = Long.parseLong(campos[2]);
        if(produtos.containsKey(code)){
            System.out.println("***Erro: Código já cadastrado: " + code);
            return false;
        }

        if(campos[1].equals("Livro")){
            newBook(campos);
        } else if(campos[1].equals("CD")){
            newCd(campos);
        } else if(campos[1].equals("DVD")){
            newDvd(campos);
        }

        return true;
    }

    public boolean addProducts(long code, int quant){
        System.out.println("\nOperação de compra: " + code);
        
        if(!estoque.containsKey(code)){
            System.out.println("***Erro: Código inexistente: " + code);
            return false;
        }

        if((quantProdutosAtual + quant) > quantProdutosMax){
            System.out.println("Estoque cheio.");
            return false;
        }

        quantProdutosAtual += quant;
        int atualQuant = estoque.get(code);
        estoque.put(code, atualQuant + quant);   

        return true; 
    }

    public boolean soldProducts(long code, int quant){
        System.out.println("\nOperação de venda: " + code);

        if(!estoque.containsKey(code)){
            System.out.println("***Erro: Código inexistente: " + code);
            return false;
        }
        
        int atualQuant = estoque.get(code);
        if(atualQuant >= quant){
            estoque.put(code, atualQuant - quant); 
            quantProdutosAtual -= quant;
            return true;
        } else {
            System.out.println("***Erro: Estoque insuficiente: " + code + " Quantidade: " + quant);
            return false;
        }   
    }

    private void printProdutosPorTipo(Class<?> tipo, String label) {
        int total = 0;
        for (Product p : produtos.values()) {
            if (tipo.isInstance(p)) {
                p.printDetails();
                int quant = estoque.get(p.getCode());
                total += quant;
                System.out.println("Quantidade: " + quant + "\n");
            }
        }
        System.out.println("Quantidade de " + label + ": " + total + "\n");
    }

    public void printSumario() {
        System.out.println("\nOperação de sumarização: ");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            printProdutosPorTipo(Book.class, "Livros");
            printProdutosPorTipo(Cd.class, "CDs");
            printProdutosPorTipo(Dvd.class, "DVDs");
        }
    }

}