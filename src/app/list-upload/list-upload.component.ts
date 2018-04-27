import { Component, OnInit } from '@angular/core';
import { UploadFileService } from '../services/upload-file.service';
import { Observable } from 'rxjs/Observable';
import { FileUpload } from '../classes/file-upload';

@Component({
  selector: 'app-list-upload',
  templateUrl: './list-upload.component.html',
  styleUrls: ['./list-upload.component.scss']
})
export class ListUploadComponent implements OnInit {

  showFile : boolean = false;
  fileUploads: Observable<Array<FileUpload>>;

  constructor(private uploadSvc: UploadFileService) { }

  ngOnInit() {
  }

  showFiles(enable: boolean) {
    this.showFile = enable;
 
    if (enable) {
      this.fileUploads = this.uploadSvc.getFiles();
    }
  }

}
