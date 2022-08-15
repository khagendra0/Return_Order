import { FullscreenOverlayContainer } from '@angular/cdk/overlay';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConfirmRequestComponent } from './pages/confirm-request/confirm-request.component';
import { CprocessingComponent } from './pages/cprocessing/cprocessing.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SuccessComponent } from './pages/success/success.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full'

  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full',
  },
  {
    path:'cprocessing',
    component:CprocessingComponent,
    pathMatch:'full'
  },
  {
    path:'confirmRequest',
    component:ConfirmRequestComponent,
    pathMatch:'full'
  },
  {
    path:'success',
    component:SuccessComponent,
    pathMatch:'full'
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
