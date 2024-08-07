package com.example.topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

	@Bean
	public NewTopic userTopic() {
		return TopicBuilder.name("user")
				.build();
	}
}
