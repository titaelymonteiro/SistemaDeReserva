package Servicos;

import java.util.List;
import Modelo.Hotel;
import ModeloDAO.HotelDAO;

public class HotelS {
    static HotelDAO hotelDAO = new HotelDAO();

    public void criarHotel(String nome, String localizacao) {
        Hotel hotel = new Hotel(nome, localizacao);
        hotelDAO.criar(hotel);
    }

    public void lerHoteis() {
        List<Hotel> lista = hotelDAO.lerHoteis();
        for (Hotel hotel : lista) {
            System.out.println(hotel.getNome() + " - " + hotel.getLocalizacao());
        }
    }

    public void atualizarHotel(int id, String nome, String localizacao) {
        Hotel hotel = new Hotel(nome, localizacao);
        hotelDAO.atualizar(hotel, id);
    }

    public void removerHotel(int id) {
        hotelDAO.remover(id);
    }
}
