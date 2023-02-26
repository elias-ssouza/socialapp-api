package com.darkgreen.socialappapi

import org.springframework.data.jpa.repository.JpaRepository

interface  MessageRepository: JpaRepository<Message, Long> {
}