import { Injectable } from '@angular/core';
import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';

@Injectable()
export class UploadFileService {

  FOLDER = 'jsa-s3/';

  constructor() { }

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
      Body: file
    };
 
    bucket.upload(params, function (err, data) {
      if (err) {
        console.log('There was an error uploading your file: ', err);
        return false;
      }
 
      console.log('Successfully uploaded file.', data);
      return true;
    });
  }
}
