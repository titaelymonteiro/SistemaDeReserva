package Modelo;

import java.time.LocalDate;

public class Acomodacao {
    private String tipo;
    private int quantidadeLeitos;
    private double precoBase;

    public Acomodacao(String tipo, int quantidadeLeitos, double precoBase) {
        this.tipo = tipo;
        this.quantidadeLeitos = quantidadeLeitos;
        this.precoBase = precoBase;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidadeLeitos() {
        return quantidadeLeitos;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public boolean estaDisponivel(LocalDate dataEstadia) {
        // Implementação fictícia para disponibilidade
        return true; // Para exemplo, sempre disponível
    }

    public void setReservado(boolean reservado) {
        boolean reservado1 = reservado;
    }

}
