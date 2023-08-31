package vttp2023.batch3.csf.assessment.cnserver.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2023.batch3.csf.assessment.cnserver.models.News;
import vttp2023.batch3.csf.assessment.cnserver.models.TagCount;
import vttp2023.batch3.csf.assessment.cnserver.repositories.ImageRepository;
import vttp2023.batch3.csf.assessment.cnserver.services.NewsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NewsController {

	@Autowired
	ImageRepository imgRepo; 
	NewsService service; 

	// TODO: Task 1
	@PostMapping(path="/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>createNewArticle(@RequestBody String payload){
		//Request Body is JsonDoc from FrontEnd
		//Logic to handle incoming Json data 

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject newsJson = reader.readObject();

        JsonObject success = Json.createObjectBuilder()
                .add("success", service.postNews(newsJson))
                .build();

        return ResponseEntity.ok(success.toString());

	}

	@PostMapping(path="/uploadPhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ModelAndView postUpload(@RequestPart String description
			, @RequestPart MultipartFile myfile) {

		ModelAndView mav = new ModelAndView();

		try {
			// String mediaType = myfile.getContentType();
			// InputStream is = myfile.getInputStream();

			//imgRepo.upload(description, mediaType, is);
			String id = imgRepo.saveImage(myfile);
			System.out.printf(">>> Saving Photo to S3 Bucket: %s\n", id);
		} catch (IOException ex) {
			mav.setStatus(HttpStatusCode.valueOf(500));
			mav.setViewName("error");
			mav.addObject("errorMsg", ex.getMessage());
			return mav;
		}

		mav.addObject("controlName", myfile.getName());
		mav.addObject("fileName", myfile.getOriginalFilename());
		mav.addObject("mediaType", myfile.getContentType());
		mav.addObject("size", myfile.getSize());
		mav.setViewName("upload");
		mav.setStatus(HttpStatusCode.valueOf(200));

		return mav;
	}


	// TODO: Task 2
	@GetMapping(path="/search")
	public List<News> getTop10Hashtags(TagCount count){
		List<News> getTop10Hashtag = new LinkedList<>(); 
	return List<News>();
	}

	// TODO: Task 3

}
