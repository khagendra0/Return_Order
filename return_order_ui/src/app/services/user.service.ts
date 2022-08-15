import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }
  public authUser(user:any){
    return this.http.post(`${baseUrl}/auth`,user);
    

  }
  public loginUser(token:any){

    localStorage.setItem("token",token.token);
    localStorage.setItem("username",token.username);
    return true;
  }
 
  public isLoggedIn(){
    let tokenStr=localStorage.getItem("token");
    if(tokenStr==undefined||tokenStr==''||tokenStr==null){
      return false;
    }else{
      return true;
    }
  }
  public logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    return true;
  }
  public getToken(){
    return localStorage.getItem("token");
  }
  public SetUser(user:any){
    localStorage.setItem('user',JSON.stringify(user));

  }
  public getUser(){
    let userStr=localStorage.getItem("user");
    if(userStr!=null){
      return JSON.parse(userStr);
    }
      else{
        this.logout;
        return null;
      }
    
  }
  public getUsername(){
    return localStorage.getItem("username");
  }
}
