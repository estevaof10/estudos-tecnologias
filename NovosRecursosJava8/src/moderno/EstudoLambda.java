package moderno;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EstudoLambda {
    public static void main(String args[]) {

        List<String> palavras = new ArrayList<String>();
        palavras.add("Alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");
        System.out.println("");

        // exemplo 1.
        //new Consumer fornecendo os metodos de implementaçao

//        Consumer<String> consumidor= new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        //passando o new como parametro no foreach da interface iterable
//        palavras.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        //o foreach ja espera um consumer entao podemos omitir essa informacao,
        // e como o Consumer só tem um metodo o compilador ja entende que iremos implementar aquele metodo em especifico
        // e assim podemos deixar nosso método mais enxuto
        palavras.forEach((s) -> { // estou passando um Consumer e implementando o metodo accept
                System.out.println(s);
        });

        //exemplo 2.

        System.out.println("exemplo 2 ===================");
        palavras.sort((o1,o2) -> {
                if(o1.length() < o2.length())
                    return -1;
                if (o1.length() > o2.length())
                    return 1;
                return 0;
            });

        // otmização do lambda de cima
        palavras.sort((s1,s2)-> { return Integer.compare(s1.length(), s2.length()); });
        System.out.println(palavras + "sort");

        Consumer<String> impressor = s-> System.out.println(s);
        palavras.forEach(impressor);

    }
}
