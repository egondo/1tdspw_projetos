import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        Livro l = new Livro();
        l.setAno(1975);
        l.setIsbn("785546");
        l.setAutor("Milan Kundera");
        l.setTitulo("A insustentavel leveza do ser");

        Livro l2 = new Livro();
        l2.setTitulo("Senhor dos Anéis");
        l2.setAno(1978);
        l2.setIsbn("55345340");
        l2.setAutor("JR Tolkien");

        Filme f = new Filme();
        f.setTitulo("Harry Potter e a Pedra Filosofal");
        f.setClassificacao("Livre");
        f.setDuracao(136);
        f.setGenero("Infantil");

        List<String> atores = new ArrayList<>();
        atores.add("Daniel Radcliff");
        atores.add("Emma Watson");
        f.setAtores(atores);

        List<XMLizable> lista = new ArrayList<>();
        lista.add(l);
        lista.add(l2);
        lista.add(f);

        try {
            FileWriter fw = new FileWriter("d:/dados.xml");
            BufferedWriter bw = new BufferedWriter(fw);
            for(XMLizable obj : lista) {
                bw.write(obj.toXML());
                bw.write("\n");
            }
            bw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
