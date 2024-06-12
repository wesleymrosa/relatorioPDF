package br.com.relatorioPDF.service;

import br.com.relatorioPDF.entities.PdfFile;
import br.com.relatorioPDF.repositories.PdfFileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfFileService {
    private final PdfFileRepository pdfFileRepository;
    public PdfFileService(PdfFileRepository pdfFileRepository) {
        this.pdfFileRepository = pdfFileRepository;
    }
    public List<PdfFile> findAll() {
        return pdfFileRepository.findAll();
    }
    @Transactional
    public PdfFile save(PdfFile pdfFile) {
        return pdfFileRepository.save(pdfFile);
    }
}
