package com.co.iuvity.kafaka.producers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import static com.co.iuvity.kafaka.constan.Consntans.JSON_TOPIC;
import static com.co.iuvity.kafaka.constan.Consntans.JSON_PATH;

public class JsonProducer {

	public static void main(String[] args) {

		try (Producer<String, byte[]> producer = new KafkaProducer<>(getProperties());) {
			byte[] byteArrayJson = convertFileToByteArray(JSON_PATH);
			producer.send(new ProducerRecord<String, byte[]>(JSON_TOPIC, getTimestamp(), byteArrayJson));
		} catch (Exception e) {
			System.out.println("problems loading json file. " + e.getMessage());
		}

	}

	private static Properties getProperties() {

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("acks", "all");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
		return properties;

	}

	private static byte[] convertFileToByteArray(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		return Files.readAllBytes(path);
	}

	private static String getTimestamp() {
		String timestamps = new Timestamp(System.currentTimeMillis()).toString();
		return timestamps.replace(":", "_").substring(0, timestamps.indexOf("."));
	}

}
