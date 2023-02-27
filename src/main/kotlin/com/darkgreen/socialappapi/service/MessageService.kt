package com.darkgreen.socialappapi.service

import com.darkgreen.socialappapi.Message
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.Optional

interface MessageService {
    fun create(message: Message): Message

    fun getAll(): List<Message>

    fun getById(id: Long): Optional<Message>

    fun update(id: Long, message: Message) : Optional<Message>

    fun delete( id: Long)
}