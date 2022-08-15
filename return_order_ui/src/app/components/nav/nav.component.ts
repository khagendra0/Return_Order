import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(private user:UserService,private route:Router) { }

  ngOnInit(): void {
  }
  out(){
    this.user.logout();
    this.route.navigate(['/login']);
    return true;
  }

}
