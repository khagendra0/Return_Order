import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  constructor(private user:UserService,private router:Router) { }

  ngOnInit(): void {
     if(this.user.getUsername()==""||this.user.getUsername()==''||this.user.getUsername()==undefined){
      this.router.navigate(['login']);
      
    }
  }
  out(){
    this.user.logout;
    return true;
  }
 

  }


