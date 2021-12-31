package moderno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethods {
    public static void main(String args[]) {
        // metodos defaults são metodos que possuem corpo em uma interface, antes do java 8 isso não era possivel
        // exemplo 1. usando List e um sort da interface de collections
        List<String> palavras = new ArrayList<String>();
        palavras.add("Alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");

        Collections.sort(palavras);
        System.out.println(palavras);

        // exemplo 2. implementeando um comparator

        Comparator<String> comparator = new ComparadorPorTamanho();
        System.out.println("exemplo 2 ===================");
        Collections.sort(palavras, comparator);
        System.out.println(palavras);

        //exemplo 3. usando o sort da propria interface List<> usando o comparador que criamos
        System.out.println("exemplo 3 ===================");
        palavras.sort(comparator);
        System.out.println(palavras);

        //exemplo 4.

        //forma 1 de imprimir as strings
//        for(String p : palavras){
//            System.out.println(p);
//        }

        //usando o foreach da propria List<>
        Consumer<String> consumidor= new ImprimeNaLinha();
        palavras.forEach(consumidor);

    }
}

class ImprimeNaLinha implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length())
            return -1;
        if (o1.length() > o2.length())
            return 1;
        return 0;
    }
}