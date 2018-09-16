package io.alexaggs.project.beer;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomebrewController {
	
	@Autowired
	private HomebrewService topService;

	@RequestMapping("/topics")
	public List<HomebrewBeer> getAllTopics() {
		return topService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public HomebrewBeer getTopic(@PathVariable String id) {
		return topService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody HomebrewBeer topic) {
		topService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody HomebrewBeer topic, @PathVariable String id) {
		topService.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topService.deleteTopic(id);
	}
}
