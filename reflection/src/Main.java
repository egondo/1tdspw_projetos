import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Random;
import java.util.prefs.Preferences;

public class Main {

    private static Pessoa criaPessoa() {
        String[] nomesF = {"Sandra", "Bia", "Ana", "Diana", "Fabiana", "Joana", "Leticia"};
        String[] nomesM = {"Sergio", "Evandro", "Carlos", "Daniel", "Fabio", "Joao", "Leandro"};

        Random r = new Random();
        Pessoa pes = new Pessoa();
        if (r.nextBoolean()) {
            pes.setGenero("masculino");
            pes.setNome(nomesM[r.nextInt(7)]);
        }
        else {
            pes.setGenero("feminino");
            pes.setNome(nomesF[r.nextInt(7)]);
        }
        pes.setCpf(Long.toString(r.nextLong(100_000_000_00L, 999_999_999_99L)));
        int ano = r.nextInt(1930, 2010);
        int mes = r.nextInt(1, 12);
        int dia = r.nextInt(1, 28);
        pes.setNascimento(LocalDate.of(ano, mes, dia));
        return pes;
    }

    private static Produto criaProduto() {
        String[] desc = {"Celular", "Relógio", "Alexa", "Caixa de som", "Notebook", "Fone"};
        String[] local = {"SP", "MG", "RJ", "PR", "DF", "RS", "BA"};

        Random r = new Random();
        Produto prod = new Produto();
        prod.setDescricao(desc[r.nextInt(desc.length)]);
        prod.setLocalizacao(local[r.nextInt(local.length)]);
        prod.setQuantidade(r.nextInt(10, 1000));
        prod.setValor(10000 * r.nextDouble());
        prod.setCodigo(Long.toString(r.nextLong(100_000_000L, 999_999_999L)));
        return prod;
    }

    private static Object geraObjeto() {
        Random r = new Random();
        if (r.nextBoolean())
            return criaPessoa();
        else
            return criaProduto();
    }

    public static void main(String[] args) throws Exception {
        Object[] objetos = new Object[30];
        for (int i = 0; i < 30; i++) {
            objetos[i] = geraObjeto();
        }
        //"insert into pessoa(nome, idade, genero) values('Beto', 25, 'masculino')"
        Pessoa p = new Pessoa();
        p.setNascimento(LocalDate.now());
        p.setCpf("2834393");
        p.setIdade(26);
        p.setGenero("feminino");
        p.setNome("Ricardo");

        Class c = p.getClass();
        Method met = c.getDeclaredMethod("getNome");
        Object nome = met.invoke(p);
        System.out.println("Chamdando o método getNome() -> " + nome);

        met = c.getDeclaredMethod("getNascimento");
        Object valor = met.invoke(p);
        System.out.println("Chamdando o método getNascimento() -> " + valor);
    }
}