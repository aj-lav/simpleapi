package com.example.springbootstarter.simpleapi.topic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TopicServiceTest {

    private TopicService topicServiceUnderTest;
    @Mock private TopicDataRepo topicDataRepo;

    @BeforeEach
    void setUp() {
        // This gives a new instance of service for each testing.
        topicServiceUnderTest = new TopicService(topicDataRepo);
    }

    @Test
    void canGetAllTopics() {
        // Just verify correct method is invoked
        // when
        topicServiceUnderTest.getAllTopics();
        // then
        verify(topicDataRepo).findAll();
    }

    @Test
    void canGetTopic() {
        //given
        String id = "Java";
        Topic topicToTest = new Topic(
                id,
                "Java",
                "A wide description about Java."
        );
        // when
        topicServiceUnderTest.addTopic(topicToTest);
        topicServiceUnderTest.getTopic(id);
        // then
        ArgumentCaptor<String> idArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(topicDataRepo).findById(idArgumentCaptor.capture());
        String capturedValueOfId = idArgumentCaptor.getValue();
        assertThat(capturedValueOfId).isEqualTo(id);
    }

    @Test
    void canAddTopic() {
        // given
        Topic topicToTest = new Topic(
                "Java",
                "Java",
                "A wide description about Java."
        );
        // when
        topicServiceUnderTest.addTopic(topicToTest);

        // then
        // verifying whther correct method is invoked and the input we gave is also correct.
        ArgumentCaptor<Topic> topicArgumentCaptor = ArgumentCaptor.forClass(Topic.class);
        verify(topicDataRepo).save(topicArgumentCaptor.capture());
        Topic capturedValueOfTopic = topicArgumentCaptor.getValue();
        assertThat(capturedValueOfTopic).isEqualTo(topicToTest);
    }

    @Test
    void caUpdateTopic() {
        // given
        String id = "Java";
        Topic topicToTest = new Topic(
                id,
                "Java",
                "A wide description about Java."
        );
        // when
        topicServiceUnderTest.updateTopic(topicToTest, id);
        // then
        ArgumentCaptor<Topic> topicArgumentCaptor = ArgumentCaptor.forClass(Topic.class);
        verify(topicDataRepo).save(topicArgumentCaptor.capture());
        Topic capturedValueOfTopic = topicArgumentCaptor.getValue();
        assertThat(capturedValueOfTopic).isEqualTo(topicToTest);

    }

    @Test
    void deleteTopic() {
        //given
        String id = "Java";
        // when
        topicServiceUnderTest.deleteTopic(id);
        // then
        ArgumentCaptor<String> idArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(topicDataRepo).deleteById(idArgumentCaptor.capture());
        String capturedValueOfId = idArgumentCaptor.getValue();
        assertThat(capturedValueOfId).isEqualTo(id);
    }
}