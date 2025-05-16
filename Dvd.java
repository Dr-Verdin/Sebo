public class Dvd extends Product{
    String diretor;
    String idioma;
    String genero;
    int ano;
    String nacionalidade;

    public Dvd(int code, String filme, String diretor, String idioma, String genero, int ano, String nacionalidade){
        super(code, filme);

        this.diretor = diretor;
        this.idioma = idioma;
        this.genero = genero;
        this.ano = ano;
        this.nacionalidade = nacionalidade;
    }

    @Override
    public int getCode(){
        return super.getCode();
    }

    public String getFilme(){
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
        System.out.println("Código: " + getCode());
        System.out.println("Filme: " + getFilme());
        System.out.println("Diretor: " + getDiretor());
        System.out.println("Idioma: " + getIdioma());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Ano: " + getAno());
        System.out.println("Nacionalidade: " + getNacionalidade());
    }
}