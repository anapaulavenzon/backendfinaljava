package com.atividadefinaldemodulobackend.entities;

import java.util.Objects;

public class Recados {

    private Integer id;

    private String descricao;

    private String detalhamento;

    private String status;

    public Recados() {
    }

    public Recados(Integer id, String descricao, String detalhamento, String status) {
        this.id = id;
        this.descricao = descricao;
        this.detalhamento = detalhamento;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Recados{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", detalhamento='" + detalhamento + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recados)) return false;
        Recados recados = (Recados) o;
        return getId().equals(recados.getId()) && getDescricao().equals(recados.getDescricao()) && getDetalhamento().equals(recados.getDetalhamento()) && getStatus().equals(recados.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getDetalhamento(), getStatus());
    }
}
