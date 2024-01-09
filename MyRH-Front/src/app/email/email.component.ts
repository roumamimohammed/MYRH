import {Component} from '@angular/core';
import {EmailService, PdfEmailRequest} from '../email.service';

@Component({
    selector: 'app-email',
    templateUrl: './email.component.html',
    styleUrls: ['./email.component.css'],
})
export class EmailComponent {
  file : any;
    emailRequest: PdfEmailRequest = {
        to: '',
        subject: '',
        text: '',
        pdfAttachment: '', // This will store the Base64 content of the PDF file
    };

    constructor(private emailService: EmailService) {}

    onFileChange(event: any) {
        this.file = event.target?.files?.[0];
    }


    async sendPdf() {
        if (this.file) {
            const reader = new FileReader();
            reader.onload = (e) => {
                // Set the Base64 content of the PDF file to emailRequest.pdfAttachment
                this.emailRequest.pdfAttachment = (e.target?.result as string).split(",")[1];
            };
            reader.readAsDataURL(this.file);
        }
        console.log(this.emailRequest.pdfAttachment)
        this.emailService.sendPdf(this.emailRequest).subscribe(
            (response) => {
                console.log('PDF email sent successfully:', response);
            },
            (error) => {
                console.error('Failed to send PDF email:', error);
            }
        );
    }
}
