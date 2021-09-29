package com.example.springbootstarter.simpleapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// This is the annotation that we need to put on top of any class to make that a Rest controller.
public class TopicController {

    @Autowired
    private TopicService topicService;
    // here topicService is an object created for utilizing the service offered by the TopicService.
    // @Autowired is an annotation used to say "inject service to this class" to spring.


    @RequestMapping("/topics")
    // @GetMapping("/topics")
    // The /topics returns a list of objects of the type "topic". Spring MVC deals with the conversion
    // of list data into json.
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }


    @RequestMapping("/topics/{id}")
    //@GetMapping("/topic/{id}")
    // { } -- curly brackets are used here to specify the value after /topic/ is a variable, to get required topic. we
    // can give any name to that variable. But how we will give id/value got from url to getTopicById. This can be resolved
    // using the @PathVariable("nameOfVariableInjectedToMethod") annotation. "(...)" can be neglected if varName is same.
    public Optional<Topic> getTopicById (@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    //@PostMapping("/topics")
    public String addTopic(@RequestBody Topic topic){
        // Spring MVC will collect the data in the body of the incoming request which is in json format and will be converted
        // into an instance of Topic class, and saved into topic variable. This whole thing will be done by @RequestBody
        // annotation
        topicService.addTopic(topic);
        return "Topic added";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    // @PutMapping("/topics/{id}")
    public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic,id);
        return "Topic "+id+" updated";
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    // @DeleteMapping("/topics/{id}")
    public String deleteTopic( @PathVariable String id){
        topicService.deleteTopic(id);
        return "Topic "+id+" deleted";
    }
}
