package com.example.firebaseopet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

class PopulateUtil {
    public static List<Pessoa> loadPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        Pessoa pessoa = new Pessoa();
        pessoa.nome = "Pedro José";
        pessoa.qtde_filhos = 1;
        pessoa.salario = 2500.75;
        pessoa.ativo = false;
        pessoa.pets = Arrays.asList("Pingo","Odin");
        pessoa.data_aniversario = new GregorianCalendar(2000, Calendar.APRIL,27).getTime();

        pessoas.add(pessoa);

        pessoa = new Pessoa();
        pessoa.nome = "José";
        pessoa.qtde_filhos = 10;
        pessoa.salario = 5000.75;
        pessoa.ativo = true;
        pessoa.pets = Arrays.asList("Alice","Josney");
        pessoa.data_aniversario = new GregorianCalendar(2000, Calendar.APRIL,28).getTime();

        pessoas.add(pessoa);

        pessoa = new Pessoa();
        pessoa.nome = "Lorenzo";
        pessoa.qtde_filhos = 0;
        pessoa.salario = 50000.75;
        pessoa.ativo = true;
        pessoa.pets = null;
        pessoa.data_aniversario = new GregorianCalendar(2000, Calendar.APRIL,29).getTime();

        pessoas.add(pessoa);

        return pessoas;
    }
}
