package br.com.relatorioPDF.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "tb_relatorio")
public class PdfFile implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_publicacao")
    private LocalDateTime data_publicacao;
    @Column(name = "data_sistema")
    private LocalDateTime data_sistema;
    @Column(name = "conteudo")
    private byte[] conteudo;

    public PdfFile() {
    }

    public PdfFile(Long id, LocalDateTime data_publicacao, LocalDateTime data_sistema, byte[] conteudo) {
        this.id = id;
        this.data_publicacao = data_publicacao;
        this.data_sistema = data_sistema;
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdfFile pdfFile = (PdfFile) o;
        return Objects.equals(id, pdfFile.id) && Objects.equals(data_publicacao, pdfFile.data_publicacao) && Objects.equals(data_sistema, pdfFile.data_sistema) && Arrays.equals(conteudo, pdfFile.conteudo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, data_publicacao, data_sistema);
        result = 31 * result + Arrays.hashCode(conteudo);
        return result;
    }

    @Override
    public String toString() {
        return "PdfFile{" +
                "id=" + id +
                ", data_publicacao=" + data_publicacao +
                ", data_sistema=" + data_sistema +
                ", conteudo=" + Arrays.toString(conteudo) +
                '}';
    }
}
