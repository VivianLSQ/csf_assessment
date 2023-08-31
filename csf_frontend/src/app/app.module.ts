import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { MainComponent } from './components/main.component';
import { PostComponent } from './components/post.component';
import { DisplayComponent } from './components/display.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ArticleService } from './article.service';
import { DetailsComponent } from './components/details.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    PostComponent,
    DisplayComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [ArticleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
