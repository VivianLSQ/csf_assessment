import { HttpClient } from '@angular/common/http';
import { ElementRef, Injectable } from '@angular/core';
import { Observable, firstValueFrom } from 'rxjs';
import { Article, Tag } from './models';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  apiURL:string = '/api/post'
  apiURLForAllNews: string ='/api/details'
  apiURLTags: string = '/api/display'
  apiURLMain: string = '/api/main'

  constructor(private http: HttpClient) { }

  createArticle(article: Article): Observable <any>{
    return this.http.post(this.apiURL, article)
  }

  getAllNewsOfTag(): Observable<any> {
    return this.http.get(this.apiURLForAllNews);
  }

  createTag(tag: Tag){
  }

  showTopTags(tag: Tag){
    return this.http.get(this.apiURLTags);
  }

  //To upload image
  upload(description: string, elemRef: ElementRef): Promise<any> {

    console.info('>>> File Uploaded: ', elemRef.nativeElement.files)

    const data = new FormData()
    data.set("description", description)
    data.set("myfile", elemRef.nativeElement.files[0])

    return firstValueFrom(
      this.http.post<any>('/upload', data)
    )
  }

}
