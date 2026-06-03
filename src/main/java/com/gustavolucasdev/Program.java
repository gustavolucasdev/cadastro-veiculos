package com.gustavolucasdev;

import com.gustavolucasdev.entities.Veiculos;
import com.gustavolucasdev.repositories.VeiculoRepository;
import com.gustavolucasdev.services.VeiculoService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Program {

    static VeiculoService service = new VeiculoService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcao;
        System.out.println("================================================================");
        System.out.println("|              Bem vindo ao cadastro de veículos!              |");
        System.out.println("================================================================");
        do {
            System.out.println("                    O que você deseja fazer?                    ");
            System.out.println("1-Cadastrar, 2-Listar, 3-Buscar por placa, 4-Remover, 5-Sair");
            System.out.print("Insira aqui: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    buscarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opcao != 5);
        sc.close();
    }

    public static void cadastrarVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================================");
        System.out.println("                Área de cadastramento de veículos               ");
        System.out.print("Informe a placa: ");
        String placa = sc.nextLine();
        System.out.print("Informe a marca: ");
        String marca = sc.nextLine();
        System.out.print("Informe o modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Informe o ano: ");
        int ano = sc.nextInt();
        Veiculos veiculo = new Veiculos(
                placa,
                marca,
                modelo,
                ano
        );
        service.cadastrar(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        System.out.println("================================================================");
        System.out.println();
    }

    public static void listarVeiculos() {

        List<Veiculos> veiculos = service.listar();
        System.out.println("===============================================================================");
        System.out.println("                    Área de listagem de veículos cadastrados                   ");
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            System.out.println("===============================================================================");
            System.out.println();
            return;
        }

        for (Veiculos v : veiculos) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println(v);
            System.out.println("-------------------------------------------------------------------------------");
        }
        System.out.println("===============================================================================");
        System.out.println();
    }

    public static void buscarVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================================");
        System.out.println("               Área de busca de veículo por placa               ");
        System.out.print("Informe a placa: ");
        String placa = sc.next();

        Veiculos veiculo = service.buscarPlaca(placa);

        if (veiculo != null) {
            System.out.println(veiculo);
            System.out.println("================================================================");
        } else {
            System.out.println("Veículo não encontrado.");
            System.out.println("================================================================");
        }
        System.out.println();
    }

    public static void removerVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================================");
        System.out.println("             Área de remoção de veículos cadastrados            ");
        System.out.print("Informe a placa: ");
        String placa = sc.next();

        boolean removido = service.removerPorPlaca(placa);

        if (removido) {
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
        System.out.println("================================================================");
        System.out.println();
    }

}