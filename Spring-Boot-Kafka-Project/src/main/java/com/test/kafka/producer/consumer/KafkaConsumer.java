package com.test.kafka.producer.consumer;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	

	// Consume All message from the Topic
//	@KafkaListener(groupId = "myGroup", topicPartitions = @TopicPartition(topic = "test01", partitionOffsets = {
//			@PartitionOffset(partition = "0", initialOffset = "0") }))
//	public void consume(String message) {
//		LOGGER.info(String.format("Message received -> %s", message));
//	}
	
	
	// Consume Live from the Topic
	@KafkaListener(topics ="test01", groupId = "myGroup" )
	public void consume(String message) {
		LOGGER.info(String.format("Message received -> %s", message));
	}

}
