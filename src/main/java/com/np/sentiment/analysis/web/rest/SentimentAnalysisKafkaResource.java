package com.np.sentiment.analysis.web.rest;

import com.np.sentiment.analysis.service.SentimentAnalysisKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sentiment-analysis-kafka")
public class SentimentAnalysisKafkaResource {

    private final Logger log = LoggerFactory.getLogger(SentimentAnalysisKafkaResource.class);

    private SentimentAnalysisKafkaProducer kafkaProducer;

    public SentimentAnalysisKafkaResource(SentimentAnalysisKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
