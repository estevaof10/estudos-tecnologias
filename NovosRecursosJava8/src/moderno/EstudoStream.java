package moderno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EstudoStream {
    public static void main(String args[]) {

        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JS", 105));
        cursos.add(new Curso("JAVA", 125));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
        //cursos.forEach(c-> System.out.println(c.getNome()));

        //filter imprime
        cursos.stream().filter(c -> c.getAlunos() >= 100)
                .forEach(c-> System.out.println(c.getNome()));

        // map
        cursos.stream()
                .map(Curso::getAlunos)
                .filter(alunos -> alunos >= 100)
                .forEach(System.out::println);

    }
}
