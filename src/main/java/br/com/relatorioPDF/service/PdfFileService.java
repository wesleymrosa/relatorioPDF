package br.com.relatorioPDF.service;

import br.com.relatorioPDF.entities.PdfFile;
import br.com.relatorioPDF.repositories.PdfFileRepository;
import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.*;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfFileService {

    public final String RELATORIOS = "classpath:jasper/relatorios";

    public final String ARQUIVOJRXML = "relatorio.jrxml";
    public  final Logger LOGGER = LoggerFactory.getLogger(PdfFileService.class);
    private final PdfFileRepository pdfFileRepository;
    public final String DESTINOPDF = "C:\\jasper-report\\";

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

    public void gerar(PdfFile pdfFile) throws FileNotFoundException {


        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", pdfFile.getId());
        parametros.put("data_publicacao", pdfFile.getData_publicacao());
        parametros.put("data_sistema", pdfFile.getData_sistema());
        parametros.put("conteudo", pdfFile.getConteudo());

        String pathAbsoluto = (String) getAbsolutPath();

        String folderDiretorio = getDiretorioSave("relatorios-salvos");
        try {
            JasperReport report = JasperCompileManager.compileReport(pathAbsoluto);
            LOGGER.info("report compilado: {} ", pathAbsoluto);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
            LOGGER.info("jasper print");
            JasperExportManager.exportReportToPdfFile(print,folderDiretorio);
            LOGGER.info("PDF EXPORTADO PARA: {}", folderDiretorio );

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private String getDiretorioSave(String name) {
        this.createDiretorio(name);
        return DESTINOPDF+name.concat(".pdf");
    }

    private void createDiretorio(String name) {
        File dir = new File(name);
        if (!dir.exists()){
            dir.mkdir();
        }
    }

    private Object getAbsolutPath() throws FileNotFoundException {
        return ResourceUtils.getFile(RELATORIOS+ARQUIVOJRXML).getAbsolutePath();
    }
}
