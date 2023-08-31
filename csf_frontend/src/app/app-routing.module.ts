import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './components/main.component';
import { PostComponent } from './components/post.component';
import { DisplayComponent } from './components/display.component';

const routes: Routes = [
  {path: '', component: MainComponent, title: 'Top 10 News Hashtags'},
  {path: 'display/:query', component: DisplayComponent},
  {path: 'post/:id', component: PostComponent},
  {path: '**', redirectTo: '/', pathMatch: 'prefix'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
