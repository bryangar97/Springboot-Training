package com.deloitte.training;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TrainingApplicationTests {

    Logger log = LoggerFactory.getLogger(TrainingApplicationTests.class);

    @Test
    void contextLoads() {
        assertThat(1).isEqualTo( (2 - 1));
    }

}
