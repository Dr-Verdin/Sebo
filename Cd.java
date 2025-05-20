public class Cd extends Product{
    private String artista;
    private int numTrilhas;
    private String gravadora;
    private int ano;

    public Cd(long newCode, String newAlbum, String newArtista, int newNumTrilhas, String newGravadora, int newAno){
        super(newCode, newAlbum);
        this.artista = newArtista;
        this.numTrilhas = newNumTrilhas;
        this.gravadora = newGravadora;
        this.ano = newAno;
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
        System.out.println("CD");
        super.printDetails();
        System.out.println("Banda: " + getArtista());
        System.out.println("Gravadora: " + getGravadora());
        System.out.println("Ano: " + getAno());
        System.out.println("trilhas: " + getNumTrilhas());
    }
}