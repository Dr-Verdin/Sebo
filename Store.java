import java.util.*;

public class Store {
    private Map<Integer, Product> produtos = new HashMap<>();    // ter controle sobre os produtos
    private Map<Integer, Integer> estoque = new HashMap<>();     // ter controle sobre a quantidade de cada item
    private int quantProdutosMax;
    private int quantProdutosAtual;

    public Store(int lenMax){
        this.quantProdutosMax = lenMax;
        this.quantProdutosAtual = 0;
    }

    public Product getProduct(int code){
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

    public int getQuantProduto(int code){
        return estoque.get(code);
    }

    private void newBook(String[] campos){
        int code = Integer.parseInt(campos[2]);
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
        int code = Integer.parseInt(campos[2]);
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
        int code = Integer.parseInt(campos[2]);
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

    public void insertProduct(String[] campos){
        int code = Integer.parseInt(campos[2]);
        if(produtos.containsKey(code)){
            System.out.println("Produto com o código de barras " + code + " já existe.");
            return;
        }

        if(campos[1].equals("Livro")){
            newBook(campos);
        } else if(campos[1].equals("CD")){
            newCd(campos);
        } else if(campos[1].equals("DVD")){
            newDvd(campos);
        } else {
            System.out.println("Tipo de produto inválido.");
        }
    }

    public void addProducts(int code, int quant){
        if(!estoque.containsKey(code)){
            System.out.println("Produto com o código de barras " + code + " não existe.");
            return;
        }

        if((quantProdutosAtual + quant) > quantProdutosMax){
            System.out.println("Estoque cheio.");
            return;
        }

        quantProdutosAtual += quant;
        int atualQuant = estoque.get(code);
        estoque.put(code, atualQuant + quant);     
    }

    public boolean soldProducts(int code, int quant){
        if(!estoque.containsKey(code)){
            System.out.println("Produto com o código de barras " + code + " não existe.");
            return false;
        }
        
        int atualQuant = estoque.get(code);
        if(atualQuant >= quant){
            estoque.put(code, atualQuant - quant); 
            quantProdutosAtual -= quant;
            return true;
        } else {
            System.out.println("Quantidade insuficiente para vender.");
            return false;
        }   
    }

    public void printSumario(){
        System.out.println("Sumário dos Produtos na Loja:");
        System.out.println("----------------------------------------");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Product p : produtos.values()) {
                p.printDetails(); // Chama o método de impressão de detalhes específico de cada produto
                int quant = estoque.get(p.getCode());
                System.out.println("Quantidade em estoque: " + quant);
                System.out.println("----------------------------------------");
                System.out.println();
            }
        }
    }
}