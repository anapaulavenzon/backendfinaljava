package com.atividadefinaldemodulobackend.service;

import com.atividadefinaldemodulobackend.entities.Recados;
import com.atividadefinaldemodulobackend.exeception.ExcecaoDePaginaNaoEncontrada;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RecadosService {

    private List<Recados> bdRecados = new ArrayList<>();

    private Integer id = 0;
    public Recados salvarRecados(Recados recado){

        recado.setId(++id);
        bdRecados.add(recado);
        return recado;
    }

    public List<Recados> listarRecados(){
        return bdRecados;
    }

    public Recados buscarRecadosId(Integer id){

        Recados recadoAchado = new Recados();

        for (Recados recado: bdRecados) {
            if(recado.getId().equals(id)){
                recadoAchado = recado;
            }
        }

        if(Objects.isNull(recadoAchado.getId()) || Objects.isNull(recadoAchado.getDescricao()) || Objects.isNull(recadoAchado.getDetalhamento())){

            throw new ExcecaoDePaginaNaoEncontrada("Registro não encontrado");
        }else{
            return recadoAchado;
        }
    }

    public void removerRecados(Integer id){

        bdRecados.removeIf(recado -> recado.getId().equals(id));

        List<Recados> recado = new ArrayList<>();

        for (Recados r : bdRecados) {
            if(r.getId().equals(id)){
                recado.add(r);
            }
        }
        bdRecados.removeAll(recado);
    }

    public Recados atualizarRecados(Integer id, Recados recado){

        Recados recadoAtualizado = new Recados();

        for (Recados recadoAtual: bdRecados) {
            if(recadoAtual.getId().equals(id)){
                recadoAtual.setDescricao(recado.getDescricao());
                recadoAtual.setDetalhamento(recado.getDetalhamento());
                recadoAtual.setStatus(recado.getStatus());
                recadoAtualizado = recadoAtual;
            }
        }

        return recadoAtualizado;
    }

    public List<Recados> BuscarRecado(String busca, String operacao){

        List<Recados> recadosAchados = new ArrayList<>();

        if(operacao.equals("descricao")){
            for (Recados recado: bdRecados) {

                if(recado.getDescricao().contains(busca)){
                    recadosAchados.add(recado);
                }

            }
        }else if(operacao.equals("detalhamento")){
            for (Recados recado: bdRecados) {
                if(recado.getDetalhamento().contains(busca)){
                    recadosAchados.add(recado);
                }
            }

        }else if(operacao.equals("status")){
            for (Recados recado: bdRecados) {
                String statusRecado = recado.getStatus().toLowerCase();

                if( statusRecado.contains(busca) && busca.equals("concluido")){
                    recadosAchados.add(recado);
                } else if(statusRecado.contains(busca) && busca.equals("pendente")){
                    recadosAchados.add(recado);
                }
                else if(statusRecado.contains(busca) && busca.equals("cancelado")){
                    recadosAchados.add(recado);
                }
            }
        }
        return recadosAchados;
    }
}
