import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';
import 'rxjs/add/observable/of';
import { FileUpload } from '../classes/file-upload';

@Injectable()
export class UploadFileService {

  FOLDER = 'jsa-s3/';
  BUCKET = 'revmuzik-photo-upload-bucket';

  constructor() { }

  getS3Bucket(): any{
  	const bucket = new S3(
      {
        accessKeyId: 'AKIAJCL44LICHQZMEOBQ',
        secretAccessKey: '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',
        region: 'ca-central-1'
      }//https://s3.ca-central-1.amazonaws.com/revmuzik-photo-upload-bucket/jsa-s3/fat_person_doing_crunches.png
    );

    return bucket;
  }

  uploadfile(file) {
 
    const bucket = new S3(
      {
        accessKeyId: 'AKIAJCL44LICHQZMEOBQ',
        secretAccessKey: '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',
        region: 'us-east-1'
      }
    );
 
    const params = {
      Bucket: 'revmuzik-photo-upload-bucket',
      Key: this.FOLDER + file.name,
      Body: file,
      ACL: 'public-read'
    };
 
    this.getS3Bucket().upload(params, function (err, data) {
      if (err) {
        console.log('There was an error uploading your file: ', err);
        return false;
      }
 
      console.log('Successfully uploaded file.', data);
      return true;//experiment with returning 'data'
    });
  }

  //gets files in s3 bucket
  getFiles(): Observable<Array<FileUpload>>{
  	const fileUploads = new Array<FileUpload>();

  	const params = {
      Bucket: this.BUCKET,
      Prefix: this.FOLDER
    };

    this.getS3Bucket().listObjects(params, function(err, data){
    	if (err) {
			console.log('There was an error getting your files: ' + err);
			return;
		}

		console.log('Successfully got files.', data);

		const fileData = data.Contents;

		fileData.forEach((file) => {
			fileUploads.push(new FileUpload(file.Key, 'https://s3.ca-central-1.amazonaws.com/' + params.Bucket + '/' + file.Key));
		});
    });

    return Observable.of(fileUploads);
  }
}
