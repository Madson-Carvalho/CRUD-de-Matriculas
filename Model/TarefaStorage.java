package Model;

import java.util.ArrayList;
import java.util.List;

public class TarefaStorage {
    private static int incremento = 0;
    private static List<Tarefa> tarefas = new ArrayList<>();

    public static void inserir(Tarefa tarefa) {
        tarefa.setId(++incremento);
        tarefas.add(tarefa);
    }

    public static void atualizar(Tarefa tarefa) {
        int i = tarefas.indexOf(tarefa);
        if (i >= 0) {
            tarefas.set(i, tarefa);
        }
    }

    public static void remover(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    public static List<Tarefa> listar() {
        return tarefas;
    }
}
