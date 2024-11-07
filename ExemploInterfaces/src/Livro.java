public class Livro implements XMLizable {

    private String isbn;
    private String titulo;
    private int ano;
    private String autor;



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    @Override
    public String toXML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<livro ano=" + ano + ">");
        sb.append("<titulo>" + titulo + "</titulo>");
        sb.append("<autor>" + autor + "</autor>");
        sb.append("<isbn>" + isbn + "</isbn>");
        sb.append("</livro>");
        return sb.toString();
    }
}
