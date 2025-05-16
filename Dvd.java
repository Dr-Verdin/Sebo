public class Dvd extends Product{
    private String diretor;
    private String idioma;
    private String genero;
    private int ano;
    private String nacionalidade;

    public Dvd(int newCode, String newTitulo, String newDiretor, String newIdioma, String newGenero, int newAno, String newNacionalidade){
        super(newCode, newTitulo);
        this.diretor = newDiretor;
        this.idioma = newIdioma;
        this.genero = newGenero;
        this.ano = newAno;
        this.nacionalidade = newNacionalidade;
    }

    public String getTitulo(){
        return super.getNome();
    }

    public String getDiretor(){
        return diretor;
    }

    public String getIdioma(){
        return idioma;
    }

    public String getGenero(){
        return genero;
    }

    public int getAno(){
        return ano;
    }

    public String getNacionalidade(){
        return nacionalidade;
    }

    @Override
    public void printDetails(){
        System.out.println("Tipo: DVD");
        System.out.println("Código: " + super.getCode());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Diretor: " + getDiretor());
        System.out.println("Idioma: " + getIdioma());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Ano: " + getAno());
        System.out.println("Nacionalidade: " + getNacionalidade());
    }
}