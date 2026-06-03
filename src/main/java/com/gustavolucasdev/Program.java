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
        System.out.println("Bem vindo ao cadastro de veículos!");
        do {
            System.out.println("1-Cadastrar, 2-Listar, 3-Buscar por placa, 4-Remover, 5-Sair");
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
        System.out.println("Informe a placa: ");
        String placa = sc.nextLine();
        System.out.println("Informe a marca: ");
        String marca = sc.nextLine();
        System.out.println("Informe o modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Informe o ano: ");
        int ano = sc.nextInt();
        Veiculos veiculo = new Veiculos(
                placa,
                marca,
                modelo,
                ano
        );
        service.cadastrar(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public static void listarVeiculos() {

        List<Veiculos> veiculos = service.listar();

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        for (Veiculos v : veiculos) {
            System.out.println(v);
        }
    }

    public static void buscarVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a placa:");
        String placa = sc.next();

        Veiculos veiculo = service.buscarPlaca(placa);

        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public static void removerVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a placa:");
        String placa = sc.next();

        boolean removido = service.removerPorPlaca(placa);

        if (removido) {
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

}