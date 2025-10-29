package com.grid.reactiveprogramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;


class SampleTest {

    Sample sample = new Sample();

    @Test
    @DisplayName("check for flux")
    void returnFlux() {
        //given

        //when
        var flux = sample.returnFlux();

        //then
        StepVerifier.create(flux)
                .expectNextCount(3)
                .verifyComplete();

    }


    @Test
    @DisplayName("Test for Mono")
    void returnMono() {
        var mono = sample.returnMono();

        StepVerifier.create(mono)
                .expectNext("Aditya")
                .expectNextCount(0)
                .verifyComplete();

    }

    @Test
    @DisplayName("Test of Filter and Map()")
    void opWithMap() {
        //when
        var flux = sample.returnFluxWithMapFilter(4);

        StepVerifier.create(flux)
                .expectNext("6-Aditya")
                .verifyComplete();
    }

    @Test
    @DisplayName("Test For FlatMap")
    void returnFluxWithFlatMapFilter() {

        var charArray = sample.returnFluxWithFlatMapFilter(4);

        StepVerifier.create(charArray)
                // .expectNext("A","d","i","t","y","a")
                .expectNextCount(6)
                .verifyComplete()
        ;

    }

    @Test
    @DisplayName("Test to check flat map with delay ")
    void returnFluxWithFlatMapFilterWithDelay() {

        var charArray = sample.returnFluxWithFlatMapFilterWithDelay(3);

        StepVerifier.create(charArray)
                .expectNextCount(14)
                .verifyComplete();

    }

    @Test
    @DisplayName("Test for concatmap with delay")
    void returnFluxWithConcatMapFilterWithDelay() {

        var carArray = sample.returnFluxWithConcatMapFilterWithDelay(3);

        StepVerifier.create(carArray)
                .expectNextCount(14)
                .verifyComplete();

    }

    @Test
    @DisplayName("Test for monoList using flatmap")
    void listMono() {

        var monoList = sample.listMono();

        StepVerifier.create(monoList).expectNext(List.of("A","D","I","T","Y","A")).verifyComplete();

    }
}