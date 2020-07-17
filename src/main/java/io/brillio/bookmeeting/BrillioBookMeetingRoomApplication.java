package io.brillio.bookmeeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author jghosh
 * Starting point of the Book Meeting Room Spring application
 */
@SpringBootApplication
@EnableSwagger2
public class BrillioBookMeetingRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrillioBookMeetingRoomApplication.class, args);
	}

}
