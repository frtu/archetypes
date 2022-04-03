package ${groupId}.events.service

import ${groupId}.events.entity.Event
import ${groupId}.events.entity.EventRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/events")
class EventController(val repository: EventRepository) {
    @GetMapping
    fun findAll() = repository.findAll()

    @PostMapping
    fun addEvent(@RequestBody event: Event) = repository.save(event)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) =
        repository.findById(id)

    @PutMapping("/{id}")
    fun updateEvent(@PathVariable id: Long, @RequestBody event: Event) {
        assert(event.id == id)
        repository.save(event)
    }

    @DeleteMapping("/{id}")
    fun removeEvent(@PathVariable id: Long) = repository.deleteById(id)
}