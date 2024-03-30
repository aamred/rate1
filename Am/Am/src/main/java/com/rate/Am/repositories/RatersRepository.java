package com.rate.Am.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rate.Am.models.Rater;

/**
 * @author Anton Muzhytskyi
 */

@Repository
public interface RatersRepository extends JpaRepository<Rater, Integer> {
	
	Optional<Rater> findByNickname(String nickname);
	Optional<Rater> findByRaterId(int raterId);
	Optional<Rater> findByTelephone(String telephone);
	
	void save(org.springframework.boot.autoconfigure.security.SecurityProperties.User user);
}
