import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { from } from 'rxjs';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'; 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService:UserService,private snack:MatSnackBar,private router:Router) { }
  public user={
    username: '',
    password: '',
  }

  ngOnInit(): void {
  }
  clear(loginForm:any){
    loginForm.reset();
  }
  formSubmit(){
    console.log(this.user);
    if(this.user.username=='' &&  this.user.password==''){
      this.snack.open('Cedentials are required','',{duration:5000});
      return;
    }

    if(this.user.username==''|| this.user.username==null){
      this.snack.open('Username is required','',{duration:3000});
      return;
    }
    if(this.user.password==''){
      this.snack.open('Password is required','',{duration:3000});
      return;
    }
    this.userService.authUser(this.user).subscribe(
      (data) =>{
        console.log(data);
        
        this.userService.loginUser(data);
        this.router.navigate(['cprocessing']);
        Swal.fire('Success','You are logged in','success');
      },
      (error)=>{
        console.log(error);
        this.snack.open('Something went wrong!','',{duration:3000});
      }
    )
  }

}
