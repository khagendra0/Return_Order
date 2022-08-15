import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CprocessingComponent } from '../pages/cprocessing/cprocessing.component';
import componentUrl from './componentHelper';
import ProcessUrl from './processsHelper';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class ScomponentService {

  constructor(private http:HttpClient,private user:UserService) { }
    
  public getCharge(cprocessingForm:any){
    let compType=cprocessingForm.componentType;
    let count:number=cprocessingForm.quantity;
        return this.http.get(`${componentUrl}/packagingAndDelivery/getCharge/${compType}/${count}`);
  }
  public getAmount(amount:any){
    localStorage.setItem("charge",amount);
    return true;
  }
  public getDetails(cprocessingForm:any){
    return this.http.post(`${ProcessUrl}/ProcessDetails`,cprocessingForm,{headers: new HttpHeaders().set('Authorization',`Bearer ${(this.user.getToken())}`)}
    );
  }
  public getDelievery(details:any){
    localStorage.setItem("requestId",details.requestId);
    localStorage.setItem("processingCharge",details.processingCharge);
    localStorage.setItem("packageAndDelieveryCharge",details.packageAndDelieveryCharge);
    localStorage.setItem("dateOfDelievery",details.dateOfDelievery);
    return true;
  }
  public geRequestId(){
    return localStorage.getItem("requestId");
  }
  public geProcessingCharge(){
    return localStorage.getItem("processingCharge");
  }
  public getPackageAndDelieveryCharge(){
    return localStorage.getItem("packageAndDelieveryCharge");
  }
  public getDateOfDelievery(){
    return localStorage.getItem("dateOfDelievery");
  }
}
