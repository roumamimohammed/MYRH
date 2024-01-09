// email.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmailService {
  private apiUrl = 'http://localhost:8080/api/postulations/send-pdf';

  constructor(private http: HttpClient) {}

  sendPdf(emailRequest: PdfEmailRequest): Observable<string> {
    return this.http.post<string>(this.apiUrl, emailRequest);
  }
}

export interface PdfEmailRequest {
  to: string;
  subject: string;
  text: string;
  pdfAttachment: string; // This should be a Base64-encoded string
}
