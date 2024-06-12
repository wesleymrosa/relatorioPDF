package br.com.relatorioPDF.controller;

import br.com.relatorioPDF.dtos.PdfFileDto;
import br.com.relatorioPDF.entities.PdfFile;
import br.com.relatorioPDF.service.PdfFileService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping(value = "/pdf")
public class PdfFileController {
    private final PdfFileService pdfFileService;

    public PdfFileController(PdfFileService pdfFileService) {
        this.pdfFileService = pdfFileService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PdfFileDto pdfFileDto) {
        PdfFile pdfFile = new PdfFile();
        BeanUtils.copyProperties(pdfFileDto, pdfFile);
        pdfFile.setData_sistema(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.ok().body(pdfFileService.save(pdfFile));
    }


    @GetMapping
    public ResponseEntity<List<PdfFile>> findAll() {

        return ResponseEntity.ok().body(pdfFileService.findAll());
    }
}

