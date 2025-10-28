package com.grid.reactiveprogramming;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Sample {
    public static void main(String[] args) {


        Sample sample = new Sample();
        sample.returnFlux().log().subscribe(string -> System.out.println("name is :" + string));

        sample.returnMono().log().subscribe(s -> System.out.println("Momo :" + s));
    }

    public Flux<String> returnFlux()
    {
        return Flux.fromIterable(List.of(
                "Aditya", "bala", "giri"
        ));
    }

    public Mono<String> returnMono()
    {
        return Mono.just("Aditya");
    }

}
