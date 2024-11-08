import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GeradorTabela {

    public String geraTabela(Class c) throws Exception {
        StringBuffer sb = new StringBuffer();

        sb.append("create table ");
        sb.append(c.getName().toLowerCase());
        sb.append("(");
        Field[] campos = c.getDeclaredFields();
        for(Field f : campos) {

            if (!f.isAnnotationPresent(Transiente.class)) {
                sb.append(f.getName().toLowerCase());
                sb.append(getTipo(f.getType()));
                sb.append(",");
            }
        }
        sb = sb.delete(sb.length() - 1, sb.length());
        sb.append(");");
        return sb.toString();
    }

    private String getTipo(Class type) {
        String classe = type.getName();

        if (classe.equals("java.lang.String"))
            return " varchar2(255)";
        else if (classe.equals("int"))
            return " number(4, 0)";
        else if (classe.equals("double"))
            return " number(8, 2)";
        else if (classe.equals("java.time.LocalDate"))
            return " date";
        else
            return "UNKNOW";
    }

    public static void main(String[] args) throws Exception {

        Class[] classes = {Pessoa.class, Produto.class, Contrato.class};
        GeradorTabela gt = new GeradorTabela();
        BufferedWriter bw = new BufferedWriter(new FileWriter("modelo.sql"));
        for(Class c : classes) {
            String sql = gt.geraTabela(c);
            //System.out.println(sql);
            bw.write(sql);
            bw.write("\n");
        }
        bw.close();
    }
}
