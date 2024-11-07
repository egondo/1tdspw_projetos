import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Util {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Livro l = new Livro();
        l.setAno(1975);
        l.setIsbn("785546");
        l.setAutor("Milan Kundera");
        l.setTitulo("A insustentavel leveza do ser");

        XMLizable x = l;
        Field[] fields = x.getClass().getDeclaredFields();
        Method[] metodos = x.getClass().getMethods();

        for(Field f : fields) {
            System.out.println(f.getName());
        }

        for(Method m : metodos) {
            if (m.getName().startsWith("get")) {
                System.out.println(m.getName() + " " + m.invoke(x));
            }
        }
    }
}
