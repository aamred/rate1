package com.rate.Am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rate.Am.models.Post;


/**
 * @author Anton Muzhytskyi
 */

public interface PostRepository extends JpaRepository<Post, Integer>{

}
