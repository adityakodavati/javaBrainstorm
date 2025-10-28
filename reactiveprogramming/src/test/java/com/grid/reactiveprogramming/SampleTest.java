package com.grid.reactiveprogramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


class SampleTest {

    Sample sample = new Sample();

    @Test
    @DisplayName("check for flux")
    void returnFlux()
    {
        //given

        //when
        var flux =  sample.returnFlux();

        //then
        StepVerifier.create(flux)
                .expectNextCount(3)
                .verifyComplete();

    }


    @Test
    @DisplayName("Test for Mono")
    void returnMono()
    {
        var mono = sample.returnMono();

        StepVerifier.create(mono)
                .expectNext("Aditya")
                .expectNextCount(0)
                .verifyComplete();

    }
}