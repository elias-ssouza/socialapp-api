package com.darkgreen.socialappapi.service

import com.darkgreen.socialappapi.Message
import com.darkgreen.socialappapi.MessageRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageServiceImpl (private val repository: MessageRepository) : MessageService {
    override fun create(message: Message): Message {
        return repository.save(message)
    }

    override fun getAll(): List<Message> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Message> {
        return repository.findById(id)
    }

    override fun update(id: Long, message: Message): Optional<Message> {
        val optional = getById(id)
        if (optional.isEmpty) Optional.empty<Message>()

        return optional.map {
            val messageToUpdate = it.copy(
                text = message.text
            )
            repository.save(messageToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map{
            repository.delete(it)
        }.orElseThrow{throw RuntimeException("Id not found $id")}
    }
}