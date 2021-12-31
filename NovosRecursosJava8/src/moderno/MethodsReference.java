package moderno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodsReference {
    public static void main(String args[]) {

        List<String> palavras = new ArrayList<String>();
        palavras.add("Alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");
        System.out.println("");
        // maneira criada na classe EstudoLambda
        palavras.sort((s1,s2)-> { return Integer.compare(s1.length(), s2.length()); });
        System.out.println(palavras + "sort");

        // otmizando com methodsReference
        palavras.sort(Comparator.comparing(String::length)); // palavras ordene comparando o length da String

        // otimizado
        palavras.sort(Comparator.comparing(s -> s.length()));

        // faz a mesma coisa que o metodo a cima só que dessa maneira é mais legivel
        Comparator<String> comparador = Comparator.comparing(s -> s.length());
        palavras.sort(comparador);

        // mais legivel
        Function<String,Integer> funcao = s->s.length();
        Comparator<String> comparadorb = Comparator.comparing(funcao);
        palavras.sort(comparadorb);

        // a mesma coisa que os metodos acima so que sem usar lambda

        Function<String,Integer> funcao2 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Comparator<String> compara = Comparator.comparing(funcao2);
        palavras.sort(compara);

    }
}
