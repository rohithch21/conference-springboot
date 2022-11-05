package com.pluralsight.conferencespringboot.repositories;

import com.pluralsight.conferencespringboot.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
