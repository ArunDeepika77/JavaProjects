import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule,routingmodules } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuotationService} from'./services/quotation.service';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {QuotationResolver} from './services/quotation.resolver';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    routingmodules
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    BrowserAnimationsModule,ReactiveFormsModule,FormsModule
    

  ],
  providers: [QuotationService,QuotationResolver],
  bootstrap: [AppComponent]
})
export class AppModule { }
