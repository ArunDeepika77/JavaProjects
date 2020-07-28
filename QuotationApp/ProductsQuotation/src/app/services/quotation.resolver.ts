import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Quotation} from "../model/quotation";
import {Observable} from "rxjs";
import {QuotationService} from "./quotation.service";



@Injectable()
export class QuotationResolver implements Resolve<Quotation> {

    constructor(private quotationService:QuotationService) {

    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Quotation> {
        return this.quotationService.getQuotationListByDate(route.params['id']);
    }

}