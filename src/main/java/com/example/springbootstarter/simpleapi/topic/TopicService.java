package com.example.springbootstarter.simpleapi.topic;
// This class deals with the business Logic of the application. When the application starts spring create
// an instance of this service( specified by this class) and keep/registers in its memory. Later other
// classes depends on this class will ask for this service.At that time, this will be injected to them.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
// The way we tell the spring that this class is for the service purpose is, by using the @Service
// annotation.
// Later some other class will call this service, by creating private object of this service class.
// Add @Autowired to private object created, to inject this service to that class.
public class TopicService {

    @Autowired
    // A new member variable to access the TopicDataRepo from here.
    private TopicDataRepo topicDataRepo;



    public List<Topic> getAllTopics() {
        // findAll gets all instances from DB. But it is an iterable so we need to convert it into List.
        List<Topic> topics = new ArrayList<>();
        topicDataRepo.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
        return topicDataRepo.findById(id);
    }

    public void addTopic(Topic topic) {
        topicDataRepo.save(topic);
    }

    public void updateTopic(Topic topic, String id){
        topicDataRepo.save(topic);
        // save method works for both update and insertion operation. If an instance already exists in DB with same key,
        // it updates that instance or insert a new instance.
    }


    public void deleteTopic(String id){
        topicDataRepo.deleteById(id);
    }

}
