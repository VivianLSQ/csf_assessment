import { Article, Tag } from './../models';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent{

  durationArray: any[]= [5, 15, 30, 45, 60]
  tag!:string

  constructor(private router: Router){}

  // @ViewChild('showTopTags')
  // query!: ElementRef;

  // showTopTags(){
  //   const displayQuery = this.query.nativeElement.value;
  //   this.router.navigate(['/display/', displayQuery])
  // }


}

