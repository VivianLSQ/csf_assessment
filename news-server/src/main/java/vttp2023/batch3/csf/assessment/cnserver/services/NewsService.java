package vttp2023.batch3.csf.assessment.cnserver.services;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;
import vttp2023.batch3.csf.assessment.cnserver.models.News;
import vttp2023.batch3.csf.assessment.cnserver.models.TagCount;
import vttp2023.batch3.csf.assessment.cnserver.repositories.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepo; 
	
	// TO-DO: Task 1
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns the news id

	public String postNews(JsonObject newsJson) {
		String newsId = UUID.randomUUID().toString().substring(0, 8);

        News news = new News(newsId, newsJson.getString("title"), newsJson.getString("photo"),
                                newsJson.getString("description"), newsJson.getString("description"));

    	try {
			newsRepo.insertNewPost(news);
		} catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }

        return newsId;
	}
	 
	// TO-DO: Task 2
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns a list of tags and their associated count
	public List<TagCount> getTags(/* Any number of parameters */) {
		return new LinkedList<>();
	}

	// TO-DO: Task 3
	// Do not change the method name and the return type
	// You may add any number of parameters
	// Returns a list of news
	public List<News> getNewsByTag(/* Any number of parameters */) {
		return new LinkedList<>();
	}
	
}
