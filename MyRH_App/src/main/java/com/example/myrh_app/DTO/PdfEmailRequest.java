package com.example.myrh_app.DTO;

import java.util.Base64;

public class PdfEmailRequest {
    private String to;
    private String subject;
    private String text;
    private byte[] pdfAttachment; // This field represents the PDF file as a byte array

    // Constructors, getters, and setters...

    public PdfEmailRequest() {
        // Default constructor
    }

    public PdfEmailRequest(String to, String subject, String text, byte[] pdfAttachment) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.pdfAttachment = pdfAttachment;
    }

    // Getters and setters...

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getPdfAttachment() {
        return pdfAttachment;
    }

    public void setPdfAttachment(byte[] pdfAttachment) {
        this.pdfAttachment = pdfAttachment;
    }

    public String getPdfBase64() {
        return Base64.getEncoder().encodeToString(pdfAttachment);
    }
}
