
export interface Article{
  postDate: string;
  title: string;
  photo: Blob;
  description: string;
  tag: string

}

export interface Tag{
  name: string;
  count: number;
}
