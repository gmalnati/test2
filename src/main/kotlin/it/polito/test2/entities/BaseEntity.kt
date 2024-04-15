package it.polito.test1.entities

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.util.ProxyUtils

@MappedSuperclass
open class BaseEntity {
    @Id
    @GeneratedValue
    val id: Long = 0L

    override fun equals(other: Any?): Boolean {
        if (null === other) return false
        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false
        other as BaseEntity
        return if (0L == id) false
               else this.id == other.id
    }

    override fun hashCode() = 1

    override fun toString() = "@Entity ${this.javaClass.name}(id=$id)"
}