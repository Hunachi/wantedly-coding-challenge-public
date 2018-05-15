package com.github.hunachi.common.ddd

abstract class Identifier<T>(val value: T) {
    
    override fun equals(other: Any?): Boolean =
        when {
            this === other          -> true
            other !is Identifier<*> -> false
            else                    -> value == this.value
        }
    
    override fun hashCode(): Int = value?.hashCode() ?: 0
}