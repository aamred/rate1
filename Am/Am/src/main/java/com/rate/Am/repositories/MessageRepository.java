package com.rate.Am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rate.Am.models.Message;

/**
 * @author Anton Muzhytskyi
 */

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
