package com.home.first.camunda.service

import com.home.first.camunda.controller.model.Request
import com.home.first.camunda.controller.model.Response
import com.home.first.camunda.exception.CustomBaseException
import com.home.first.camunda.exception.CustomException
import org.springframework.stereotype.Service


@Service
class ProcessService {
    fun cancelActiveProcess(identifier:Request): Response {
        when (identifier.id){
            "12" -> throw CustomBaseException("CustomBaseException")
            "21" -> throw CustomException("CustomException")
        }
        return Response("end process")
    }
}