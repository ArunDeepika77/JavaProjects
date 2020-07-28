import { Component, OnInit } from '@angular/core';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import {Product} from '../model/product'
import { Router } from '@angular/router';
import { QuotationService } from '../services/quotation.service';
import { from } from 'rxjs';
import * as $ from 'jquery';

@Component({
  selector: 'app-form-view',
  templateUrl: './form-view.component.html',
  styleUrls: ['./form-view.component.css']
})
export class FormViewComponent implements OnInit {
  date : string;
  product : Product = new Product();
  submitted = false;
  recordCreated = false;
  constructor(private router : Router , private quotationService : QuotationService) {}

  ngOnInit(): void {}
  triggerChange(event: MatDatepickerInputEvent<Date>) {
    var date = new Date(event.value),
      mnth = ("0" + (date.getMonth() + 1)).slice(-2),
      day = ("0" + date.getDate()).slice(-2);
    //  alert(new Date(event.value));
   // alert( [date.getFullYear(), mnth, day].join("/"));
   
  }
  quotationLoad(dateChange){
    if(dateChange.value){
      this.quotationService.passDateValue(dateChange.value);
    }else{
      alert('Select a Valid Date');
    }
  };
  addProduct(){
this.submitted = false;
this.product = new Product();   
  }
  onSubmit() {
    this.recordCreated = false;
    this.save();    
    this.recordCreated = true;
  }
  save() {
    this.quotationService.addProduct(this.product)
      .subscribe(data => console.log(data), error => console.log(error));
      this.recordCreated = true;
    this.product = new Product();
  }
 
}
