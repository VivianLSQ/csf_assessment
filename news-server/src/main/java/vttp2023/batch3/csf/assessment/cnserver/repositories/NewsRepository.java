package vttp2023.batch3.csf.assessment.cnserver.repositories;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp2023.batch3.csf.assessment.cnserver.models.News;
import vttp2023.batch3.csf.assessment.cnserver.models.TagCount;
import vttp2023.batch3.csf.assessment.cnserver.models.Tags;

@Repository
public class NewsRepository {

	@Autowired
	MongoTemplate mongoTemplate; 

	// TO-DO: Task 1 
	// Write the native Mongo query in the comment above the method

	//db.news.findOne(
    //    { _id: <id> }
    // )
	public Document getPostById(String newsId){
		return mongoTemplate.findOne(
                Query.query(Criteria.where(newsId).is(newsId)),
                Document.class,
                "news"
        );
	}

	public void insertNewPost(News news) {
		
	}


	// TO-DO: Task 2 
	// Write the native Mongo query in the comment above the method
	
	 /*
	  db.news.aggregate(
		[	{
				$project: { 
					name: 1, 
					count: 1
				}
			},
			{
				$sort: { count: -1 }
				$sort: { name: 1 }
			},
			{
				$limit: 10
			}
		])
	  */

	public List<TagCount> getTop10NewsTags(){
		ProjectionOperation projectTagSummary= Aggregation.project("name", "count");

		SortOperation sortByTagCount= Aggregation.sort(
			Sort.by(Direction.DESC, “count”));

		SortOperation sortByTagName= Aggregation.sort(
			Sort.by(Direction.ASC, “name”));

		LimitOperation getTop10Only = Aggregation.limit(longLimit); 

		Aggregation pipeline= Aggregation.newAggregation(projectTagSummary, sortByTagCount);

		AggregationResults<Document> results= mongoTemplate.aggregate(
		pipeline, “news”, Document.class);

	}

	// TO-DO: Task 3
	// Write the native Mongo query in the comment above the method


}
