package Menu;

import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.Hotel;
import ModeloDAO.ClienteDAO;
import ModeloDAO.FuncionarioDAO;
import ModeloDAO.HotelDAO;
import ModeloDAO.ReservaDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        HotelDAO hotelDAO = new HotelDAO();
        ReservaDAO reservaDAO = new ReservaDAO();

        try {
            while (true) {
                System.out.println("---------- MENU PRINCIPAL ----------");
                System.out.println("1. Criar Cliente");
                System.out.println("2. Criar Funcionario");
                System.out.println("3. Criar Hotel");
                System.out.println("4. Criar Reserva");
                System.out.println("5. Ler Clientes");
                System.out.println("6. Ler Funcionarios");
                System.out.println("7. Ler Hoteis");
                System.out.println("8. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        criarCliente(scanner, clienteDAO);
                        break;

                    case 2:
                        criarFuncionario(scanner, funcionarioDAO);
                        break;

                    case 3:
                        criarHotel(scanner, hotelDAO);
                        break;

                    case 4:
                        criarReserva(scanner, reservaDAO);
                        break;

                    case 5:
                        lerClientes(clienteDAO);
                        break;

                    case 6:
                        lerFuncionarios(funcionarioDAO);
                        break;

                    case 7:
                        lerHoteis(hotelDAO);
                        break;

                    case 8:
                        System.out.println("Saindo...");
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static void criarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.println("Criando novo cliente...");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        Cliente cliente = new Cliente(nome, email, telefone, senha);
        clienteDAO.criar(cliente);
        System.out.println("Cliente criado com sucesso.");
    }

    private static void criarFuncionario(Scanner scanner, FuncionarioDAO funcionarioDAO) {
        System.out.println("Criando novo funcionário...");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("senha: ");
        String senha = scanner.nextLine();
        System.out.print("cargo: ");
        String cargo = scanner.nextLine();
        Funcionario novofuncionario = new Funcionario( nome, email, telefone, senha, cargo);
        funcionarioDAO.criar(novofuncionario);
        System.out.println("Funcionário criado com sucesso.");
    }

    private static void criarHotel(Scanner scanner, HotelDAO hotelDAO) {
        System.out.println("Criando novo hotel...");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("localizacao: ");
        String localizacao = scanner.nextLine();
        Hotel hotel = new Hotel(nome, localizacao);
        hotelDAO.criar(hotel);
        System.out.println("Hotel criado com sucesso.");
    }

    private static void criarReserva(Scanner scanner, ReservaDAO reservaDAO) {
        System.out.println("Criando nova reserva...");

    }

    private static void lerClientes(ClienteDAO clienteDAO) {
        System.out.println("------ LISTA DE CLIENTES ------");
        List<Cliente> clientes = clienteDAO.lerClientes();
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("-----------------------------");
        }
    }

    private static void lerFuncionarios(FuncionarioDAO funcionarioDAO) {
        System.out.println("------ LISTA DE FUNCIONÁRIOS ------");
        List<Funcionario> funcionarios = funcionarioDAO.lerFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Email: " + funcionario.getEmail());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("-----------------------------");
        }
    }

    private static void lerHoteis(HotelDAO hotelDAO) {
        System.out.println("------ LISTA DE HOTÉIS ------");
        List<Hotel> hoteis = hotelDAO.lerHoteis();
        for (Hotel hotel : hoteis) {
            System.out.println("Nome: " + hotel.getNome());
            System.out.println("Endereço: " + hotel.getLocalizacao());
            System.out.println("-----------------------------");
        }
    }
}
