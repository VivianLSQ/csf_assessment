import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Article, Tag } from '../models';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ArticleService } from '../article.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  form!:FormGroup
  tags!: FormArray
  sub!: Subscription

  newTag: string ='';
  allTags: string [] = [];
  tagIdx: number = 1;

  @ViewChild('Upload')
  Upload!: ElementRef

  constructor(private fb: FormBuilder,
              private router: Router,
              private service: ArticleService){}

  ngOnInit(): void {
   this.form=this.createForm();
  }

  createForm(){
    return this.fb.group({
      //postDate: this.fb.control<string>(''),
      title: this.fb.control<string>('', [Validators.required, Validators.minLength(5)]),
      photo: this.fb.control<string>( '', [Validators.required]),
      description: this.fb.control<string>('', [Validators.required, Validators.minLength(5)]),
      tags: this.fb.control<string []>([])
    })
  }

  postNews(){
    const article: Article = this.form.value
    console.log(article)
    this.service.createArticle(article)
    this.service.upload(article['description'], this.Upload)
      .then(response =>{
        console.info('>>> response: ', response)
        alert("You have successfully posted {newsId: <_id>")
        this.router.navigate(['/main']) //navigate to View 0
      })
      .catch(error => {
        console.error('error: ', error)
        alert("You have failed to post an article. Please try again!")
        this.router.navigate(['/post']) //remain at View 2
      })
  }


  addTag(){
    this.allTags.push(this.newTag);
    //reset input
    this.newTag ='';

    // const tag: Tag = this.form.value
    // console.log(tag)
    // this.service.createTag(tag)
  }

  deleteTag(tagIdx: number){
    this.allTags.splice(tagIdx);
  }


  checkIfValid(): boolean {
    return this.form.invalid;
  }

}

