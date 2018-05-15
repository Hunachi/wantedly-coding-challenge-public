package com.github.hunachi.common.ddd

abstract class Entity<out T : Identifier<*>>(open val id: T) {
    
    override fun equals(other: Any?): Boolean = (other is Entity<*>) && other.id == id
    
    override fun hashCode(): Int = id.hashCode()
}