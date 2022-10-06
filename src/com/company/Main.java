package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, ArrayList<String>> hashtable = new Hashtable<String, ArrayList<String>>();

        ArrayList<String> listaContatosVinicius = new ArrayList<String>();

        listaContatosVinicius.add("Phellipe");
        listaContatosVinicius.add("Luis");
        listaContatosVinicius.add("Pedro");
        listaContatosVinicius.add("Juliano");

        hashtable.put("Vinicius", listaContatosVinicius);

        ArrayList<String> listaContatosLuis = new ArrayList<String>();

        listaContatosLuis.add("Rerison");
        listaContatosLuis.add("Maciel");

        hashtable.put("Luis", listaContatosLuis);

        ArrayList<String> listaContatosPhelippe = new ArrayList<String>();

        listaContatosPhelippe.add("Fabricio");
        listaContatosPhelippe.add("Harrison");

        hashtable.put("Phelippe", listaContatosPhelippe);

        ArrayList<String> listaContatosJuliano = new ArrayList<String>();

        listaContatosJuliano.add("Pedro");

        hashtable.put("Juliano", listaContatosJuliano);

        ArrayList<String> listaContatosPedro = new ArrayList<String>();

        listaContatosPedro.add("Juliano");

        hashtable.put("Pedro", listaContatosPedro);

//        apresentarDados(hashtable);
        System.out.println(pesquisaEmLargura(hashtable, "Harrison"));
    }

    private static void apresentarDados(Hashtable<String, ArrayList<String>> hashtable) {
        for (Map.Entry<String, ArrayList<String>> entidade : hashtable.entrySet()) {
            String chave = entidade.getKey();
            ArrayList<String> valor = entidade.getValue();

            System.out.println(chave + " / " + valor);
        }
    }

    private static String pesquisaEmLargura(Hashtable<String, ArrayList<String>> hashtable, String verticeInicial) {
        Queue<String> queue = new LinkedList<String>();
        ArrayList<String> verificados = new ArrayList<String>();

        queue = enfileirarDados(queue, (ArrayList<String>)hashtable.get(verticeInicial));

        while (queue.size() > 0){
             String pessoa = queue.poll();

             if (pessoa.equals("Harrison")){
                 return "Harrison foi encontrado.";
             }

             if (verificados.contains(pessoa)){
                 continue;
             }

             queue = enfileirarDados(queue, (ArrayList<String>)hashtable.get(pessoa));
        }

        return "Harrison não foi encontrado";
    }

    private static Queue<String> enfileirarDados(Queue<String> queue, ArrayList<String> lista){
        if (lista == null)
            return queue;

        for (String item : lista){
            queue.offer(item);
        }

        return queue;
    }

}
