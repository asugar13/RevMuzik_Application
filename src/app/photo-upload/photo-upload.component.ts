import { Component, OnInit } from '@angular/core';
import { UploadFileService } from '../services/upload-file.service';

@Component({
  selector: 'photo-upload',
  templateUrl: './photo-upload.component.html',
  styleUrls: ['./photo-upload.component.scss']
})
export class PhotoUploadComponent implements OnInit {

  selectedFiles: FileList;

  constructor(private uploadService: UploadFileService) { }

  ngOnInit() {
  }

  upload() {
    const file = this.selectedFiles.item(0);
    this.uploadService.uploadfile(file);
  }
 
  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
}
