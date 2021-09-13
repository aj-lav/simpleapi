package com.example.springbootstarter.simpleapi.topic;
// This class deals with the business Logic of the application. When the application starts spring create
// an instance of this service( specified by this class) and keep/registers in its memory. Later other
// classes depends on this class will ask for this service.At that time, this will be injected to them.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    /*// Here contents of the topics are Hard coded. Usually these are taking from the database.
    // We are not using the below block of code, instead we use DB.
    private final List<Topic> topics = new ArrayList<>( Arrays.asList(
            new Topic("code","Clean Code","Reads this in order to create better code"),
            new Topic("cs","computer science","A textbook for cs students"),
            new Topic("python","Learn python, the Hard way","Book to learn python")
    ));
    // Arrays.asList create an immutable of elements. In order to update topic list that should be a mutable
*/ //
    // we are replacing this with new codes ie with DB.
    /*public List<Topic> getAllTopics() {
        // It is a getter to access the values from the outside of this class.
        return topics;
    }*/

    public List<Topic> getAllTopics() {
        // findAll gets all instances from DB. But it is an iterable so we need to convert it into List.
        List<Topic> topics = new ArrayList<>();
        topicDataRepo.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
        return topicDataRepo.findById(id);
    }
    /*public Topic getTopic (String id){
        // It returns a single topic
        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }*/

    // Using code for accessing data from DB.
    /*// Adds a single topic
    public void addTopic(Topic topic){
        topics.add(topic);
    }*/
    public void addTopic(Topic topic) {
        topicDataRepo.save(topic);
    }

    public void updateTopic(Topic topic, String id){
        topicDataRepo.save(topic);
        // save method works for both update and insertion operation. If an instance already exists in DB with same key,
        // it updates that instance or insert a new instance.
    }
    /*// It updates a topic specified by the id.
    public void updateTopic(Topic topic, String id){
        for (int i = 0;i < topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i,topic);
            }
        }
    }*/

    public void deleteTopic(String id){
        topicDataRepo.deleteById(id);
    }
    /*public void deleteTopic(String id){
        topics.removeIf(topic -> topic.getId().equals(id));
//        for (int i = 0;i < topics.size(); i++){
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.remove(i);
//            }
//        }
    }*/
}
