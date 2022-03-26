package ${groupId}.events.entity

import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface EventRepository : JpaRepository<Event, Long> {
    fun findById(id: Long): Event
    fun deleteById(id: Long): Event
}