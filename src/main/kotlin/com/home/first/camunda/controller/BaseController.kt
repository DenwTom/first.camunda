package com.home.first.camunda.controller

import com.home.first.camunda.controller.model.Request
import com.home.first.camunda.controller.model.Response
import com.home.first.camunda.service.ProcessService
import com.home.first.camunda.util.WebUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class BaseController (
    private val processService: ProcessService,
    private val webUtils: WebUtils
        ){

    @PostMapping("/end-process")
    fun cancelActiveProcess(
        @RequestBody request: Request
    ): ResponseEntity<*> =
        webUtils.handleRequest("baseController") {
            processService.cancelActiveProcess(request)
        }



//        return ResponseEntity( Response("active process canceled"), HttpStatus.OK)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "process not fount")
//    @ExceptionHandler(Response.class)
//    fun exceptionNotFound(e: Response){
//
//    }

}