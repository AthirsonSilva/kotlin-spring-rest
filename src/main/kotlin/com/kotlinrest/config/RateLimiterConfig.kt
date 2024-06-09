package com.kotlinrest.config

import com.kotlinrest.exception.RateLimitExceededException
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger


@Aspect
@Component
class RateLimitingAspect {

    companion object {
        private val requestCounts = ConcurrentHashMap<String, AtomicInteger>()
        private const val REQUEST_LIMIT = 100
        private const val TIME_LIMIT: Long = 60000
    }

    @Before("@annotation(FunctionalInterface)")
    fun beforeRequest() {
        val count = requestCounts.computeIfAbsent(
            Thread.currentThread().name
        ) { _: String? -> AtomicInteger(0) }
        if (count.incrementAndGet() > REQUEST_LIMIT) {
            throw RateLimitExceededException("Rate limit exceeded")
        }
        if (requestCounts.size == 1) {
            resetRequestCounts()
        }
    }

    private fun resetRequestCounts() {
        Thread {
            try {
                Thread.sleep(TIME_LIMIT)
                requestCounts.clear()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }.start()
    }

}