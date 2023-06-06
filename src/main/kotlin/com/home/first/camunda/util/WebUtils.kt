package com.home.first.camunda.util

import com.home.first.camunda.controller.model.Response
import com.home.first.camunda.exception.CustomException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class WebUtils {
    fun <T> handleRequest(
        audiPoint: String,
        getResponse: () -> T
    ): ResponseEntity<*> = try {
        print("handleRequest start")
        print("....................")
        print("handleRequest end")
        val response = getResponse()
        ResponseEntity(response, HttpStatus.OK)
    } catch (th: CustomException) {
        print(th.message)
        ResponseEntity(Response("process not found"), HttpStatus.NOT_FOUND)
    } catch (th: Throwable) {
        print(th.message)
        ResponseEntity("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR)
    } finally {
        print("finally method")
    }

}