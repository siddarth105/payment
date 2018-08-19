package com.ecomm.chkt.payment.controller;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping(value = "/rest")
public class ReactiveAccountController {
	
	static Random random = new Random();
	
	@GetMapping(value = "/getAccount", produces = MediaType.TEXT_EVENT_STREAM_VALUE)  //APPLICATION_STREAM_JSON_VALUE / TEXT_EVENT_STREAM_VALUE
	public Flux<String> getAccount() {
		Flux<Long> delay = Flux.interval(Duration.ofSeconds(3));
		Flux<String> accountNames = Flux.<String>fromStream(Stream.generate(() -> generateRandom()));
		return Flux.zip(delay, accountNames).map(x -> x.getT2()).log(accountNames.toString());
	}
	
	private String generateRandom() {
		return "userName_"+ random.nextInt(100);
	}
	
	private void otherEg() {
		/*ConnectableFlux<String> publish = Flux.<String>create(fluxSink -> {
		    while(true) {
		        fluxSink.next("a");
		    }
		}).sample(Duration.ofSeconds(2))
		.publish();
		publish.subscribe(System.out::println); 
		publish.connect();
		return publish.autoConnect(5);*/
	}

}
