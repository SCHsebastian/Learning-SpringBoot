package es.sebastianch.test.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestControllerSample {

    @GetMapping("/api/hello")
    fun hello() = "Hello World!"

    @GetMapping("/api/admin/sample-object")
    fun sampleObject() = SampleO("Sebastián", 23)
}