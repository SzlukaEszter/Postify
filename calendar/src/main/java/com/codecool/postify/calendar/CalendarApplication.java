package com.codecool.postify.calendar;

import com.codecool.postify.calendar.model.Channel;
import com.codecool.postify.calendar.model.Event;
import com.codecool.postify.calendar.model.Week;
import com.codecool.postify.calendar.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static com.codecool.postify.calendar.model.Channel.*;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class CalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarApplication.class, args);
	}

	@Autowired
	EventRepository eventRepository;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Calendar Calendar(){
		return Calendar.getInstance();
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {

			Channel channel1 = FACEBOOK;
			HashSet<Channel> set = new HashSet<>();
			set.add(channel1);
			Event event1 = Event.builder()
					.channels(set)
					.contentId(1)
					.date(LocalDate.of(2020, 03, 9))
							.time(LocalTime.of(11, 10))
					.build();

			Channel channel2 = INSTAGRAM;
			HashSet<Channel> set2 = new HashSet<>();
			set.add(channel2);
			Event event2 = Event.builder()
					.channels(set2)
					.contentId(3)
					.date(LocalDate.of(2020, 03, 11))
					.time(LocalTime.of(9, 10))
					.build();

			Channel channel = WHATSUP;
			HashSet<Channel> set3 = new HashSet<>();
			set.add(channel2);
			Event event3 = Event.builder()
					.channels(set2)
					.contentId(4)
					.date(LocalDate.of(2020, 03, 11))
					.time(LocalTime.of(14, 10))
					.build();

			eventRepository.saveAll(Arrays.asList(event1, event2, event3));

		};
	}
}
