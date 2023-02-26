package com.darkgreen.socialappapi

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {
    @Autowired lateinit var mockMvc: MockMvc

    @Autowired lateinit var messageRepository: MessageRepository

    @Test
    fun `test find all` () {

        messageRepository.save(Message(text = "apenas testando se tá tudo ok"))

        mockMvc.perform(MockMvcRequestBuilders.get("/messages"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("\$").isArray)
            .andExpect(MockMvcResultMatchers.jsonPath("\$[0].id").isNumber)
            .andExpect(MockMvcResultMatchers.jsonPath("\$[0].text").isString)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `test find by id` () {

       val message = messageRepository.save(Message(text = "testando se tá tudo ok"))

        mockMvc.perform(MockMvcRequestBuilders.get("/messages/${message.id}"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("\$.id").value(message.id))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.text").value(message.text))
                .andDo(MockMvcResultHandlers.print())
    }
}
