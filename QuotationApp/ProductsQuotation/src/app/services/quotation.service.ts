import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable, BehaviorSubject} from "rxjs";
import {Quotation} from "../model/quotation";
import { Product } from '../model/product';



@Injectable()
export class QuotationService {

  private dateValue = new BehaviorSubject('');
  currentDate = this.dateValue.asObservable();

  private baseUrl = 'http://localhost:8080/quotation/product/quotation/getQuotationListByDate';
  private onLoadUrl = 'http://localhost:8080/quotation/product/quotation/getQuotationListBySelectedDate';
  
  private addProductUrl = 'http://localhost:8080/quotation/product/quotation/addProduct';
    constructor(private http:HttpClient) {

    }

    getQuotationListByDate(quotationDateId: number): Observable<any> {
      return this.http.get<Quotation>(`${this.baseUrl}/${quotationDateId}`);
    }

    passDateValue(date : string){
      this.dateValue.next(date);
    }
    getQuotationListBySelectedDate(dateValue : Date): Observable<any>{
      return this.http.get<Quotation>(`${this.onLoadUrl}/${dateValue}`);
    }
    addProduct(product : Object): Observable<any>{
      return this.http.post(`${this.addProductUrl}`,product);
    }
}