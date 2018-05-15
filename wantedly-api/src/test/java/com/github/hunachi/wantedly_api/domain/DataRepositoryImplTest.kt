package com.github.hunachi.wantedly_api.domain

import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DataRepositoryImplTest {
    
    private lateinit var repository: DataRepository
    
    @Before
    fun setUp() {
        repository = DataRepositoryImpl(Schedulers.trampoline())
    }
    
    @Test
    fun test_data() {
        val testSubscriber = repository.data("kotlin", 0).test()
        
        testSubscriber.awaitTerminalEvent()
        
        testSubscriber.assertNoErrors()
            .assertNoTimeout()
            .assertComplete()
        
        val list = testSubscriber.values()[0]
        
        assert(list.isNotEmpty())
    }
    
    @Test
    fun test_data_avatar_null() {
        val testSubscriber = repository.data("java", 1).test()
        
        testSubscriber.awaitTerminalEvent()
        
        testSubscriber.assertNoErrors()
            .assertNoTimeout()
            .assertComplete()
        
        val list = testSubscriber.values()[0]
        
        assert(list.isNotEmpty())
    }
    
    @Test
    fun test_data_none() {
        val testSubscriber = repository.data("hoge", 0).test()
        
        testSubscriber.awaitTerminalEvent()
        
        testSubscriber.assertNoErrors()
            .assertNoTimeout()
            .assertComplete()
    }
    
    
    @Test
    fun test_data_Y() {
        val testSubscriber = repository.data("Y", 0).test()
        
        testSubscriber.awaitTerminalEvent()
        
        testSubscriber.assertNoErrors()
            .assertNoTimeout()
            .assertComplete()
        
        val list = testSubscriber.values()[0]
        
        assert(list.isNotEmpty())
    }
}
