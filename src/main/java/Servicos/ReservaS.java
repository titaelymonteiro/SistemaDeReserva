package Servicos;

import Modelo.Cliente;
import Modelo.Hotel;
import Modelo.Reserva;
import ModeloDAO.ReservaDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReservaS {
    static ReservaDAO reservaDAO = new ReservaDAO();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void criarReserva(int idCliente, int idHotel, String dataCheckIn, String dataCheckOut, double valorTotal) {
        LocalDate checkInDate = LocalDate.parse(dataCheckIn, formatter);
        LocalDate checkOutDate = LocalDate.parse(dataCheckOut, formatter);
        Reserva reserva = new Reserva(idCliente, idHotel, checkInDate, checkOutDate);
        reserva.setValorTotal(valorTotal);
        reservaDAO.criar(reserva);
    }

    public void lerReservas() {
        try {
            List<Reserva> lista = reservaDAO.lerReservas();
            for (Reserva reserva : lista) {
                System.out.println("Cliente: " + reserva.getCliente().getNome() +
                        " - Hotel: " + reserva.getHotel().getNome() +
                        " - Check-in: " + reserva.getDataCheckIn() +
                        " - Check-out: " + reserva.getDataCheckOut() +
                        " - Valor Total: " + reserva.getValorTotal());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ler reservas: " + e.getMessage());
        }
    }

    public void atualizarReserva(int id, int idCliente, int idHotel, String dataCheckIn, String dataCheckOut, double valorTotal) {
        LocalDate checkInDate = LocalDate.parse(dataCheckIn, formatter);
        LocalDate checkOutDate = LocalDate.parse(dataCheckOut, formatter);
        Reserva reserva = new Reserva(id, idCliente, idHotel, checkInDate, checkOutDate);
        reserva.setValorTotal(valorTotal);
        reservaDAO.atualizar(reserva, id);
    }

    public void removerReserva(int id) {
        reservaDAO.remover(id);
    }
}
