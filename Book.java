public class Book extends Product{
    String autor;
    String editora;
    int ano;
    int edicao;
    int paginas;
    String idioma;

    public Book(int code, String livro, String autor, String editora, int ano, int edicao, int paginas, String idioma){
        super(code, livro);

        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.edicao = edicao;
        this.paginas = paginas
        this.idioma = idioma;
    }

    @Override
    public int getCode(){
        return super.getCode();
    }

    public String getLivro(){
        return super.getNome();
    }

    public String getAutor(){
        return autor;
    }

    public String getEditora(){
        return editora;
    }

    public int getAno(){
        return ano;
    }

    public int getEdicao(){
        return edicao;
    }

    public int getPaginas(){
        return paginas;
    }

    public String getIdioma(){
        return idioma;
    }

    @Override
    public void printDetails(){
        System.out.println("Código: " + getCode());
        System.out.println("Livro: " + getLivro());
        System.out.println("Autor: " + getAutor());
        System.out.println("Editora: " + getEditora());
        System.out.println("Ano: " + getAno());
        System.out.println("Edição: " + getEdicao());
        System.out.println("Páginas: " + getPaginas());
        System.out.println("Idioma: " + getIdioma());
    }
}