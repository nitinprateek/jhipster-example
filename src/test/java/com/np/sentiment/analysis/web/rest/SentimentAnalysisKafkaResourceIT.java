package com.np.sentiment.analysis.web.rest;

import com.np.sentiment.analysis.SentimentAnalysisApp;
import com.np.sentiment.analysis.service.SentimentAnalysisKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = SentimentAnalysisApp.class)
public class SentimentAnalysisKafkaResourceIT {

    @Autowired
    private SentimentAnalysisKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        SentimentAnalysisKafkaResource kafkaResource = new SentimentAnalysisKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/sentiment-analysis-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
