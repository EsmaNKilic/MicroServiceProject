package com.kodlama.rentalService.configurations.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class KafkaTopicConfiguration {

	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	@Bean
	public NewTopic topic() {
		return TopicBuilder.name(topicName).build();
	}

}
