package com.darkgreen.socialappapi

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "messages")
data class Message (
    @Id @GeneratedValue
    var id: Long? = null,
    var text: String
)