package com.gustavolucasdev.repositories;

import com.gustavolucasdev.entities.Veiculos;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository {

    private List<Veiculos> veiculos = new ArrayList<>();

    public void salvar(Veiculos veiculo) {
        veiculos.add(veiculo);
    }

    public List<Veiculos> listar() {
        return veiculos;
    }

    public Veiculos buscarPlaca(String placa) {

        for (Veiculos v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }

        return null;
    }

    public boolean removerPorPlaca(String placa) {
        return veiculos.removeIf(
                veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)
        );
    }
}
