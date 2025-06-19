public class Livro implements Comparable<Livro> {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Livro [getTitulo()=" + getTitulo() + ", getAutor()=" + getAutor() + ", getAno()=" + getAno() + "]";
    }

    private String geraChave(){
        String chave = (this.getAutor() + this.getTitulo() + this.getAno()).toLowerCase();
        return chave;
    }

    @Override
    public int compareTo(Livro outroLivro) {
        String chaveThis = this.geraChave();
        String chaveOutro = outroLivro.geraChave();
        return chaveThis.compareTo(chaveOutro);
    }
}
