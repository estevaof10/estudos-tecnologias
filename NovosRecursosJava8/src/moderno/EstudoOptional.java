package moderno;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EstudoOptional {

    public static void main(String args[]) {

        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JS", 105));
        cursos.add(new Curso("JAVA", 125));
        cursos.add(new Curso("C", 55));

        // o Optional ajuda a trabalhar com null
        cursos.stream()
                  .filter(c -> c.getAlunos() >=100)
                  .findAny()
                  .ifPresent(curso1 -> System.out.println(curso1.getNome()));

         List<Curso> cursos2 = cursos.stream()
                .filter(c -> c.getAlunos() >=100)
                .collect(Collectors.toList());
        cursos2.forEach(c ->System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() >=100)
                .collect(Collectors.toMap(
                        c-> c.getNome(),// chave
                        c-> c.getAlunos())) //valor
                .forEach((nome, aluno) -> System.out.println(nome + " tem " + aluno + " alunos"));//valor

        cursos.parallelStream()
                .filter(c -> c.getAlunos() >=100)
                .collect(Collectors.toMap(
                        c-> c.getNome(),// chave
                        c-> c.getAlunos())) //valor
                .forEach((nome, aluno) -> System.out.println(nome + " tem " + aluno + " alunos"));//valor

    }
}
