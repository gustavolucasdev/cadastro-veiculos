package com.gustavolucasdev.services;

import com.gustavolucasdev.entities.Veiculos;
import com.gustavolucasdev.repositories.VeiculoRepository;

import java.util.List;

public class VeiculoService {

    VeiculoRepository repository = new VeiculoRepository();

    public void cadastrar(Veiculos veiculo) {
        repository.salvar(veiculo);
    }
    public List<Veiculos> listar(){
        return repository.listar();
    }

    public Veiculos buscarPlaca(String placa) {
        return repository.buscarPlaca(placa);
    }
    public boolean removerPorPlaca(String placa) {
        return repository.removerPorPlaca(placa);
    }
}
