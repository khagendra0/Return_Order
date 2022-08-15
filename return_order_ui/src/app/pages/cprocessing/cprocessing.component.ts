import { Component, OnInit } from '@angular/core';
import { ScomponentService } from 'src/app/services/scomponent.service';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-cprocessing',
  templateUrl: './cprocessing.component.html',
  styleUrls: ['./cprocessing.component.css']
})
export class CprocessingComponent implements OnInit {

  constructor(private userService:UserService,private scomponent:ScomponentService,private snack:MatSnackBar,private router:Router) { }
  

  ngOnInit(): void {
    if(this.userService.getUsername()==""||this.userService.getUsername()==''||this.userService.getUsername()==undefined){
      this.router.navigate(['login']);
      
    }
  }
  
  khaggu=this.userService.getUsername();
  paggu=this.userService.getToken();
  public cprocessingForm ={
    userName:'',
    contactNumber:'',
    isPriorityRequest:'true',
    componentType:'',
    componentName:'',
    quantity:''

  }
  clear(loginForm:any){
    loginForm.reset();
  }
  
  formSubmit(){
    console.log(this.cprocessingForm);
    this.scomponent.getCharge(this.cprocessingForm).subscribe(
      (data)=>{
        console.log(data);
        this.scomponent.getDetails(this.cprocessingForm).subscribe(
          (data)=>{
            console.log(data);
            this.scomponent.getDelievery(data);
            this.router.navigate(['confirmRequest']);
          },
          (error)=>{
            console.log(error);
            this.snack.open('Something went wrong!','',{duration:3000});
          }  
          )
    
        
      },
      (error)=>{
        console.log(error);
        this.snack.open('Something went wrong!','',{duration:3000});
      }  

    )
    
   
  }
  myfunc(){
    if(this.userService.getToken()==null||this.userService.getToken()==''||this.userService.getToken()==undefined){
      console.log('my func works');
      this.router.navigate(['login']);
      
    }

  }

}
