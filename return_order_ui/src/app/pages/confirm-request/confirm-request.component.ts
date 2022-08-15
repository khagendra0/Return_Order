import { Component, OnInit } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Router } from '@angular/router';
import { ScomponentService } from 'src/app/services/scomponent.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'; 


@Component({
  selector: 'app-confirm-request',
  templateUrl: './confirm-request.component.html',
  styleUrls: ['./confirm-request.component.css']
})

export class ConfirmRequestComponent implements OnInit {

  constructor(private cp:ScomponentService,private user:UserService, private route:Router) { }

  ngOnInit(): void {
    if(this.user.getUsername()==""||this.user.getUsername()==''||this.user.getUsername()==undefined){
      this.route.navigate(['login']);
      
    }
    
  }
  requestId=this.cp.geRequestId();
  username=this.user.getUsername();
  date=this.cp.getDateOfDelievery();
  pAndDcharge=this.cp.getPackageAndDelieveryCharge();
  processingcharge=this.cp.geProcessingCharge();
  total:number=Number(this.pAndDcharge)+Number(this.processingcharge);

 
   proceed(){
    Swal.fire('Success','You request is created!','success');
    this.route.navigate(['success']);

  }
 

  }





