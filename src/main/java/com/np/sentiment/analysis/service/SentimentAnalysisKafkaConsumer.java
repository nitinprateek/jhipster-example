package com.np.sentiment.analysis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SentimentAnalysisKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(SentimentAnalysisKafkaConsumer.class);
    private static final String TOPIC = "topic_sentimentanalysis";

    @KafkaListener(topics = "topic_sentimentanalysis", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
