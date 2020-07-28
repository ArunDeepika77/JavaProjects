import { Component, OnInit, QueryList, Input } from '@angular/core';
import { QuotationService } from '../services/quotation.service';
import {Quotation} from "../model/quotation";
import { Router, ActivatedRoute ,Params  } from '@angular/router';
import { FormViewComponent } from '../form-view/form-view.component';

@Component({
  selector: 'app-list-view',
  templateUrl: './list-view.component.html',
  styleUrls: ['./list-view.component.css']
})
export class ListViewComponent implements OnInit {
  quotationDateId:number = 0;
   dateValue: string;
   date : Date;
   
  public quotations: Array<Quotation>;
  constructor(private route: ActivatedRoute,private router: Router,private _quotationservice: QuotationService) { }



  ngOnInit() {
    this._quotationservice.currentDate.subscribe(dateValue => this.dateValue = dateValue);
    this.date = new Date(this.dateValue);
  this._quotationservice.getQuotationListBySelectedDate(this.date).subscribe(data => {
    this.quotations = data;
  });
  }
  onChange(quationDateValue) {
    this.quotationDateId = quationDateValue;
    var dateString;
    this._quotationservice.getQuotationListByDate(this.quotationDateId).subscribe(data => {
      this.quotations = data;
    });
}

}
