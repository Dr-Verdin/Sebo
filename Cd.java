public class Cd extends Product{
    String artista;
    int numTrilhas;
    String gravadora;
    int ano;

    public Cd(int code, String album, String artista, int numTrilhas, String gravadora, int ano){
        super(code, album);

        this.artista = artista;
        this.numTrilhas = numTrilhas;
        this.gravadora = gravadora;
        this.ano = ano;
    }

    @Override
    public int getCode(){
        return super.getCode();
    }

    public String getAlbum(){
        return super.getNome();
    }

    public String getArtista(){
        return artista;
    }

    public int getNumTrilhas(){
        return numTrilhas;
    }

    public String getGravadora(){
        return gravadora;
    }

    public int getAno(){
        return ano;
    }

    @Override
    public void printDetails(){
        System.out.println("Código: " + getCode());
        System.out.println("Albúm: " + getAlbum());
        System.out.println("Artista: " + getArtista());
        System.out.println("Número de Trilhas: " + getNumTrilhas());
        System.out.println("Gravadora: " + getGravadora());
        System.out.println("Ano: " + getAno());
    }
}