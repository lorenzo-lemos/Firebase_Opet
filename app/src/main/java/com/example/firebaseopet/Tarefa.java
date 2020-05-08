package com.example.firebaseopet;

import java.util.Date;

public class Tarefa {
    private String Horario;
    private String Titulo;
    private String Prioridade;
    private String Categoria;

    public Tarefa(String horario, String titulo, String prioridade, String categoria) {
        Horario = horario;
        Titulo = titulo;
        Prioridade = prioridade;
        Categoria = categoria;
    }

    public Tarefa() {
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getPrioridade() {
        return Prioridade;
    }

    public void setPrioridade(String prioridade) {
        Prioridade = prioridade;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
