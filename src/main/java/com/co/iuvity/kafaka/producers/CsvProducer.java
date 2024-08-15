package com.co.iuvity.kafaka.producers;

import static com.co.iuvity.kafaka.constan.Consntans.CSV_TOPIC;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class CsvProducer {

	public void produceCsv(String key, String data) {
		try (Producer<String, String> producer = new KafkaProducer<>(getProperties());) {
			producer.send(new ProducerRecord<String, String>(CSV_TOPIC, key, data));
		}
	}

	private static Properties getProperties() {

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("acks", "all");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		return properties;

	}

}
