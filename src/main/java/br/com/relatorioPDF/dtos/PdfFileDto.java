package br.com.relatorioPDF.dtos;

import br.com.relatorioPDF.entities.PdfFile;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PdfFileDto implements Serializable {
    private static final Long serialVersionUID = 1L;
    private LocalDateTime data_publicacao;
    private LocalDateTime data_sistema;
    private byte[] conteudo;
    public PdfFileDto() {
    }
    public PdfFileDto(PdfFile obj) {
        this.data_publicacao = obj.getData_publicacao();
        this.data_sistema = obj.getData_sistema();
        this.conteudo = obj.getConteudo();
    }

    public LocalDateTime getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(LocalDateTime data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public LocalDateTime getData_sistema() {
        return data_sistema;
    }

    public void setData_sistema(LocalDateTime data_sistema) {
        this.data_sistema = data_sistema;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }
}
