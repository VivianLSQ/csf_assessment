import { ArticleService } from '../article.service';
import { Article } from './../models';
import { Component, OnInit, inject } from '@angular/core';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit{

  service = inject(ArticleService);
  news: any[] = [];

  hashtagName!: string


  ngOnInit(): void {
    this.service.getAllNewsOfTag().subscribe((result) => {
      for (let index = 0; index < result.length; index++) {
        const news = result[index];
        this.news.push(news);
      }
    })
  }


}
