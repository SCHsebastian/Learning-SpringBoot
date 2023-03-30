package es.sebastianch.test.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestControllerSample {

    @GetMapping("/hello")
    fun hello() = "Hello World!"

    @GetMapping("/sample-object")
    fun sampleObject() = SampleO("Sebastián", 23)
}