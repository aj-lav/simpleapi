package com.example.springbootstarter.simpleapi.topic;

import org.springframework.data.repository.CrudRepository;

// This file deals with codes to access DB. Thanks to Spring, they already implemented a repository called CrudRepository
// that helps to make our code smaller. [ similar to what we did with TopicService.java]
// Usually we create methods like getTopic(id), getAllTopic(), updateTopic(id), deleteTopic(id) to deal things with DB.
//Thanks to CrudRepository, all these basic methods are already created.
// If we need some special operation like searching for id containing some special keywords, we need to implement our own
// methods, CrudRepository deals only the basic stuff. We need to tell the type information ie Topic ( What is the entity class we are
// working here), and String (id of the entity class)
public interface TopicDataRepo extends CrudRepository<Topic, String>  {
    // In order to do our crud operation  we need access to this interface from TopicService. This can be done by autowiring.
}
// In This application we are using Apache derby, it is an embedded database. When spring sees this in our dependency, it connects
// to derby. Therefore no initialization required. While using other DB we need to connect it first.