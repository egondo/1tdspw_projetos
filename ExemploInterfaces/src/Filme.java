import java.util.List;

public class Filme implements XMLizable {

    private String titulo;
    private List<String> diretores;
    private int duracao;
    private List<String> atores;
    private String classificacao;
    private String genero;

    public String toXML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<filme duracao=" + duracao + ">");
        sb.append("<titulo>" + titulo + "</titulo>");
        sb.append("<genero>" + genero + "</genero>");
        sb.append("<classificacao>" + classificacao + "</classificacao>");
        sb.append("<diretores>");
        if (diretores != null) {
            for (String d : diretores) {
                sb.append("<diretor>" + d + "</diretor>");
            }
        }
        sb.append("</diretores>");

        sb.append("<atores>");
        if (diretores != null) {
            for (String d : atores) {
                sb.append("<ator>" + d + "</ator>");
            }
        }
        sb.append("</atores>");

        sb.append("</filme>");
        return sb.toString();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<String> diretores) {
        this.diretores = diretores;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<String> getAtores() {
        return atores;
    }

    public void setAtores(List<String> atores) {
        this.atores = atores;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
