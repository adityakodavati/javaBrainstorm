package com.grid.reactiveprogramming;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Sample {
    public static void main(String[] args) {


        Sample sample = new Sample();

/*
        sample.returnFlux().log().subscribe(string -> System.out.println("name is :" + string));

        sample.returnMono().log().subscribe(s -> System.out.println("Momo :" + s));

        sample.returnFluxWithMapFilter(4).subscribe(s -> System.out.println(s));

*/

        sample.returnFluxWithFlatMapFilter(3).subscribe(System.out::println);

        System.out.println("---------------------");
        sample.returnFluxWithFlatMapFilterWithDelay(3).subscribe(System.out::println);
    }

    //Simple Flux
    public Flux<String> returnFlux() {
        return Flux.fromIterable(List.of(
                "Aditya", "bala", "giri"
        ));
    }

    //Simple Mono
    public Mono<String> returnMono() {
        return Mono.just("Aditya");
    }

    //Simple Flux with map() and Filter()
    public Flux<String> returnFluxWithMapFilter(int stringLength) {
        return returnFlux()
                .filter(s -> s.length() > 4)
                .map(s -> s.length() + "-" + s).log();
    }

    //using splitting String and returning character array
    public Flux<String> splitString(String s)
    {
        var string = s.split("");

        return Flux.fromArray(string);
    }


    //using splitting String and returning character array with delay
    private Flux<String> splitStringWithDelay(String s) {

        var delay = new Random().nextInt(1000);

        var splittedString = s.split("");

        return Flux.fromArray(splittedString)
                .delayElements(Duration.ofMillis(delay));

    }
    //using flatmap() with filter()
    public Flux<String> returnFluxWithFlatMapFilter(int stringLength) {
        return returnFlux()
                .filter(s -> s.length() > stringLength)
                .flatMap(this::splitString)
                .log();
    }

    //using flatmap() with filter() introduced delay doesnot follow order
    public Flux<String> returnFluxWithFlatMapFilterWithDelay(int stringLength) {

        return returnFlux()
                .filter(s -> s.length() > stringLength)
                .flatMap(this::splitStringWithDelay)
                .log();
    }

    //using concatmap() with filter() introduced delay which preserves order.
    public Flux<String> returnFluxWithConcatMapFilterWithDelay(int stringLength) {

        return returnFlux()
                .filter(s -> s.length() > stringLength)
                .concatMap(this::splitStringWithDelay)
                .log();
    }
}
