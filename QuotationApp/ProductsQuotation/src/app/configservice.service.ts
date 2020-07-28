

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ConfigserviceService {
  constructor(private http: HttpClient) { 
    
  }
  APIURL = "";
  getAPIDATA(data:any) {
    return this.http.get(this.APIURL+data);
  }
}