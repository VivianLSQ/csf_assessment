import { Article } from './../models';
import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-search',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

  activatedRoute = inject(ActivatedRoute);
  service = inject(ArticleService);
  searchSub$!: Subscription;
  query: string = '';
  searchResults: any[] = [];

  ngOnInit(): void {
     this.query = this.activatedRoute.snapshot.params['query'];

    //  this.searchSub$ = this.service.showTopTags(this.query).subscribe({
    //   next: (result) => { this.searchResults = result; },
    //   error: (error) => { console.log(error); },
    //   complete: () => { this.searchSub$.unsubscribe(); }
    //  });
  }
}
