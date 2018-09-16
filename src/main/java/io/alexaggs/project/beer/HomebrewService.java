package io.alexaggs.project.beer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomebrewService {
	
	@Autowired
	HomebrewRepository topicRepository;
	
	public List<HomebrewBeer> getAllTopics() {
		List<HomebrewBeer> topics = new ArrayList<HomebrewBeer>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public HomebrewBeer getTopic(String id) {
		return topicRepository.findOne(id);
	}
	
	public void addTopic(HomebrewBeer topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(HomebrewBeer topic, String id) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.delete(getTopic(id));
	}
}
