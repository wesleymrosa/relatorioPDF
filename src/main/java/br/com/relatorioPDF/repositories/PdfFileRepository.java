package br.com.relatorioPDF.repositories;

import br.com.relatorioPDF.entities.PdfFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfFileRepository extends JpaRepository<PdfFile, Long> {
}
