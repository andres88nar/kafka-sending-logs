package com.co.iuvity.kafaka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.co.iuvity.kafaka.service.JsonToCsvTrasformer;

import static com.co.iuvity.kafaka.constan.Consntans.JSON_TOPIC;

public class JsonConsumer {

	public static void main(String[] args) {

		try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getProperties());) {
			consumer.subscribe(Arrays.asList(JSON_TOPIC));
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
				records.forEach(record -> {					
					new JsonToCsvTrasformer().jsonToCsv(record.key(), record.value());
				});
			}
		}  
	}

	private static Properties getProperties() {

		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "devs4j-group");
		properties.setProperty("enable.auto.commit", "true");
		properties.setProperty("auto.commit.interval.ms", "1000");
		properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		return properties;
	}

}
