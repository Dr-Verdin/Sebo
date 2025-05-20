public class Book extends Product{
    private String autor;
    private String editora;
    private int ano;
    private int edicao;
    private int paginas;
    private String idioma;

    public Book(long newCode, String newTitulo, String newAutor, String newEditora, int newAno, int newEdicao, int newPaginas, String newIdioma){
        super(newCode, newTitulo);
        this.autor = newAutor;
        this.editora = newEditora;
        this.ano = newAno;
        this.edicao = newEdicao;
        this.paginas = newPaginas;
        this.idioma = newIdioma;
    }

    public String getTitulo(){
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
        System.out.println("Livro");
        super.printDetails();
        System.out.println("Autor: " + getAutor());
        System.out.println("Editora: " + getEditora());
        System.out.println("Edição: " + getEdicao());
        System.out.println("Ano: " + getAno());
        System.out.println("Páginas: " + getPaginas());
        System.out.println("Idioma: " + getIdioma());
    }
}