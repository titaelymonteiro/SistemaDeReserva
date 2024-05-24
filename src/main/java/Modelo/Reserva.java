package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private int idReserva;
    private Cliente idCliente;
    private static Hotel idHotel;
    private List<Acomodacao> acomodacoes;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private double valorTotal;

    public Reserva(int idReserva, Cliente idcliente, Hotel idhotel, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.idReserva = idReserva;
        this.idCliente = idcliente;
        this.idHotel = idhotel;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.acomodacoes = new ArrayList<>();
        this.valorTotal = calcularValorTotal();
    }

    public Reserva(int idCliente, int idHotel, String dataCheckIn, String dataCheckOut) {
        // Convertendo strings para objetos LocalDate
        this.dataCheckIn = LocalDate.parse(dataCheckIn);
        this.dataCheckOut = LocalDate.parse(dataCheckOut);
        this.acomodacoes = new ArrayList<>();
        this.valorTotal = calcularValorTotal();
    }



    public Cliente getCliente() {return idCliente;}

    public  Hotel getHotel() {return idHotel;}

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    private double calcularValorTotal() {
        double total = 0;
        long dias = dataCheckOut.toEpochDay() - dataCheckIn.toEpochDay();
        for (Acomodacao acomodacao : acomodacoes) {
            total += acomodacao.getPrecoBase() * dias;
        }
        return total;
    }

    public void listarAcomodacoes() {
        if (acomodacoes.isEmpty()) {
            System.out.println("Não há acomodações na reserva.");
        } else {
            System.out.println("------ ACOMODAÇÕES DA RESERVA ------");
            for (Acomodacao acomodacao : acomodacoes) {
                System.out.println("Tipo: " + acomodacao.getTipo() + ", Leitos: " + acomodacao.getQuantidadeLeitos() + ", Preço: " + acomodacao.getPrecoBase());
            }
            System.out.println("------------------------------------");
        }
    }

}
