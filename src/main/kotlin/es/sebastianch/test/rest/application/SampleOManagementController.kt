package es.sebastianch.test.rest.application

import es.sebastianch.test.rest.domain.SampleO
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin")
class SampleOManagementController {

    val SAMPLE_OS = listOf(
        SampleO(0, "Sebastián", 23),
        SampleO(1, "Juan", 24),
        SampleO(2, "Pedro", 25)
    )

    @GetMapping("/sample-objects")
    fun getAll() = SAMPLE_OS

    @GetMapping("/sample-object/{id}")
    fun getOne(@PathVariable("id") id: Int) = SAMPLE_OS[id]

    @PostMapping("/sample-object/create")
    fun create(@RequestBody sampleO: SampleO) = SAMPLE_OS.plus(sampleO)

    @PutMapping("/sample-object/update/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody sampleO: SampleO) = List(SAMPLE_OS.size) { index ->
        if (index == id) sampleO else sampleO
    }

    @DeleteMapping("/sample-object/delete/{id}")
    fun delete(@PathVariable("id") id: Int) = SAMPLE_OS.filterIndexed { index, _ -> index != id }
}