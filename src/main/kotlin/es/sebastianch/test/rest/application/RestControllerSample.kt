package es.sebastianch.test.rest.application

import es.sebastianch.test.rest.domain.SampleO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestControllerSample {

    @GetMapping("/api/hello")
    fun hello() = "Hello World!"

    @GetMapping("/api/admin/me")
    fun sampleObject() = SampleO(0,"Sebastián", 23)
}