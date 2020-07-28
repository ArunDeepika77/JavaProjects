import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {Observable, BehaviorSubject, of} from "rxjs";
import {Quotation} from "../model/quotation";
import {catchError, finalize} from "rxjs/operators";



export class QuotationDataSource implements DataSource<Quotation> {

    private quotationSubject = new BehaviorSubject<Quotation[]>([]);

    private loadingQuotation = new BehaviorSubject<boolean>(false);

    public loading$ = this.loadingQuotation.asObservable();

    constructor() {

    }

    loadQuotation(quotationDate:number,
                filter:string,
                sortDirection:string,
                pageIndex:number,
                pageSize:number) {

        this.loadingQuotation.next(true);

    }

    connect(collectionViewer: CollectionViewer): Observable<Quotation[]> {
        console.log("Connecting data source");
        return this.quotationSubject.asObservable();
    }

    disconnect(collectionViewer: CollectionViewer): void {
        this.quotationSubject.complete();
        this.loadingQuotation.complete();
    }

}