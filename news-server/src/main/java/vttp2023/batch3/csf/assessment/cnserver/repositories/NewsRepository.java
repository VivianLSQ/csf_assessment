package vttp2023.batch3.csf.assessment.cnserver.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import vttp2023.batch3.csf.assessment.cnserver.models.News;

@Repository
public class NewsRepository {

	@Autowired
	MongoTemplate mongoTemplate; 

	// TODO: Task 1 
	// Write the native Mongo query in the comment above the method

	//db.news.findOne(
    //    { _id: <id> }
    // )

	public void insertNewPost(News news) {
	}



	// TODO: Task 2 
	// Write the native Mongo query in the comment above the method
	
	/*
	 db.news.find()
	.sort({s:1, _id:-1})
	.limit(10);
	 */

	public List<News> getTop10NewsTags(){
		List<News> top10News = new LinkedList<>(); 

	}

	// TODO: Task 3
	// Write the native Mongo query in the comment above the method


}
