package com.fsb.gestion_restaurant.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyBean.class);

    @Override
    public void run(String... args) {
        logger.info("Application started");
        logger.debug("Debugging information");
        logger.warn("Warning message");
        logger.error("Error occurred");
    }
}
