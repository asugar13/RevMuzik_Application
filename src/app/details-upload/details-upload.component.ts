import { Component, OnInit, Input } from '@angular/core';
import { FileUpload } from '../classes/file-upload';

@Component({
  selector: 'app-details-upload',
  templateUrl: './details-upload.component.html',
  styleUrls: ['./details-upload.component.scss']
})
export class DetailsUploadComponent implements OnInit {

  @Input() fileUpload: FileUpload;

  constructor() { }

  ngOnInit() {
  }

}
