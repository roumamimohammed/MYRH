package com.example.myrh_app.Controllers;

import com.example.myrh_app.DTO.PdfEmailRequest;
import com.example.myrh_app.DTO.PostulationDTO;
import com.example.myrh_app.Implementation.Email;
import com.example.myrh_app.Implementation.Postulation;
import com.example.myrh_app.Services.PostulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/postulations")
public class PostulationController {

    private final Postulation postulationService;

    @Autowired
    private Email emailService;
    @Autowired
    public PostulationController(Postulation postulationService) {
        this.postulationService = postulationService;
    }

    @PostMapping("/add")
    public void addPostulation(@RequestBody PostulationDTO postulationDTO) {
        postulationService.addPostulation(postulationDTO);
    }

    @PostMapping("/send-pdf")
    public ResponseEntity<String> sendPdf(@RequestBody PdfEmailRequest pdfEmailRequest) {
        try {
            String to = pdfEmailRequest.getTo();
            String subject = pdfEmailRequest.getSubject();
            byte[] pdfBytes = Base64.getDecoder().decode(pdfEmailRequest.getPdfBase64());

            emailService.sendPdf(to, subject, pdfBytes);

            return ResponseEntity.ok("PDF email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to send PDF email.");
        }
    }
}
